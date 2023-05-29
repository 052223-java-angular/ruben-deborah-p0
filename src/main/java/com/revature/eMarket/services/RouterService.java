package com.revature.eMarket.services;

import com.revature.eMarket.daos.CartDAO;
import com.revature.eMarket.daos.ProductDAO;
import com.revature.eMarket.daos.ReviewDAO;
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
//    private CartService cartService;

    public void navigate(String path, Scanner scan) {

        switch (path) {
            case "/home":
                new HomeScreen(this).start(scan);
                break;
            case "/login":
                new LogInScreen(this,getUserService(), getCartService(), session).start(scan);
                break;
            case "/register":
                new RegisterScreen(getUserService(), this, session).start(scan);
                break;
            case "/product":
                new ProductScreen(getProdService(), this, catServ).start(scan);
                break;
            case "/cart":
                new CartScreen(this, getCartService(), getProdService(), session).start(scan);
                break;
            case "/menu":
<<<<<<< HEAD
                new MenuScreen(session).start(scan);
            case "/prodDetails":
                new ProdDetailsScreen(getProdService()).start(scan);
=======
                new MenuScreen(getCartService(), this, session).start(scan);
>>>>>>> 5cf5d464ef1c251b2a44c55f8f563380a60d9a38
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

<<<<<<< HEAD
    private ProductService getProdService() { return new ProductService(new ProductDAO(), new ReviewDAO()); };
=======
    private ProductService getProdService() {
        return new ProductService(new ProductDAO()); };

    private CartService getCartService() {
        return new CartService(new CartDAO());
    }
>>>>>>> 5cf5d464ef1c251b2a44c55f8f563380a60d9a38
}