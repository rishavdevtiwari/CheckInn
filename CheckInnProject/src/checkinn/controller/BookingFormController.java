package checkinn.controller;

import checkinn.view.BookingForm;

public class BookingFormController {
    private final BookingForm bookingForm;
    private final RoomDetailsController roomDetailsController;

    public BookingFormController(BookingForm bookingForm, String roomName, double roomPrice, RoomDetailsController roomDetailsController) {
        this.bookingForm = bookingForm;
        this.roomDetailsController = roomDetailsController;
        this.bookingForm.setRoomName(roomName);
        this.bookingForm.setRoomPrice(roomPrice);

        initializeListeners();
    }

    private void initializeListeners() {
        bookingForm.addBackListener(e -> {
            close();
            roomDetailsController.open();
        });
    }

    public void open() {
        bookingForm.setVisible(true);
    }

    public void close() {
        bookingForm.dispose();
    }
}







// package checkinn.controller;

// import checkinn.view.BookingForm;

// public class BookingFormController {
//     private final BookingForm bookingForm;

//     public BookingFormController(BookingForm bookingForm, String roomName, double roomPrice) {
//         this.bookingForm = bookingForm;
//         this.bookingForm.setRoomName(roomName);
//         this.bookingForm.setRoomPrice(roomPrice);

//     }

//     public void open() {
//         bookingForm.setVisible(true);
//         bookingForm.setLocationRelativeTo(null);
//     }

//     public void close() {
//         bookingForm.dispose();
//     }
// }