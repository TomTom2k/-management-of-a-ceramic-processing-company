/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ptud.GUI;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import ptud.Connection.ConnectDB;
import ptud.ults.ImageCus;

/**
 *
 * @author TomTom
 */
public class Layout extends javax.swing.JFrame {
//    fun

    private void activeMenuItem(JButton button) {
        Color color = new Color(238, 250, 235);
        Color colorActive = new Color(198, 222, 192);
        btnQLTK.setBackground(color);
        btnQLNS.setBackground(color);
        btnQLHD.setBackground(color);
        btnQLSP.setBackground(color);
        btnTinhLuong.setBackground(color);
        btnChamCong.setBackground(color);

        button.setBackground(colorActive);
    }

    public void showLayout(String name) {
        cardLayout.show(body, name);
    }
    public void showChiTietNV(String maNV) {
    	showLayout("xemChiTietNS");
    	gD_XemChiTietNS.updateData(maNV, "nv");
    }
    public void showChiTietCN(String maCN) {
    	showLayout("xemChiTietNS");
    	gD_XemChiTietNS.updateData(maCN, "cn");
    }
    

    /**
     * Creates new form Layout
     */
    private CardLayout cardLayout;
    public static Layout instance;

    public Layout() {
        initComponents();
        instance = this;
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        avatarImage.setIcon(ImageCus.getScaledImageIcon("/assets/images/avataruser1.jpg", 160, 160));
        cardLayout = (CardLayout) (body.getLayout());
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
        btnQLTK = new javax.swing.JButton();
        btnQLNS = new javax.swing.JButton();
        btnQLHD = new javax.swing.JButton();
        btnQLSP = new javax.swing.JButton();
        btnTinhLuong = new javax.swing.JButton();
        btnChamCong = new javax.swing.JButton();
        logout = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        body = new javax.swing.JPanel();
        gD_Main = new ptud.GUI.GD_Main();
        gD_QLTK = new ptud.GUI.GD_QLTK();
        gD_QLNS = new ptud.GUI.GD_QLNS();
        gD_QLHD = new ptud.GUI.GD_QLHD();
        gD_QLSP = new ptud.GUI.GD_QLSP();
        gD_TinhLuong = new ptud.GUI.GD_TinhLuong();
        gD_ChamCong = new ptud.GUI.GD_ChamCong();
        gD_ThemNV1 = new ptud.GUI.GD_ThemNS();
        gD_DanhGia2 = new ptud.GUI.GD_DanhGia();
        gD_XemChiTietNS = new ptud.GUI.GD_XemChiTietNS();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                .addContainerGap(612, Short.MAX_VALUE))
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

