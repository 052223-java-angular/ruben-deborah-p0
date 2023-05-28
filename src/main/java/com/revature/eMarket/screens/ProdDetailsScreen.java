package com.revature.eMarket.screens;

import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.Review;
import com.revature.eMarket.services.ProductService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@AllArgsConstructor
public class ProdDetailsScreen implements IScreen {
    private final ProductService productServ;

    public void details(Scanner scan, Product product) {
        System.out.print("[" + product.getId() + "] ");
        System.out.print("Name: " + product.getName() + " ");
        System.out.print("Price: " + product.getPrice() + " ");
        System.out.print("Stock: " + product.getStock() + " \n");

        List<Review> reviews = new ArrayList<>();
        String input = "";


        exit:
        {
            while (true) {
                System.out.println("Select: [x to exit]");
                System.out.println("\n[1] View All Reviews");
                System.out.println("[2] Leave a Review");
                System.out.println("[x] Exit to products");

                switch (scan.nextLine()){
                    case "1":
                        reviews = productServ.findByProdId(product.getId());
                        System.out.println("Product id: "+product.getId());
                        printList(reviews);

                        break;
                    case "x":
                        System.out.println("Leaving Reviews");
                        break exit;
                    default:
                        System.out.println("Invalid selection, try again.");
                        break;
                }
            }
        }

    }

    public void printList(List<Review> list) {
        System.out.println("Test review print: " + list);
        if (list.isEmpty()) {

            return;
        }
        for (int i = 0; i < list.size(); i++) {
            loopPrint(list.get(i));
        }
    }

    public void loopPrint(Review review) {
        System.out.print("[" + review.getId() + "] ");
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
