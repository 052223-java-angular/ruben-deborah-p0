package com.revature.eMarket.screens;

import java.util.Scanner;

public class RegisterScreen implements IScreen {

    @Override
    public void start(Scanner scan) {
        String input = "";


        exit:
        {
            while (true) {
                System.out.println("\nRegister Screen");
                scan.nextLine();
                break exit;
            }
        }
    }
}