package checkinn.database; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection implements DbConnection {

    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "CheckInn";
    private static final String DB_USER = "root"; 
    private static final String DB_PASSWORD = "newpassword";

    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SERVER_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME + "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

    @Override
    public Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);

            try (Connection serverConn = DriverManager.getConnection(SERVER_URL, DB_USER, DB_PASSWORD);
                 Statement stmt = serverConn.createStatement()) {
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
                System.out.println("Database '" + DB_NAME + "' ensured to exist.");
            } catch (SQLException e) {
                System.err.println("Error during database creation check for '" + DB_NAME + "': " + e.getMessage());
                return null;
            }

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Successfully connected to database '" + DB_NAME + "'.");

            createTablesIfNotExists(conn);

            return conn;

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection to database '" + DB_NAME + "' failed: " + e.getMessage());
        }
        return conn;
    }

    private void createTablesIfNotExists(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            System.out.println("Starting table creation process...");

            String sqlStatuses = "CREATE TABLE IF NOT EXISTS Statuses ("
                    + "status_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "status_info VARCHAR(255) NOT NULL"
                    + ")";
            stmt.execute(sqlStatuses);
            System.out.println("Table 'Statuses' is ready.");

            String sqlUser = "CREATE TABLE IF NOT EXISTS User ("
                    + "User_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "first_name VARCHAR(100), "
                    + "last_name VARCHAR(100), "
                    + "phone_number VARCHAR(20) UNIQUE, "
                    + "email VARCHAR(255) UNIQUE, "
                    + "password VARCHAR(255) NOT NULL, " 
                    + "security_question TEXT, "
                    + "security_answer TEXT" 
                    + ")";
            stmt.execute(sqlUser);
            System.out.println("Table 'User' is ready.");

            String sqlMenuItem = "CREATE TABLE IF NOT EXISTS MenuItem ("
                    + "Menu_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "itemname VARCHAR(255) NOT NULL"
                    + ")";
            stmt.execute(sqlMenuItem);
            System.out.println("Table 'MenuItem' is ready.");
            String sqlAdmin = "CREATE TABLE IF NOT EXISTS Admin ("
                    + "admin_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "password VARCHAR(255) NOT NULL, " 
                    + "Status_id INT, "
                    + "FOREIGN KEY (Status_id) REFERENCES Statuses(status_id) ON DELETE SET NULL ON UPDATE CASCADE"
                    + ")";
            stmt.execute(sqlAdmin);
            System.out.println("Table 'Admin' is ready.");

            String sqlRoom = "CREATE TABLE IF NOT EXISTS Room ("
                    + "Room_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "Status_id INT, "
                    + "description TEXT, "
                    + "FOREIGN KEY (Status_id) REFERENCES Statuses(status_id) ON DELETE SET NULL ON UPDATE CASCADE"
                    + ")";
            stmt.execute(sqlRoom);
            System.out.println("Table 'Room' is ready.");

            String sqlBooking = "CREATE TABLE IF NOT EXISTS Booking ("
                    + "Booking_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "Room_id INT, "
                    + "User_id INT, "
                    + "Admin_id INT, "
                    + "status_id INT, "
                    + "menu_id INT, "
                    + "invoice_id INT NULL, "
                    + "booking_date DATETIME DEFAULT CURRENT_TIMESTAMP, "
                    + "FOREIGN KEY (Room_id) REFERENCES Room(Room_id) ON DELETE SET NULL ON UPDATE CASCADE, "
                    + "FOREIGN KEY (User_id) REFERENCES User(User_id) ON DELETE SET NULL ON UPDATE CASCADE, "
                    + "FOREIGN KEY (Admin_id) REFERENCES Admin(admin_id) ON DELETE SET NULL ON UPDATE CASCADE, "
                    + "FOREIGN KEY (status_id) REFERENCES Statuses(status_id) ON DELETE SET NULL ON UPDATE CASCADE, "
                    + "FOREIGN KEY (menu_id) REFERENCES MenuItem(Menu_id) ON DELETE SET NULL ON UPDATE CASCADE"
                    + ")";
            stmt.execute(sqlBooking);
            System.out.println("Table 'Booking' is ready (initial schema).");

            String sqlInvoice = "CREATE TABLE IF NOT EXISTS Invoice ("
                    + "Invoice_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "Booking_id INT NOT NULL, "
                    + "total_amount DECIMAL(10, 2) NOT NULL, "
                    + "invoice_date DATETIME DEFAULT CURRENT_TIMESTAMP, "
                    + "payment_method VARCHAR(50), "
                    + "FOREIGN KEY (Booking_id) REFERENCES Booking(Booking_id) ON DELETE CASCADE ON UPDATE CASCADE"
                    + ")";
            stmt.execute(sqlInvoice);
            System.out.println("Table 'Invoice' is ready.");

            String fkBookingInvoiceConstraintName = "fk_booking_invoice";
            if (!foreignKeyExists(conn, DB_NAME, "Booking", fkBookingInvoiceConstraintName)) {
                String sqlAlterBookingAddFk = "ALTER TABLE Booking "
                        + "ADD CONSTRAINT " + fkBookingInvoiceConstraintName + " "
                        + "FOREIGN KEY (invoice_id) REFERENCES Invoice(Invoice_id) ON DELETE SET NULL ON UPDATE CASCADE";
                stmt.execute(sqlAlterBookingAddFk);
                System.out.println("Foreign key '" + fkBookingInvoiceConstraintName + "' added to 'Booking' table.");
            } else {
                System.out.println("Foreign key '" + fkBookingInvoiceConstraintName + "' already exists in 'Booking' table.");
            }
            System.out.println("All tables and relationships are set up.");

        } catch (SQLException e) {
            System.err.println("Error during table creation: " + e.getMessage());
            throw e; 
        }
    }
    private boolean foreignKeyExists(Connection conn, String databaseName, String tableName, String constraintName) throws SQLException {
        String sql = "SELECT COUNT(*) FROM information_schema.TABLE_CONSTRAINTS "
                   + "WHERE CONSTRAINT_SCHEMA = ? " 
                   + "AND TABLE_NAME = ? "        
                   + "AND CONSTRAINT_NAME = ? "   
                   + "AND CONSTRAINT_TYPE = 'FOREIGN KEY'";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, databaseName);
            pstmt.setString(2, tableName);
            pstmt.setString(3, constraintName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    @Override
    public void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection to '" + DB_NAME + "' closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing connection: " + e.getMessage());
        }
    }
}