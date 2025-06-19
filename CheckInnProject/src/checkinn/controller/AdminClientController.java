package checkinn.controller;

import checkinn.dao.UserDao;
import checkinn.model.UserData;
import checkinn.view.AdminBookingHistory;
import checkinn.view.AdminClientView;
import checkinn.view.AdminReviewView;
import checkinn.view.LoginView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AdminClientController {
    private final AdminClientView view;
    private final AdminDashboardController dashboardController;

    public AdminClientController(AdminClientView view, AdminDashboardController dashboardController) {
        this.view = view;
        this.dashboardController = dashboardController;
        initializeListeners();
    }

    public void open() {
        loadAllUsers();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

   private void initializeListeners() {
    view.addBackToDashboardListener(e -> {
        view.dispose();
        dashboardController.showView();
    });

            view.getAdminReviewButton().addActionListener(e->{
            view.setVisible(false);
            AdminReviewView adminReviewView=new AdminReviewView();
            AdminReviewController adminReviewController;
        adminReviewController = new AdminReviewController(adminReviewView,dashboardController);
            adminReviewController.open();
        });
            
    view.getBookingHistoryButton().addActionListener(e -> {
        view.dispose();
        AdminBookingHistory bookingHistoryView = new AdminBookingHistory();
        AdminBookingHistoryController bookingHistoryController = new AdminBookingHistoryController(bookingHistoryView, dashboardController);
        bookingHistoryController.open();
    });
    
    view.getLogOutButton().addActionListener(e -> {
        int confirm = JOptionPane.showConfirmDialog(
            view, 
            "Are you sure you want to logout?",
            "Confirm Logout",
            JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            view.dispose();
            
            // Open the LoginView
            LoginView loginView = new LoginView();
            UserDao userDao = new UserDao(); 
            new LoginController(loginView, userDao).open();
        }
    });
    
    view.addDeleteClientListener(e -> {
        String input = javax.swing.JOptionPane.showInputDialog(view, "Enter User ID to delete:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int userId = Integer.parseInt(input.trim());
                UserDao userDao = new UserDao();
                boolean deleted = userDao.deleteUserById(userId);
                if (deleted) {
                    javax.swing.JOptionPane.showMessageDialog(view, "User deleted successfully.", "Deleted", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    loadAllUsers(); // Refresh list
                } else {
                    javax.swing.JOptionPane.showMessageDialog(view, "User not found or could not be deleted.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(view, "Invalid User ID.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        }
    });
}

    private void loadAllUsers() {
        UserDao userDao = new UserDao();
        List<UserData> users = userDao.getAllUsers();
        StringBuilder sb = new StringBuilder();
        for (UserData user : users) {
            sb.append("ID: ").append(user.getUserId())
              .append(" | Name: ").append(user.getFirstName()).append(" ").append(user.getLastName())
              .append(" | Email: ").append(user.getEmail())
              .append(" | Phone: ").append(user.getPhoneNumber())
              .append("\n");
        }
        view.setClientTextArea(sb.toString());
    }

}