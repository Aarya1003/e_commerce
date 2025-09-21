package com.ecommerce.sandhyaLand.controller;

import com.ecommerce.sandhyaLand.exception.CartItemException;
import com.ecommerce.sandhyaLand.exception.UserException;
import com.ecommerce.sandhyaLand.model.User;
import com.ecommerce.sandhyaLand.response.ApiResponse;
import com.ecommerce.sandhyaLand.service.CartItemService;
import com.ecommerce.sandhyaLand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartItem")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId,
                                                      @RequestHeader("Authorization") String jwt)
            throws UserException, CartItemException {
        User user = userService.findUserProfileByJwt(jwt);
        cartItemService.removeCartItem(user.getId(), cartItemId);
        ApiResponse res = new ApiResponse();
        res.setMessage("item deleted from cart");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
