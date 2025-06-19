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

    @Test
    public void testGetAllMenuItems_NotEmpty() {
        List<MenuItem> menuItems = menuItemDao.getAllMenuItems();
        
      
        assertNotNull("Menu items list should not be null", menuItems);
        
       
        assertTrue("Menu items should contain at least one item", menuItems.size() > 0);
        
        
        for (MenuItem item : menuItems) {
            System.out.println("ID: " + item.getMenuId() + ", Name: " + item.getItemName() + ", Price: " + item.getPrice());
        }
    }
}

