package com.revature.eMarket;

import com.revature.eMarket.daos.CategoryDAO;
import com.revature.eMarket.daos.ProductDAO;
import com.revature.eMarket.daos.ReviewDAO;
import com.revature.eMarket.services.CategoryService;
import com.revature.eMarket.services.ProductService;
import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.utils.ConnectionFactory;
import com.revature.eMarket.utils.Session;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
  private static final Logger logger = LogManager.getLogger(App.class);
  /**
   * The entry point of the eMarket Application.
   *
   * @param args command line arguments
   * @throws ClassNotFoundException if the specified class cannot be found
   * @throws IOException            if an I/O error occurs
   * @throws SQLException           if a database error occurs
   */
  public static void main(String args[]) throws SQLException, IOException, ClassNotFoundException {
    System.out.println(ConnectionFactory.getInstance().getConnection());
    logger.info("------------------- START APPLICATION ------------------");

    Scanner scan = new Scanner(System.in);

<<<<<<< HEAD
    RouterService router = new RouterService(new Session(), new ProductService(new ProductDAO(), new ReviewDAO()), new CategoryService(new CategoryDAO()));

=======
>>>>>>> 5cf5d464ef1c251b2a44c55f8f563380a60d9a38
    // create a new RouterService with a Session.
    RouterService router = new RouterService(new Session(), new ProductService(new ProductDAO()), new CategoryService(new CategoryDAO()));

    // navigate to the "/home" route using the router and scanner

    router.navigate("/home", scan);

    logger.info("------------------- END APPLICATION --------------------");

    scan.close();
  }
}
