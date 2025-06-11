package checkinn.controller;

import checkinn.model.Room; // <-- Import the Room model
import checkinn.model.UserData;
import checkinn.view.BookingFormView;
import checkinn.view.DashboardView;
import checkinn.view.RoomDetailsView;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoomDetailsController {

    private final RoomDetailsView view;
    private final DashboardView dashboardView;
    private final UserData user;
    private final Room room; // <-- Store the whole Room object as a field

    /**
     * EDITED: The constructor now accepts a single Room object.
     * @param view
     * @param dashboardView
     * @param user
     * @param room
     */
    public RoomDetailsController(RoomDetailsView view, DashboardView dashboardView, UserData user, Room room) {
        this.view = view;
        this.dashboardView = dashboardView;
        this.user = user;
        this.room = room; // <-- Assign the passed-in Room object to the field

        // Populate the view with data from the Room object
        this.view.setRoomName(room.getRoomType());
        this.view.setPrice(room.getPrice());
        this.view.setDescription(room.getDescription());
        this.view.setRoomImage(room.getImagePath()); // Set the image

        initializeListeners();
    }

    private void initializeListeners() {
        // Listener for the "Book now" button
        view.addBookingListener((ActionEvent e) -> {
            openBookingForm();
        });

        // Listener for the "<- Dashboard" text field
        view.addBackListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                goBack();
            }
        });
    }

//    private void bookRoom() {
//        String userName = (user != null && user.getFirstName() != null) ? user.getFirstName() : "Guest";
//        
//        // Use the room object to get details for the confirmation message
//        int confirm = JOptionPane.showConfirmDialog(
//                view,
//                "Confirm booking for " + room.getRoomType() + " at RS. " + String.format("%.2f", room.getPrice()) + "?",
//                "Confirm Booking",
//                JOptionPane.YES_NO_OPTION
//        );
//
//        if (confirm == JOptionPane.YES_OPTION) {
//            // Here you would add your database logic to save the booking
//            JOptionPane.showMessageDialog(view, "Room booked successfully for " + userName + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
//            goBack(); // Go back to dashboard after booking
//        }
//    }

    private void openBookingForm() {
        // Close RoomDetailsView
        close();

        // Open BookingForm and pass room name and price
        BookingFormView bookingForm = new BookingFormView();
        BookingFormController bookingFormController = new BookingFormController(
            bookingForm,
            room.getRoomType(),
            room.getPrice(),
            this
        );
        bookingFormController.open();
    }

    public void close() {
        view.dispose();
    }


    private void goBack() {
        view.dispose(); // Close the RoomDetailsView
        dashboardView.setVisible(true); // Show the dashboard again
    }

    public void open() {
        view.setLocationRelativeTo(dashboardView); 
        view.setVisible(true);
    }
}