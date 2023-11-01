/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ptud.GUI;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import ptud.ults.ImageCus;

/**
 *
 * @author TranLoc
 */
public class Layout1 extends javax.swing.JFrame {
//    fun
    private void activeMenuItem(JButton button) {
        Color color = new Color(238, 250, 235);
        Color colorActive = new Color(198,222,192);
        btnDanhSachTaiKhoan.setBackground(color);
        btnTaoTaiKhoan.setBackground(color);
        btnCapNhatTaiKhoan.setBackground(color);    
        button.setBackground(colorActive);
    }

    /**
     * Creates new form Layout
     */
    CardLayout cardLayout;
    public Layout1() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        avatarImage.setIcon(ImageCus.getScaledImageIcon("/assets/images/avataruser1.jpg", 160, 160));
//        cardLayout = (CardLayout)(body.getLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Aside = new javax.swing.JPanel();
        avatar = new javax.swing.JPanel();
        avatarImage = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        btnTaoTaiKhoan = new javax.swing.JButton();
        btnCapNhatTaiKhoan = new javax.swing.JButton();
        btnDanhSachTaiKhoan = new javax.swing.JButton();
        logout = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1572, 995));
        setMinimumSize(new java.awt.Dimension(1572, 995));
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(0, 100));

        Aside.setBackground(new java.awt.Color(238, 250, 235));
        Aside.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        Aside.setPreferredSize(new java.awt.Dimension(200, 300));
        Aside.setLayout(new java.awt.BorderLayout(0, 20));

        avatar.setBackground(new java.awt.Color(238, 250, 235));
        avatar.setPreferredSize(new java.awt.Dimension(200, 200));

        avatarImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/avataruser1.jpg"))); // NOI18N
        avatarImage.setPreferredSize(new java.awt.Dimension(160, 160));

        javax.swing.GroupLayout avatarLayout = new javax.swing.GroupLayout(avatar);
        avatar.setLayout(avatarLayout);
        avatarLayout.setHorizontalGroup(
            avatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avatarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(avatarImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        avatarLayout.setVerticalGroup(
            avatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avatarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(avatarImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        Aside.add(avatar, java.awt.BorderLayout.NORTH);

        menu.setBackground(new java.awt.Color(238, 250, 235));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        menu.setLayout(flowLayout1);

        btnTaoTaiKhoan.setBackground(new java.awt.Color(238, 250, 235));
        btnTaoTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTaoTaiKhoan.setText(" Tạo tài khoản");
        btnTaoTaiKhoan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTaoTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTaoTaiKhoan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTaoTaiKhoan.setIconTextGap(0);
        btnTaoTaiKhoan.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnTaoTaiKhoan.setPreferredSize(new java.awt.Dimension(200, 40));
        btnTaoTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoTaiKhoanActionPerformed(evt);
            }
        });
        menu.add(btnTaoTaiKhoan);

        btnCapNhatTaiKhoan.setBackground(new java.awt.Color(238, 250, 235));
        btnCapNhatTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnCapNhatTaiKhoan.setText(" Cập nhật tài khoản");
        btnCapNhatTaiKhoan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnCapNhatTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCapNhatTaiKhoan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCapNhatTaiKhoan.setIconTextGap(0);
        btnCapNhatTaiKhoan.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnCapNhatTaiKhoan.setPreferredSize(new java.awt.Dimension(200, 40));
        btnCapNhatTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatTaiKhoanActionPerformed(evt);
            }
        });
        menu.add(btnCapNhatTaiKhoan);

        btnDanhSachTaiKhoan.setBackground(new java.awt.Color(238, 250, 235));
        btnDanhSachTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDanhSachTaiKhoan.setText(" Danh sách tài khoản");
        btnDanhSachTaiKhoan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDanhSachTaiKhoan.setBorderPainted(false);
        btnDanhSachTaiKhoan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDanhSachTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDanhSachTaiKhoan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDanhSachTaiKhoan.setIconTextGap(0);
        btnDanhSachTaiKhoan.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnDanhSachTaiKhoan.setPreferredSize(new java.awt.Dimension(200, 40));
        btnDanhSachTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhSachTaiKhoanActionPerformed(evt);
            }
        });
        menu.add(btnDanhSachTaiKhoan);
        btnDanhSachTaiKhoan.getAccessibleContext().setAccessibleDescription("");

        Aside.add(menu, java.awt.BorderLayout.CENTER);

        logout.setBackground(new java.awt.Color(238, 250, 235));
        logout.setPreferredSize(new java.awt.Dimension(200, 100));

        jPanel1.setBackground(new java.awt.Color(198, 222, 192));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 5));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        btnLogout.setBackground(new java.awt.Color(198, 222, 192));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.setBorder(null);
        btnLogout.setPreferredSize(new java.awt.Dimension(70, 40));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        Aside.add(logout, java.awt.BorderLayout.SOUTH);

        getContentPane().add(Aside, java.awt.BorderLayout.WEST);

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addContainerGap(1204, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel1)
                .addContainerGap(383, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel3);

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1138, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel2)
                .addContainerGap(438, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel4);

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel3)
                .addContainerGap(1063, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(282, 282, 282)
                .addComponent(jLabel3)
                .addContainerGap(385, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("", jPanel5);

        jPanel7.setBackground(new java.awt.Color(225, 240, 221));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setText("CÔNG TY GIA CÔNG GỐM SỨ TỨ VƯƠNG");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnCapNhatTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatTaiKhoanActionPerformed
        jTabbedPane1.setSelectedIndex(1);
        activeMenuItem(btnCapNhatTaiKhoan);
    }//GEN-LAST:event_btnCapNhatTaiKhoanActionPerformed

    private void btnTaoTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoTaiKhoanActionPerformed
        jTabbedPane1.setSelectedIndex(0);
        activeMenuItem(btnTaoTaiKhoan);
    }//GEN-LAST:event_btnTaoTaiKhoanActionPerformed

    private void btnDanhSachTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhSachTaiKhoanActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        System.err.println(jTabbedPane1.getSelectedIndex());
        activeMenuItem(btnDanhSachTaiKhoan);
    }//GEN-LAST:event_btnDanhSachTaiKhoanActionPerformed

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
            java.util.logging.Logger.getLogger(Layout1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Layout1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Layout1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Layout1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Layout1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Aside;
    private javax.swing.JPanel avatar;
    private javax.swing.JLabel avatarImage;
    private javax.swing.JButton btnCapNhatTaiKhoan;
    private javax.swing.JButton btnDanhSachTaiKhoan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTaoTaiKhoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}