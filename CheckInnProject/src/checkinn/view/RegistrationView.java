
package checkinn.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
//import javax.swing.*;
/**
 *
 * @author rishav
 */
public class RegistrationView extends javax.swing.JFrame {

    public RegistrationView() {
        initComponents();
        makeRedirectLabelClickable();
        setTitle("Registration Form | CheckInn");
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
        TitleLabel = new javax.swing.JLabel();
        SubtitleLabel = new javax.swing.JLabel();
        RegFirstName = new javax.swing.JLabel();
        RegEmail = new javax.swing.JLabel();
        RegEmailInput = new javax.swing.JTextField();
        RegLNameInput = new javax.swing.JTextField();
        RegLastName = new javax.swing.JLabel();
        RegFNameInput = new javax.swing.JTextField();
        RegNewpass = new javax.swing.JLabel();
        RegNewPassInput = new javax.swing.JPasswordField();
        RegConfirmNewPassInput = new javax.swing.JPasswordField();
        RegConfirmNewpass = new javax.swing.JLabel();
        RegPh = new javax.swing.JLabel();
        RegPhInput = new javax.swing.JTextField();
        RegButton = new javax.swing.JButton();
        AlrHavAccQ = new javax.swing.JLabel();
        RedirectToLogin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        TitleLabel.setText("Create a New Account");

        SubtitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SubtitleLabel.setText("CheckInn Today");

        RegFirstName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RegFirstName.setText("First Name");

        RegEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RegEmail.setText("Email Address | Username");

        RegEmailInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RegEmailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegEmailInputActionPerformed(evt);
            }
        });

        RegLNameInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        RegLastName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RegLastName.setText("Last Name");

        RegFNameInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        RegNewpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RegNewpass.setText("New Password");

        RegNewPassInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        RegConfirmNewPassInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RegConfirmNewPassInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegConfirmNewPassInputActionPerformed(evt);
            }
        });

        RegConfirmNewpass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RegConfirmNewpass.setText("Confirm New Password");

        RegPh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        RegPh.setText("Phone Number");

        RegPhInput.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        RegButton.setBackground(new java.awt.Color(0, 153, 0));
        RegButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        RegButton.setText("Register");
        RegButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegButtonActionPerformed(evt);
            }
        });

        AlrHavAccQ.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        AlrHavAccQ.setText("Already have an account?");

        RedirectToLogin.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        RedirectToLogin.setForeground(new java.awt.Color(0, 51, 153));
        RedirectToLogin.setText("Log In");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RegButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(RegConfirmNewpass)
                                        .addComponent(RegConfirmNewPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RegLNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(RegLastName))
                                        .addGap(58, 58, 58)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(RegNewpass, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(RegNewPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(71, 71, 71))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(RegFirstName)
                                    .addGap(331, 331, 331)
                                    .addComponent(RegEmail))
                                .addComponent(RegPh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(RegPhInput, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RegFNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(RegEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(TitleLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(SubtitleLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(AlrHavAccQ)
                .addGap(18, 18, 18)
                .addComponent(RedirectToLogin)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(TitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SubtitleLabel)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegEmail)
                    .addComponent(RegFirstName))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegFNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegNewpass)
                    .addComponent(RegLastName))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegLNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegNewPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegPh)
                    .addComponent(RegConfirmNewpass))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegConfirmNewPassInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegPhInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(RegButton)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlrHavAccQ)
                    .addComponent(RedirectToLogin))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smallcheckinnlogo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boyontable.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegEmailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegEmailInputActionPerformed

    }//GEN-LAST:event_RegEmailInputActionPerformed

    private void RegButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegButtonActionPerformed
    
    }//GEN-LAST:event_RegButtonActionPerformed

    private void RegConfirmNewPassInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegConfirmNewPassInputActionPerformed
   
    }//GEN-LAST:event_RegConfirmNewPassInputActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegistrationView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlrHavAccQ;
    private javax.swing.JLabel RedirectToLogin;
    private javax.swing.JButton RegButton;
    private javax.swing.JPasswordField RegConfirmNewPassInput;
    private javax.swing.JLabel RegConfirmNewpass;
    private javax.swing.JLabel RegEmail;
    private javax.swing.JTextField RegEmailInput;
    private javax.swing.JTextField RegFNameInput;
    private javax.swing.JLabel RegFirstName;
    private javax.swing.JTextField RegLNameInput;
    private javax.swing.JLabel RegLastName;
    private javax.swing.JPasswordField RegNewPassInput;
    private javax.swing.JLabel RegNewpass;
    private javax.swing.JLabel RegPh;
    private javax.swing.JTextField RegPhInput;
    private javax.swing.JLabel SubtitleLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


    public String getFirstName() {
        return RegFNameInput.getText().trim();
    }

    public String getLastName() {
        return RegLNameInput.getText().trim();
    }

    public String getEmail() {
        return RegEmailInput.getText().trim();
    }

    public String getPassword() {
        return new String(RegNewPassInput.getPassword()).trim();
    }

    public String getConfirmPassword() {
        return new String(RegConfirmNewPassInput.getPassword()).trim();
    }

    public String getPhoneNumber() {
        return RegPhInput.getText().trim();
    }

    public void showError(String message) { JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE); }
    public void showMessage(String message) { JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE); }

    public void addRegisterListener(ActionListener listener) {
        RegButton.addActionListener(listener);
    }

    public void addLoginNavigationListener(MouseListener listener) {
        RedirectToLogin.addMouseListener(listener);
    }
    
  public javax.swing.JLabel getRedirectToLogin() {
      return RedirectToLogin;
  }
     private void makeRedirectLabelClickable(){
    RedirectToLogin.setForeground(new java.awt.Color(0,51,153));
    RedirectToLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
}     
}