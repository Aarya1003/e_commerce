package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.ProductException;
import com.ecommerce.sandhyaLand.model.Rating;
import com.ecommerce.sandhyaLand.model.User;
import com.ecommerce.sandhyaLand.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

    public Rating createRating(RatingRequest req, User user) throws ProductException;
    public List<Rating> getProductsRating(Long productId);

}
