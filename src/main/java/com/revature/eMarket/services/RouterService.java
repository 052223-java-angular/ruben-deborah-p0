package com.revature.eMarket.services;

import com.revature.eMarket.daos.ProductDAO;
import com.revature.eMarket.daos.RoleDAO;
import com.revature.eMarket.daos.UserDAO;
import com.revature.eMarket.screens.*;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class RouterService {
    private Session session;
    private ProductService prodServ;
    private CategoryService catServ;

    public void navigate(String path, Scanner scan) {

        switch (path) {
            case "/home":
                new HomeScreen(this).start(scan);
                break;
            case "/login":
                new LogInScreen(this,getUserService()).start(scan);
                break;
            case "/register":
                new RegisterScreen(getUserService(), this, session).start(scan);
                break;
            case "/product":
                new ProductScreen(getProdService(), this, catServ).start(scan);
                break;
            case "/menu":
                new MenuScreen(session).start(scan);
            default:
                break;
        }
    }

    /*************************************** Helper Method ************************************/

    private UserService getUserService() {
        return new UserService(new UserDAO(),getRoleService());
    }

    private RoleService getRoleService() {
        return new RoleService(new RoleDAO());
    }

    private ProductService getProdService() { return new ProductService(new ProductDAO()); };
}