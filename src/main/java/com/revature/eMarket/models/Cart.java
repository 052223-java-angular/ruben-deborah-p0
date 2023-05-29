package com.revature.eMarket.models;

import lombok.*;

import java.math.BigDecimal;
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
    double total;
    private BigDecimal total_cost;
    private List<CartItems> items;

    public Cart(BigDecimal total_cost, String user_id){
        this.id = UUID.randomUUID().toString();
        this.total_cost = total_cost;
        this.user_id = user_id;
    }
    private Cart(String user_id){
        this.id = UUID.randomUUID().toString();
        this.user_id = user_id;
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public void setTotalCost(float totalCost) {
        this.total = totalCost;
    }
}