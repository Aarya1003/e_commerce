package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.ProductException;
import com.ecommerce.sandhyaLand.model.Product;
import com.ecommerce.sandhyaLand.model.Review;
import com.ecommerce.sandhyaLand.model.User;
import com.ecommerce.sandhyaLand.repository.ProductRepository;
import com.ecommerce.sandhyaLand.repository.ReviewRepository;
import com.ecommerce.sandhyaLand.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private ProductService productService;
    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;

    public ReviewServiceImpl(ProductRepository productRepository, ProductService productService, ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product=productService.findProductById(req.getProductId());
        Review review=new Review(LocalDateTime.now(), req.getProductId(),product, req.getReview(), user);
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {
        return reviewRepository.getAllProductsReview(productId);
    }
}
