package com.example.domain;

public class Product {

    private double price;
    private String label;
    private boolean discount;

    public Product(double price, String label, boolean discount) {
        this.price = price;
        this.label = label;
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean hasDiscount() {
        return discount;
    }

}
