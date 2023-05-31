package com.revature.eMarket.screens;

import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.User;
import com.revature.eMarket.services.CartService;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.services.UserService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.Scanner;

@AllArgsConstructor
public class LogInScreen implements IScreen{
    private final RouterService router;
    private final UserService userService;
    private final CartService cartService;
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
                logger.info("Welcome to the Login Screen of eMarket!");
                clearScreen();

                System.out.println("Login Screen.\n");
                System.out.println("[x] Exit to menu");

                // get username
                username = getUsername(scan);
                logger.info("Username: " + username);

                if (username.equals("x")) {
                    logger.info("Returning back to the home screen...");
                    if (session.getId() == null) {
                        router.navigate("/landing", scan);
                    }
                    router.navigate("/home", scan);
                    break exit;
                }

                // get password
                password = getPassword(scan);
                logger.info("Password: " + password );

                if (password.equals("x")) {
                    logger.info("Returning back to the home screen...");
                    if (session.getId() == null) {
                        router.navigate("/landing", scan);
                    }
                    router.navigate("/home", scan);
                    break exit;
                }

                // confirm user's credentials
                System.out.println("Please confirm your credentials");
                System.out.println("\nUsername: " + username);
                System.out.println("Password: " + password);
                System.out.println("\nEnter [y/n]: ");

                switch (scan.nextLine()){
                    case "y":
                        Optional<User> confirmedUser = userService.login(username, password);
                        if(confirmedUser.isEmpty()){
                            clearScreen();
                            System.out.println("Invalid username or password...");
                            System.out.println("\nPress [Enter] to continue...");
                            scan.nextLine();
                            break;
                        }
                        // gets cart id and sets this current session with user cart
                        String cid = confirmedUser.get().getId().toString();
                        Optional<Cart> cart = cartService.findById(cid);

                        session.setSession(confirmedUser, cart.get().getId());
                        // session successful
                        System.out.println("\nLogin Successful!");
                        // navigate back to the menu screen
                        router.navigate("/home", scan);
                        break exit;
                    case "n":
                        clearScreen();
                        logger.info("Restarting login");
                        System.out.println("Restarting process...");
                        System.out.println("\nPress [Enter] to continue...");
                        scan.nextLine();
                        break;
                    default:
                        clearScreen();
                        logger.warn("Wrong option");
                        System.out.println("Invalid option!");
                        System.out.println("\nPress [Enter] to continue...");
                        scan.nextLine();
                        break;
                }

            }
        }
    }

    /*************************** Helper methods *****************************************/

    public String getUsername(Scanner scan){
        String username = "";

        while (true){
            System.out.println("\nEnter your username (x to cancel): ");
            username = scan.nextLine();

            if (username.equalsIgnoreCase("x")) {
                return "x";
            }
            if (username.equalsIgnoreCase("b")) {
                return "b";
            }
                if (!userService.isValidUsername(username)) {
                    clearScreen();
                    logger.warn("Login Unsuccessful!");
                    System.out.println("No user found with this username");
                    System.out.println("\nPlease try again...");
                    scan.nextLine();
                    continue;
                }
                break;
        }
        return username;
    }

    public String getPassword(Scanner scan){
        String password = "";

        while (true){
        System.out.println("Enter your password(x to cancel: ");
        password = scan.nextLine();
            if (password.equalsIgnoreCase("x")) {
                return "x";
            }

            if (password.equalsIgnoreCase("b")) {
                return "b";
            }

            if (password.equals("")) {
                clearScreen();
                System.out.println("Password is missing");
                System.out.print("\nPress [Enter] to continue...");
                scan.nextLine();
                continue;
            }
            break;
        }
        return password;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}