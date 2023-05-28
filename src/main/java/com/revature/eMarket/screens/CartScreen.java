package com.revature.eMarket.screens;

import com.revature.eMarket.models.Cart;
import com.revature.eMarket.services.CartService;
import com.revature.eMarket.services.RouterService;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.Scanner;

@AllArgsConstructor
public class CartScreen implements IScreen{
    private final RouterService router;
    private final CartService cart;

    @Override
    public void start(Scanner scan) {
        String input = "";
        String item ="";
        int amount = 0;


        while (true){
            System.out.println("Cart Screen!");
            System.out.println("Press [Enter] to continue...");
            System.out.println("\n[1] View shopping cart");
            System.out.println("[2] Product name: "); // product name added
            System.out.println("[3] Product price"); // price of the product
            System.out.println("[r] Remove an item" + "[m] Modify an item" + "[d] Delete an item");
            System.out.println("[4] Checkout");
            System.out.println("[b] Back to the main menu" + "[x] Exit");
            Optional<Cart> ct = cart.getCartByUserId("");
//            List<CartItems> cartItems = ci.get().getItems();

            System.out.println("\nEnter (x to cancel: ");
            input = scan.nextLine();

            switch (input.toLowerCase()){
                case "b":
                    router.navigate("/home", scan);
                    break;
                case "d":
                    System.out.println("Delete an item: ");
                case "m":
                    System.out.println("\nEnter item to modify");
                    item = scan.nextLine();
                case "r":
            }

        }

    }
}
