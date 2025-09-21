package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.ProductException;
import com.ecommerce.sandhyaLand.model.Product;
import com.ecommerce.sandhyaLand.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

     Product createProduct(CreateProductRequest req);

     String deleteProduct(Long productId) throws Exception;

     Product updateProduct(Long productId,Product req) throws Exception;

    Product findProductById(Long id) throws ProductException;

    List<Product> findProductByCategory(String category);

    Page<Product> getAllProduct(Integer minPrice, Integer maxPrice,String category,List<String>colors,
                                List<String>sizes,Integer minDiscount,String sort,String stock,Integer pageNumber,
                                Integer pageSize);

    List<Product> findAllProducts();
}
