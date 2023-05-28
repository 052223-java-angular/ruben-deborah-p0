package com.revature.eMarket.services;

import com.revature.eMarket.daos.ProductDAO;
import com.revature.eMarket.daos.RoleDAO;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.Role;
import lombok.AllArgsConstructor;
import com.revature.eMarket.utils.custom_exeptions.RoleNotFoundException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductService {
    private final ProductDAO prodDAO;

    public List<Product> findAll() {
        return prodDAO.findAll();
    }
}