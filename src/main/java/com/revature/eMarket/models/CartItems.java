package com.revature.eMarket.models;

import java.util.UUID;

public class CartItems {
    private String id;
    private String name;
    private int stock;
    private String cart_id;
    private String product_id;
    private int quantity;
    private float price;

    public CartItems(String name, int stock, int quantity, float price, String cart_id, String product_id){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.cart_id = cart_id;
        this.product_id = product_id;

    }
}
