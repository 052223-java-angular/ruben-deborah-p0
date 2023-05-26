package com.revature.eMarket.screens;

import com.revature.eMarket.models.User;
import com.revature.eMarket.services.UserService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

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
                clearScreen();
                System.out.println("\nWelcome to the Registration Screen.");
//                scan.nextLine();

                // get username
                username = getUsername(scan);
                if(username.equals("x")){
                    break exit;
                }

                // get password
                password = getPassword(scan);
                if(password.equals("x")){
                    break;
                }

                //confirm user's info
                clearScreen();
                System.out.println("Please confirm your credentials.");
                System.out.println("\nUsername :" + username);
                System.out.println("Password: " + password);
                System.out.println("\n Enter (y/n)");

                switch(scan.nextLine()){
                    case "y":
                        User newUser = userService.register(username, password);
                        break;
                    case "n":
                        clearScreen();
                        System.out.println("\nRestarting process:");
                        System.out.println("\nPress enter to continue...");
                        scan.nextLine();
                        break;
                    default:
                        clearScreen();
                        System.out.println("\nInvalid Option!");
                        System.out.println("\nPress enter to continue...");
                        scan.nextLine();

                        break;
                }
                break exit;
            }
        }
    }

    /*************************** Helper methods *****************************************/

    public String getUsername(Scanner scan) {
        String username = "";

        while (true) {
            System.out.print("\nEnter a username (x to cancel): ");
            username = scan.nextLine();

            System.out.print("username:" + username);

            if (username.equalsIgnoreCase("x")) {
                return "x";
            }
            if (!userService.isValidUsername(username)) {
                clearScreen();
                // username must be 8-20 characters long
                System.out.println("Invalid username. [8.20 chars, alpha num].");
                System.out.println("Press [Enter] to continue.");
                scan.nextLine();
                continue;
            }
            if (!userService.isUniqueUsername(username)) {
                clearScreen();
                // username must be 8-20 characters long
                System.out.println("Username must be unique!");
                System.out.println("Press [Enter] to continue.");
                scan.nextLine();
                continue;
            }
            break;
        }
        return username;
    }

    public String getPassword(Scanner scan) {
//        String password = "";
        return "";
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}



