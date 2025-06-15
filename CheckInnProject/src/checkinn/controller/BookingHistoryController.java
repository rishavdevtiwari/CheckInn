public class BookingHistoryController {
    private final BookingHistoryView view;
    private final UserData user;
    private final DashboardController dashboardController;

    public BookingHistoryController(BookingHistoryView view, UserData user, DashboardController dashboardController) {
        this.view = view;
        this.user = user;
        this.dashboardController = dashboardController;
        initializeListeners();
    }

    public void open() {
        //loadBookingHistory();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void initializeListeners() {
        view.addBackToDashboardListener(e -> {
            view.dispose();
            dashboardController.open();
        });
    }
}