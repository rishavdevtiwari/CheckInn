/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package checkinn.dao;

/**
 *
 * @author saura
 */

import checkinn.database.MySqlConnection;
import checkinn.model.Review;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao {
    private final MySqlConnection dbConnection = new MySqlConnection();

    public void addReview(Review review) {
        String sql = "INSERT INTO Review (user_id, review_text) VALUES (?, ?)";
        try (Connection conn = dbConnection.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, review.getUserId());
            stmt.setString(2, review.getReviewText());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Review> getAllReviews() {
    List<Review> reviews = new ArrayList<>();
    String sql = "SELECT * FROM Review ORDER BY review_date DESC";
    try (Connection conn = dbConnection.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Review review = new Review();
            review.setReviewId(rs.getInt("review_id"));
            review.setUserId(rs.getInt("user_id"));
            review.setReviewText(rs.getString("review_text"));
            review.setReviewDate(rs.getTimestamp("review_date"));
            reviews.add(review);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return reviews;
}
}
