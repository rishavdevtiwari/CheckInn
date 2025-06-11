package checkinn.controller;

import checkinn.view.AdminDashboardView; // Make sure this matches your view's class name
import checkinn.view.LoginView;
import javax.swing.JOptionPane;

public class AdminDashboardController {
    private final AdminDashboardView view;
    // In the future, you will add a RoomStatusDao here:
    // private final RoomStatusDao roomStatusDao; 

    public AdminDashboardController(AdminDashboardView view) {
        this.view = view;
        // this.roomStatusDao = new RoomStatusDao(); // For future database work
        
        initializeListeners();
        loadInitialRoomStatuses();
    }
    
    // This is where you would load the current status of each room from a database
    private void loadInitialRoomStatuses() {
        // For now, we'll set default values
        view.setSingleRoomStatus("Vacant");
        view.setDoubleRoomStatus("Occupied");
        view.setDeluxeRoomStatus("Out of Order");
        view.setSuiteRoomStatus("Vacant");
    }

    private void initializeListeners() {
        // Attach listeners for the Single Room buttons
        view.addSingleVacantListener(e -> updateRoomStatus("Single", "Vacant"));
        view.addSingleOccupiedListener(e -> updateRoomStatus("Single", "Occupied"));
        view.addSingleOutOfOrderListener(e -> updateRoomStatus("Single", "Out of Order"));

        // Attach listeners for the Double Room buttons
        // ... you would add the listeners for double, deluxe, and suite here ...

        // Attach listener for the logout button
        view.addLogoutListener(e -> logout());
    }

    // A single, reusable method to handle all status updates
    private void updateRoomStatus(String roomType, String newStatus) {
        System.out.println("Updating " + roomType + " to " + newStatus);

        // Update the label on the UI
        switch (roomType) {
            case "Single":
                view.setSingleRoomStatus(newStatus);
                break;
            case "Double":
                view.setDoubleRoomStatus(newStatus);
                break;
            // ... add cases for Deluxe and Suite ...
        }

        // TODO: In the future, you will save this to the database
        // roomStatusDao.updateStatus(roomType, newStatus);
        
        JOptionPane.showMessageDialog(view, roomType + " status has been set to " + newStatus);
    }

    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(view, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            view.dispose();
            new LoginController(new LoginView(), new checkinn.dao.UserDao()).open();
        }
    }
    
    public void showView() {
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }
}