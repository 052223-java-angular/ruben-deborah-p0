package com.revature.eMarket.services;

import com.revature.eMarket.daos.UserDAO;
import com.revature.eMarket.models.User;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public boolean isValidUsername(String username) {
        // checks if username 8-20 characters long, no _ or . at end, no _ or . at beginning, a-z, A-Z, 0-9
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    public boolean isUniqueUsername(String username) {
        Optional<User> userOpt = userDAO.findByUsername(username);
        if(userOpt.isEmpty()){
            return true;
        }
        return false;
    }

    public User register(String username, String password) {

        return null;
    }
}
