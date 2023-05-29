package com.revature.eMarket.models;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Cart {
    private String id;
    private String user_id;
    private List<CartItems> items;

    private Cart(String user_id){
        this.id = UUID.randomUUID().toString();
        this.user_id = user_id;
        this.items = new ArrayList<>();
    }
}