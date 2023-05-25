package com.revature.eMarket.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String id;
    private String username;
    private String password;
    private String roleId;
}