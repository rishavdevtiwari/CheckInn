import checkinn.dao.ReviewDao;
import checkinn.model.Review;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;

public class ReviewTest {

    private ReviewDao reviewDao;

    @Before
    public void setUp() {
        reviewDao = new ReviewDao();
    }

   
}