package checkinn.controller;

import checkinn.view.mail.AdminDashboard;
import java.awt.event.ActionEvent;

public class AdminDashboardController {
    private final AdminDashboard view;

    public AdminDashboardController(AdminDashboard view) {
        this.view = view;
        initializeListeners();
    }