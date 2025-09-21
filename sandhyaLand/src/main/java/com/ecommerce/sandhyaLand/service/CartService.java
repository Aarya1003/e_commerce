package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.ProductException;
import com.ecommerce.sandhyaLand.model.Cart;
import com.ecommerce.sandhyaLand.model.User;
import com.ecommerce.sandhyaLand.request.AddItemRequest;

public interface CartService {

    public Cart createCart(User user);
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
    public Cart findUserCart(Long userId);

}
