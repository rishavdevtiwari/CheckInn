package checkinn.controller;

import checkinn.dao.RoomDao;
import checkinn.model.Room; // <-- Import the Room model
import checkinn.model.UserData;
import checkinn.view.BookingForm;
import checkinn.view.DashboardView;
import checkinn.view.InvoiceView;
import checkinn.view.RoomDetailsView;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoomDetailsController {

    private final RoomDetailsView view;
    private final DashboardView dashboardView;
    private final UserData user;
    private final InvoiceView invoiceView;
    private final Room room; // <-- Store the whole Room object as a field

    /**
     * EDITED: The constructor now accepts a single Room object.
     * @param view
     * @param dashboardView
     * @param user
     * @param room
     */
    public RoomDetailsController(RoomDetailsView view, DashboardView dashboardView, UserData user, Room room, InvoiceView invoiceView) {
        this.view = view;
        this.dashboardView = dashboardView;
        this.invoiceView=invoiceView;
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

private void openBookingForm() {
close();
    BookingForm bookingForm = new BookingForm();
    bookingForm.setRoomId(room.getRoomId());
    bookingForm.setRoomName(room.getRoomType());
    bookingForm.setRoomPrice(room.getPrice());
    bookingForm.setUserId(user.getUserId());
    BookingFormController bookingFormController = new BookingFormController(
        bookingForm,
        room.getRoomType(),
        room.getPrice(),
        this,
        dashboardView ,
        user.getEmail(),
            invoiceView
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

private void loadRoomDetails() {
    String status;
    int statusId = room.getStatusId();
    if (statusId == 2) {
        status = "Occupied";
    } else if (statusId == 1) {
        status = "Vacant";
    } else if (statusId == 3) {
        status = "Out of Order";
    } else {
        status = "Unknown";
    }
    view.setRoomStatus(status);
    view.setRoomName(room.getRoomType());
    view.setPrice(room.getPrice());
    view.setDescription(room.getDescription());
    view.setRoomImage(room.getImagePath());
}
}