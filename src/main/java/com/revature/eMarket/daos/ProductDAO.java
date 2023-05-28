package com.revature.eMarket.daos;

import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.Role;
import com.revature.eMarket.models.User;
import com.revature.eMarket.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAO implements CrudDAO<Product>{

    @Override
    public void save(Product obj) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        List<Product> storeList = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM products WHERE stock > 0";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                //ps.setString(1, username);

                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){

                        Product prod = new Product();
                        prod.setId(rs.getString("id"));
                        prod.setName(rs.getString("name"));
                        prod.setPrice(rs.getString("price"));
                        prod.setStock(rs.getString("stock"));
                        prod.setCategory_id(rs.getString("category_id"));
                        storeList.add(prod);
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

    public Product findByName(String name) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {


            String sql = "SELECT * FROM products WHERE name = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, name);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Product prod = new Product();
                        prod.setId(rs.getString("id"));
                        prod.setName(rs.getString("name"));
                        prod.setPrice(rs.getString("price"));
                        prod.setStock(rs.getString("stock"));
                        prod.setCategory_id(rs.getString("category_id"));
                        return prod;
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

    public List<Product> findByCategory(String category) {
        List<Product> storeList = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM products WHERE category_id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, category);

                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){

                        Product prod = new Product();
                        prod.setId(rs.getString("id"));
                        prod.setName(rs.getString("name"));
                        prod.setPrice(rs.getString("price"));
                        prod.setStock(rs.getString("stock"));
                        prod.setCategory_id(rs.getString("category_id"));
                        storeList.add(prod);
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
        System.out.println(storeList);
        return storeList;
    }
}
