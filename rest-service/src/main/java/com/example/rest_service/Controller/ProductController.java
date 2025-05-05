package com.example.rest_service.Controller;

import com.example.rest_service.Entity.Product;
import com.example.rest_service.Entity.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product") // JSON
    public List<Product> getProductsJson() {
        return productService.getAllProducts();
    }
}
