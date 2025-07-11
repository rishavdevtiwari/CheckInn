
import checkinn.dao.RoomDao;
import org.junit.*;
import static org.junit.Assert.*;

public class RoomTest {
    

    private RoomDao roomDao;
    private int originalStatus;//initializing variable to acces it in @ After 

    @Before
    public void setUp() {
        roomDao = new RoomDao();
    }
    
    @After
    public void tearDown() {
       // Restore the status of room 1 as it was after testing for avoiding inconveniences
      
        roomDao.setRoomStatus(1, originalStatus);
    }

    @Test
    public void testSetAndGetRoomStatus() {
        int roomId = 1; // Using a valid room id (single =1)
        int originalStatus = roomDao.getRoomStatusId(roomId);

        // Set to Occupied which is 2
        roomDao.setRoomStatus(roomId, 2);
        int statusAfterSet = roomDao.getRoomStatusId(roomId);
        assertEquals(2, statusAfterSet);

        // Setting room status back to original status
        roomDao.setRoomStatus(roomId, originalStatus);
        int statusRestored = roomDao.getRoomStatusId(roomId);
        assertEquals(originalStatus, statusRestored);
    }
    @Test
    public void testGetRoomStatusId_InvalidRoom() {
        int status = roomDao.getRoomStatusId(-1); // Invalid room ID for testing
        assertEquals(1, status); // this needs to return vacant for test to pass
    }
}
    