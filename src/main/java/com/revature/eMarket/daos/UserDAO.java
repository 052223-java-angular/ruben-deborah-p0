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

public class UserDAO implements CrudDAO<User>{

    @Override
    public void save(User obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");

    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public User findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
//        return null;
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//        return null;
    }

    public Optional<User> findByUsername(String username){
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM users WHERE username = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)){
                // set the username parameters for the prepared statement
                ps.setString(1, username);

                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        user.setRoleId(rs.getString("role_id"));
                        return Optional.of(user);
                    }
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }catch(IOException e){
            System.out.println("Unable to connect to application.properties");
            throw new RuntimeException(e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("unable to load jdbc");
            throw new RuntimeException(e.getMessage());
        }

        return Optional.empty();
    }
}
