package checkinn.controller;

import checkinn.view.AboutUs;
import java.awt.event.ActionEvent;

public class AboutUsController {

    private final AboutUs aboutUsView;
    private final Object previousController;

    public AboutUsController(AboutUs aboutUsView, DashboardController dashboardController) {
        this.aboutUsView = aboutUsView;
        this.previousController = dashboardController;
        initialize();
    }
    
    public AboutUsController(AboutUs aboutUsView, BookingHistoryController bookingHistoryController) {
        this.aboutUsView = aboutUsView;
        this.previousController = bookingHistoryController;
        initialize();
    }

    private void initialize() {
        aboutUsView.addExitButtonListener((ActionEvent e) -> {
            close();
            if (previousController instanceof DashboardController) {
                ((DashboardController) previousController).open();
            } else if (previousController instanceof BookingHistoryController) {
                ((BookingHistoryController) previousController).open();
            }
        });
    }

    public void open() {
        aboutUsView.setVisible(true);
        aboutUsView.setLocationRelativeTo(null);
    }

    public void close() {
        aboutUsView.dispose();
    }
}