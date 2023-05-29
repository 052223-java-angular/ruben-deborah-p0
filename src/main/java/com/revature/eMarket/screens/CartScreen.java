package com.revature.eMarket.screens;

import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.CartItems;
import com.revature.eMarket.services.CartService;
import com.revature.eMarket.services.ProductService;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class CartScreen implements IScreen{
    private final RouterService router;
    private final CartService cartService;
    private final ProductService prodService;
    private final Session session;
//    getProdService


    @Override
    public void start(Scanner scan) {
        String input = "";
        String itemQuantity ="";
        Cart cart = cartService.findCartByCardId(session.getCart_id());
        List<CartItems> cartItems = cartService.findAllCartItemsByCartId(cart.getId());
//        int amount = 0;

//            for(CartItems c : cartItems){
//                System.out.println(c.getProduct_id() + " " + c.getQuantity());
//            }
        exit:{
            // cart screen emptied
            if (cartItems.isEmpty()) {
                cartIsEmpty(scan);
                break exit;
            }
        }

//        Optional<Cart> ct = cart.getCartByUserId("08ccc180-30d9-4771-b384-2fba9ebdffa1");
//            List<CartItems> cartItems = ct.get().getItems();


//            System.out.println("\nEnter (x to cancel: ");
//            input = scan.nextLine();
        // cart screen
        while (true){
            clearScreen();
            System.out.println("Welcome to the Cart Screen!" + session.getUsername() + "!");
            System.out.println("Press [Enter] to continue...");

            // View Shopping cart
            System.out.println("View shopping cart");
            ViewCartItems(cartItems);

            // navigate through the options
            System.out.println("\nProduct name: "); // product name added
            System.out.println("Product price: "); // price of the product
            System.out.println("[r] Remove an item" + "[m] Modify an item");
            System.out.println("[1] Checkout");
            System.out.println("[b] Back to the main menu" + "[x] Exit");

            switch (input.toLowerCase()){
                case "b":
                    router.navigate("/home", scan);
                    break;
                case "m":
                    System.out.println("\nEnter item to modify");
                    itemQuantity = scan.nextLine();
                case "r":
                    System.out.println("");

            }

        }

    }


    /***************************** Helper Methods *****************************/

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    private void cartIsEmpty(Scanner scan) {
        return;
    }
    private void ViewCartItems(List<CartItems> cartItems) {
        return;
    }
}
