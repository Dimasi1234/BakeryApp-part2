package com.example.bakeryapp;

public class ItemCart {
    private String productName;
    private int quantity;
    private double price;
    private int imageResource;

    public ItemCart(String productName, int quantity, double price, int imageResource) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public double getTotalPrice() {
        return quantity * price;
    }
}
