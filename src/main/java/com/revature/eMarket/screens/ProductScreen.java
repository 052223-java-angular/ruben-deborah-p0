package com.revature.eMarket.screens;

import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.User;
import com.revature.eMarket.services.ProductService;
import com.revature.eMarket.services.RouterService;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class ProductScreen implements IScreen{
    private final ProductService productServ;
    private final RouterService router;


    @Override
    public void start(Scanner scan) {
            List<Product> inventory = new ArrayList<>(); // = productServ.findAll();

            while (true) {
                System.out.println("\nProducts Screen. [Enter to cont..]");
                System.out.println("\n[1] View All Products");
                System.out.println("\n[2] View By Name");
                System.out.println("\n[x] Exit ");

                switch (scan.nextLine()) {
                    case "1": // print the list
                        System.out.println("Created user confirm test [y]");
                        inventory = productServ.findAll();
                        printList(inventory);
                        break;
                    case "2":
                        System.out.println("Enter product name");
                        String temp = scan.nextLine();
                        Product prod = productServ.findByName(temp);

                        if (prod != null) {
                            System.out.print("[" + prod.getName() + "] ");
                            System.out.print(prod.getName() + " ");
                            System.out.print("Price: " + prod.getPrice() + " ");
                            System.out.print("Stock: " + prod.getStock() + " \n");

                        }
                        else {
                            System.out.println("No product exists. [Enter to cont...]");
                            scan.nextLine();
                        }
                        break;
                    case "x":
                        System.out.println("Leaving products.[Enter] to cont...");
                        router.navigate("/home", scan);
                        break;
                    default:
                        System.out.println("Choose a valid option. [Enter] to cont...");
                        scan.nextLine();
                }

            }

    }


    // Takes list of products and outputs
    public void printList(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + list.get(i).getName() + "] ");
            System.out.print(list.get(i).getName() + " ");
            System.out.print("Price: " + list.get(i).getPrice() + " ");
            System.out.print("Stock: " + list.get(i).getStock() + " \n");
        }
    }

}
