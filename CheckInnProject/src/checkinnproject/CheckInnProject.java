/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package checkinnproject;


import checkinn.controller.LoginController;
import checkinn.dao.UserDao;
import checkinn.view.LoginView;
/**
 *s
 * @author ACER NITRO
 */
public class CheckInnProject {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) {
LoginView loginView = new LoginView();
UserDao userDao = new UserDao();
LoginController loginController = new LoginController(loginView, userDao);
loginController.open();
loginView.setLocationRelativeTo(null);      
        
    }
    
}
