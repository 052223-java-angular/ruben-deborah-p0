package com.revature.eMarket.screens;

import java.util.Scanner;

import  lombok.*;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.services.UserService;

@AllArgsConstructor
public class RegisterScreen implements IScreen {
    private final UserService userService;

    @Override
    public void start(Scanner scan) {
        String input = "";
        String username = "";
        String password = "";

        exit:
        {
            while (true) {
                System.out.println("\nRegister Screen.");
                scan.nextLine();

                username = getUsername(scan);

                break exit;
            }
        }
    }

    /*************************** Helper methods *****************************************/

    public String getUsername(Scanner scan) {
        while (true) {
            System.out.print("\nEnter a username (x to cancel): ");
            String username = scan.nextLine();

            System.out.print("username:" + username);

            if (username.equalsIgnoreCase("x")) {
                return "x";
            }
            if (!userService.isValidUsername(username)) {
                System.out.println("Invalid username. [8.20 chars, alpha num].");
                System.out.println("[Enter] to continue.");
                scan.nextLine();
                continue;
            }
            return username;
        }
    }

    public String getPassword() {
        return "";
    }


}



