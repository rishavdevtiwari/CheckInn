package checkinn.controller;

import checkinn.model.UserData;
import checkinn.view.UserProfileView;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserProfileController {
    private final UserProfileView userProfileView;
    private final DashboardController dashboardController;
    private final UserData user;

    public UserProfileController(UserProfileView userProfileView, DashboardController dashboardController, UserData user) {
        this.userProfileView = userProfileView;
        this.dashboardController = dashboardController;
        this.user = user;
        

        initializeListeners();
    }

    private void initializeListeners() {
        userProfileView.addBackToDashboardListener(e -> {
            userProfileView.dispose();
            
           
            dashboardController.open();
        });

        userProfileView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dashboardController.open();
            }
        });
    }

    public void open() {
        userProfileView.setLocationRelativeTo(null);
        userProfileView.setVisible(true);
    }

  
}