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

    public void setSession(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.role_id = user.getRole_id();
    }
}