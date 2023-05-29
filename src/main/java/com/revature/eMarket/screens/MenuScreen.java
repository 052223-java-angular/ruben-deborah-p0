package com.revature.eMarket.screens;

import com.revature.eMarket.services.CartService;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class MenuScreen implements IScreen {
    private CartService cartService;
    private RouterService router;
    private Session session;

    @Override
    public void start(Scanner scan) {
        System.out.print("Welcome to Menu Screen" + session.getUsername() + "!\n");


    }
}