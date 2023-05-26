package com.revature.eMarket.screens;

import java.util.Scanner;

import com.revature.eMarket.models.User;
import com.revature.eMarket.services.RoleService;
import com.revature.eMarket.utils.Session;
import  lombok.*;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.services.UserService;

@AllArgsConstructor
public class RegisterScreen implements IScreen {
    private final UserService userService;
    private final RouterService router;
    private Session session;


    @Override
    public void start(Scanner scan) {
        String input = "";
        String username = "";
        String password = "";

        exit:
        {
            while (true) {
                System.out.println("\nRegister Screen. [Enter to cont..]");
                scan.nextLine();

                username = getUsername(scan);

                if (username.equals("x")) {
                    break exit;
                }

                // get password
                password = getPassword(scan);

                if(password.equals("x")) {
                    break exit;
                }

                System.out.println("Please confirm your credentials: ");
                System.out.println("\nUsername: " + username);
                System.out.println("\npassword: " + password);
                System.out.println("\n[y/n]: ");

                switch(scan.nextLine()) {
                    case "y":
                        System.out.println("Created user confirm test [y]");
                        User createdUser = userService.register(username, password);
                        //Session session = new Session();
                        session.setSession(createdUser);
                        router.navigate("/menu", scan);
                        break exit;

                    case "n":
                        System.out.println("Restarting register process");
                        System.out.print("Press [Enter] to continue...");
                        scan.nextLine();
                    default:
                        System.out.println("Choose a valid option.");
                        System.out.print("Press [Enter] to continue...");
                        scan.nextLine();
                        break;
                }

                break exit;
            }
        }
    }

    /*************************** Helper methods *****************************************/

    public String getPassword(Scanner scan) {
        String password = "";
        String confirm = "";

        while(true) {
            System.out.print("\nEnter a password (x to cancel): ");
            password = scan.nextLine();

            System.out.print("password:" + password);

            if (password.equalsIgnoreCase("x")) {
                return "x";
            }
            // verify if input password is valid
            if (!userService.isValidPassword(password)) {
                System.out.println("Invalid password. 8 chars, 1 letter and 1 number. [Enter to continue...]");
                scan.nextLine();
                continue;
            }

            System.out.println("Confirm password: ");
            confirm = scan.nextLine();

            if (confirm.equalsIgnoreCase("x")) {
                return "x";
            }

            if (!userService.isSamePassword(password, confirm)) {
                System.out.println("Passwords need to be the same. [Enter to cont...]");
                scan.nextLine();
                continue;
            }



            break;
        }
        return password;
    }

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
                System.out.println("Invalid username. [8.20 chars, alpha num].");
                System.out.println("[Enter] to continue.");
                scan.nextLine();
                continue;
            }

            if (!userService.isUniqueUsername(username)) {

                System.out.print("Username is not unique! [Enter] to continue: ");
                scan.nextLine();
                continue;
            }

            break;
        }
        return username;
    }

    public String getPassword() {
        return "";
    }


}



