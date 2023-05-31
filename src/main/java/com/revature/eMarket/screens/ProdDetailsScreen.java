package com.revature.eMarket.screens;

import com.revature.eMarket.models.CartItem;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.Review;
import com.revature.eMarket.models.User;
import com.revature.eMarket.services.CartItemService;
import com.revature.eMarket.services.CartService;
import com.revature.eMarket.services.ProductService;
import com.revature.eMarket.services.UserService;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@AllArgsConstructor
public class ProdDetailsScreen implements IScreen {
    private final ProductService productServ;
    private final CartItemService cartItemService;
    private final CartService cartService;
    Session session;
    private static final Logger logger = LogManager.getLogger(ProdDetailsScreen.class);

    public void details(Scanner scan, Product product) {

        logger.info("Start details process...");

        List<Review> reviews = new ArrayList<>();
        String input = "";

        exit:
        {
            System.out.print("[" + product.getId() + "] ");
            System.out.print("Name: " + product.getName() + " ");
            System.out.print("Price: " + product.getPrice() + " ");
            System.out.print("Stock: " + product.getStock() + " \n");

            while (true) {

                System.out.println("\n[1] View All Reviews");
                System.out.println("[2] Leave a Review");
                System.out.println("[3] Add to cart");
                System.out.println("[x] Exit to products");

                System.out.print("\nSelect an option: ");
            rev:
            {
                switch (scan.nextLine()) {
                    case "1":
                        logger.info("Start reviews process...");
                        reviews = productServ.findByProdId(product.getId(), session.getId());
                        printList(reviews);
                        System.out.print("\nEnter to continue: ");
                        input = scan.nextLine();
                        break rev;
                    case "2":
                        logger.info("Start add review process...");
                        String rate = "";
                        String rev = "";
                        System.out.println("user writes Reviews");

                        jump:
                        {
                            while (true) {
                                // rate out of 5
                                System.out.println("Rate product [0 - 5]: ");
                                rate = scan.nextLine();
                                if (rate.equals("x")) {
                                    logger.info("Exit Registration Screen!");
                                    break exit;
                                }

                                if (!productServ.isValidRating(rate)) {
                                    System.out.println("Invalid input, [0,5]. Retry.");
                                    break;
                                }
                                System.out.println("Leave a written review: ");
                                rev = scan.nextLine();
                                if (rev.equals("x")) {
                                    logger.info("Exit Registration Screen!");
                                    break exit;
                                }

                                logger.info("Manual USEr input for testing");
                                System.out.println("Rating: " + rate);
                                System.out.println("Review: " + rev);
                                System.out.println("Confirm? [y/n] ");
                                Review review = new Review(rate, rev, session.getId(), product.getId());

                                switch (scan.nextLine()) {
                                    case "y":
                                        logger.info("User confirms review.");
                                        productServ.insert(review);
                                        break rev;

                                    case "n":
                                        logger.info("Leaving review input....");
                                        break jump;
                                    default:
                                        logger.warn("Invalid Option");
                                        System.out.println("Choose a valid option.");
                                        System.out.print("Press [Enter] to continue...");
                                        scan.nextLine();
                                        break;
                                }
                            }
                        }
                    case "3":
                        logger.info("Add product to cart");
                        CartItem cartItem = new CartItem(product, session.getCart_id());

                        cartService.findById(session.getId());
                        cartItemService.insert(cartItem);

                        System.out.println("Item added to cart! [Enter] to continue");
                        input = scan.nextLine();
                        break;
                    case "x":
                        logger.info("Exiting product details");
                        System.out.println("Exiting product screen.");
                        break exit;
                    default:
                        logger.warn("Wrong selection...");
                        System.out.println("Invalid selection, try again.");
                        break;
                }
            }
            }
        }

    }
    /*************************** Helper methods *****************************************/
    public void printList(List<Review> list) {
        if (list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            loopPrint(list.get(i));
        }
    }

    public void loopPrint(Review review) {
        logger.info("Print all reviews...");
        //System.out.format("%-15s%-10.2f%5d\n", "Rating: " + review.getRating(), product.getPrice(), product.getStock());
        System.out.print("Rating: " + review.getRating() + " ");
        System.out.print("Review: " + review.getReview() + " ");
        System.out.print("User: " + review.getUser_id() + " \n");
    }

    public void start(Scanner scan) {

        List<Product> inventory = new ArrayList<>(); // = productServ.findAll();
        String input = "";
        while (true) {

        }
    }
}
