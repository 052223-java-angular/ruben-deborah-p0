package com.revature.eMarket.screens;

import com.revature.eMarket.models.Category;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.User;
import com.revature.eMarket.services.CategoryService;
import com.revature.eMarket.services.ProductService;
import com.revature.eMarket.services.RouterService;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class ProductScreen implements IScreen{

    private final ProductService productServ;
    private final RouterService router;
    private final CategoryService catServ;

    private static final Logger logger = LogManager.getLogger(ProductScreen.class);


    @Override
    public void start(Scanner scan) {
            List<Product> inventory = new ArrayList<>(); // = productServ.findAll();
            String input = "";
            ProdDetailsScreen details = new ProdDetailsScreen(productServ);
            Product prod = new Product();

            while (true) {
                System.out.println("Products Screen. [Enter to cont..]");
                System.out.println("\n[1] View All Products");
                System.out.println("[2] View By Name");
                System.out.println("[3] View By Category");
                System.out.println("[4] Search in range [low,high]");
                System.out.println("[x] Exit ");
                System.out.println("Select your option: ");

                logger.info("Start products selection process...");

                switch (scan.nextLine()) {
                    case "1": // Show All products in store
                        logger.info("Show all products selected...");
                        inventory = productServ.findAll();
                        printList(inventory);
                        input = scan.nextLine();

                        try {
                            int x = Integer.parseInt(input);

                            if (x < 0 || x > inventory.size()) {
                                System.out.println("Invalid option, select again.");
                                break;
                            }
                            prod = inventory.get(x-1);
                            details.details(scan, prod);
                        }catch(NumberFormatException e) {
                            System.out.println("input is not an int value");
                            break;
                        }
                        break;
                    case "2": // Show specific item and launch to details
                        logger.info("Specific item query ...");
                        System.out.println("Enter product name");
                        input = scan.nextLine();
                        prod = productServ.findByName(input);

                        if (prod != null) {
                            System.out.print("[" + prod.getName() + "] ");
                            System.out.print(prod.getName() + " ");
                            System.out.print("Price: " + prod.getPrice() + " ");
                            System.out.print("Stock: " + prod.getStock() + " \n");

                            //selection(scan, prod, details, input);
                            details.details(scan, prod);
                        }
                        else {
                            logger.warn("No product exists...");
                            System.out.println("No product exists. [Enter to cont...]");
                            scan.nextLine();
                        }
                        break;
                    case "3":
                        logger.info("Start category search...");
                        System.out.println("Search by Category\n");
                        // display categories as options
                        List<Category> catList = catServ.findAll();
                        displayCategory(catList);

                        // query for category items
                        input = scan.nextLine();
                        inventory = productServ.findById(input);
                        printList(inventory);
                        input = scan.nextLine();
                        try {
                            int x = Integer.parseInt(input);

                            if (x < 0 || x > inventory.size()) {
                                System.out.println("Invalid option, select again.");
                                break;
                            }
                            prod = inventory.get(x-1);
                            details.details(scan, prod);
                        }catch(NumberFormatException e) {
                            System.out.println("input is not an int value");
                            break;
                        }
                        break;
                    case "4":
                        logger.info("Start range search...");
                        System.out.println("Enter low: ");
                        String low = scan.nextLine();
                        System.out.println("Enter high: ");
                        String high = scan.nextLine();

                        //display list of range items
                        inventory = productServ.findByRange(low,high);
                        printList(inventory);

                        // select from displayed list of items
                        input = scan.nextLine();
                        try {
                            int x = Integer.parseInt(input);

                            if (x < 0 || x > inventory.size()) {
                                System.out.println("Invalid option, select again.");
                                break;
                            }
                            prod = inventory.get(x-1);
                            details.details(scan, prod);
                        }catch(NumberFormatException e) {
                            System.out.println("input is not an int value");
                            break;
                        }
                        break;
                    case "x":
                        logger.info("Exiting products process...");
                        System.out.println("Leaving products.[Enter] to cont...");
                        router.navigate("/home", scan);
                        break;
                    default:
                        logger.warn("Invalid selection...");
                        System.out.println("Choose a valid option. [Enter] to cont...");
                        scan.nextLine();
                }
            }
    }

    // Takes list of products and outputs
    public void printList(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + ( i + 1)  + "]");
            loopPrint(list.get(i));
        }
    }

    public void loopPrint(Product product) {
<<<<<<< HEAD
        //System.out.print("[" + product.getId() + "] ");
=======
        System.out.print("[" + product.getId() + "] ");
>>>>>>> 5cf5d464ef1c251b2a44c55f8f563380a60d9a38
        System.out.print("Name: " + product.getName() + " ");
        System.out.print("Price: " + product.getPrice() + " ");
        System.out.print("Stock: " + product.getStock() + "\n");
    }

    public void displayCategory(List<Category> categories) {
        System.out.println("Select your choice: ");
        for (int i = 0; i < categories.size(); i++) {
            System.out.print("[" + categories.get(i).getId() + "] ");
            System.out.println(categories.get(i).getCategory());
        }
    }

    public void selection(Scanner scan, Product product, ProdDetailsScreen details, String input) {

        exit: {
            while(true) {
                switch(input.toLowerCase()) {
                    case "1":
                        details.details(scan, product);
                        //router.navigate("/prodDetails", scan);
                        break exit;
                    case "x":
                        System.out.println("Exiting...");
                        break exit;
                    default:
                        System.out.println("Invalid option, try again.");
                        input = scan.nextLine();
                        break;
                }
            }
        }


    }

}
