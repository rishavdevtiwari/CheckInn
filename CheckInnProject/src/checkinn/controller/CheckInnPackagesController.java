package checkinn.controller;

import checkinn.view.CheckInnPackages;

public class CheckInnPackagesController {
    private final CheckInnPackages checkInnPackagesView;

    public CheckInnPackagesController(CheckInnPackages checkInnPackagesView) {
        this.checkInnPackagesView = checkInnPackagesView;
    }

    public void open() {
        checkInnPackagesView.setVisible(true);
        checkInnPackagesView.setLocationRelativeTo(null);
    }

    public void close() {
        checkInnPackagesView.dispose();
    }
}