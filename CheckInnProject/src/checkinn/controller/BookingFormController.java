package checkinn.controller;

import checkinn.dao.BookingDao;
import checkinn.dao.InvoiceDao;
import checkinn.dao.RoomDao;
import checkinn.model.Booking;
import checkinn.model.MenuItem;
import checkinn.view.BookingForm;
import checkinn.view.DashboardView;
import checkinn.view.InvoiceView;
import java.util.Date;
import java.util.List;

public class BookingFormController {
    private final BookingForm bookingForm;
    private final DashboardView dashboardView;
    private final InvoiceView invoiceView;
    private final String email;
    private final RoomDetailsController roomDetailsController;
    private final BookingDao bookingDao = new BookingDao();

    public BookingFormController(BookingForm bookingForm, String roomName, double roomPrice, RoomDetailsController roomDetailsController, DashboardView dashboardView, String email, InvoiceView invoiceView) {
        this.bookingForm = bookingForm;
        this.dashboardView = dashboardView;
        this.email = email;
        this.roomDetailsController = roomDetailsController;
        this.bookingForm.setRoomName(roomName);
        this.bookingForm.setRoomPrice(roomPrice);
        this.invoiceView = invoiceView;
        initializeListeners();
    }

private void initializeListeners() {
    bookingForm.addBackListener(e -> {
        close();
        roomDetailsController.open();
    });


    bookingForm.addCompleteBookingListener(e -> {
        String fullName = bookingForm.getFullName();
        Date checkIn = bookingForm.getCheckInDate();
        Date checkOut = bookingForm.getCheckOutDate();
        List<MenuItem> selectedMenuItems = bookingForm.getSelectedMenuItems();
            int roomId = bookingForm.getRoomId();

            BookingDao bookingDao = new BookingDao();
    if (bookingDao.isRoomBookedForPeriod(roomId, checkIn, checkOut)) {
        bookingForm.showError("This room is already booked for the selected dates. Please choose another date.");
        return;
    }   
        if (fullName == null || fullName.trim().isEmpty()) {
            bookingForm.showError("Full name is required.");
            return;
        }
        if (checkIn == null || checkOut == null || !checkOut.after(checkIn)) {
            bookingForm.showError("Check-in and check-out dates are invalid.");
            return;
        }
        if (selectedMenuItems == null || selectedMenuItems.isEmpty()) {
            bookingForm.showError("Please select at least one menu item.");
            return;
        }

        long diffMillis = checkOut.getTime() - checkIn.getTime();
        long days = (diffMillis / (1000 * 60 * 60 * 24));
        if (days < 1) days = 1;

        double roomPrice = bookingForm.getRoomPrice();
        double menuPrice = selectedMenuItems.stream().mapToDouble(MenuItem::getPrice).sum();
        double totalPrice = (roomPrice * days) + menuPrice;

        bookingForm.setTotalPrice(totalPrice);

        Booking booking = new Booking();
        booking.setRoomId(bookingForm.getRoomId());
        booking.setUserId(bookingForm.getUserId());
        booking.setStatusId(2); // 2 = Occupied
        booking.setInvoiceId(0);
        booking.setCheckInDate(checkIn);
        booking.setCheckOutDate(checkOut);
        booking.setTotalPrice(totalPrice);

        int bookingId = bookingDao.saveBooking(booking);
        if (bookingId > 0) {
            bookingDao.saveBookingMenuItems(bookingId, selectedMenuItems);

            RoomDao roomDao = new RoomDao();
            roomDao.setRoomStatus(booking.getRoomId(), 2);

            InvoiceDao invoiceDao = new InvoiceDao();
            int invoiceId = invoiceDao.createInvoice(bookingId, totalPrice, "Cash");
            bookingDao.updateInvoiceId(bookingId, invoiceId);

            bookingForm.showMessage("Booking successful!");

            InvoiceView newInvoiceView = new InvoiceView();
            newInvoiceView.setInvoiceData(
                bookingForm.getRoomName(),
                bookingForm.getFullName(),
                fullName,
                checkIn,
                checkOut,
                selectedMenuItems,
                totalPrice
            );

            newInvoiceView.getCloseInvoiceButton().addActionListener(e2 -> {
                newInvoiceView.dispose();
                DashboardView newDashboardView = new DashboardView();
                DashboardController dashboardController = new DashboardController(newDashboardView, email);
                dashboardController.open();
            });

            newInvoiceView.setVisible(true);
            close();
        } else {
            bookingForm.showError("Booking failed. Please try again.");
        }
    });
}

    public void open() {
        bookingForm.setVisible(true);
    }

    public void close() {
        bookingForm.dispose();
    }
}