package com.revature.eMarket.models;


import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class CartItem {
    private String id;
    private String name;
//    private int stock;
    private String cart_id;
    private String product_id;
    private int quantity;
    private double price;
//    private List<CartItems> items;


    public CartItem(String name, int quantity, double price, String cart_id, String product_id){
        this.id = UUID.randomUUID().toString();
        this.name = name;
//        this.stock = stock;
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;

    }

}
