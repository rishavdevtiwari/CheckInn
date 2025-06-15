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
            
                view.addLogoutListener(e -> {
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
            view,
            "Are you sure you want to logout?",
            "Confirm Logout | CheckInn",
            javax.swing.JOptionPane.YES_NO_OPTION
        );
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            view.dispose();
            javax.swing.JOptionPane.showMessageDialog(null, "Logged out successfully", "Logout | CheckInn", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            checkinn.view.LoginView loginView = new checkinn.view.LoginView();
            checkinn.dao.UserDao userDao = new checkinn.dao.UserDao();
            checkinn.controller.LoginController loginController = new checkinn.controller.LoginController(loginView, userDao);
            loginController.open();
        }
    });
            
    }
}