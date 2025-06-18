package checkinn.controller;

import checkinn.dao.BookingDao;
import checkinn.model.Booking;
import checkinn.model.UserData;
import checkinn.view.BookingHistoryView;
import checkinn.view.InvoiceView;
import checkinn.view.ReviewView;
import checkinn.view.UserProfileView;
import java.util.List;

public class BookingHistoryController {
    private final BookingHistoryView view;
    private final UserData user;
    private final DashboardController dashboardController;
        private List<Booking> userBookings;

    public BookingHistoryController(BookingHistoryView view, UserData user, DashboardController dashboardController) {
        this.view = view;
        this.user = user;
        this.dashboardController = dashboardController;
        initializeListeners();
    }

    public void open() {
            view.setUserName(user.getFirstName() + " " + user.getLastName());
        loadBookingHistory();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void initializeListeners() {
        view.addBackToDashboardListener(e -> {
            view.dispose();
            dashboardController.open();
        });
        
            view.addUserProfileRedirectionListener(e -> {
        view.dispose();
        UserProfileView userProfileView = new UserProfileView(user);
        UserProfileController userProfileController = new UserProfileController(userProfileView, dashboardController, user);
        userProfileController.open();
    });

    view.SingleRoomViewInvoice.addActionListener(e -> openInvoiceForRoom("Single Room"));
    view.DoubleRoomViewInvoice.addActionListener(e -> openInvoiceForRoom("Double Room"));
    view.DeluxeRoomViewInvoice.addActionListener(e -> openInvoiceForRoom("Deluxe Room"));
    view.ExecutiveSuiteVieWInvoice.addActionListener(e -> openInvoiceForRoom("Executive Suite"));
            

    view.getReviewButton().addActionListener(e -> {
    ReviewView reviewView = new ReviewView();
    ReviewController reviewController = new ReviewController(reviewView,user, dashboardController);
    reviewController.open();
    view.setVisible(false); 
});

                view.addLogoutListener(e -> {
        int confirm = javax.swing.JOptionPane.showConfirmDialog(
            view,
            "Are you sure you want to logout?",
            "Confirm Logout | CheckInn",
            javax.swing.JOptionPane.YES_NO_OPTION
        );
        if (confirm == javax.swing.JOptionPane.YES_OPTION) {
            view.dispose();
            javax.swing.JOptionPane.showMessageDialog(null, "Logged out successfully", "Logout | CheckInn", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            checkinn.view.LoginView loginView = new checkinn.view.LoginView();
            checkinn.dao.UserDao userDao = new checkinn.dao.UserDao();
            checkinn.controller.LoginController loginController = new checkinn.controller.LoginController(loginView, userDao);
            loginController.open();
        }
    });
            
    }
    private void loadBookingHistory() {
    BookingDao bookingDao = new BookingDao();
    userBookings = bookingDao.getBookingsWithMenuItemsByUser(user.getUserId());

    // For each room type, update the view
    for (Booking booking : userBookings) {
        String roomType = booking.getRoomType();
        if ("Single Room".equals(roomType)) {
            view.setSingleRoomBooking(
                booking.getCheckInDate(), booking.getCheckOutDate(), true
            );
        } else if ("Double Room".equals(roomType)) {
            view.setDoubleRoomBooking(
                booking.getCheckInDate(), booking.getCheckOutDate(), true
            );
        } else if ("Deluxe Room".equals(roomType)) {
            view.setDeluxeRoomBooking(
                booking.getCheckInDate(), booking.getCheckOutDate(), true
            );
        } else if ("Executive Suite".equals(roomType)) {
            view.setExecutiveSuiteBooking(
                booking.getCheckInDate(), booking.getCheckOutDate(), true
            );
        }
    }
    view.setUnbookedRooms(userBookings);
}

private void openInvoiceForRoom(String roomType) {
    for (Booking booking : userBookings) {
        if (booking.getRoomType().equals(roomType)) {
            InvoiceView invoiceView = new InvoiceView();
            invoiceView.setInvoiceData(
                booking.getRoomType(),
                user.getFirstName() + " " + user.getLastName(),
                user.getFirstName() + " " + user.getLastName(),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getMenuItems(),
                booking.getTotalPrice()
            );
            invoiceView.getCloseInvoiceButton().addActionListener(e -> invoiceView.dispose());
            invoiceView.setVisible(true);
            break;
        }
    }
}

}