import checkinn.dao.InvoiceDao;
import org.junit.*;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InvoiceTest {

    private InvoiceDao invoiceDao;
    private int lastInvoiceId = 0;

    @Before
    public void setUp() {
        invoiceDao = new InvoiceDao();
    }

    @After
    public void tearDown() {
        // Restore the database state after test of invoice
        if (lastInvoiceId > 0) {
            try (Connection conn = new checkinn.database.MySqlConnection().openConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                         "DELETE FROM Invoice WHERE invoice_id = ?")) {
                stmt.setInt(1, lastInvoiceId);
                stmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCreateInvoice() {
        int bookingId = 1; // Using valid booking ID from the database
        double totalAmount = 999.99;
        String paymentMethod = "Cash";

        lastInvoiceId = invoiceDao.createInvoice(bookingId, totalAmount, paymentMethod);
        assertTrue(lastInvoiceId > 0);
    }
    
}