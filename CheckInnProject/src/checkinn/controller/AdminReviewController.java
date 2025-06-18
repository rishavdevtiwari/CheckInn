package checkinn.controller;

import checkinn.dao.ReviewDao;
import checkinn.model.Review;
import checkinn.view.AdminReviewView;
import java.util.List;

public class AdminReviewController {
    private final AdminReviewView view;

    public AdminReviewController(AdminReviewView view) {
        this.view = view;
        initialize();
    }

    private void initialize() {
        loadReviews();
        view.getExitButton().addActionListener(e -> view.dispose());
    }

    private void loadReviews() {

    }

    public void open() {
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}