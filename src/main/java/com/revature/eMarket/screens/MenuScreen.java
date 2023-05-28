package com.revature.eMarket.screens;

import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class MenuScreen implements IScreen {
    private Session session;

    @Override
    public void start(Scanner scan) {
        System.out.print("Session Id: " + session.getUsername() + "!\n");
        
    }
}