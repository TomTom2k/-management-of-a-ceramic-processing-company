/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ptud.GUI;

import java.awt.CardLayout;
import java.lang.invoke.MethodHandles;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import ptud.DAO.DAO_HopDong;
import ptud.Entity.HopDong;
import ptud.GUI.GUI_HD.GD_ChiTietHopDong;
import ptud.ults.ImageCus;

/**
 *
 * @author TomTom
 */
public class GD_QLHD extends javax.swing.JPanel {

    DAO_HopDong daoHongDong = new DAO_HopDong();
    DefaultTableModel hopDongModel;
      String[]  firstHopDongRow;
    /**
     * Creates new form GD_HD
     */
    public GD_QLHD() 
    {
        initComponents();
        cardLayout = (CardLayout) (rightSide.getLayout());
        hopDongModel = (DefaultTableModel) hopDongTable.getModel();
        updateTable();
    }
    void updateTable()
    {
        deleleTable();
        filHopDongTable();
    }
    int deleleTable()
    {
        int rowIndex = hopDongModel.getRowCount();
        for(int i = 1; i< rowIndex;i++)
        {
            if(hopDongModel.getRowCount()==1)
            {
                return 1;
            }
            else
            {
              hopDongModel.removeRow(1);
            }          
        }
        return 0;
    }
    void filHopDongTable()
    {
       for(HopDong hopDong : daoHongDong.getAll())
       {
           changeEnityToObject(hopDong);
       }
    }
    void changeEnityToObject(HopDong hopDong)
    {
        Object[] rowDate = new Object[6];
        rowDate[0] = hopDong.getMaHD();
        rowDate[1] = hopDong.getTenHD();
        rowDate[2] = hopDong.getNgayBatDauString();
        rowDate[3] = hopDong.getNgayKetThucString();
        rowDate[4] = hopDong.getDonGiaString();
        rowDate[5] = hopDong.getTrangThai();
        hopDongModel.addRow(rowDate);         
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
        hopDong_Panel = new javax.swing.JPanel();
        hopDongScroll = new javax.swing.JScrollPane();
        hopDongTable = new javax.swing.JTable();
        khachHang_Panel = new javax.swing.JPanel();
        khachHangScroll = new javax.swing.JScrollPane();
        khachHangTable = new javax.swing.JTable();

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

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        hopDong_Panel.setBackground(new java.awt.Color(255, 255, 255));

        hopDongScroll.setBackground(new java.awt.Color(255, 255, 255));

        hopDongTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hợp đồng", "Tên hợp đồng", "Ngày bắt đầu", "Ngày kết thúc", "Trị giá hợp đồng", "Trạng thái"
            }
        ));
        hopDongScroll.setViewportView(hopDongTable);

        javax.swing.GroupLayout hopDong_PanelLayout = new javax.swing.GroupLayout(hopDong_Panel);
        hopDong_Panel.setLayout(hopDong_PanelLayout);
        hopDong_PanelLayout.setHorizontalGroup(
            hopDong_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hopDongScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        hopDong_PanelLayout.setVerticalGroup(
            hopDong_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hopDong_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hopDongScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Hợp Đồng", hopDong_Panel);

        khachHang_Panel.setBackground(new java.awt.Color(255, 255, 255));

        khachHangScroll.setBackground(new java.awt.Color(255, 255, 255));

        khachHangTable.setModel(new javax.swing.table.DefaultTableModel(
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
        khachHangScroll.setViewportView(khachHangTable);

        javax.swing.GroupLayout khachHang_PanelLayout = new javax.swing.GroupLayout(khachHang_Panel);
        khachHang_Panel.setLayout(khachHang_PanelLayout);
        khachHang_PanelLayout.setHorizontalGroup(
            khachHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(khachHangScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
        );
        khachHang_PanelLayout.setVerticalGroup(
            khachHang_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khachHang_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(khachHangScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khách Hàng", khachHang_Panel);

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
    private javax.swing.JScrollPane hopDongScroll;
    private javax.swing.JTable hopDongTable;
    private javax.swing.JPanel hopDong_Panel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane khachHangScroll;
    private javax.swing.JTable khachHangTable;
    private javax.swing.JPanel khachHang_Panel;
    private javax.swing.JPanel rightSide;
    private javax.swing.JButton taoHopDongButton;
    private javax.swing.JButton timButton;
    // End of variables declaration//GEN-END:variables

    private int isCTHD = 1;
}
