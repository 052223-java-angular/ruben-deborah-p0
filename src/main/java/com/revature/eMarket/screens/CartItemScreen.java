package com.revature.eMarket.screens;

import com.revature.eMarket.models.CartItem;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.Review;
import com.revature.eMarket.services.CartItemService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class CartItemScreen implements IScreen{
    private CartItemService cartItemService;
    Session session;

    private static final Logger logger = LogManager.getLogger(CartScreen.class);
    public void details(Scanner scan, CartItem cartItem) {

        logger.info("Start details process...");
        System.out.print("[" + cartItem.getId() + "] ");
        System.out.print("Name: " + cartItem.getName() + " ");
        System.out.print("Price: " + cartItem.getPrice() + " ");
        System.out.print("Stock: " + cartItem.getQuantity() + " \n");

        List<CartItem> cartItems = new ArrayList<>();
        String input = "";

        exit:
        {

            while (true) {
                System.out.println("Select: [x to exit]");
                System.out.println("\n[1] Remove from cart");
                System.out.println("[x] Exit to products");

                switch (scan.nextLine()) {
                    case "1":
                        logger.info("Start cart removal process...");
                        cartItemService.remove(session.getCart_id());
                        System.out.println("Product id: " + cartItem.getId());
                        break;
                    case "x":
                        logger.info("exiting cart details");

                        break exit;

                }
            }

        }
        System.out.print("Huh?");
    }
                        @Override
    public void start(Scanner scan) {

    }

}
