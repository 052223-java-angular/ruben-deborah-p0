package com.revature.eMarket.screens;

import com.revature.eMarket.services.RouterService;

import java.util.Scanner;

public class HomeScreen implements IScreen {
    private final RouterService router;

    public HomeScreen(RouterService router) {
        this.router = router;
    }
    @Override
    public void start(Scanner scan) {
        clearScreen();
        String input = "";

        exit:
        {
            while (true) {
                System.out.println("Welcome to eMarket!");

                System.out.println("\n[1] Register Screen");
                System.out.println("\n[2] Menu Screen");
                System.out.println("\n[x] Exit");

                System.out.print("\nEnter: ");
                input = scan.nextLine();

                switch(input.toLowerCase()) {
                    case "1":
                        router.navigate("/register", scan);
                        break;
                    case "2":
                        router.navigate("/menu", scan);
                    case "x":
                        System.out.println("\nGoodbye.");
                        break exit;
                    default:
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
