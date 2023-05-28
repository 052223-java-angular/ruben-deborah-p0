package com.revature.eMarket.screens;

import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.services.UserService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@AllArgsConstructor
public class LogInScreen implements IScreen{
    private final RouterService router;
    private final UserService userService;
    private Session session;
    private static final Logger logger = LogManager.getLogger(LogInScreen.class);

    @Override
    public void start(Scanner scan) {
        String input = "";
        String username = "";
        String password = "";

        logger.info("Start login process...");

        exit: {
            while(true) {
                logger.info("Login to eMarket!");
                clearScreen();
                System.out.println("Sign in here!");
                System.out.println("[b] Back to main menu");
                System.out.println("[x] Exit");

                username = getUsername(scan);
                logger.info("Username: " + username);
//                System.out.println("Username" + username);

                if (username.equals("b")) {
                    logger.info("Returning back to the home screen...");
                    router.navigate("/home", scan);
                    break exit;
                }

                if (username.equals("x")) {
                    logger.info("Leaving the Login Screen...");
                    break exit;
                }

//                System.out.println("password");

//                System.out.println("\nEnter your password");
                password = getPassword(scan);
                logger.info("Password: " + password );

                if (password.equals("b")) {
                    logger.info("Returning back to the home screen...");
                    router.navigate("/home", scan);
                    break;
                }

                if (password.equals("x")) {
                    logger.info("Leaving the Login Screen...");
                    break exit;
                }

                if (!userService.login(username, password)) {
                    logger.warn("Login Unsuccessful!");
                    System.out.println("\nNo user found with the combination of this username and password.");
                    System.out.println("\nPlease try again...");
                    scan.nextLine();
                    continue;
                } else {
                    System.out.println("\nSuccess!!!");
                }

//                session.setSession(userService.get());
                router.navigate("/menu", scan);
                // return back to the home screen after log-in
                break exit;
            }
        }
    }

    /*************************** Helper methods *****************************************/

    public String getUsername(Scanner scan){
        String username = "";

        System.out.println("\nEnter your username: ");
        username = scan.nextLine();

        return username.equalsIgnoreCase("x") ? "x" : username.equalsIgnoreCase("b") ? "b" : username;
    }

    public String getPassword(Scanner scan){
        String password = "";

        System.out.println("Enter your password: ");
        password = scan.nextLine();

        return password.equalsIgnoreCase("x") ? "x" : password.equalsIgnoreCase("b") ? "b" : password;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}