package com.revature.eMarket.services;

import com.revature.eMarket.daos.RoleDAO;
import com.revature.eMarket.daos.UserDAO;
import com.revature.eMarket.screens.HomeScreen;
import com.revature.eMarket.screens.LogInScreen;
import com.revature.eMarket.screens.MenuScreen;
import com.revature.eMarket.screens.RegisterScreen;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class RouterService {
    private Session session;

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
}