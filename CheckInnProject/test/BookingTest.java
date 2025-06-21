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

@After
    public void tearDown() {
        // Clean up test booking to keep database intact
        if (testBookingId > 0) {
            bookingDao.cancelBooking(testBookingId);
        }
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

    @Test
    public void testIsRoomBookedForPeriod() {
        // place booking for room
        Booking booking = new Booking();
        booking.setRoomId(1);
        booking.setUserId(1);
        booking.setStatusId(2);
        booking.setInvoiceId(0);
        Date checkIn = new Date(System.currentTimeMillis() + 3600 * 1000);
        Date checkOut = new Date(System.currentTimeMillis() + 2 * 3600 * 1000);
        booking.setCheckInDate(checkIn);
        booking.setCheckOutDate(checkOut);
        booking.setTotalPrice(1000.0);

        testBookingId = bookingDao.saveBooking(booking);

        // overlapping period should return true
        boolean isBooked = bookingDao.isRoomBookedForPeriod(1, checkIn, checkOut);
        assertTrue(isBooked);

        // non-overlapping period should return false
        Date futureCheckIn = new Date(System.currentTimeMillis() + 10 * 3600 * 1000);
        Date futureCheckOut = new Date(System.currentTimeMillis() + 12 * 3600 * 1000);
        boolean notBooked = bookingDao.isRoomBookedForPeriod(1, futureCheckIn, futureCheckOut);
        assertFalse(notBooked);
    }
    @Test
public void testCancelBooking() {
    Booking booking = new Booking();
    booking.setRoomId(1);
    booking.setUserId(1);
    booking.setStatusId(2);
    booking.setInvoiceId(0);
    booking.setCheckInDate(new Date(System.currentTimeMillis() + 3600 * 1000));
    booking.setCheckOutDate(new Date(System.currentTimeMillis() + 2 * 3600 * 1000));
    booking.setTotalPrice(1234.56);

    int bookingId = bookingDao.saveBooking(booking);
    assertTrue(bookingId > 0);

    boolean cancelResult = bookingDao.cancelBooking(bookingId);
    assertTrue(cancelResult);

    Booking canceledBooking = bookingDao.getBookingById(bookingId);
    assertNull("Booking should no longer exist after cancellation", canceledBooking);
}

}