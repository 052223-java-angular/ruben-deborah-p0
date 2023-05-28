package com.revature.eMarket.screens;

import com.revature.eMarket.models.User;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.services.UserService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@AllArgsConstructor
public class RegisterScreen implements IScreen {
    private final UserService userService;
    private final RouterService router;
    private Session session;
    private static final Logger logger = LogManager.getLogger(RegisterScreen.class);


    @Override
    public void start(Scanner scan) {
        String input = "";
        String username = "";
        String password = "";

        logger.info("Start registration process...");

        exit:
        {
            while (true) {
                clearScreen();
                System.out.println("\nWelcome to the Register Screen.");
                System.out.println("Press [Enter] to continue..");
                scan.nextLine();

                // get username
                username = getUsername(scan);

                logger.info("username: {}", username);

                if (username.equals("x")) {
                    logger.info("Exit Registration Screen!");
                    break exit;
                }

                // get password
                password = getPassword(scan);

                if(password.equals("x")) {
                    logger.info("Exit Registration Screen!");
                    break exit;
                }

                // confirm user's info
                clearScreen();
                System.out.println("Please confirm your credentials: ");
                System.out.println("\nUsername: " + username);
                System.out.println("Password: " + password);
                System.out.print("\nEnter [y/n]: ");

                switch(scan.nextLine()) {
                    case "y":
                        logger.info("User confirms credentials are correct.");
                        clearScreen();
                        System.out.println("Created user confirm test [y]");
                        User createdUser = userService.register(username, password);
                        //Session session = new Session();
                        session.setSession(createdUser);
                        router.navigate("/menu", scan);
                        break exit;

                    case "n":
                        logger.info("Restarting registration process....");
                        System.out.println("Restarting register process");
                        System.out.print("Press [Enter] to continue...");
                        scan.nextLine();
                    default:
                        logger.warn("Invalid Option");
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

            System.out.print("Password:" + password);

            if (password.equalsIgnoreCase("x")) {
                return "x";
            }
            // verify if input password is valid
            if (!userService.isValidPassword(password)) {
                System.out.println("Invalid password. 8 chars, 1 letter and 1 number.");
                System.out.println("\nPress [Enter] to continue...");
                scan.nextLine();
                continue;
            }

            System.out.println("\nConfirm password: ");
            confirm = scan.nextLine();

            if (confirm.equalsIgnoreCase("x")) {
                return "x";
            }

            if (!userService.isSamePassword(password, confirm)) {
                clearScreen();
                System.out.println("Passwords need to be the same.");
                System.out.println("\nPress [Enter] to continue...");
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

            if (username.equalsIgnoreCase("x")) {
                return "x";
            }
            if (!userService.isValidUsername(username)) {
                logger.warn("Invalid username for: {}", username);
                clearScreen();
                System.out.println("Invalid username. [8.20 chars, alpha num].");
                System.out.println("\nPress [Enter] to continue.");
                scan.nextLine();
                continue;
            }

            if (!userService.isUniqueUsername(username)) {
                logger.warn("Username is not unique for: {}", username);
                clearScreen();
                System.out.print("Username is not unique!");
                System.out.print("\nPress [Enter] to continue...");
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
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}



