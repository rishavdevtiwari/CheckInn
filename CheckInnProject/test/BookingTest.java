import checkinn.dao.BookingDao;
import checkinn.model.Booking;
import java.util.Calendar;
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
    int roomId = 1;
    int userId = 1;

    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);

    // Booking for the day tomorrow
    cal.add(Calendar.DATE, 1);
    Date checkIn = cal.getTime();
    cal.add(Calendar.DATE, 1);
    Date checkOut = cal.getTime();

    Booking booking = new Booking();
    booking.setRoomId(roomId);
    booking.setUserId(userId);
    booking.setStatusId(2);
    booking.setInvoiceId(0);
    booking.setCheckInDate(checkIn);
    booking.setCheckOutDate(checkOut);
    booking.setTotalPrice(1000.0);

    testBookingId = bookingDao.saveBooking(booking);
    assertTrue("Booking should be saved", testBookingId > 0);

    // Overlapping period with booking
    boolean isBooked = bookingDao.isRoomBookedForPeriod(roomId, checkIn, checkOut);
    assertTrue("Room should be booked for the same period", isBooked);

    // Non-overlapping period with booking
    cal.add(Calendar.DATE, 8);//-> 10 days after original booking
    Date futureCheckIn = cal.getTime();
    cal.add(Calendar.DATE, 1);
    Date futureCheckOut = cal.getTime();

    boolean notBooked = bookingDao.isRoomBookedForPeriod(roomId, futureCheckIn, futureCheckOut);
    assertFalse("Room should not be booked for a non-overlapping period", notBooked);
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
