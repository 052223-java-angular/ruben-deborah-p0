package com.revature.eMarket.screens;

import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class MenuScreen implements IScreen {
    private Session session;

    @Override
    public void start(Scanner scan) {
        clearScreen();
        System.out.print("Welcome to Menu Screen" + session.getUsername() + "!\n");
//        scan.nextLine();
    }


    /*************************************** Helper Method ************************************/


    /**
     * Clears the console screen.
     */
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}