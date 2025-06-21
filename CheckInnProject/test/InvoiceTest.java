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
    @Test
public void testDuplicateInvoiceNotAllowed() {
    int bookingId = 1; // Ensure this booking exists and has no invoice yet
    double totalAmount = 500.00;
    String paymentMethod = "UPI";

    int firstInvoiceId = invoiceDao.createInvoice(bookingId, totalAmount, paymentMethod);
    assertTrue("First invoice should be created", firstInvoiceId > 0);
    lastInvoiceId = firstInvoiceId;

    int secondInvoiceId = invoiceDao.createInvoice(bookingId, totalAmount, paymentMethod);
    assertEquals("Duplicate invoice should be prevented", -1, secondInvoiceId);

    // Clean up if second invoice was somehow created
    if (secondInvoiceId > 0) {
        deleteInvoiceById(secondInvoiceId);
    }
}

    private void deleteInvoiceById(int secondInvoiceId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}