package checkinn.dao;

import checkinn.database.MySqlConnection;
import checkinn.model.Booking;
import checkinn.model.MenuItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class BookingDao {
    private final MySqlConnection dbConnection = new MySqlConnection();

public int saveBooking(Booking booking) {
    String sql = "INSERT INTO Booking (room_id, user_id, status_id, invoice_id, CheckIn_date, CheckOut_date, total_price) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = dbConnection.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        stmt.setInt(1, booking.getRoomId());
        stmt.setInt(2, booking.getUserId());
        stmt.setInt(3, booking.getStatusId());
        if (booking.getInvoiceId() == 0) {
            stmt.setNull(4, java.sql.Types.INTEGER);
        } else {
            stmt.setInt(4, booking.getInvoiceId());
        }
        stmt.setTimestamp(5, new java.sql.Timestamp(booking.getCheckInDate().getTime()));
        stmt.setTimestamp(6, new java.sql.Timestamp(booking.getCheckOutDate().getTime()));
        stmt.setDouble(7, booking.getTotalPrice());
        int affectedRows = stmt.executeUpdate();
        if (affectedRows == 0) return 0;
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;
}

public void saveBookingMenuItems(int bookingId, List<MenuItem> menuItems) {
    String sql = "INSERT INTO BookingMenuItem (booking_id, menu_id) VALUES (?, ?)";
    try (Connection conn = dbConnection.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        for (MenuItem item : menuItems) {
            stmt.setInt(1, bookingId);
            stmt.setInt(2, item.getMenuId());
            stmt.addBatch();
        }
        stmt.executeBatch();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public void updateInvoiceId(int bookingId, int invoiceId) {
    String sql = "UPDATE Booking SET invoice_id = ? WHERE booking_id = ?";
    try (Connection conn = dbConnection.openConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, invoiceId);
        stmt.setInt(2, bookingId);
        stmt.executeUpdate();
    } catch (SQLException e) {
    }
}

}