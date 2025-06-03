<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

=======
>>>>>>> main
package checkinn.controller;

import checkinn.view.LoginView;
import checkinn.view.RegistrationView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

<<<<<<< HEAD
public class RedirectToRegcontroller {
    
    private final LoginView loginView;
    private RegistrationView registrationView;
    
    public RedirectToRegcontroller(LoginView loginView) {
=======
public class RedirectToRegController {
    private final LoginView loginView;
    
    public RedirectToRegController(LoginView loginView) {
>>>>>>> main
        this.loginView = loginView;
        initController();
    }
    
    private void initController() {
<<<<<<< HEAD
        // Add mouse listener to the redirect label
=======
>>>>>>> main
        loginView.getRedirectToReg().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                redirectToRegistration();
            }
        });
    }
    
    private void redirectToRegistration() {
        // Hide the login view
        loginView.setVisible(false);
        
<<<<<<< HEAD
        // Create and show the registration view
        if (registrationView == null) {
            registrationView = new RegistrationView();
            // You might want to pass the loginView reference to registrationView
            // so you can return to it later
            registrationView.setLoginViewReference(loginView);
            registrationView.setLocationRelativeTo(null);
        }
        registrationView.setVisible(true);
    }
}
=======
        // Create and show registration view
        RegistrationView registrationView = new RegistrationView();
        registrationView.setLocationRelativeTo(null);
        
        // Set up the back navigation
        new RedirectToLoginController(registrationView, loginView);
        
        registrationView.setVisible(true);
    }
}
>>>>>>> main
