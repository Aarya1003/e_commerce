package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.CartItemException;
import com.ecommerce.sandhyaLand.exception.UserException;
import com.ecommerce.sandhyaLand.model.Cart;
import com.ecommerce.sandhyaLand.model.CartItem;
import com.ecommerce.sandhyaLand.model.Product;
import com.ecommerce.sandhyaLand.repository.CartItemRepository;
import com.ecommerce.sandhyaLand.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService{

    private CartItemRepository cartItemRepository;
    private UserService userService;
    private CartRepository cartRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository, CartRepository cartRepository, UserService userService) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.userService = userService;
    }

    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());

        if (cartItem.getCart() != null && cartItem.getCart().getUser() != null) {
            cartItem.setUserId(cartItem.getCart().getUser().getId());
        }
        CartItem newCartItem=cartItemRepository.save(cartItem);
        return newCartItem;
    }

    @Override
    public CartItem updateCartItem(Long userId,Long id,CartItem cartItem) throws UserException, CartItemException {
        CartItem existing = findCartItemById(id);

        if (!existing.getUserId().equals(userId)) {
            throw new UserException("You cannot update another user's cart item");
        }

        existing.setQuantity(cartItem.getQuantity());
        existing.setPrice(existing.getQuantity() * existing.getProduct().getPrice());
        existing.setDiscountedPrice(existing.getProduct().getDiscountedPrice() * existing.getQuantity());

        return cartItemRepository.save(existing);
    }

    @Override
    public CartItem isCartItemExists(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem=cartItemRepository.isCartItemExist(cart,product,size,userId);
        return cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
        CartItem cartItem = findCartItemById(cartItemId);

        if (!cartItem.getUserId().equals(userId)) {
            throw new UserException("You can't remove another user's cart item");
        }

        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        Optional<CartItem> opt =cartItemRepository.findById(cartItemId);
        if(opt.isPresent()) {
            return opt.get();
        }
        throw new CartItemException("cart item not found with id : "+cartItemId);
    }
}
