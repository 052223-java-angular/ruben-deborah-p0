package com.revature.eMarket.utils;

import com.revature.eMarket.models.User;
import lombok.*;

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

    public void setSession(User user, String id) {
        //System.out.println(user);
        this.id = user.getId();
        this.cart_id = user.getId();
        this.username = user.getUsername();
        this.role_id = user.getRole_id();
    }
    public void setSession(String id, String name, String cart_id){
        this.id = id;
        this.username = name;
        this.cart_id = cart_id;
    }
}