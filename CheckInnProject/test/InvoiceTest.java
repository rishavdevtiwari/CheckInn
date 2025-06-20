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

    
    
}