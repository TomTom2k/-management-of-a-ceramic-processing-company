/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package ptud.GUI;

import ptud.ults.ImageCus;

/**
 *
 * @author TomTom
 */
public class GD_QLNS extends javax.swing.JPanel {
    /** Creates new form QLHD_GD */
    public GD_QLNS() {
        initComponents();
        btnSearch.setIcon(ImageCus.getScaledImageIcon("/assets/icons/search.jpeg", 30, 30));
        btnSearch1.setIcon(ImageCus.getScaledImageIcon("/assets/icons/search.jpeg", 30, 30));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        tmp = new javax.swing.JPanel();
        body = new javax.swing.JTabbedPane();
        dsCn = new javax.swing.JPanel();
        option1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        search1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnSearch1 = new javax.swing.JButton();
        tableNV1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        dsNv = new javax.swing.JPanel();
        tableNV = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        option = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        search = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setPreferredSize(new java.awt.Dimension(555, 100));
        header.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 0, 0));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("QUẢN LÝ NHÂN SỰ");
        title.setPreferredSize(new java.awt.Dimension(105, 60));
        header.add(title, java.awt.BorderLayout.NORTH);

        tmp.setBackground(new java.awt.Color(198, 222, 192));

        javax.swing.GroupLayout tmpLayout = new javax.swing.GroupLayout(tmp);
        tmp.setLayout(tmpLayout);
        tmpLayout.setHorizontalGroup(
            tmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1004, Short.MAX_VALUE)
        );
        tmpLayout.setVerticalGroup(
            tmpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        header.add(tmp, java.awt.BorderLayout.CENTER);

        add(header, java.awt.BorderLayout.NORTH);

        body.setBackground(new java.awt.Color(255, 255, 255));

        option1.setPreferredSize(new java.awt.Dimension(100, 60));

        jButton4.setBackground(new java.awt.Color(198, 222, 192));
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Đánh giá công nhân");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setPreferredSize(new java.awt.Dimension(150, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(198, 222, 192));
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Thôi việc công nhân");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.setPreferredSize(new java.awt.Dimension(150, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(198, 222, 192));
        jButton6.setForeground(new java.awt.Color(0, 0, 0));
        jButton6.setText("Thêm công nhân");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.setPreferredSize(new java.awt.Dimension(150, 30));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        search1.setLayout(new java.awt.BorderLayout());

        jTextField2.setText("Tìm công nhân");
        jTextField2.setBorder(null);
        jTextField2.setPreferredSize(new java.awt.Dimension(71, 30));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        search1.add(jTextField2, java.awt.BorderLayout.CENTER);

        jComboBox2.setBackground(new java.awt.Color(198, 222, 192));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã CM", "Tên công nhân", "Số điện thoại", " " }));
        jComboBox2.setBorder(null);
        jComboBox2.setMinimumSize(new java.awt.Dimension(100, 30));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        search1.add(jComboBox2, java.awt.BorderLayout.EAST);

        btnSearch1.setBackground(new java.awt.Color(198, 222, 192));
        btnSearch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/search.jpeg"))); // NOI18N
        btnSearch1.setBorder(null);
        btnSearch1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch1.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });
        search1.add(btnSearch1, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout option1Layout = new javax.swing.GroupLayout(option1);
        option1.setLayout(option1Layout);
        option1Layout.setHorizontalGroup(
            option1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        option1Layout.setVerticalGroup(
            option1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(option1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(option1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(option1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2210001", "Lê Thị Xuân Mai", "23/04/2022", "054198003412", "0987566743", "Nữ", "11/05/1998",  new Double(500000.0), null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã CN", "Tên công nhân", "Ngày bắt đầu làm", "CCCD", "Số điện thoại", "Giới tính", "Ngày sinh", "Phụ cấp", "Lương cơ bảng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setRowHeight(30);
        tableNV1.setViewportView(jTable2);

        javax.swing.GroupLayout dsCnLayout = new javax.swing.GroupLayout(dsCn);
        dsCn.setLayout(dsCnLayout);
        dsCnLayout.setHorizontalGroup(
            dsCnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableNV1)
            .addGroup(dsCnLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(option1, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
        );
        dsCnLayout.setVerticalGroup(
            dsCnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsCnLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(option1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tableNV1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
        );

        body.addTab("Công nhân", dsCn);

        dsNv.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2210001", "Lê Thị Xuân Mai", "23/04/2022", "054198003412", "0987566743", "Nữ", "11/05/1998",  new Double(500000.0), null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên nhân viên", "Ngày bắt đầu làm", "CCCD", "Số điện thoại", "Giới tính", "Ngày sinh", "Phụ cấp", "Lương cơ bảng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setRowHeight(30);
        tableNV.setViewportView(jTable1);

        option.setPreferredSize(new java.awt.Dimension(100, 60));

        jButton3.setBackground(new java.awt.Color(198, 222, 192));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Đánh giá nhân viên");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setPreferredSize(new java.awt.Dimension(150, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(198, 222, 192));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Thôi việc nhân viên");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setPreferredSize(new java.awt.Dimension(150, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(198, 222, 192));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Thêm nhân viên");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setPreferredSize(new java.awt.Dimension(150, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        search.setLayout(new java.awt.BorderLayout());

        jTextField1.setText("Tìm nhân viên");
        jTextField1.setBorder(null);
        jTextField1.setPreferredSize(new java.awt.Dimension(71, 30));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        search.add(jTextField1, java.awt.BorderLayout.CENTER);

        jComboBox1.setBackground(new java.awt.Color(198, 222, 192));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NV", "Tên nhân viên", "Số điện thoại", " " }));
        jComboBox1.setBorder(null);
        jComboBox1.setMinimumSize(new java.awt.Dimension(100, 30));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        search.add(jComboBox1, java.awt.BorderLayout.EAST);

        btnSearch.setBackground(new java.awt.Color(198, 222, 192));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/search.jpeg"))); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        search.add(btnSearch, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout optionLayout = new javax.swing.GroupLayout(option);
        option.setLayout(optionLayout);
        optionLayout.setHorizontalGroup(
            optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        optionLayout.setVerticalGroup(
            optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dsNvLayout = new javax.swing.GroupLayout(dsNv);
        dsNv.setLayout(dsNvLayout);
        dsNvLayout.setHorizontalGroup(
            dsNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableNV)
            .addGroup(dsNvLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(option, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE))
        );
        dsNvLayout.setVerticalGroup(
            dsNvLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsNvLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tableNV, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))

        );

        body.addTab("Nhân viên", dsNv);

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        System.out.println("search");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Layout.instance.showLayout("themNS");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane body;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
    private javax.swing.JPanel dsCn;
    private javax.swing.JPanel dsNv;
    private javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel option;
    private javax.swing.JPanel option1;
    private javax.swing.JPanel search;
    private javax.swing.JPanel search1;
    private javax.swing.JScrollPane tableNV;
    private javax.swing.JScrollPane tableNV1;
    private javax.swing.JLabel title;
    private javax.swing.JPanel tmp;
    // End of variables declaration//GEN-END:variables

}
