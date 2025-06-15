package checkinn.controller;

import checkinn.model.UserData;
import checkinn.view.BookingHistoryView;
import checkinn.view.UserProfileView;

public class BookingHistoryController {
    private final BookingHistoryView view;
    private final UserData user;
    private final DashboardController dashboardController;

    public BookingHistoryController(BookingHistoryView view, UserData user, DashboardController dashboardController) {
        this.view = view;
        this.user = user;
        this.dashboardController = dashboardController;
        initializeListeners();
    }

    public void open() {
        //loadBookingHistory();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void initializeListeners() {
        view.addBackToDashboardListener(e -> {
            view.dispose();
            dashboardController.open();
        });
        
            view.addUserProfileRedirectionListener(e -> {
        view.dispose();
        UserProfileView userProfileView = new UserProfileView(user);
        UserProfileController userProfileController = new UserProfileController(userProfileView, dashboardController, user);
        userProfileController.open();
    });
            
    }
}