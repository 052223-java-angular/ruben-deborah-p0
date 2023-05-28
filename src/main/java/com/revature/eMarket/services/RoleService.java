package com.revature.eMarket.services;

import com.revature.eMarket.daos.RoleDAO;
import com.revature.eMarket.models.Role;
import lombok.AllArgsConstructor;
import com.revature.eMarket.utils.custom_exeptions.RoleNotFoundException;

import java.util.Optional;

@AllArgsConstructor
public class RoleService {
    private final RoleDAO roleDao;

    public Role findByName(String username) {

        Optional<Role> roleOpt = roleDao.findByName(username);
        System.out.println("RoleService > findByName");
        System.out.println(username);

        if (roleOpt.isEmpty()) {
            System.out.println("User Role not found :(");
        }
        return roleOpt.get();
    }
}