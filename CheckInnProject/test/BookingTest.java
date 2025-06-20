import checkinn.dao.BookingDao;
import checkinn.model.Booking;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

public class BookingTest {

    private BookingDao bookingDao;
    private int testBookingId = 0;

    @Before
    public void setUp() {
        bookingDao = new BookingDao();
    }



    @Test
    public void testSaveAndGetAllBookings() {
        // initializing booking
        Booking booking = new Booking();
        booking.setRoomId(1); 
        booking.setUserId(1);
        booking.setStatusId(2); 
        booking.setInvoiceId(0);
        booking.setCheckInDate(new Date(System.currentTimeMillis() + 3600 * 1000)); // 1 hour from now
        booking.setCheckOutDate(new Date(System.currentTimeMillis() + 2 * 3600 * 1000)); // 2 hours from now
        booking.setTotalPrice(1234.56);

        testBookingId = bookingDao.saveBooking(booking);
        assertTrue(testBookingId > 0);

        List<Booking> allBookings = bookingDao.getAllBookings();
        assertNotNull(allBookings);
        assertTrue(allBookings.stream().anyMatch(b -> b.getBookingId() == testBookingId));
    }

    
}