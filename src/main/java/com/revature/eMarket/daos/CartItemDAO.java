package com.revature.eMarket.daos;

import com.revature.eMarket.models.CartItem;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartItemDAO implements CrudDAO<CartItem> {
    @Override
    public void save(CartItem cartItem) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "insert into cart_items (id, name, quantity, price, cart_id, product_id) values (?, ?, ?, ?, ?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, cartItem.getId());
                ps.setString(2, cartItem.getName());
                ps.setInt(3, cartItem.getQuantity());
                ps.setFloat(4, cartItem.getPrice());
                ps.setString(5, cartItem.getCart_id());
                ps.setString(6, cartItem.getProduct_id());
                ps.executeUpdate();
            }

        }catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db \n" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties \n" + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load jdbc \n" + e);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'update' ");
    }

    public void update(String id, int quantity) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "update cart_items set quantity = ? where id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1, quantity);
                ps.setString(2, id);
                ps.executeUpdate();
            }
        }catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db \n" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties \n" + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load jdbc \n" + e);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    // delete item from cart by cart item id
    @Override
    public void delete(String id) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "delete from cart_items where id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, id);
                ps.executeUpdate();
            }
        }catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db \n" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties \n" + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load jdbc \n" + e);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    // find all items from a user cart
    public List<CartItem> findAllByCart(String cart_id) {
        List<CartItem> cartList = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM cart_items WHERE cart_id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, cart_id);

                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){

                        CartItem cartItem = new CartItem();
                        cartItem.setId(rs.getString("id"));
                        cartItem.setName(rs.getString("name"));
                        cartItem.setCart_id(rs.getString("cart_id"));
                        cartItem.setProduct_id(rs.getString("product_id"));
                        cartItem.setQuantity(rs.getInt("quantity"));
                        cartItem.setPrice(rs.getFloat("price"));
                        cartList.add(cartItem);
                    }
                }

            }
        }catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("Unable to access the database. Debug");
        }catch(ClassNotFoundException e) {
            throw new RuntimeException("Can't find application. Debug");
        }catch (IOException e) {
            throw new RuntimeException("Unable to load JDBC. Debug");
        }
        return cartList;
    }

    // find specific cart item by id
    @Override
    public Optional<CartItem> findById(String id) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "select * from cart_items where id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, id);
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        CartItem cartItem = new CartItem();
                        cartItem.setId(rs.getString("id"));
                        cartItem.setCart_id(rs.getString("cart_id"));
                        cartItem.setProduct_id(rs.getString("product_id"));
                        cartItem.setQuantity(rs.getInt("quantity"));
                        return Optional.of(cartItem);
                    }
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException("Unable to connect to db \n" + e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot find application.properties \n" + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unable to load jdbc \n" + e);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return  Optional.empty();
    }

    @Override
    public List<CartItem> findAll() {
        return null;
    }


    public List<CartItem> findAll(String cart_id) {
        List<CartItem> storeList = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM cart_items WHERE cart_id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, cart_id);

                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){

                        CartItem cartItem = new CartItem();
                        cartItem.setId(rs.getString("id"));
                        cartItem.setName(rs.getString("name"));
                        cartItem.setCart_id(rs.getString("cart_id"));
                        cartItem.setProduct_id(rs.getString("product_id"));
                        cartItem.setQuantity(rs.getInt("quantity"));
                        cartItem.setPrice(rs.getFloat("price"));
                        storeList.add(cartItem);
                    }
                }

            }
        }catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("Unable to access the database. Debug");
        }catch(ClassNotFoundException e) {
            throw new RuntimeException("Can't find application. Debug");
        }catch (IOException e) {
            throw new RuntimeException("Unable to load JDBC. Debug");
        }
        return storeList;
    }

}