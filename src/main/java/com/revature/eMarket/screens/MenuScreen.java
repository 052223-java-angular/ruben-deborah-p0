package com.revature.eMarket.screens;

import com.revature.eMarket.models.Cart;
import com.revature.eMarket.services.CartService;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@AllArgsConstructor
public class MenuScreen implements IScreen {
    private static final Logger logger = LogManager.getLogger(RegisterScreen.class);

    private CartService cartService;
    private RouterService router;
    private Session session;

    @Override
    public void start(Scanner scan) {
        System.out.print("Welcome to Session Screen " + session.getUsername() + "!\n");
        System.out.println("id: "+ session.getId());
        System.out.println("role: "+ session.getRole_id());
        System.out.println("cart id: "+ session.getCart_id());



        while (true) {

            System.out.println("\n[1] Login Out");
            System.out.println("[x] Back");

            System.out.print("\nEnter: ");
            String input = scan.nextLine();

            switch(input.toLowerCase()) {
                case "1":
                    logger.info("Navigating to Login Screen");
                    session.logoutSession();
                    router.navigate("/landing", scan);
                    break;
                case "x":
                    logger.info("Exiting...");
                    router.navigate("/home", scan);
                    break;
                default:
                    logger.warn("Invalid Option");
                    System.out.println("Choose a valid option.");
                    System.out.print("Press [Enter] to continue...");
                    scan.nextLine();
                    break;
            }
        }

    }
}