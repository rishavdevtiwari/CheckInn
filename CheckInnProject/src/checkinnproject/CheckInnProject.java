package checkinnproject;

import checkinn.controller.LoginController;
import checkinn.dao.UserDao;
import checkinn.view.LoginView;
import com.formdev.flatlaf.themes.FlatMacLightLaf; 

/**
 *
 * @author ACER NITRO
 */
public class CheckInnProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            FlatMacLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        
        LoginView loginView = new LoginView();
        UserDao userDao = new UserDao();
        LoginController loginController = new LoginController(loginView, userDao);
        
        loginController.open(); 
        loginView.setLocationRelativeTo(null);
    }
}