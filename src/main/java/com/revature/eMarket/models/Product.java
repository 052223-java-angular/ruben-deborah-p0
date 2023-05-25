package com.revature.eMarket.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product {
    private String id;
    private String name;
    private String price;
    private String category;
    private String category_id;
}