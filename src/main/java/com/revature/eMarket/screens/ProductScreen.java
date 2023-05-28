package com.revature.eMarket.screens;

import com.revature.eMarket.models.Category;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.User;
import com.revature.eMarket.services.CategoryService;
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
    private final CategoryService catServ;


    @Override
    public void start(Scanner scan) {
            List<Product> inventory = new ArrayList<>(); // = productServ.findAll();
            String input = "";

            while (true) {
                System.out.println("Products Screen. [Enter to cont..]");
                System.out.println("\n[1] View All Products");
                System.out.println("[2] View By Name");
                System.out.println("[3] View By Category");
                System.out.println("[4] Search in range [low,high]");
                System.out.println("[x] Exit ");

                switch (scan.nextLine()) {
                    case "1": // print the list
                        inventory = productServ.findAll();
                        printList(inventory);
                        break;
                    case "2":
                        System.out.println("Enter product name");
                        input = scan.nextLine();
                        Product prod = productServ.findByName(input);

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
                    case "3":
                        System.out.println("Search by Category\n");
                        // display categories as options
                        List<Category> catList = catServ.findAll();
                        displayCategory(catList);
                        input = scan.nextLine();

                        inventory = productServ.findById(input);
                        printList(inventory);
                        break;
                    case "4":
                        System.out.println("Enter low: ");
                        String low = scan.nextLine();
                        System.out.println("Enter high: ");
                        String high = scan.nextLine();

                        inventory = productServ.findByRange(low,high);
                        printList(inventory);
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
            loopPrint(list.get(i));
        }
    }

    public void loopPrint(Product product) {
        System.out.print("[" + product.getId() + "] ");
        System.out.print("Name: " + product.getName() + " ");
        System.out.print("Price: " + product.getPrice() + " ");
        System.out.print("Stock: " + product.getStock() + " \n");
    }

    public void displayCategory(List<Category> categories) {
        System.out.println("Select your choice: ");
        for (int i = 0; i < categories.size(); i++) {
            System.out.print("[" + categories.get(i).getId() + "] ");
            System.out.println(categories.get(i).getCategory());
        }
    }

}
