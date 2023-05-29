package com.revature.eMarket.utils;

import com.revature.eMarket.models.User;
import lombok.*;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Session {
    private String id;
    private String username;
    private String role_id;
    private String cart_id;

    public void setSession(Optional<User> user) {
        //System.out.println(user);
        this.id = user.get().getId();
        this.cart_id = user.get().getId();
        this.username = user.get().getUsername();
        this.role_id = user.get().getRole_id();
    }
    public void setSession(String id, String name, String cart_id){
        this.id = id;
        this.username = name;
        this.cart_id = cart_id;
    }
}