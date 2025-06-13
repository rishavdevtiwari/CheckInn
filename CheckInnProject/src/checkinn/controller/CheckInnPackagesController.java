package checkinn.controller;

import checkinn.view.CheckInnPackages;

public class CheckInnPackagesController {
    private final CheckInnPackages checkInnPackagesView;
    private final BookingFormController bookingFormController;

    public CheckInnPackagesController(CheckInnPackages checkInnPackagesView, BookingFormController bookingFormController) {
        this.checkInnPackagesView = checkInnPackagesView;
        this.bookingFormController = bookingFormController;
        initializeListeners();
    }

    public void open() {
        checkInnPackagesView.setVisible(true);
        checkInnPackagesView.setLocationRelativeTo(null);
    }

    private void initializeListeners() {
        checkInnPackagesView.addBackToBookingFormListener(e -> {
            checkInnPackagesView.dispose();
            bookingFormController.open();
        });
    }

    public void close() {
        checkInnPackagesView.dispose();
    }
}