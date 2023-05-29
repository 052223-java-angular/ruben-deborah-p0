package com.revature.eMarket.daos;

import com.revature.eMarket.models.Cart;
import com.revature.eMarket.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDAO {


    public void createCart(Cart cart) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO carts (id, total_cost, user_id) VALUES (?, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cart.getId());
                ps.setBigDecimal(2, cart.getTotal_cost());
                ps.setString(3, cart.getUser_id());
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load jdbc");
        }
    }

    public Cart findCartByUserId(String userId) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM carts WHERE user_id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, userId);

                try (ResultSet rs = ps.executeQuery()) {
                    Cart cart = new Cart();
                    if (rs.next()) {
                        cart.setId(rs.getString("id"));
                        cart.setTotal_cost(rs.getBigDecimal("total_cost"));
                        cart.setUser_id(rs.getString("user_id"));
                    }
                    return cart;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load jdbc");
        }
    }

    public Cart findCartByCartId(String cartId) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM carts WHERE id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cartId);

                try (ResultSet rs = ps.executeQuery()) {
                    Cart cart = new Cart();
                    if (rs.next()) {
                        cart.setId(rs.getString("id"));
                        cart.setTotal_cost(rs.getBigDecimal("total_cost"));
                        cart.setUser_id(rs.getString("user_id"));
                    }
                    return cart;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load jdbc");
        }
    }

    public void deleteCart(String cartId) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "DELETE FROM carts WHERE id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cartId);

                ps.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load jdbc");
        }
    }

    public void updateCart(Cart cart) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "UPDATE carts SET total_cost = ?, user_id = ? WHERE id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setBigDecimal(1, cart.getTotal_cost());
                ps.setString(2, cart.getUser_id());
                ps.setString(3, cart.getId());
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Unable to connect to db");
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load jdbc");
        }
    }



}