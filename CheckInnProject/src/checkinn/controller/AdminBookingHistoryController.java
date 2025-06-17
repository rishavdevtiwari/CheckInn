package checkinn.controller;

import checkinn.dao.BookingDao;
import checkinn.model.Booking;
import checkinn.view.AdminBookingHistory;
import checkinn.view.AdminDashboard;
import java.util.List;

public class AdminBookingHistoryController {

    private final AdminBookingHistory view;
    private final AdminDashboardController dashboardController;
    private final BookingDao bookingDao;

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
        // This listener will take the admin back to the dashboard
        view.getAdminDashboardButton().addActionListener(e -> {
            view.dispose();
            dashboardController.showView();
        });
    }

    private void loadBookingHistory() {
        // You will need to create this method in BookingDao
        List<Booking> allBookings = bookingDao.getAllBookings(); 
        
        // Logic to populate your view's fields and tables
        // For example:
        // view.displayBookings(allBookings);
        System.out.println("Booking data loaded for admin.");
    }
}