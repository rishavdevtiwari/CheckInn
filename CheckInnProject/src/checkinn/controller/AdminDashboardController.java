package checkinn.controller;

import checkinn.dao.UserDao;
import checkinn.model.UserData;
import checkinn.view.AdminBookingHistory;
import checkinn.view.AdminClientView;
import checkinn.view.AdminDashboard;
import checkinn.view.LoginView;
import javax.swing.JOptionPane;
// Add missing imports for the controllers
import checkinn.controller.AdminBookingHistoryController;
import checkinn.controller.AdminClientController;


public class AdminDashboardController {

    private final AdminDashboard view;
    private final UserData adminData; // Re-add UserData to hold admin's info

    // Update the constructor to accept UserData again
    public AdminDashboardController(AdminDashboard view, UserData adminData) {
        this.view = view;
        this.adminData = adminData; // Store the admin data
        initializeView(); // Call method to set the admin's name
        initializeListeners();
        loadInitialRoomStatuses();
    }
    
    // Re-add the method to set the admin's name on the view
    private void initializeView() {
        view.setAdminName(adminData.getFirstName() + " " + adminData.getLastName());
    }

    // Initial state setting of dashboard
    private void loadInitialRoomStatuses() {
        view.setSingleRoomStatus("Vacant");
        view.setDoubleRoomStatus("Occupied");
        view.setDeluxeRoomStatus("Out of Order");
        view.setSuiteRoomStatus("Vacant");
    }

    private void openAdminBookingHistory() {
        AdminBookingHistory bookingHistoryView = new AdminBookingHistory();
        AdminBookingHistoryController bookingHistoryController = new AdminBookingHistoryController(bookingHistoryView, this);
        view.setVisible(false); // Hide the dashboard
        bookingHistoryController.open();
    }

    // Action listeners for set status buttons
    private void initializeListeners() {
        // Single room status listners
        view.addSingleVacantListener(e -> updateRoomStatus("Single", "Vacant"));
        view.addSingleOccupiedListener(e -> updateRoomStatus("Single", "Occupied"));
        view.addSingleOutOfOrderListener(e -> updateRoomStatus("Single", "Out of Order"));

        // Double room status listeners
        view.addDoubleVacantListener(e -> updateRoomStatus("Double", "Vacant"));
        view.addDoubleOccupiedListener(e -> updateRoomStatus("Double", "Occupied"));
        view.addDoubleOutOfOrderListener(e -> updateRoomStatus("Double", "Out of Order"));
        
        // Deluxe room status listeners
        view.addDeluxeVacantListener(e -> updateRoomStatus("Deluxe", "Vacant"));
        view.addDeluxeOccupiedListener(e -> updateRoomStatus("Deluxe", "Occupied"));
        view.addDeluxeOutOfOrderListener(e -> updateRoomStatus("Deluxe", "Out of Order"));

        // Suite room status listeners
        view.addSuiteVacantListener(e -> updateRoomStatus("Suite", "Vacant"));
        view.addSuiteOccupiedListener(e -> updateRoomStatus("Suite", "Occupied"));
        view.addSuiteOutOfOrderListener(e -> updateRoomStatus("Suite", "Out of Order"));

        // Admin dashboard navigation listeners
        view.addLogoutListener(e -> logout());
        view.addAdminClientButtonListener(e -> openAdminClientView());
        
        view.addDashboardRefreshListener(e -> {
            loadInitialRoomStatuses();
            JOptionPane.showMessageDialog(view, "Dashboard has been refreshed.", "Refresh", JOptionPane.INFORMATION_MESSAGE);
        });
        
        view.addBookingHistoryListener(e -> openAdminBookingHistory());
    }

    /**
     * A single, reusable method to handle all status update logic.
     * @param roomType The type of room to update (e.g., "Single")
     * @param newStatus The new status to set (e.g., "Vacant")
     */
    private void updateRoomStatus(String roomType, String newStatus) {
        System.out.println("Admin is setting " + roomType + " room status to: " + newStatus);

        // Update the correct label on the UI
        switch (roomType) {
            case "Single":
                view.setSingleRoomStatus(newStatus);
                break;
            case "Double":
                view.setDoubleRoomStatus(newStatus);
                break;
            case "Deluxe":
                view.setDeluxeRoomStatus(newStatus);
                break;
            case "Suite":
                view.setSuiteRoomStatus(newStatus);
                break;
        }

        // TODO: In the future, you will save this change to your database here.
        // E.g., roomStatusDao.updateStatus(roomType, newStatus);
        
        JOptionPane.showMessageDialog(view, roomType + " room status has been set to '" + newStatus + "'");
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(view, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            view.dispose(); // Close the admin dashboard
            
            // Re-open the login screen
            LoginView loginView = new LoginView();
            UserDao userDao = new UserDao();
            new LoginController(loginView, userDao);
            loginView.setVisible(true);
        }
    }

    private void openAdminClientView() {
        AdminClientView adminClientView = new AdminClientView();
        AdminClientController adminClientController = new AdminClientController(adminClientView, this);
        view.setVisible(false); 
        adminClientController.open();
    }

    /**
     * Makes the admin dashboard visible.
     */
    public void showView() {
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}