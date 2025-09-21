package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.ProductException;
import com.ecommerce.sandhyaLand.model.Product;
import com.ecommerce.sandhyaLand.model.Rating;
import com.ecommerce.sandhyaLand.model.User;
import com.ecommerce.sandhyaLand.repository.RatingRepository;
import com.ecommerce.sandhyaLand.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{

    private ProductService productService;
    private RatingRepository ratingRepository;

    public RatingServiceImpl(ProductService productService, RatingRepository ratingRepository) {
        this.productService = productService;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product product=productService.findProductById(req.getProductId());

        Rating rating=new Rating(user,product,req.getRating(), LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {
        return ratingRepository.getAllProductsRating(productId);
    }
}














