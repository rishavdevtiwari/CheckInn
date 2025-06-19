package checkinn.controller;

import checkinn.dao.BookingDao;
import checkinn.dao.RoomDao;
import checkinn.dao.UserDao; // Import for UserDao
import checkinn.model.Booking;
import checkinn.view.AdminBookingHistory;
import checkinn.view.AdminClientView;
import checkinn.view.AdminReviewView;
import checkinn.view.InvoiceView;
import checkinn.view.LoginView; // Import for LoginView
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class AdminBookingHistoryController {

    private final AdminBookingHistory view;
    private final AdminDashboardController dashboardController;
    private final BookingDao bookingDao;
    private List<Booking> allBookings;

    public AdminBookingHistoryController(AdminBookingHistory view, AdminDashboardController dashboardController) {
        this.view = view;
        this.dashboardController = dashboardController;
        this.bookingDao = new BookingDao();
        initializeListeners();
    }

    public void open() {
        loadBookingHistory();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void initializeListeners() {
        view.getAdminDashboardButton().addActionListener(e -> {
            view.dispose();
            dashboardController.showView();
        });
        
                view.getAdminReviewButton().addActionListener(e->{
            view.setVisible(false);
            AdminReviewView adminReviewView=new AdminReviewView();
            AdminReviewController adminReviewController=new AdminReviewController(adminReviewView,dashboardController);
            adminReviewController.open();
        });
                
        view.getAdminClientButton().addActionListener(e -> {
            view.dispose();
            AdminClientView adminClientView = new AdminClientView();
            AdminClientController adminClientController = new AdminClientController(adminClientView, dashboardController);
            adminClientController.open();
        });

        view.getSingleViewInvoiceButton().addActionListener(e -> openInvoiceForRoom("Single Room"));
        view.getDoubleViewInvoiceButton().addActionListener(e -> openInvoiceForRoom("Double Room"));
        view.getDeluxeViewInvoiceButton().addActionListener(e -> openInvoiceForRoom("Deluxe Room"));
        view.getExecutiveSuiteViewInvoiceButton().addActionListener(e -> openInvoiceForRoom("Executive Suite"));

        view.getSingleCancelButton().addActionListener(e -> cancelBookingForRoom("Single Room"));
        view.getDoubleCancelButton().addActionListener(e -> cancelBookingForRoom("Double Room"));
        view.getDeluxeCancelButton().addActionListener(e -> cancelBookingForRoom("Deluxe Room"));
        view.getExecutiveSuiteCancelButton().addActionListener(e -> cancelBookingForRoom("Executive Suite"));

        // Logout Button Listener
        view.getLogoutButton().addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                view, 
                "Are you sure you want to logout?",
                "Confirm Logout | CheckInn",
                JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                view.dispose(); // Close the current AdminBookingHistory view

                JOptionPane.showMessageDialog(null, "Logged out successfully", "Logout | CheckInn", JOptionPane.INFORMATION_MESSAGE);
                
                // Open the LoginView
                LoginView loginView = new LoginView();
                UserDao userDao = new UserDao(); // Assuming you have a UserDao to pass to LoginController
                LoginController loginController = new LoginController(loginView, userDao);
                loginController.open();
            }
        });
    }

    private void loadBookingHistory() {
        // 1. Reset all rows to their default (disabled) state
        view.resetAllBookings(); 
        
        // 2. Get all current bookings from the database
        allBookings = bookingDao.getAllBookings();

        // 3. Loop through the bookings and update only the relevant rows
        for (Booking booking : allBookings) {
            switch (booking.getRoomType()) {
                case "Single Room":
                    view.setSingleBooking(true, booking.getClientName());
                    break;
                case "Double Room":
                    view.setDoubleBooking(true, booking.getClientName());
                    break;
                case "Deluxe Room":
                    view.setDeluxeBooking(true, booking.getClientName());
                    break;
                case "Executive Suite":
                    view.setExecutiveSuiteBooking(true, booking.getClientName());
                    break;
            }
        }
    }

    private void openInvoiceForRoom(String roomType) {
        Optional<Booking> bookingOpt = findBookingByRoomType(roomType);

        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            InvoiceView invoiceView = new InvoiceView();
            invoiceView.setInvoiceData(
                booking.getRoomType(),
                booking.getClientName(),
                booking.getClientName(),
                booking.getCheckInDate(),
                booking.getCheckOutDate(),
                booking.getMenuItems(),
                booking.getTotalPrice()
            );
             invoiceView.getCloseInvoiceButton().addActionListener(e -> {
            invoiceView.dispose(); // Close the invoice
            dashboardController.showView(); // Show the AdminDashboard again
        });
        
        invoiceView.setVisible(true);

    } else {
        JOptionPane.showMessageDialog(view, "No active booking for " + roomType, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
    

    private void cancelBookingForRoom(String roomType) {
        Optional<Booking> bookingOpt = findBookingByRoomType(roomType);

        if (!bookingOpt.isPresent()) {
            JOptionPane.showMessageDialog(view, "No active booking to cancel for " + roomType, "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        Booking bookingToCancel = bookingOpt.get();

        int choice = JOptionPane.showConfirmDialog(
            view, 
            "Are you sure you want to cancel the booking for " + bookingToCancel.getClientName() + " in " + roomType + "?",
            "Confirm Cancellation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            boolean success = bookingDao.cancelBooking(bookingToCancel.getBookingId());
            if (success) {
                JOptionPane.showMessageDialog(view, "Booking cancelled successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            RoomDao roomDao = new RoomDao();
            roomDao.setRoomStatus(bookingToCancel.getRoomId(), 1);
                loadBookingHistory();
            } else {
                JOptionPane.showMessageDialog(view, "Failed to cancel the booking.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private Optional<Booking> findBookingByRoomType(String roomType) {
        if (allBookings == null) {
            return Optional.empty();
        }
        return allBookings.stream()
                .filter(b -> roomType.equals(b.getRoomType()))
                .findFirst();
    }
}