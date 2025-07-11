package checkinn.dao;

import checkinn.model.MenuItem;
import checkinn.database.MySqlConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDao {
    private final MySqlConnection dbConnection = new MySqlConnection();

    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> items = new ArrayList<>();
        String sql = "SELECT menu_id, itemname, price FROM MenuItem";
        try (Connection conn = dbConnection.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                MenuItem item = new MenuItem();
                item.setMenuId(rs.getInt("menu_id"));
                item.setItemName(rs.getString("itemname"));
                item.setPrice(rs.getDouble("price"));
                items.add(item);
            }
        } catch (SQLException e) {
        }
        return items;
    }
}