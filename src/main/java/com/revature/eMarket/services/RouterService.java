package com.revature.eMarket.services;

import com.revature.eMarket.screens.HomeScreen;
import com.revature.eMarket.screens.RegisterScreen;

import java.util.Scanner;

public class RouterService {

    public void navigate(String path, Scanner scan) {

        switch (path) {
            case "/home":
                new HomeScreen(this).start(scan);
                break;
            case "/register":
                new RegisterScreen().start(scan);
                break;
            default:
                break;
        }
    }
}