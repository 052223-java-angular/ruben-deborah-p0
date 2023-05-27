package com.revature.eMarket;

import com.revature.eMarket.services.RouterService;
import com.revature.eMarket.utils.ConnectionFactory;
import com.revature.eMarket.utils.Session;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
  public static void main(String args[]) throws SQLException, IOException, ClassNotFoundException {
    System.out.println(ConnectionFactory.getInstance().getConnection());

    Scanner scan = new Scanner(System.in);
    RouterService router = new RouterService(new Session());
    router.navigate("/home", scan);
  }
}
