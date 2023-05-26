package com.revature.eMarket.models;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String id;
    private String username;
    private String password;
    private String role_id;

    public User(String username, String password, String role_id) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.role_id = role_id;
    }

    /*
    public User() {
        super();
    }

    public User(String id, String username, String password, String role) {
        this.id=id;
        this.username=username;
        this.password = password;
        this.role_id=role;
    }*/

}

