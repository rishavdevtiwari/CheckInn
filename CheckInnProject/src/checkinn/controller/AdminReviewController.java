package checkinn.controller;

import checkinn.dao.ReviewDao;
import checkinn.model.Review;
import checkinn.view.AdminReviewView;
import java.util.List;

public class AdminReviewController {
    private final AdminReviewView view;
    private final AdminDashboardController dashboardController;

    public AdminReviewController(AdminReviewView view,AdminDashboardController dashboardController) {
        this.view = view;
        this.dashboardController=dashboardController;
        initialize();
    }

    private void initialize() {
        loadReviews();
        view.getExitButton().addActionListener(e -> {view.dispose();
dashboardController.showView();
        });
    }

    private void loadReviews() {
        List<Review> reviews = new ReviewDao().getAllReviews();
        StringBuilder sb = new StringBuilder();
        for (Review r : reviews) {
            sb.append("User ID: ").append(r.getUserId())
              .append(" | Date: ").append(r.getReviewDate())
              .append("\n")
              .append(r.getReviewText())
              .append("\n----------------------\n");
        }
        view.getReviewTextArea().setText(sb.toString());
    }

    public void open() {
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}