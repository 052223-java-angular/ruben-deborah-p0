package com.revature.eMarket.daos;

import com.revature.eMarket.models.User;
import com.revature.eMarket.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAO implements CrudDAO<User> {

    @Override
    public void save(User obj) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO users (id, username, password, role_id) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, obj.getId());
                ps.setString(2, obj.getUsername());
                ps.setString(3, obj.getPassword());
                ps.setString(4, obj.getRole_id());

                // update the query, NOT save
                ps.executeUpdate();
            }

        }catch (SQLException e) {
            throw new RuntimeException("Unable to access the database. Debug");
        }catch(ClassNotFoundException e) {
            throw new RuntimeException("Can't find application. Debug");
        }catch (IOException e) {
            throw new RuntimeException("Unable to load JDBC. Debug");
        }
    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    public Optional<User> findByUsername(String username) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, username);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        user.setRole_id(rs.getString("role_id)"));
                        return Optional.of(user);
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

        return Optional.empty();
    }
}