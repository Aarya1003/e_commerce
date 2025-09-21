package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.OrderException;
import com.ecommerce.sandhyaLand.model.Address;
import com.ecommerce.sandhyaLand.model.Order;
import com.ecommerce.sandhyaLand.model.User;

import java.util.List;

public interface OrderService {
    public Order createOrder(User user, Address shippingAddress);
    public Order findOrderById(Long orderId) throws OrderException;
    public List<Order> userOrderHistory(Long userId);
    public Order placedOrder(Long orderId) throws OrderException;
    public Order confirmedOrder(Long orderId)throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order cancledOrder(Long orderId) throws OrderException;
    public List<Order>getAllOrders();
    public void deleteOrder(Long orderId) throws OrderException;
}
