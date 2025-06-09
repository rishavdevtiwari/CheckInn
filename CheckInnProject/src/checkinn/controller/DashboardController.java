package checkinn.controller;

import checkinn.dao.UserDao;
import checkinn.model.Room; // <-- Import the Room model
import checkinn.model.UserData;
import checkinn.view.DashboardView;
import checkinn.view.LoginView;
import checkinn.view.RoomDetailsView;
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

        // --- EDITED SECTION: Create Room objects to hold all data ---
        Room singleRoom = new Room("Single Room", 100.00, "Standard single bed room with basic amenities.", "/images/singleroom.jpg");
        Room doubleRoom = new Room("Double Room", 150.00, "Standard double bed room with basic amenities.", "/images/doubleroom.jpg");
        Room deluxeRoom = new Room("Deluxe Room", 250.00, "Spacious room with premium amenities and city view.", "/images/Deluxe.jpg");
        Room suiteRoom = new Room("Executive Suite", 400.00, "Luxurious suite with separate living area and premium services.", "/images/executive room.jpg");
        
        // --- EDITED SECTION: Assign listeners using the Room objects ---
        dashboardView.addSingleRoomListener((e) -> openRoomDetailsPage(singleRoom));
        dashboardView.addDoubleRoomListener((e) -> openRoomDetailsPage(doubleRoom));
        dashboardView.addDeluxeRoomListener((e) -> openRoomDetailsPage(deluxeRoom));
        dashboardView.addSuiteRoomListener((e) -> openRoomDetailsPage(suiteRoom));


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

    /**
     * EDITED: This method now accepts a single Room object.
     * It creates and shows the RoomDetailsView, passing the responsibility to the RoomDetailsController.
     * @param room The Room object containing all details for the selected room.
     */
    private void openRoomDetailsPage(Room room) {
        dashboardView.setVisible(false);

        RoomDetailsView detailsView = new RoomDetailsView();
        // Pass the entire 'room' object to the details controller.
        // This assumes your RoomDetailsController is updated to accept a Room object.
        RoomDetailsController detailsController = new RoomDetailsController(detailsView, this.dashboardView, this.user, room);
        
        detailsController.showView();
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