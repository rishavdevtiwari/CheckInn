package checkinn.controller;

import checkinn.model.UserData;
import checkinn.view.DashboardView;
import checkinn.view.RoomDetailsView;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

public class RoomDetailsController {

    private final RoomDetailsView view;
    private final DashboardView dashboardView; // To go back to the dashboard
    private final UserData user;
    private final String roomType;
    private final double price;

    public RoomDetailsController(RoomDetailsView view, DashboardView dashboardView, UserData user, String roomType, double price, String description) {
        this.view = view;
        this.dashboardView = dashboardView;
        this.user = user;
        this.roomType = roomType;
        this.price = price;

        // Populate the view with room data
        this.view.setRoomName(roomType);
        this.view.setPrice(price);
        this.view.setDescription(description);

        initializeListeners();
    }

    private void initializeListeners() {
        // Listener for the "Book now" button
        view.addBookingListener((ActionEvent e) -> {
            bookRoom();
        });

        // Listener for the "<- Dashboard" text field
        view.addBackListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                goBack();
            }
        });
    }

    private void bookRoom() {
        String userName = (user != null && user.getFirstName() != null) ? user.getFirstName() : "Guest";
        int confirm = JOptionPane.showConfirmDialog(
                view,
                "Confirm booking for " + roomType + " at RS. " + String.format("%.2f", price) + "?",
                "Confirm Booking",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            // Here you would add your database logic to save the booking
            JOptionPane.showMessageDialog(view, "Room booked successfully for " + userName + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
            goBack(); // Go back to dashboard after booking
        }
    }

    private void goBack() {
        view.dispose(); // Close the RoomDetailsView
        dashboardView.setVisible(true); // Show the dashboard again
    }

    public void showView() {
        view.setLocationRelativeTo(dashboardView); // Open centered on the dashboard
        view.setVisible(true);
    }
}