package checkinn.controller;

import checkinn.view.BookingForm;
import checkinn.view.CheckInnPackages;

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

            bookingForm.addMenuItemsListener(e -> {
            close();
            CheckInnPackages checkInnPackagesView = new CheckInnPackages();
            CheckInnPackagesController checkInnPackagesController = new CheckInnPackagesController(checkInnPackagesView);
            checkInnPackagesController.open();
        });
    }

    public void open() {
        bookingForm.setVisible(true);
    }

    public void close() {
        bookingForm.dispose();
    }
}






