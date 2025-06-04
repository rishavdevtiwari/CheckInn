/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package checkinn.database;
import java.sql.Connection;
/**
 *
 * @author sangyakoirala
 */
public interface DbConnection {
    Connection openConnection();
    void closeConnection(Connection conn);
    
}