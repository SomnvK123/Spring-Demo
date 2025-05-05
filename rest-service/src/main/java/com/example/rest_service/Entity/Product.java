package com.example.rest_service.Entity;


public class Product {
    private Long id;
    private String name;
    private double price;

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters và Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
