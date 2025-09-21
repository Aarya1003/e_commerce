package com.ecommerce.sandhyaLand.service;

import com.ecommerce.sandhyaLand.exception.ProductException;
import com.ecommerce.sandhyaLand.model.Category;
import com.ecommerce.sandhyaLand.model.Product;
import com.ecommerce.sandhyaLand.repository.CategoryRepository;
import com.ecommerce.sandhyaLand.repository.ProductRepository;
import com.ecommerce.sandhyaLand.request.CreateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    UserService userService;
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public ProductServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userService = userService;
    }

    @Override
    public Product createProduct(CreateProductRequest req) {
        // Fetch top-level category
        Category topLevel = categoryRepository.findByName(req.getTopLevelCategory());
        if (topLevel == null) {
            Category topCategory = new Category();
            topCategory.setName(req.getTopLevelCategory());
            topCategory.setLevel(1);
            topLevel = categoryRepository.save(topCategory);
        }

        // Fetch second-level category
        Category secondLevel = categoryRepository.findByNameAndParent(req.getSecondLevelCategory(), topLevel.getName());
        if (secondLevel == null) {
            Category secondCategory = new Category();
            secondCategory.setName(req.getSecondLevelCategory());
            secondCategory.setParentCategory(topLevel);
            secondCategory.setLevel(2);
            secondLevel = categoryRepository.save(secondCategory);
        }

        // Fetch third-level category
        Category thirdLevel = categoryRepository.findByNameAndParent(req.getThirdLevelCategory(), secondLevel.getName());
        if (thirdLevel == null) {
            Category thirdCategory = new Category();
            thirdCategory.setName(req.getThirdLevelCategory());
            thirdCategory.setParentCategory(secondLevel);
            thirdCategory.setLevel(3);
            thirdLevel = categoryRepository.save(thirdCategory);
        }

        // Create Product
        Product product = new Product();
        product.setTitle(req.getTitle());
        product.setColor(req.getColor());
        product.setDescription(req.getDescription());
        product.setDiscountedPrice(req.getDiscountedPrice());
        product.setDiscountPercent(req.getDiscountPersent());
        product.setImageUrl(req.getImageUrl());
        product.setBrand(req.getBrand());
        product.setPrice(req.getPrice());
        product.setSizes(req.getSize());
        product.setQuantity(req.getQuantity());
        product.setCategory(thirdLevel);
        product.setCreatedAt(LocalDateTime.now());

        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }


    @Override
    public String deleteProduct(Long productId) throws Exception {
        Product deleteProduct= findProductById(productId);
        deleteProduct.getSizes().clear();
        productRepository.delete(deleteProduct);
        return "Product deleted Successfully!";
    }

    @Override
    public Product updateProduct(Long productId, Product req) throws Exception {
        Product updateProduct=findProductById(productId);
        if(updateProduct.getQuantity()!=0){
            updateProduct.setQuantity(updateProduct.getQuantity());
        }
        return productRepository.save(updateProduct);
    }

    @Override
    public Product findProductById(Long id) throws ProductException {
        Optional<Product> op=productRepository.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        throw new ProductException("Product not found with id "+id);
    }

    @Override
    public List<Product> findProductByCategory(String category) {
        return List.of();
    }

    @Override
    public Page<Product> getAllProduct(Integer minPrice, Integer maxPrice, String category,
                                       List<String> colors, List<String> sizes, Integer minDiscount,
                                       String sort, String stock, Integer pageNumber, Integer pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        List<Product> products=productRepository.filterProduct(category,minPrice,maxPrice,minDiscount,sort);

        if(!colors.isEmpty()) {
            products=products.stream().filter(p-> colors.stream().anyMatch(c->c.equalsIgnoreCase
                            (p.getColor())))
                    .collect(Collectors.toList());
        }
        if(stock != null) {
            if (stock.equals("in_stock")) {
                products = products.stream().filter(p -> p.getQuantity() > 0).collect(Collectors.toList());
            } else if (stock.equals("out_of_stock")) {
                products = products.stream().filter(p -> p.getQuantity() < 1).collect(Collectors.toList());
            }

        }
        int startIndex=(int) pageable.getOffset();
        int endIndex=Math.min(startIndex + pageable.getPageSize(), products.size() );
        List<Product> pageContent=products.subList(startIndex, endIndex);
        Page<Product> filteredProducts=new PageImpl<>(pageContent,pageable,products.size());
        return filteredProducts;

    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
