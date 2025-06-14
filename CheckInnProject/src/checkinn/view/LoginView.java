/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package checkinn.view;

//import checkinn.controller.LoginController;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
/**
 *
 * @author risha
 */
public class LoginView extends javax.swing.JFrame {

    /**
     * Creates new form LoginView
     */
    public LoginView() {
        initComponents();
        makeRedirectLabelClickable();
        makeForgotPasswordLabelClickable();
        setTitle("Login Form | CheckInn");
        setLocationRelativeTo(null);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LoginFormPanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();
        SubTitleLabel = new javax.swing.JLabel();
        LoginUsername = new javax.swing.JLabel();
        LoginUsernameInput = new javax.swing.JTextField();
        LoginPassword = new javax.swing.JLabel();
        LoginPasswordInput = new javax.swing.JPasswordField();
        ForgotPassword = new javax.swing.JLabel();
        Qlabel = new javax.swing.JLabel();
        RedirectToReg = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BoyOnTableImg = new javax.swing.JLabel();
        LogoImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LoginFormPanel.setBackground(new java.awt.Color(167, 224, 212));
        LoginFormPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        TitleLabel.setText("Hello Visitor!");

        SubTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SubTitleLabel.setText("CheckInn Today");

        LoginUsername.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoginUsername.setText("Username");

        LoginUsernameInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoginUsernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginUsernameInputActionPerformed(evt);
            }
        });

        LoginPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LoginPassword.setText("Password");

        LoginPasswordInput.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LoginPasswordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginPasswordInputActionPerformed(evt);
            }
        });

        ForgotPassword.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ForgotPassword.setText("Forgot Password?");

        Qlabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Qlabel.setText("New to CheckInn?");

        RedirectToReg.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        RedirectToReg.setText("Sign Up");

        LoginButton.setBackground(new java.awt.Color(0, 102, 0));
        LoginButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        LoginButton.setText("Log In");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginFormPanelLayout = new javax.swing.GroupLayout(LoginFormPanel);
        LoginFormPanel.setLayout(LoginFormPanelLayout);
        LoginFormPanelLayout.setHorizontalGroup(
            LoginFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginFormPanelLayout.createSequentialGroup()
                .addGroup(LoginFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginFormPanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(Qlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RedirectToReg, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LoginFormPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(LoginFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LoginUsername)
                            .addGroup(LoginFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LoginPassword)
                                .addComponent(LoginButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                .addComponent(LoginPasswordInput, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LoginUsernameInput, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(SubTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TitleLabel))))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginFormPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ForgotPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        LoginFormPanelLayout.setVerticalGroup(
            LoginFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginFormPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(TitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SubTitleLabel)
                .addGap(50, 50, 50)
                .addComponent(LoginUsername)
                .addGap(31, 31, 31)
                .addComponent(LoginUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(LoginPassword)
                .addGap(28, 28, 28)
                .addComponent(LoginPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(ForgotPassword)
                .addGap(45, 45, 45)
                .addComponent(LoginButton)
                .addGap(18, 18, 18)
                .addGroup(LoginFormPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Qlabel)
                    .addComponent(RedirectToReg))
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(LoginFormPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LoginFormPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Bodoni MT Condensed", 1, 24)); // NOI18N

        BoyOnTableImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boyontable.png"))); // NOI18N
        BoyOnTableImg.setText("jLabel2");

        LogoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smallcheckinnlogo.png"))); // NOI18N
        LogoImg.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BoyOnTableImg, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 452, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LogoImg, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(471, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogoImg)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BoyOnTableImg, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(74, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(74, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoginUsernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginUsernameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginUsernameInputActionPerformed

    private void LoginPasswordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginPasswordInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginPasswordInputActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BoyOnTableImg;
    private javax.swing.JLabel ForgotPassword;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPanel LoginFormPanel;
    private javax.swing.JLabel LoginPassword;
    private javax.swing.JPasswordField LoginPasswordInput;
    private javax.swing.JLabel LoginUsername;
    private javax.swing.JTextField LoginUsernameInput;
    private javax.swing.JLabel LogoImg;
    private javax.swing.JLabel Qlabel;
    private javax.swing.JLabel RedirectToReg;
    private javax.swing.JLabel SubTitleLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public JButton getLoginButton() {
        return LoginButton;
    }

    public JLabel getForgotPasswordLabel() {
        return ForgotPassword;
    }

    public JLabel getRedirectToRegLabel() {
        return RedirectToReg;
    }

    public String getEmail() {
        return LoginUsernameInput.getText().trim();
    }

    public String getPassword() {
        return new String(LoginPasswordInput.getPassword()).trim();
    }

    public String promptForEmail() {
        return JOptionPane.showInputDialog(this, "Enter your registered email:", "Forgot Password", JOptionPane.QUESTION_MESSAGE);
    }

    public String promptForOTP() {
        return JOptionPane.showInputDialog(this, "Enter the OTP sent to your email:", "OTP Verification", JOptionPane.QUESTION_MESSAGE);
    }

    public String promptForNewPassword() {
        return JOptionPane.showInputDialog(this, "Enter your new password:", "Reset Password", JOptionPane.QUESTION_MESSAGE);
    }

public void addLoginListener(ActionListener listener) {
    LoginButton.addActionListener(listener);
}
public void showError(String message) { JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE); }
public void showMessage(String message) { JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE); }

    public void addForgotPasswordListener(MouseListener listener) {
        ForgotPassword.addMouseListener(listener);
    }

    public void addRegisterNavigationListener(MouseListener listener) {
        RedirectToReg.addMouseListener(listener);
    }

    public javax.swing.JLabel getRedirectToReg(){
    return RedirectToReg;
}
    private void makeRedirectLabelClickable(){
    RedirectToReg.setForeground(new java.awt.Color(0,51,153));
    RedirectToReg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
}
    
public javax.swing.JLabel getForgotPassword(){
    return ForgotPassword;
}
private void makeForgotPasswordLabelClickable(){
ForgotPassword.setForeground(new java.awt.Color(0,51,153));
ForgotPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
}
}