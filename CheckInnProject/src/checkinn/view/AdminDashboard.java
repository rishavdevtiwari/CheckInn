/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package checkinn.view;


import checkinn.controller.AdminReviewController;
import checkinn.controller.DashboardController;
import checkinn.controller.RegistrationController;
import checkinn.controller.mail.SMTPSMailSender;
import checkinn.dao.UserDao;
import checkinn.model.LoginRequest;
import checkinn.model.ResetPasswordRequest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author LPR HUB
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
         setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
         setLocationRelativeTo(null);
         setTitle("Administrator Dashboard | CheckInn");
        
    }
    
public void setSingleRoomStatus(String status) {
    singleRoomStatusLabel.setText(status);
}

public void setDoubleRoomStatus(String status) {
    doubleRoomStatusLabel.setText(status);
}

public void setDeluxeRoomStatus(String status) {
    deluxeRoomStatusLabel.setText(status);
}

public void setSuiteRoomStatus(String status) {
    suiteStatusLabel.setText(status);
}


// --- 2. METHODS TO LISTEN FOR BUTTON CLICKS ---

// -- Single Room Listeners --
public void addSingleVacantListener(ActionListener listener) {
    SingleSetVacantButton.addActionListener(listener);
}
public void addSingleOccupiedListener(ActionListener listener) {
    SingleSetOccupiedButton.addActionListener(listener);
}
public void addSingleOutOfOrderListener(ActionListener listener) {
    SingleSetOutOfOrderButton.addActionListener(listener);
}

// -- Double Room Listeners --
public void addDoubleVacantListener(ActionListener listener) {
    DoubleSetVacantButton.addActionListener(listener);
}
public void addDoubleOccupiedListener(ActionListener listener) {
    DoubleSetOccupiedButton.addActionListener(listener);
}
public void addDoubleOutOfOrderListener(ActionListener listener) {
    DoubleSetOutOfOrderButton.addActionListener(listener);
}

// -- Deluxe Room Listeners --
public void addDeluxeVacantListener(ActionListener listener) {
    DeluxeSetVacant.addActionListener(listener);
}
public void addDeluxeOccupiedListener(ActionListener listener) {
    DeluxeSetOccupied.addActionListener(listener);
}
public void addDeluxeOutOfOrderListener(ActionListener listener) {
    DeluxeSetOutOfOrderButton.addActionListener(listener);
}

// -- Suite Room Listeners --
public void addSuiteVacantListener(ActionListener listener) {
    ExecutiveSetVacantButton.addActionListener(listener);
}
public void addSuiteOccupiedListener(ActionListener listener) {
    ExecutiveSetOccupiedButton.addActionListener(listener);
}
public void addSuiteOutOfOrderListener(ActionListener listener) {
    ExecutiveSetOutOfOrderButton.addActionListener(listener);
}


// -- Navigation Panel Listeners --
public void addDashboardRefreshListener(ActionListener listener) {
    AdminDashboardButton.addActionListener(listener);
}

public void addBookingHistoryListener(ActionListener listener) {
    BookingHistoryButton.addActionListener(listener);
}


public void addAdminClientButtonListener(java.awt.event.ActionListener listener) {
    AdminClientButton.addActionListener(listener);
}

