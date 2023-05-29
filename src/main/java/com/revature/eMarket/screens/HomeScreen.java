package com.revature.eMarket.screens;

import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.utils.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class HomeScreen implements IScreen {
    private final RouterService router;
    private Session session;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);


    public HomeScreen(RouterService router, Session userSession) {

        this.router = router;
        this.session = userSession;
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
                    System.out.println("[4] Product Screen");
                    System.out.println("[x] Logout");

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

                            logger.info("Navigate to Products Screen");
                            router.navigate("/product", scan);
                            break;
                        case "x":
                            logger.info("Logging out. Goodbye!\n");
                            System.out.println("Logging out. Goodbye!\n");
                            session.logoutSession();
                            router.navigate("/landing",scan);
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
