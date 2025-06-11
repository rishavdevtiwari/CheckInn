package checkinn.controller;

import checkinn.view.mail.AdminDashboard;
import java.awt.event.ActionEvent;

public class AdminDashboardController {
    private final AdminDashboard view;

    public AdminDashboardController(AdminDashboard view) {
        this.view = view;
        initializeListeners();
    }
}
 private void initializeListeners() {
    
        this.view.addLogoutListener((ActionEvent e) -> {
            logout();
        });
    }
   private void logout() {
        int confirm = JOptionPane.showConfirmDialog(view, "Are you sure you want to logout?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Close the admin dashboard
            view.dispose();
            
            // Re-open the login screen
            LoginView loginView = new LoginView();
            UserDao userDao = new UserDao();
            new LoginController(loginView, userDao).open();
        }
    }

    public void showView() {
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
}