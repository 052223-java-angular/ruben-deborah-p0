package com.revature.eMarket.daos;

import com.revature.eMarket.models.CartItems;
import com.revature.eMarket.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartItemDAO {
    public List<CartItems> findAllCartItemsByCardId(String cartId) {
            try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
                String sql = "SELECT cart_items.id, cart_items.quantity, cart_items.cart_id, cart_items.price, " +
                        "cart_items.product_id, products.stock, products.name FROM cart_items " +
                        "INNER JOIN products ON cart_items.product_id = products.id AND cart_items.cart_id = ?";

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, cartId);

                    try (ResultSet rs = ps.executeQuery()) {
                        List<CartItems> cartItem = new ArrayList<>();
                        while (rs.next()) {
                            CartItems cartItems = new CartItems();
                            cartItems.setId(rs.getString("id"));
                            cartItems.setStock(rs.getInt("stock"));
                            cartItems.setQuantity(rs.getInt("quantity"));
                            cartItems.setName(rs.getString("name"));
                            cartItems.setPrice(rs.getBigDecimal("price"));
                            cartItems.setCart_id(rs.getString("cart_id"));
                            cartItems.setProduct_id(rs.getString("product_id"));
                            cartItem.add(cartItems);
                        }
                        return cartItem;
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

    public void createCartItem(CartItems cartItems) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO cart_items (id, quantity, price, cart_id, product_id) " +
                    "VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cartItems.getId());
                ps.setInt(2, cartItems.getQuantity());
                ps.setFloat(3, cartItems.getPrice());
                ps.setString(4, cartItems.getCart_id());
                ps.setString(5, cartItems.getProduct_id());
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

    public List<CartItems> findAllCartItemsByCartId(String cartId) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT cart_items.id, cart_items.quantity, cart_items.cart_id, cart_items.price, " +
                    "cart_items.product_id, products.stock, products.name FROM cart_items " +
                    "INNER JOIN products ON cart_items.product_id = products.id AND cart_items.cart_id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cartId);

                try (ResultSet rs = ps.executeQuery()) {
                    List<CartItems> cartItems = new ArrayList<>();
                    while (rs.next()) {
                        CartItems cartItem = new CartItems();
                        cartItem.setId(rs.getString("id"));
                        cartItem.setStock(rs.getInt("stock"));
                        cartItem.setQuantity(rs.getInt("quantity"));
                        cartItem.setName(rs.getString("name"));
                        cartItem.setPrice(rs.getBigDecimal("price"));
                        cartItem.setCart_id(rs.getString("cart_id"));
                        cartItem.setProduct_id(rs.getString("product_id"));
                        cartItems.add(cartItem);
                    }
                    return cartItems;
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

    public void deleteCartItem(String cartItemId) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "DELETE FROM cart_items WHERE id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, cartItemId);

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

    public void updateCartItem(CartItems cartItem) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "UPDATE cart_items SET quantity = ?, price = ?, cart_id = ?, product_id = ? WHERE id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, cartItem.getQuantity());
                ps.setFloat(2, cartItem.getPrice());
                ps.setString(3, cartItem.getCart_id());
                ps.setString(4, cartItem.getProduct_id());
                ps.setString(5, cartItem.getId());
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
}
