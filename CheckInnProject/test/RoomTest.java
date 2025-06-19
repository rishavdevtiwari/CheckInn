
import checkinn.dao.RoomDao;
import org.junit.*;
import static org.junit.Assert.*;

public class RoomTest {

    private RoomDao roomDao;

    @Before
    public void setUp() {
        roomDao = new RoomDao();
    }

    
