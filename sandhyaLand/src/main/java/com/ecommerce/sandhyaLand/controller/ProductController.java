package com.ecommerce.sandhyaLand.controller;

import com.ecommerce.sandhyaLand.exception.ProductException;
import com.ecommerce.sandhyaLand.model.Product;
import com.ecommerce.sandhyaLand.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> findProductByCategoryHandler(@RequestParam String category,
          @RequestParam List<String>color, @RequestParam List<String> size, @RequestParam Integer minPrice,
         @RequestParam Integer maxPrice, @RequestParam Integer minDiscount, @RequestParam String sort,
          @RequestParam String stock, @RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        Page<Product> res = productService.getAllProduct(minPrice,maxPrice,category,color,size,minDiscount,
                sort,stock,pageNumber,pageSize);
        System.out.println("complete products");
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }
    @GetMapping("/products/id/{productId}")
    public ResponseEntity<Product>  findProductByIdHandler(@PathVariable Long productId) throws ProductException {
        Product product=productService.findProductById(productId);
        return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
    }
}
