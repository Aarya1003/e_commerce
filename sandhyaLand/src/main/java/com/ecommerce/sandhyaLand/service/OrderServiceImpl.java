package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.OrderException;
import com.ecommerce.sandhyaLand.model.*;
import com.ecommerce.sandhyaLand.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private CartRepository cartRepository;
    private CartService cartItemService;
    private ProductService productService;
    private AddressRepository addressRepository;
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private OrderItemService orderItemService;
    private OrderItemRepository orderItemRepository;

    public OrderServiceImpl(AddressRepository addressRepository, CartService cartItemService, CartRepository cartRepository, OrderItemRepository orderItemRepository, OrderItemService orderItemService, OrderRepository orderRepository, ProductService productService, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.cartItemService = cartItemService;
        this.cartRepository = cartRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderItemService = orderItemService;
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.userRepository = userRepository;
    }

    @Override
    public Order createOrder(User user, Address shippAddress) {
        // Save address with user
        shippAddress.setUser(user);
        Address address = addressRepository.save(shippAddress);
        user.getAddress().add(address);
        userRepository.save(user);

        // Get user cart
        Cart cart = cartItemService.findUserCart(user.getId());

        // Create Order first (but don't add orderItems yet)
        Order createdOrder = new Order();
        createdOrder.setUser(user);
        createdOrder.setTotalPrice(cart.getTotalPrice());
        createdOrder.setTotalDiscountedPrice(cart.getTotalDiscountedPrice());
        createdOrder.setDiscount(cart.getDiscount());
        createdOrder.setTotalItem(cart.getTotalItem());
        createdOrder.setOrderAddress(address);
        createdOrder.setOrderDate(LocalDateTime.now());
        createdOrder.setOrderStatus("PENDING");
        createdOrder.getPaymentDetails().setStatus("PENDING");
        createdOrder.setCreateAt(LocalDateTime.now());

        // Save order first so it gets a primary key
        Order savedOrder = orderRepository.save(createdOrder);

        // Now create orderItems and link them
        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem item : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setPrice(item.getPrice());
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setSize(item.getSize());
            orderItem.setUserId(item.getUserId());
            orderItem.setDiscountedPrice(item.getDiscountedPrice());

            // set the order reference
            orderItem.setOrder(savedOrder);

            // save each orderItem
            OrderItem savedItem = orderItemRepository.save(orderItem);
            orderItems.add(savedItem);
        }

        // link back to order
        savedOrder.setOrderItems(orderItems);

        // save again to persist relationship
        return orderRepository.save(savedOrder);
    }

    @Override
    public Order findOrderById(Long orderId) throws OrderException {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent()){
            return order.get();
        }
        throw new OrderException("No existing order with "+orderId);
    }

    @Override
    public List<Order> userOrderHistory(Long userId) {
        List<Order> orders=orderRepository.getUserOrders(userId);
        return orders;
    }

    @Override
    public Order placedOrder(Long orderId) throws OrderException {
        Order order=findOrderById(orderId);
        order.setOrderStatus("PLACED");
        order.getPaymentDetails().setStatus("COMPLETED");
        return orderRepository.save(order);
    }

    @Override
    public Order confirmedOrder(Long orderId) throws OrderException {
        Order order=findOrderById(orderId);
        order.setOrderStatus("CONFIRMED");
        return orderRepository.save(order);
    }

    @Override
    public Order shippedOrder(Long orderId) throws OrderException {
        Order order=findOrderById(orderId);
        order.setOrderStatus("SHIPPED");
        return orderRepository.save(order);
    }

    @Override
    public Order deliveredOrder(Long orderId) throws OrderException {
        Order order=findOrderById(orderId);
        order.setOrderStatus("DELIVERED");
        return orderRepository.save(order);
    }

    @Override
    public Order cancledOrder(Long orderId) throws OrderException {
        Order order=findOrderById(orderId);
        order.setOrderStatus("CANCELLED");
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Long orderId) throws OrderException {
          orderRepository.deleteById(orderId);
    }
}
