package com.revature.eMarket.screens;

import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.User;
import com.revature.eMarket.services.ProductService;
import com.revature.eMarket.services.RouterService;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class ProductScreen implements IScreen{
    private final ProductService productServ;
    private final RouterService router;


    @Override
    public void start(Scanner scan) {

            List<Product> inventory = productServ.findAll();

            while (true) {
                System.out.println("\nProducts Screen. [Enter to cont..]");
                System.out.println("\n[1] View All Products]");
                System.out.println("\n[x] Exit ");

                switch (scan.nextLine()) {
                    case "1":
                        System.out.println("Created user confirm test [y]");

                        for (int i = 0; i < inventory.size(); i++) {
                            System.out.print("[" + inventory.get(i).getName() + "] ");
                            System.out.print(inventory.get(i).getName() + " ");
                            System.out.print("Price: " + inventory.get(i).getPrice() + " ");
                            System.out.print("Stock: " + inventory.get(i).getStock() + " ");
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
}
