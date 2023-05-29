package com.revature.eMarket.daos;

import com.revature.eMarket.models.Category;
import com.revature.eMarket.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryDAO implements CrudDAO<Category> {

    @Override
    public void save(Category obj) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Optional<Category> findById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

//    @Override
//    public Optional<CartItem> findById(String id) {
//        return null;
//    }

    @Override
    public List<Category> findAll() {
        List<Category> catList = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM categories";
            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                //ps.setString(1, username);

                try (ResultSet rs = ps.executeQuery()) {
                    while(rs.next()){

                        Category cat = new Category();
                        cat.setId(rs.getString("id"));
                        cat.setCategory(rs.getString("category"));
                        catList.add(cat);
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
        return catList;
    }
}
