package com.revature.eMarket.screens;

import com.revature.eMarket.services.RouterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class HomeScreen implements IScreen {
    private final RouterService router;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);


    public HomeScreen(RouterService router) {
        this.router = router;
    }
    @Override
    public void start(Scanner scan) {
        clearScreen();
        String input = "";
        logger.info("Navigated to Home Screen.");

        exit:
        {
            while (true) {

                System.out.println("\n[1] Register Screen");
                System.out.println("[2] Menu Screen");
                System.out.println("[3] Login Screen");
<<<<<<< HEAD
                System.out.println("[4] Products Screen");
=======
                System.out.println("[4] Product Screen");
>>>>>>> 5cf5d464ef1c251b2a44c55f8f563380a60d9a38
                System.out.println("[x] Exit");

                System.out.print("\nEnter: ");
                input = scan.nextLine();

                switch(input.toLowerCase()) {
                    case "1":
                        logger.info("Navigating to Register Screen");
                        // Navigate to RegisterScreen
                        router.navigate("/register", scan);
                        break;
                    case "2":
                        logger.info("Navigating to Menu Screen");
                        // Navigate to MenuScreen
                        router.navigate("/menu", scan);
                    case "3":
                        logger.info("Navigating to Login Screen");
//                        router.navigate("/login", scan);
                        router.navigate("/login", scan);
                        break;
                    case "4":
<<<<<<< HEAD
                        logger.info("Navigating to Product Screen");
//                        router.navigate("/login", scan);
=======
                        logger.info("Navigate to Products Screen");
>>>>>>> 5cf5d464ef1c251b2a44c55f8f563380a60d9a38
                        router.navigate("/product", scan);
                        break;
                    case "x":
                        logger.info("Exit Home Screen");
                        System.out.println("\nGoodbye!");
                        break exit;
                    default:
                        logger.warn("Invalid Option");
                        clearScreen();
                        System.out.println("Choose a valid option.");
                        System.out.print("Press [Enter] to continue...");
                        scan.nextLine();
                        break;
                }
            }
        }
    }

    /***************************** Helper Methods *****************************/

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
