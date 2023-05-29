package com.revature.eMarket.daos;

import com.revature.eMarket.models.Product;
import com.revature.eMarket.models.Review;
import com.revature.eMarket.utils.ConnectionFactory;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements CrudDAO<Review> {

    @Override
    public void save(Review obj) {

    }

    @Override
    public void update(String id) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Review findById(String id) {
        return null;
    }

    @Override
    public List<Review> findAll() {
        return null;
    }

    public Review insert(Review rev) {
        try(Connection conn = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO reviews (id,review, rating, user_id, product_id) VALUES (?, ?, ?, ?, ?)";
            System.out.println("Testing ReviewDAO insert");
            try(PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1, (int) System.currentTimeMillis() % Integer.MAX_VALUE);
                ps.setString(2, rev.getReview());
                ps.setString(3, rev.getRating());

                ps.setString(4, rev.getUser_id());
                ps.setString(5, rev.getProduct_id());
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
        return null;
    }

    public List<Review> findByProdId(String id) {
        List<Review> reviewList = new ArrayList<>();

        try(Connection conn = ConnectionFactory.getInstance().getConnection()) {


            String sql = "SELECT * FROM reviews WHERE product_id = ?";

            try(PreparedStatement ps = conn.prepareStatement(sql)) {

                ps.setString(1, id);

                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Review review = new Review();
                        review.setId(rs.getString("id"));
                        review.setRating(rs.getString("rating"));
                        review.setReview(rs.getString("review"));
                        review.setUser_id(rs.getString("user_id"));
                        review.setProduct_id(rs.getString("product_id"));
                        reviewList.add(review);
                    }
                    return reviewList;
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException("Unable to access the database. Debug");
        }catch(ClassNotFoundException e) {
            throw new RuntimeException("Can't find application. Debug");
        }catch (IOException e) {
            throw new RuntimeException("Unable to load JDBC. Debug");
        }

    }


}
