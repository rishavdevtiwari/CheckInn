/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package checkinn.view;

import checkinn.model.MenuItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author risha
 */
public class InvoiceView extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceView
     */
    public InvoiceView() {
        initComponents();
        setTitle("Invoice | CheckInn");
        setLocationRelativeTo(null);
    }

    public void setInvoiceData(String roomName, String clientName, String fullName, Date checkIn, Date checkOut, List<MenuItem> menuItems, double totalPrice) {
    InvoiceRoomName.setText(roomName);
    ClientName.setText(clientName);
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    InvoiceCheckIn.setText(sdf.format(checkIn));
    InvoiceCheckOut.setText(sdf.format(checkOut));
    String menuNames = menuItems.stream()
        .map(MenuItem::getItemName)
        .collect(Collectors.joining(", "));
    InvoiceMenuItems.setText(menuNames);
    InvoiceTotalPrice.setText("Rs. " + String.format("%.2f", totalPrice));
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        InvoicePanel = new javax.swing.JPanel();
        LogoLabel = new javax.swing.JLabel();
        RoomTypeField = new javax.swing.JLabel();
        CheckInDateField = new javax.swing.JLabel();
        InvoiceCheckIn = new javax.swing.JLabel();
        CheckOutDateField = new javax.swing.JLabel();
        InvoiceCheckOut = new javax.swing.JLabel();
        MenuItemsField = new javax.swing.JLabel();
        InvoiceMenuItems = new javax.swing.JLabel();
        InvoiceRoomName = new javax.swing.JLabel();
        TotalPriceField = new javax.swing.JLabel();
        InvoiceTotalPrice = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ClientName = new javax.swing.JLabel();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InvoicePanel.setBackground(new java.awt.Color(255, 255, 204));
        InvoicePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        LogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checkinnlogo.png"))); // NOI18N
        LogoLabel.setText("jLabel2");

        RoomTypeField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        RoomTypeField.setText("Room Type : ");

        CheckInDateField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        CheckInDateField.setText("Check-In Date :");

        InvoiceCheckIn.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        InvoiceCheckIn.setText("XX-XX-XXXX");

        CheckOutDateField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        CheckOutDateField.setText("Check-Out Date :");

        InvoiceCheckOut.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        InvoiceCheckOut.setText("XX-XX-XXXX");

        MenuItemsField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        MenuItemsField.setText("Menu Items :");

        InvoiceMenuItems.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        InvoiceMenuItems.setText("Breakfast Package, Brunch Package, Lunch Package, Dinner Package");

        InvoiceRoomName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        InvoiceRoomName.setText("<RoomName>");

        TotalPriceField.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        TotalPriceField.setText("Total Price : ");

        InvoiceTotalPrice.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        InvoiceTotalPrice.setText("Rs. XXXX.XX");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Invoice.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setText("Client Information :");

        ClientName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        ClientName.setText("Name");

        javax.swing.GroupLayout InvoicePanelLayout = new javax.swing.GroupLayout(InvoicePanel);
        InvoicePanel.setLayout(InvoicePanelLayout);
        InvoicePanelLayout.setHorizontalGroup(
            InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createSequentialGroup()
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(InvoicePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 659, Short.MAX_VALUE))
                    .addGroup(InvoicePanelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(InvoicePanelLayout.createSequentialGroup()
                                .addComponent(CheckInDateField)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(InvoicePanelLayout.createSequentialGroup()
                                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CheckOutDateField)
                                    .addComponent(MenuItemsField)
                                    .addComponent(RoomTypeField)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(InvoiceMenuItems, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1)
                                        .addComponent(InvoiceCheckIn)
                                        .addComponent(InvoiceRoomName)
                                        .addComponent(InvoiceCheckOut)))))))
                .addGap(59, 59, 59))
            .addGroup(InvoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(InvoicePanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(TotalPriceField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(InvoiceTotalPrice)
                .addGap(43, 43, 43))
        );
        InvoicePanelLayout.setVerticalGroup(
            InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InvoicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LogoLabel)
                    .addComponent(jLabel1))
                .addGap(54, 54, 54)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomTypeField)
                    .addComponent(InvoiceRoomName))
                .addGap(74, 74, 74)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ClientName))
                .addGap(61, 61, 61)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckInDateField)
                    .addComponent(InvoiceCheckIn))
                .addGap(80, 80, 80)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckOutDateField)
                    .addComponent(InvoiceCheckOut))
                .addGap(69, 69, 69)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuItemsField)
                    .addComponent(InvoiceMenuItems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(InvoicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalPriceField)
                    .addComponent(InvoiceTotalPrice))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InvoicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InvoicePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(InvoiceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InvoiceView().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CheckInDateField;
    private javax.swing.JLabel CheckOutDateField;
    private javax.swing.JLabel ClientName;
    private javax.swing.JLabel InvoiceCheckIn;
    private javax.swing.JLabel InvoiceCheckOut;
    private javax.swing.JLabel InvoiceMenuItems;
    private javax.swing.JPanel InvoicePanel;
    private javax.swing.JLabel InvoiceRoomName;
    private javax.swing.JLabel InvoiceTotalPrice;
    private javax.swing.JLabel LogoLabel;
    private javax.swing.JLabel MenuItemsField;
    private javax.swing.JLabel RoomTypeField;
    private javax.swing.JLabel TotalPriceField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void getLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}