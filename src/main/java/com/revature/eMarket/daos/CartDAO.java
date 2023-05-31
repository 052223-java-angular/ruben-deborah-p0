package com.revature.eMarket.daos;

import com.revature.eMarket.models.Cart;
import com.revature.eMarket.models.Product;
import com.revature.eMarket.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CartDAO implements CrudDAO<Cart> {

    public Optional<Cart> findByUserId(String id) {
        // TODO Auto-generated method sub
        //throw new UnsupportedOperationException("Unimplemented method 'findByUserId' ");


       return null;
    }

    public List<Cart> findAll() {
        // TODO Auto-generated method sub
        throw new UnsupportedOperationException("Unimplemented method 'findAll' ");
//        return null;
    }

    @Override
    public List<Cart> findAll(String id) {
        return null;
    }

    @Override
    public void save(Cart cart) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){

            String sql = "insert into carts (id, user_id) values (?, ?)";

            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setString(1, cart.getId());
                ps.setString(2, cart.getUser_id());
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
        // TODO Auto-generated method sub
        throw new UnsupportedOperationException("Unimplemented method 'update' ");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method sub
        throw new UnsupportedOperationException("Unimplemented method 'delete' ");
    }

    @Override
    public Optional<Cart> findById(String id) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM carts WHERE user_id = ?";
            try(PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Cart cart = new Cart();
                        cart.setId(rs.getString("id"));
                        cart.setUser_id(rs.getString("user_id"));
                        return Optional.of(cart);
                    }
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException("Unable to access the database. Debug");
        }catch(ClassNotFoundException e) {
            throw new RuntimeException("Can't find application. Debug");
        }catch (IOException e) {
            throw new RuntimeException("Unable to load JDBC. Debug");
        }

        return null;
    }

}