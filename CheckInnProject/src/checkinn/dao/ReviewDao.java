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
}
