package com.revature.eMarket.models;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Review {
    private String id;
    private String rating;
    private String review;
    private String user_id;
    private String product_id;

    public Review(String rating, String review, String user_id, String product_id) {
        this.id = UUID.randomUUID().toString();
        this.rating = rating;
        this.review = review;
        this.user_id = user_id;
        this.product_id = product_id;
    }
}