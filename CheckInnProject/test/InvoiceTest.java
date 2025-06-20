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

    

    @Test
    public void testCreateInvoice() {
        int bookingId = 1; // Using valid booking ID from the database
        double totalAmount = 999.99;
        String paymentMethod = "Cash";

        lastInvoiceId = invoiceDao.createInvoice(bookingId, totalAmount, paymentMethod);
        assertTrue(lastInvoiceId > 0);
    }
}