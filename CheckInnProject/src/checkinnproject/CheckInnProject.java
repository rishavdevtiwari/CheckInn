package checkinnproject;

import checkinn.controller.LoginController;
import checkinn.dao.UserDao;
import checkinn.view.LoginView;
import com.formdev.flatlaf.themes.FlatMacLightLaf; // 1. Add this import

/**
 *
 * @author ACER NITRO
 */
public class CheckInnProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // 2. Add this block to set up the Look and Feel at the very start
        try {
            FlatMacLightLaf.setup();
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        
        // 3. The rest of your code remains the same
        LoginView loginView = new LoginView();
        UserDao userDao = new UserDao();
        LoginController loginController = new LoginController(loginView, userDao);
        
        // Note: It's better to set location and visibility inside the controller
        // but for now, we leave your logic as is.
        loginController.open(); 
        loginView.setLocationRelativeTo(null);
    }
}