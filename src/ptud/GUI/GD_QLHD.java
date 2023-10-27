/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ptud.GUI;

import java.awt.CardLayout;
import javax.swing.JFrame;
import ptud.GUI.GUI_HD.GD_ChiTietHopDong;
import ptud.ults.ImageCus;

/**
 *
 * @author TomTom
 */
public class GD_QLHD extends javax.swing.JPanel {

    /**
     * Creates new form GD_HD
     */
    public GD_QLHD() {
        initComponents();
         cardLayout = (CardLayout)(rightSide.getLayout());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gD_ChiTietHopDong2 = new ptud.GUI.GUI_HD.GD_ChiTietHopDong();
        rightSide = new javax.swing.JPanel();
        gD_ChiTietHopDong3 = new ptud.GUI.GUI_HD.GD_ChiTietHopDong();
        gD_TaoHopDong2 = new ptud.GUI.GUI_HD.GD_TaoHopDong();
        body = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        heading_2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        timButton = new javax.swing.JButton();
        taoHopDongButton = new javax.swing.JButton();
        heading_1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        body_1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDoubleBuffered(false);
        setFocusCycleRoot(true);
        setPreferredSize(new java.awt.Dimension(1400, 1000));

        rightSide.setBackground(new java.awt.Color(255, 255, 102));
        rightSide.setForeground(new java.awt.Color(255, 255, 255));
        rightSide.setPreferredSize(new java.awt.Dimension(300, 600));
        rightSide.setLayout(new java.awt.CardLayout());
        rightSide.add(gD_ChiTietHopDong3, "CTHD");
        rightSide.add(gD_TaoHopDong2, "THD");

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setLayout(new java.awt.BorderLayout());

        heading.setBackground(new java.awt.Color(255, 255, 255));
        heading.setLayout(new java.awt.BorderLayout());

        heading_2.setBackground(new java.awt.Color(255, 255, 255));
        heading_2.setPreferredSize(new java.awt.Dimension(694, 50));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm Kiếm:");

        jLabel2.setText("Tìm kiếm theo:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        timButton.setBackground(new java.awt.Color(198, 222, 192));
        timButton.setToolTipText("");
        timButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timButtonActionPerformed(evt);
            }
        });

        taoHopDongButton.setBackground(new java.awt.Color(198, 222, 192));
        taoHopDongButton.setText("Tạo Hợp Đồng");
        taoHopDongButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taoHopDongButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout heading_2Layout = new javax.swing.GroupLayout(heading_2);
        heading_2.setLayout(heading_2Layout);
        heading_2Layout.setHorizontalGroup(
            heading_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heading_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(taoHopDongButton)
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        heading_2Layout.setVerticalGroup(
            heading_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heading_2Layout.createSequentialGroup()
                .addGroup(heading_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taoHopDongButton)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(timButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        heading.add(heading_2, java.awt.BorderLayout.CENTER);

        heading_1.setBackground(new java.awt.Color(225, 240, 221));
        heading_1.setPreferredSize(new java.awt.Dimension(694, 50));

        jLabel3.setBackground(new java.awt.Color(225, 240, 221));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("QUẢN LÝ HỢP ĐỒNG");

        javax.swing.GroupLayout heading_1Layout = new javax.swing.GroupLayout(heading_1);
        heading_1.setLayout(heading_1Layout);
        heading_1Layout.setHorizontalGroup(
            heading_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heading_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                .addContainerGap())
        );
        heading_1Layout.setVerticalGroup(
            heading_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        heading.add(heading_1, java.awt.BorderLayout.PAGE_START);

        body.add(heading, java.awt.BorderLayout.PAGE_START);

        body_1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hợp đồng", "Tên hợp đồng", "Ngày bắt đầu", "Ngày kết thúc", "Trị giá hợp đồng", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hợp Đồng", jPanel6);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Số lượng", "Đơn giá", "Tiến độ"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel7);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách hàng", "email", "số điện thoại", "Tổ chức"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khách Hàng", jPanel8);

        javax.swing.GroupLayout body_1Layout = new javax.swing.GroupLayout(body_1);
        body_1.setLayout(body_1Layout);
        body_1Layout.setHorizontalGroup(
            body_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        body_1Layout.setVerticalGroup(
            body_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        body.add(body_1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightSide, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void timButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timButtonActionPerformed

    private void taoHopDongButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taoHopDongButtonActionPerformed
        // TODO add your handling code here:
        if(isCTHD==1)
        {          
           cardLayout.show(rightSide, "THD");                   
        } 
        else
        {
            cardLayout.show(rightSide, "CTHD");          
        }
        isCTHD *=-1;
     
    }//GEN-LAST:event_taoHopDongButtonActionPerformed
   /**
     * Creates new form Layout
     */
    CardLayout cardLayout;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body_1;
    private ptud.GUI.GUI_HD.GD_ChiTietHopDong gD_ChiTietHopDong2;
    private ptud.GUI.GUI_HD.GD_ChiTietHopDong gD_ChiTietHopDong3;
    private ptud.GUI.GUI_HD.GD_TaoHopDong gD_TaoHopDong2;
    private javax.swing.JPanel heading;
    private javax.swing.JPanel heading_1;
    private javax.swing.JPanel heading_2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel rightSide;
    private javax.swing.JButton taoHopDongButton;
    private javax.swing.JButton timButton;
    // End of variables declaration//GEN-END:variables

    private int isCTHD = 1;
}
