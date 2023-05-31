package com.revature.eMarket.screens;

import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.CartItem;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.services.CartItemService;
import com.revature.eMarket.services.CartService;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

@AllArgsConstructor
public class CartScreen implements IScreen {
    private final RouterService router;
    private final CartService cart;
    private final CartItemService cartItemService;
//    private final CartDAO cartDAO;
//    private final ProductService prodService;
    private final Session session;
    private static final Logger logger = LogManager.getLogger(CartScreen.class);



    @Override
    public void start(Scanner scan) {
        List<CartItem> inventory = new ArrayList<>(); // = productServ.findAll();
        CartScreen details = new CartScreen(this.router, this.cart, this.cartItemService, this.session);
        String input = "";
        Product prod = new Product();
        exit: {
            while (true) {
                System.out.println("Cart Screen. [Enter to cont..]");

                System.out.println("\n[1] View Cart");
                System.out.println("[x] Exit ");
                System.out.println("Select your option: ");

                logger.info("Start cart selection process...");

                switch (scan.nextLine().toLowerCase()) {
                    case "1": // Show All products in store
                        logger.info("Show all cart...");
                        inventory = cartItemService.findAllByCart(session.getCart_id());
                        printList(inventory);
                        input = scan.nextLine();

                        try {
                            int x = Integer.parseInt(input);

                            if (x < 0 || x > inventory.size()) {
                                System.out.println("Invalid option, select again.");
                                break;
                            }
                            //prod = inventory.get(x - 1);

                        } catch (NumberFormatException e) {
                            System.out.println("input is not an int value");
                            break;
                        }
                        break;
                    case "x":
                        logger.info("Exiting cart screen");
                        break exit;
                    default:
                        break;
                }
            }
        }
    }



    /***************************** Helper Methods *****************************/

    public void printList(List<CartItem> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + ( i + 1)  + "]");
            loopPrint(list.get(i));
        }
    }

    public void loopPrint(CartItem cartItem) {
        System.out.print("Name: " + cartItem.getName() + " ");
        System.out.print("Price: " + cartItem.getPrice() + " ");
        System.out.print("Stock: " + cartItem.getQuantity() + "\n");
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private void cartIsEmpty(Scanner scan) {
        // if cart is not found, navigate back to menu
        exit:
        {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the Cart Screen!" + session.getUsername() + "!");
                System.out.println("Press [Enter] to continue...");
                System.out.println("\nThere is nothing in your cart....");
                System.out.println("\n[1] Continue shopping");
                System.out.println("Press [x] to return");

                System.out.println("\nChoose an option: ");
                switch (scan.nextLine()) {
                    case "1":
                        //navigate to product screen
                        router.navigate("/home", scan);
                        break exit;
                    case "x":
                        break exit;
                    default:
                        break;
                }

            }
        }
    }

    private String getCardNumber(Scanner scan){
        String cardNumber = "";

        while(true){
            System.out.println("\nPlease enter your card number: ");
            cardNumber = scan.nextLine();

            if(cardNumber.equalsIgnoreCase("x")){
                return "x";
            }

            if(cardNumber.equalsIgnoreCase("b")){
                return "b";
            }

//            if(!PaymentService.isValidCardNumber(cardNumber)){
//                clearScreen();
//                System.out.println("Invalid card number!");
//                System.out.print("\nPress enter to continue...");
//                scan.nextLine();
//                continue;
//            }
            break;
        }
        return cardNumber;
    }
    private String getExpirationDate(Scanner scan){
        String expirationDate = "";

        while(true){
            System.out.println("\nEnter the expiration date mm/yyyy: ");
            expirationDate = scan.nextLine();

            if(expirationDate.equalsIgnoreCase("x")){
                return "x";
            }

            if(expirationDate.equalsIgnoreCase("b")){
                return "b";
            }

//            if(!PaymentService.isValidExpirationDate(expirationDate)){
//                clearScreen();
//                System.out.println("Invalid expiration date!");
//                System.out.print("\nPress enter to continue...");
//                scan.nextLine();
//                continue;
//            }
            break;
        }
        return expirationDate;
    }
    private String getSecurityCode(Scanner scan){
        String securityCode = "";


        while(true){
            System.out.println("\nEnter the security code: ");
            securityCode = scan.nextLine();

            if(securityCode.equalsIgnoreCase("x")){
                return "x";
            }

            if(securityCode.equalsIgnoreCase("b")){
                return "b";
            }

//            if(!PaymentService.isValidSecurityCode(securityCode)){
//                clearScreen();
//                System.out.println("Invalid expiration security code!");
//                System.out.print("\nPress enter to continue...");
//                scan.nextLine();
//                continue;
//            }
            break;
        }
        return securityCode;
    }

}