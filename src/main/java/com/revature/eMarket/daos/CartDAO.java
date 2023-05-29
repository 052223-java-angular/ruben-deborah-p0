package com.revature.eMarket.daos;

import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.CartItems;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CartDAO implements CrudDAO<CartItems> {

    public Optional<Cart> findByUserId(String id) {

        return null;
    }

    public List<CartItems> findAllCartItemsByCardId(String cartId) {

        return null;
    }

    @Override
    public void save(CartItems obj) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public CartItems findById(String id) {
        return null;
    }

    @Override
    public List<CartItems> findAll() {
        return null;
    }
}
