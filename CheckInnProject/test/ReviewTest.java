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

    @Test
    public void testAddAndGetAllReviews() {
        // Preparing review
        Review review = new Review();
        review.setUserId(1); // Using a valid user ID from the database (Only testing after registering a user)
        review.setReviewText("JUnit test review " + System.currentTimeMillis());

        // Adding review
        reviewDao.addReview(review);

        // Fetching reviews and checking for reviews updation
        List<Review> reviews = reviewDao.getAllReviews();
        assertFalse(reviews.isEmpty());
        Review lastReview = reviews.get(0); //fetching reviews

        assertEquals(review.getUserId(), lastReview.getUserId());
        assertEquals(review.getReviewText(), lastReview.getReviewText());
    }
}