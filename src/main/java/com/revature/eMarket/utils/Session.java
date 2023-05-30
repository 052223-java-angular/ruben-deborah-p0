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

    public void setSession(Optional<User> user, String cart) {
        //System.out.println(user);
        this.id = user.get().getId();
        this.username = user.get().getUsername();
        this.role_id = user.get().getRole_id();
        this.cart_id = cart;
    }

    public void logoutSession() {
        this.id = "";
        this.username = "";
        this.role_id = "";
        this.cart_id = "";
    }


    public void setSession(String id){
        this.id = id;
        this.username = id;
        this.role_id = "1";
    }

    public  void setSessionCart(String id) {
        this.cart_id = id;
    }

}