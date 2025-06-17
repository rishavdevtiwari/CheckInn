package checkinn.dao;

import checkinn.database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDao {
    private final MySqlConnection dbConnection = new MySqlConnection();

    public void setRoomStatus(int roomId, int statusId) {
        String sql = "UPDATE Room SET status_id = ? WHERE room_id = ?";
        try (Connection conn = dbConnection.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, statusId);
            stmt.setInt(2, roomId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getRoomStatusId(int roomId) {
    String sql = "SELECT status_id FROM Room WHERE room_id = ?";
    try (Connection conn = dbConnection.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, roomId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("status_id");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 1; // Default to Vacant if error
}

        public void updateRoomPrice(int roomId, double newPrice) {
        String sql = "UPDATE Room SET price = ? WHERE room_id = ?";
        try (Connection conn = dbConnection.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDouble(1, newPrice);
            stmt.setInt(2, roomId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

