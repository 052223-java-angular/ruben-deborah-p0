package com.revature.eMarket.screens;

import com.revature.eMarket.services.RouterService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static java.lang.System.exit;

@AllArgsConstructor
public class SignOnScreen implements IScreen {
    private static final Logger logger = LogManager.getLogger(SignOnScreen.class);
    private final RouterService router;
    @Override
    public void start(Scanner scan) {
        String input = "";
        logger.info("Landing screen.");

        exit:
        {
            while (true) {

                System.out.println("\n[1] Register Screen");
                System.out.println("[2] Login Screen");
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
                        logger.info("Navigating to Login Screen");
                        router.navigate("/login", scan);
                        break;
                    case "x":
                        logger.info("Exit program");
                        System.out.println("\nGoodbye!");
                        System.exit(1);
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
}
