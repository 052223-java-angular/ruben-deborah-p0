package com.revature.eMarket.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.revature.eMarket.models.Role;
import com.revature.eMarket.models.User;
import com.revature.eMarket.utils.ConnectionFactory;


public class RoleDAO implements CrudDAO<Role> {

    @Override
    public void save(Role obj) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Role findById(String id) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    public Optional<Role> findByName(String username) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM roles WHERE role = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, username);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Role role = new Role();
                        role.setId(rs.getString("id"));
                        role.setRole(rs.getString("role"));
                        return Optional.of(role);
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