public void addLogoutListener(ActionListener listener) {
    LogOutButton.addActionListener(listener);
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        CheckinnLogoLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        SingleLabel = new javax.swing.JLabel();
        singleRoomStatusLabel = new javax.swing.JLabel();
        SingleSetVacantButton = new javax.swing.JButton();
        SingleSetOccupiedButton = new javax.swing.JButton();
        SingleSetOutOfOrderButton = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        DoubleLabel = new javax.swing.JLabel();
        doubleRoomStatusLabel = new javax.swing.JLabel();
        DoubleSetVacantButton = new javax.swing.JButton();
        DoubleSetOccupiedButton = new javax.swing.JButton();
        DoubleSetOutOfOrderButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        ExecutiveSuitLabel = new javax.swing.JLabel();
        suiteStatusLabel = new javax.swing.JLabel();
        ExecutiveSetVacantButton = new javax.swing.JButton();
        ExecutiveSetOccupiedButton = new javax.swing.JButton();
        ExecutiveSetOutOfOrderButton = new javax.swing.JButton();
        AccomodationLabel = new javax.swing.JLabel();
        SetAvailabilityLabel = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        AdminDashboardButton = new javax.swing.JButton();
        BookingHistoryButton = new javax.swing.JButton();
        LogOutButton = new javax.swing.JButton();
        AdminPfpLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        AdminClientButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AdminReviewButton = new javax.swing.JButton();
        CurrentAvailabilityLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        DeluxeLabel = new javax.swing.JLabel();
        deluxeRoomStatusLabel = new javax.swing.JLabel();
        DeluxeSetOutOfOrderButton = new javax.swing.JButton();
        DeluxeSetOccupied = new javax.swing.JButton();
        DeluxeSetVacant = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(113, 161, 161));

        CheckinnLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/checkinnlogo.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BoyWithStuff.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(CheckinnLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 814, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckinnLogoLabel)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(168, 214, 204));

        SingleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SingleLabel.setText("Single");

        singleRoomStatusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        singleRoomStatusLabel.setText("Vacant");

        SingleSetVacantButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SingleSetVacantButton.setText("Vacant");

        SingleSetOccupiedButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SingleSetOccupiedButton.setText("Occupied");
        SingleSetOccupiedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SingleSetOccupiedButtonActionPerformed(evt);
            }
        });

        SingleSetOutOfOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SingleSetOutOfOrderButton.setText("Out Of Order");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(SingleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(singleRoomStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(SingleSetVacantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SingleSetOccupiedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SingleSetOutOfOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SingleLabel)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SingleSetOccupiedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SingleSetVacantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SingleSetOutOfOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(singleRoomStatusLabel)))
                .addGap(33, 33, 33))
        );

        jPanel9.setBackground(new java.awt.Color(168, 214, 204));

        DoubleLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoubleLabel.setText("Double");

        doubleRoomStatusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        doubleRoomStatusLabel.setText("Out Of Order");

        DoubleSetVacantButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoubleSetVacantButton.setText("Vacant");

        DoubleSetOccupiedButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoubleSetOccupiedButton.setText("Occupied");

        DoubleSetOutOfOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DoubleSetOutOfOrderButton.setText("Out Of Order");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(DoubleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(doubleRoomStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(DoubleSetVacantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DoubleSetOccupiedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DoubleSetOutOfOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoubleLabel)
                    .addComponent(DoubleSetOccupiedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doubleRoomStatusLabel)
                    .addComponent(DoubleSetVacantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DoubleSetOutOfOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(168, 214, 204));

        ExecutiveSuitLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ExecutiveSuitLabel.setText("Executive Suite");

        suiteStatusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        suiteStatusLabel.setText("Vacant");

        ExecutiveSetVacantButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ExecutiveSetVacantButton.setText("Vacant");

        ExecutiveSetOccupiedButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ExecutiveSetOccupiedButton.setText("Occupied");

        ExecutiveSetOutOfOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ExecutiveSetOutOfOrderButton.setText("Out Of Order");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(ExecutiveSuitLabel)
                .addGap(115, 115, 115)
                .addComponent(suiteStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExecutiveSetVacantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExecutiveSetOccupiedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExecutiveSetOutOfOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExecutiveSetOccupiedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExecutiveSetVacantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExecutiveSetOutOfOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suiteStatusLabel)
                    .addComponent(ExecutiveSuitLabel))
                .addGap(33, 33, 33))
        );

        AccomodationLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AccomodationLabel.setText("Accomodation");

        SetAvailabilityLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SetAvailabilityLabel.setText("Set Availability");

        jPanel7.setBackground(new java.awt.Color(61, 125, 125));

        AdminDashboardButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdminDashboardButton.setText("Admin Dashboard");

        BookingHistoryButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BookingHistoryButton.setText("Booking history");
        BookingHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingHistoryButtonActionPerformed(evt);
            }
        });

        LogOutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LogOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/7124045_logout_icon(1).png"))); // NOI18N
        LogOutButton.setText("Logout");

        AdminPfpLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/IconAdmin.png"))); // NOI18N
        AdminPfpLabel.setText("jLabel11");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dsh.png"))); // NOI18N

        AdminClientButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdminClientButton.setText("Clients");
        AdminClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminClientButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Admin");

        AdminReviewButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdminReviewButton.setText("Client Reviews");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(AdminPfpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AdminDashboardButton)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(AdminReviewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LogOutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BookingHistoryButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(AdminClientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
                .addGap(51, 51, 51))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminPfpLabel)
                    .addComponent(jLabel3))
                .addGap(38, 38, 38)
                .addComponent(AdminDashboardButton)
                .addGap(18, 18, 18)
                .addComponent(BookingHistoryButton)
                .addGap(18, 18, 18)
                .addComponent(AdminClientButton)
                .addGap(18, 18, 18)
                .addComponent(AdminReviewButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(LogOutButton)
                .addGap(47, 47, 47))
        );

        CurrentAvailabilityLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CurrentAvailabilityLabel.setText("Current Availability");

        jPanel5.setBackground(new java.awt.Color(168, 214, 204));

        DeluxeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeluxeLabel.setText("Deluxe");

        deluxeRoomStatusLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deluxeRoomStatusLabel.setText("Occupied");

        DeluxeSetOutOfOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeluxeSetOutOfOrderButton.setText("Out Of Order");

        DeluxeSetOccupied.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeluxeSetOccupied.setText("Occupied");

        DeluxeSetVacant.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeluxeSetVacant.setText("Vacant");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(DeluxeLabel)
                .addGap(151, 151, 151)
                .addComponent(deluxeRoomStatusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(DeluxeSetVacant, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DeluxeSetOccupied, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(DeluxeSetOutOfOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeluxeSetOccupied, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deluxeRoomStatusLabel)
                    .addComponent(DeluxeLabel)
                    .addComponent(DeluxeSetVacant, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeluxeSetOutOfOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 56, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(AccomodationLabel)
                                .addGap(114, 114, 114)
                                .addComponent(CurrentAvailabilityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SetAvailabilityLabel)
                                .addGap(253, 253, 253))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SetAvailabilityLabel)
                            .addComponent(CurrentAvailabilityLabel)
                            .addComponent(AccomodationLabel))
                        .addGap(46, 46, 46)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookingHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookingHistoryButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookingHistoryButtonActionPerformed

    private void AdminClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminClientButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdminClientButtonActionPerformed

    private void SingleSetOccupiedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SingleSetOccupiedButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SingleSetOccupiedButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdminDashboard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AccomodationLabel;
    private javax.swing.JButton AdminClientButton;
    private javax.swing.JButton AdminDashboardButton;
    private javax.swing.JLabel AdminPfpLabel;
    private javax.swing.JButton AdminReviewButton;
    private javax.swing.JButton BookingHistoryButton;
    private javax.swing.JLabel CheckinnLogoLabel;
    private javax.swing.JLabel CurrentAvailabilityLabel;
    private javax.swing.JLabel DeluxeLabel;
    private javax.swing.JButton DeluxeSetOccupied;
    private javax.swing.JButton DeluxeSetOutOfOrderButton;
    private javax.swing.JButton DeluxeSetVacant;
    private javax.swing.JLabel DoubleLabel;
    private javax.swing.JButton DoubleSetOccupiedButton;
    private javax.swing.JButton DoubleSetOutOfOrderButton;
    private javax.swing.JButton DoubleSetVacantButton;
    private javax.swing.JButton ExecutiveSetOccupiedButton;
    private javax.swing.JButton ExecutiveSetOutOfOrderButton;
    private javax.swing.JButton ExecutiveSetVacantButton;
    private javax.swing.JLabel ExecutiveSuitLabel;
    private javax.swing.JButton LogOutButton;
    private javax.swing.JLabel SetAvailabilityLabel;
    private javax.swing.JLabel SingleLabel;
    private javax.swing.JButton SingleSetOccupiedButton;
    private javax.swing.JButton SingleSetOutOfOrderButton;
    private javax.swing.JButton SingleSetVacantButton;
    private javax.swing.JLabel deluxeRoomStatusLabel;
    private javax.swing.JLabel doubleRoomStatusLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel singleRoomStatusLabel;
    private javax.swing.JLabel suiteStatusLabel;
    // End of variables declaration//GEN-END:variables

//private void openAdminReviewView(){
//    AdminReviewView adminReviewView = new AdminReviewView();
//    AdminReviewController adminReviewController = new AdminReviewController(adminReviewView);
//    adminDashboardController.showView();
//}

public javax.swing.JButton getAdminReviewButton(){
    return AdminReviewButton;
}
}
