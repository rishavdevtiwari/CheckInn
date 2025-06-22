import checkinn.dao.InvoiceDao;
import checkinn.database.MySqlConnection;
import checkinn.model.Booking;
import checkinn.dao.BookingDao;

import org.junit.*;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class InvoiceTest {

    private InvoiceDao invoiceDao;
    private BookingDao bookingDao;
    private int lastInvoiceId = 0;
    private int testBookingId = 0;

    @Before
    public void setUp() {
        invoiceDao = new InvoiceDao();
        bookingDao = new BookingDao();

        // Create a test booking
        Booking booking = new Booking();
        booking.setRoomId(1);          // Ensure room ID 1 exists
        booking.setUserId(1);          // Ensure user ID 1 exists
        booking.setStatusId(2);        // Some valid status
        booking.setInvoiceId(0);
        booking.setCheckInDate(new Date(System.currentTimeMillis() + 3600 * 1000)); // 1 hour from now
        booking.setCheckOutDate(new Date(System.currentTimeMillis() + 2 * 3600 * 1000)); // 2 hours from now
        booking.setTotalPrice(1234.56);

        testBookingId = bookingDao.saveBooking(booking);
        assertTrue("Booking creation failed", testBookingId > 0);
    }

    @After
    public void tearDown() {
        // Clean up invoice
        if (lastInvoiceId > 0) {
            try (Connection conn = new MySqlConnection().openConnection();
                 PreparedStatement stmt = conn.prepareStatement(
                         "DELETE FROM Invoice WHERE invoice_id = ?")) {
                stmt.setInt(1, lastInvoiceId);
                stmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Clean up booking
        if (testBookingId > 0) {
            bookingDao.cancelBooking(testBookingId);
        }
    }

    @Test
    public void testCreateInvoice() {
        double totalAmount = 999.99;
        String paymentMethod = "Cash";

        lastInvoiceId = invoiceDao.createInvoice(testBookingId, totalAmount, paymentMethod);

        System.out.println("Invoice ID created: " + lastInvoiceId);
        assertTrue("Invoice was not created successfully", lastInvoiceId > 0);
    }
}
