package checkinn.controller;

import checkinn.dao.ReviewDao;
import checkinn.model.Review;
import checkinn.model.UserData;
import checkinn.view.ReviewView;

public class ReviewController {
    private final ReviewView view;
    private final UserData user;

    public ReviewController(ReviewView view, UserData user) {
        this.view = view;
        this.user = user;
        initializeListeners();
    }

    private void initializeListeners() {
        view.getReviewSubmitButton().addActionListener(e -> {
            String reviewText = view.getReviewsTextArea().getText().trim();
            if (reviewText.isEmpty()) {
                javax.swing.JOptionPane.showMessageDialog(view, "Please enter your review.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                return;
            }
            Review review = new Review();
            review.setUserId(user.getUserId());
            review.setReviewText(reviewText);
            new ReviewDao().addReview(review);
            javax.swing.JOptionPane.showMessageDialog(view, "Thank you for your review!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            view.dispose();
        });
    }

    public void open() {
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}