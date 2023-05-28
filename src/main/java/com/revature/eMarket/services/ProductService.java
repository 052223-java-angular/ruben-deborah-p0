package com.revature.eMarket.services;

import com.revature.eMarket.daos.ProductDAO;
import com.revature.eMarket.models.Product;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductService {
    private final ProductDAO prodDAO;

    public List<Product> findAll() {
        return prodDAO.findAll();
    }

    public List<Product> findById(String category) {
        return prodDAO.findByCategory(category);
    }

    public Product findByName(String name) {
        return prodDAO.findByName(name);
    }

}