package checkinn.controller;

import checkinn.view.DashboardView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardController {
    private DashboardView view;

    public DashboardController(DashboardView view) {
        this.view = view;

        // Assign listeners to buttons
        this.view.addSingleRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle single room details
                System.out.println("Single Room button clicked");
            }
        });

        this.view.addDoubleRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle double room details
                System.out.println("Double Room button clicked");
            }
        });

        this.view.addDeluxeRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle deluxe room details
                System.out.println("Deluxe Room button clicked");
            }
        });

        this.view.addSuiteRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle suite room details
                System.out.println("Suite Room button clicked");
            }
        });

        this.view.addBookingHistoryListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle booking history
                System.out.println("Booking History button clicked");
            }
        });

        this.view.addDashboardListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle dashboard refresh or navigation
                System.out.println("Dashboard button clicked");
            }
        });

        this.view.addLogoutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Handle logout
                System.out.println("Logout button clicked");
            }
        });
    }

    // Optionally, add a method to set the user name on the dashboard
    public void setUserName(String name) {
        view.setUserName(name);
    }
}