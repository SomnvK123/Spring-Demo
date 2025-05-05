package com.example.rest_service.Service;

import com.example.rest_service.Entity.Product;
import com.example.rest_service.Entity.ProductService;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product(1L, "Laptop", 1000.0),
                new Product(2L, "Phone", 500.0)
        );
    }
}