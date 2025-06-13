package checkinn.dao;

import checkinn.database.DbConnection;
import checkinn.database.MySqlConnection;
import checkinn.model.RegistrationRequest;
import checkinn.model.UserData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private final DbConnection dbConnection;

    public UserDao() {
        this.dbConnection = new MySqlConnection();
    }

    /**
     * UserAuth with email and password
     * Returns true if credentials are valid, false otherwise.
     * @param email
     * @param password
     * @return 
     */
    public boolean authenticateUser(String email, String password) {
        String sql = "SELECT * FROM User WHERE email = ? AND password = ?";
        try (Connection conn = dbConnection.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.err.println("Error during authentication: " + e.getMessage());
        }
        return false;
    }

    /**
     * Registers a new user using RegistrationRequest.Returns true if registration is successful, false otherwise.
     * @param request
     * @return 
     */
    public boolean registerUser(RegistrationRequest request) {
        // Check if email already exists
        if (emailExists(request.getEmail())) {
            return false;
        }

        String sql = "INSERT INTO User (first_name, last_name, email, password, phone_number, security_question, security_answer) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dbConnection.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, request.getFirstName());
            pstmt.setString(2, request.getLastName());
            pstmt.setString(3, request.getEmail());
            pstmt.setString(4, request.getPassword());
            pstmt.setString(5, request.getPhoneNumber());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
            return false;
        }
    }

    /**
     * Checks if an email exists in the database
     * @param email
     * @return 
     */
    public boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM User WHERE email = ?";
        try (Connection conn = dbConnection.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error checking email existence: " + e.getMessage());
        }
        return false;
    }

    /**
     * Resets a user's password
     * @param email
     * @param newPassword
     * @return 
     */
    public boolean resetPassword(String email, String newPassword) {
        String sql = "UPDATE User SET password = ? WHERE email = ?";
        try (Connection conn = dbConnection.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newPassword);
            pstmt.setString(2, email);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error resetting password: " + e.getMessage());
            return false;
        }
    }

    /**
     * Creates a new user (legacy, uses UserData)
     * @param user
     * @return 
     */
    public boolean createUser(UserData user) {
        String sql = "INSERT INTO User (first_name, last_name, email, password, phone_number, "
                   + "security_question, security_answer) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getPhoneNumber());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
            return false;
        }
    }

    /**
     * Updates user information
     * @param user
     * @return 
     */
    public boolean updateUser(UserData user) {
        String sql = "UPDATE User SET first_name = ?, last_name = ?, phone_number = ?, "
                   + "security_question = ?, security_answer = ? WHERE user_id = ?";

        try (Connection conn = dbConnection.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getPhoneNumber());
            pstmt.setInt(6, user.getUserId());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
            return false;
        }
    }

    /**
     * Helper method to extract UserData from ResultSet
     */
    private UserData extractUserFromResultSet(ResultSet rs) throws SQLException {
        UserData user = new UserData();
        user.setUserId(rs.getInt("user_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPhoneNumber(rs.getString("phone_number"));
        return user;
    }

    /**
     * Gets user by email
     * @param email
     * @return 
     */
    public UserData getUserByEmail(String email) {
        String sql = "SELECT * FROM User WHERE email = ?";
        try (Connection conn = dbConnection.openConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error getting user by email: " + e.getMessage());
        }
        return null;
    }
}