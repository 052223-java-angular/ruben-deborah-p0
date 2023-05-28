package com.revature.eMarket.models;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Cart {
    private String id;
    private String user_id;
    private List<CartItems> items;
}