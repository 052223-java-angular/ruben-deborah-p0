package com.revature.eMarket.services;

import com.revature.eMarket.daos.CategoryDAO;
import com.revature.eMarket.models.Category;

import java.util.List;

public class CategoryService {
    private final CategoryDAO catDAO;

    public CategoryService(CategoryDAO catDAO) {
        this.catDAO = catDAO;
    }
    public List<Category> findAll() {
        return catDAO.findAll();
    }
}
