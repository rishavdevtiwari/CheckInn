package checkinn.controller;

import checkinn.dao.UserDao;
import checkinn.model.UserData;
import checkinn.view.DashboardView;
import checkinn.view.LoginView;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class DashboardController {
    private final DashboardView dashboardView;
    private final String userEmail;
    private UserData user;

    public DashboardController(DashboardView dashboardView, String userEmail) {
        this.dashboardView = dashboardView;
        this.userEmail = userEmail;
        loadUserData();
        initialize();
    }

    private void loadUserData() {
        UserDao userDao = new UserDao();
        this.user = userDao.getUserByEmail(userEmail);
    }

    private void initialize() {
        // Set user name and welcome message on dashboard if available
        if (user != null && user.getFirstName() != null) {
            dashboardView.setUserName(user.getFirstName());
            dashboardView.setWelcomeMessage("Welcome, " + user.getFirstName() + "!");
        } else {
            dashboardView.setUserName("Guest");
            dashboardView.setWelcomeMessage("Welcome, Guest!");
        }

        // Assign listeners to buttons
        dashboardView.addSingleRoomListener((ActionEvent e) -> {
            handleRoomSelection("Single Room", 100.00, "Standard single bed room with basic amenities");
        });

        dashboardView.addDoubleRoomListener((ActionEvent e) -> {
            handleRoomSelection("Double Room", 150.00, "Standard double bed room with basic amenities");
        });

        dashboardView.addDeluxeRoomListener((ActionEvent e) -> {
            handleRoomSelection("Deluxe Room", 250.00, "Spacious room with premium amenities and city view");
        });

        dashboardView.addSuiteRoomListener((ActionEvent e) -> {
            handleRoomSelection("Suite", 400.00, "Luxurious suite with separate living area and premium services");
        });

        dashboardView.addBookingHistoryListener((ActionEvent e) -> {
            String bookingHistory = "Booking History for " + (user != null ? user.getFirstName() : "Guest") + ":\n"
                                 + "1. Single Room - 2023-05-15 to 2023-05-17\n"
                                 + "2. Deluxe Room - 2023-06-01 to 2023-06-05";
            JOptionPane.showMessageDialog(dashboardView, bookingHistory, "Booking History", JOptionPane.INFORMATION_MESSAGE);
        });

        dashboardView.addDashboardListener((ActionEvent e) -> {
            refreshDashboard();
        });

        dashboardView.addLogoutListener((ActionEvent e) -> {
            int confirm = JOptionPane.showConfirmDialog(
                dashboardView,
                "Are you sure you want to logout?",
                "Confirm Logout",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                close();
                JOptionPane.showMessageDialog(null, "Logged out successfully", "Logout", JOptionPane.INFORMATION_MESSAGE);
                LoginView loginView = new LoginView();
                UserDao userDao = new UserDao();
                LoginController loginController = new LoginController(loginView, userDao);
                loginController.open();
            }
        });
    }

    private void handleRoomSelection(String roomType, double price, String description) {
        String message = String.format(
            "%s\nPrice: $%.2f per night\nDescription: %s\n\nWould you like to book this room?",
            roomType, price, description
        );

        int choice = JOptionPane.showConfirmDialog(
            dashboardView,
            message,
            roomType + " Details",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                dashboardView,
                "Proceeding to booking for " + roomType,
                "Booking",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    private void refreshDashboard() {
        if (user != null && user.getFirstName() != null) {
            dashboardView.setUserName(user.getFirstName());
        } else {
            dashboardView.setUserName("Guest");
        }
        JOptionPane.showMessageDialog(
            dashboardView,
            "Dashboard refreshed",
            "Information",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void open() {
        dashboardView.setVisible(true);
    }

    public void close() {
        dashboardView.dispose();
    }
}