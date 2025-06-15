package checkinn.controller;

import checkinn.dao.UserDao;
import checkinn.model.UserData;
import checkinn.view.AdminClientView;
import java.util.ArrayList;
import java.util.List;

public class AdminClientController {
    private final AdminClientView view;
    private final AdminDashboardController dashboardController;

    public AdminClientController(AdminClientView view, AdminDashboardController dashboardController) {
        this.view = view;
        this.dashboardController = dashboardController;
        initializeListeners();
    }

    public void open() {
        loadAllUsers();
        view.setLocationRelativeTo(null);
        view.setVisible(true);
    }

    private void initializeListeners() {
        view.addBackToDashboardListener(e -> {
            view.dispose();
            dashboardController.showView();
        });
    }

    private void loadAllUsers() {
        UserDao userDao = new UserDao();
        List<UserData> users = userDao.getAllUsers();
        StringBuilder sb = new StringBuilder();
        for (UserData user : users) {
            sb.append("ID: ").append(user.getUserId())
              .append(" | Name: ").append(user.getFirstName()).append(" ").append(user.getLastName())
              .append(" | Email: ").append(user.getEmail())
              .append(" | Phone: ").append(user.getPhoneNumber())
              .append("\n");
        }
        view.setClientTextArea(sb.toString());
    }

}