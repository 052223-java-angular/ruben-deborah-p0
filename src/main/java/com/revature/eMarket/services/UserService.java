package com.revature.eMarket.services;

public class UserService {

    public boolean isValidUsername(String username) {
        // checks if username 8-20 characters long, no _ or . at end, no _ or . at beginning, a-z, A-Z, 0-9
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }
}
