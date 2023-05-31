package com.revature.eMarket.services;

import com.revature.eMarket.daos.ProductDAO;
import com.revature.eMarket.daos.ReviewDAO;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.Review;
import com.revature.eMarket.utils.Session;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductService {
    private final ProductDAO prodDAO;
    private final ReviewDAO reviewDAO;

    public List<Product> findAll() {
        return prodDAO.findAll();
    }

    public List<Product> findById(String category) {
        return prodDAO.findByCategory(category);
    }

    public List<Product> findByRange(String low, String high) {
        return prodDAO.findByRange(low, high);
    }

    public Product findByName(String name) {
        return prodDAO.findByName(name);
    }

    public List<Review> findByProdId(String id, String user_id) {
        return reviewDAO.findByProdId(id, user_id);
    }

    public boolean isValidRating(String rating) {
        // checks if username 8-20 characters long, no _ or . at end, no _ or . at beginning, a-z, A-Z, 0-9
        return rating.matches("^[1-5]+$");
    }

    public Review insert(Review rev) {
        return reviewDAO.insert(rev);
    }

    public boolean isValidReview(String review) {
        // checks if username 8-20 characters long, no _ or . at end, no _ or . at beginning, a-z, A-Z, 0-9
        return review.matches("^[a-zA-Z0-9]+$");
    }

    public Optional<Product> getProd(String id) {
        return prodDAO.findById(id);
    }
}