package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.CartItemException;
import com.ecommerce.sandhyaLand.exception.UserException;
import com.ecommerce.sandhyaLand.model.Cart;
import com.ecommerce.sandhyaLand.model.CartItem;
import com.ecommerce.sandhyaLand.model.Product;
import org.springframework.stereotype.Service;


public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId,Long id,CartItem cartItem) throws UserException, CartItemException;

    public CartItem isCartItemExists(Cart cart, Product product, String size, Long userId);

    public void removeCartItem(Long userId,Long cartItemId) throws CartItemException,UserException;

    public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
