package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartDAO;
import com.revature.eMarket.daos.CartItemDAO;
import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.CartItems;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

@AllArgsConstructor
public class CartItemService {
    private final CartDAO cartDAO;
    private final CartItemDAO cartItemDAO;
    public List<CartItems> findAllCartItemsByCartId(String cartId){
        List<CartItems> cartItems = cartItemDAO.findAllCartItemsByCardId(cartId);
        return cartItems;
    }

    public void createCartItem(CartItems cartItems) {
        cartItemDAO.createCartItem(cartItems);
    }

    private String getCartItemChosen(List<CartItems> cartItems, Scanner scan) {
        String input = "";
        while (true) {
            clearScreen();
            System.out.println("Choosing cart item...");

            // show cart item options
            viewCartItemChosen(cartItems);

            System.out.print("\nChoose an option (x to cancel): ");

            input = scan.nextLine();
            if (input.equalsIgnoreCase("x")) {
                return "x";
            } else if (!isValidNumber(input) || Integer.parseInt(input) > cartItems.size() ||
                    Integer.parseInt(input) < 1) {
                clearScreen();
                System.out.println("Input is invalid: must be a number between 1 and " + cartItems.size());
                System.out.print("\nEnter to continue...");
                scan.nextLine();
                continue;
            }

            return input;
        }
    }

    private void viewCartItemChosen(List<CartItems> cartItems) {
        int counter = 1;
        for(CartItems cartItem : cartItems){
            System.out.println("\n[" + counter +"]" +
                    cartItem.getName() +
                    " - Price: $" +
                    cartItem.getPrice() +
                    " Quantity: " + cartItem.getQuantity());
            counter += 1;
        }
    }

    /*private void updateCartAndCartItem(Cart cart, CartItems cartItem, int i) {
        Float newPrice = cartItem.getPrice()
                .divide(Float.valueOf(cartItem.getQuantity()))
                .multiply(Float.valueOf(quantity));

        // update cart
        cart.setTotalCost(cart.getTotalCost().add(newPrice.subtract(cartItem.getPrice())));
        cartService.updateCart(cart);

        // update cart item
        cartItem.setPrice(newPrice);
        cartItem.setQuantity(quantity);
        cartItemService.updateCartItem(cartItem);
    }*/

    private boolean isValidNumber(String possibleNum) {
        if (possibleNum.length() == 0 || !Pattern.matches("[0-9]+", possibleNum)) {
            return false;
        }
        return true;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
