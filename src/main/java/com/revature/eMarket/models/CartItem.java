package com.revature.eMarket.models;


import lombok.*;


import java.math.BigDecimal;

import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
public class CartItem {
    private String id;
    private String name;
    private int stock;
    private String cart_id;
    private String product_id;
    private int quantity;
    private BigDecimal price;
//    private List<CartItems> items;


    public CartItem(String name, int stock, int quantity, BigDecimal price, String cart_id, String product_id){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        this.cart_id = cart_id;
        this.product_id = product_id;

    }

}