        btnQLTK.setBackground(new java.awt.Color(238, 250, 235));
        btnQLTK.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQLTK.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnQLTK.setBorderPainted(false);
        btnQLTK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQLTK.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQLTK.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQLTK.setIconTextGap(0);
        btnQLTK.setLabel("Danh sách tài khoản");
        btnQLTK.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnQLTK.setPreferredSize(new java.awt.Dimension(200, 40));
        btnQLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLTKActionPerformed(evt);
            }
        });
        menu.add(btnQLTK);
        btnQLTK.getAccessibleContext().setAccessibleDescription("");

        btnQLNS.setBackground(new java.awt.Color(238, 250, 235));
        btnQLNS.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQLNS.setText("Danh sách nhân sự");
        btnQLNS.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnQLNS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQLNS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQLNS.setIconTextGap(0);
        btnQLNS.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnQLNS.setPreferredSize(new java.awt.Dimension(200, 40));
        btnQLNS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNSActionPerformed(evt);
            }
        });
        menu.add(btnQLNS);

        btnQLHD.setBackground(new java.awt.Color(238, 250, 235));
        btnQLHD.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQLHD.setText("Danh sách hợp đồng");
        btnQLHD.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnQLHD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQLHD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQLHD.setIconTextGap(0);
        btnQLHD.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnQLHD.setPreferredSize(new java.awt.Dimension(200, 40));
        btnQLHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLHDActionPerformed(evt);
            }
        });
        menu.add(btnQLHD);

        btnQLSP.setBackground(new java.awt.Color(238, 250, 235));
        btnQLSP.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQLSP.setText("Danh sách sản phẩm");
        btnQLSP.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnQLSP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnQLSP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQLSP.setIconTextGap(0);
        btnQLSP.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnQLSP.setPreferredSize(new java.awt.Dimension(200, 40));
        btnQLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLSPActionPerformed(evt);
            }
        });
        menu.add(btnQLSP);

        btnTinhLuong.setBackground(new java.awt.Color(238, 250, 235));
        btnTinhLuong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTinhLuong.setText("Tính lương");
        btnTinhLuong.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnTinhLuong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnTinhLuong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTinhLuong.setIconTextGap(0);
        btnTinhLuong.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnTinhLuong.setPreferredSize(new java.awt.Dimension(200, 40));
        btnTinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhLuongActionPerformed(evt);
            }
        });
        menu.add(btnTinhLuong);

        btnChamCong.setBackground(new java.awt.Color(238, 250, 235));
        btnChamCong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnChamCong.setText("Chấm công");
        btnChamCong.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnChamCong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnChamCong.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChamCong.setIconTextGap(0);
        btnChamCong.setMargin(new java.awt.Insets(2, 20, 3, 20));
        btnChamCong.setPreferredSize(new java.awt.Dimension(200, 40));
        btnChamCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChamCongActionPerformed(evt);
            }
        });
        menu.add(btnChamCong);

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        body.setLayout(new java.awt.CardLayout());
        body.add(gD_Main, "main");
        body.add(gD_QLTK, "tabTK");
        body.add(gD_QLNS, "tabNS");
        body.add(gD_QLHD, "tabHD");
        body.add(gD_QLSP, "tabSP");
        body.add(gD_TinhLuong, "tabTL");
        body.add(gD_ChamCong, "tabCC");
        body.add(gD_ThemNV1, "themNS");
        body.add(gD_DanhGia2, "danhGiaNS");
        body.add(gD_XemChiTietNS, "xemChiTietNS");

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLTKActionPerformed
        cardLayout.show(body, "tabTK");
        activeMenuItem(btnQLTK);
    }//GEN-LAST:event_btnQLTKActionPerformed

    private void btnQLNSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNSActionPerformed
        cardLayout.show(body, "tabNS");
        activeMenuItem(btnQLNS);
    }//GEN-LAST:event_btnQLNSActionPerformed

    private void btnQLHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLHDActionPerformed
        cardLayout.show(body, "tabHD");
        activeMenuItem(btnQLHD);
    }//GEN-LAST:event_btnQLHDActionPerformed

    private void btnQLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSPActionPerformed
        cardLayout.show(body, "tabSP");
        activeMenuItem(btnQLSP);
    }//GEN-LAST:event_btnQLSPActionPerformed

    private void btnTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhLuongActionPerformed
        cardLayout.show(body, "tabTL");
        activeMenuItem(btnTinhLuong);
    }//GEN-LAST:event_btnTinhLuongActionPerformed

    private void btnChamCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChamCongActionPerformed
        cardLayout.show(body, "tabCC");
        activeMenuItem(btnChamCong);
    }//GEN-LAST:event_btnChamCongActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(Layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Layout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Layout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Aside;
    private javax.swing.JPanel avatar;
    private javax.swing.JLabel avatarImage;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnChamCong;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnQLHD;
    private javax.swing.JButton btnQLNS;
    private javax.swing.JButton btnQLSP;
    private javax.swing.JButton btnQLTK;
    private javax.swing.JButton btnTinhLuong;
    private ptud.GUI.GD_ChamCong gD_ChamCong;
    private ptud.GUI.GD_DanhGia gD_DanhGia2;
    private ptud.GUI.GD_Main gD_Main;
    private ptud.GUI.GD_QLHD gD_QLHD;
    private ptud.GUI.GD_QLNS gD_QLNS;
    private ptud.GUI.GD_QLSP gD_QLSP;
    private ptud.GUI.GD_QLTK gD_QLTK;
    private ptud.GUI.GD_ThemNS gD_ThemNV1;
    private ptud.GUI.GD_XemChiTietNS gD_XemChiTietNS;
    private ptud.GUI.GD_TinhLuong gD_TinhLuong;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}
