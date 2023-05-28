package com.revature.eMarket.models;

import lombok.*;

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
}