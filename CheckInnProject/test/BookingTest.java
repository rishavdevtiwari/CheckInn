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

}