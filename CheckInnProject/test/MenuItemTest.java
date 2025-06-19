import checkinn.dao.MenuItemDao;
import checkinn.model.MenuItem;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;

public class MenuItemTest {

    private MenuItemDao menuItemDao;

    @Before
    public void setUp() {
        menuItemDao = new MenuItemDao();
    }

    

