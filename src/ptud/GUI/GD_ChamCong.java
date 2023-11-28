/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ptud.GUI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.ObjDoubleConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import ptud.DAO.DAO_BoPhan;
import ptud.DAO.DAO_ChiTietPhanCong;
import ptud.DAO.DAO_CongDoan;
import ptud.DAO.DAO_NhanVien;
import ptud.DAO.DAO_PhieuChamCongCongNhan;
import ptud.DAO.DAO_PhieuChamCongNhanVien;
import ptud.DAO.DAO_TaiKhoan;
import ptud.Entity.BoPhan;
import ptud.Entity.CongDoan;
import ptud.Entity.NhanVien;
import ptud.Entity.PhieuChamCongCongNhan;
import ptud.Entity.PhieuChamCongHanhChinh;
import ptud.Entity.TaiKhoan;

/**
 *
 * @author TomTom, TranLoc
 */
public class GD_ChamCong extends javax.swing.JPanel {

    /**
     * Creates new form GD_ChamCong
     */
    public GD_ChamCong() {
        initGUI();
    }
    DAO_PhieuChamCongCongNhan DAO_PCCCN = new DAO_PhieuChamCongCongNhan();
    DAO_PhieuChamCongNhanVien DAO_PCCNV = new DAO_PhieuChamCongNhanVien();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void initGUI() {
        initComponents();
        jTextField2.setText(LocalDate.now().toString());
        DAO_BoPhan daoBoPhan = new DAO_BoPhan();
        ArrayList<BoPhan> dsBoPhan = daoBoPhan.getAll();
        for (BoPhan bp : dsBoPhan) {
            if (bp.getMaBP().startsWith("SX")) {
                jComboBox3.addItem(bp.getTenBP());
            } else {
                jComboBox2.addItem(bp.getTenBP());
            }
        }
        loadDataTabale1();
    }

    public void loadDataTabale1() {
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        String tenBoPhan = jComboBox3.getSelectedItem().toString();

        String maBoPhan = DAO_BoPhan.getMaBoPhanByTenBoPhan(tenBoPhan);
        ArrayList<Object[]> dataChamCongCN
                = DAO_PhieuChamCongCongNhan.getDanhSachThongTinChamCongByIDBoPhan(maBoPhan);

        for (Object[] row : dataChamCongCN) {
            model.addRow(row);
        }
    }

    public void loadDataTable2() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        String tenBoPhan = jComboBox2.getSelectedItem().toString();

        String maBoPhan = DAO_BoPhan.getMaBoPhanByTenBoPhan(tenBoPhan);
        ArrayList<Object[]> dataChamCongNV
                = DAO_PhieuChamCongNhanVien.getDanhSachThongTinChamCongByIDBoPhan(maBoPhan);

        for (Object[] row : dataChamCongNV) {
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jButton3.setText("Chấm công");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã công nhân", "Tên công nhân", "Vắng", "Công đoạn", "Số lượng giao", "Số lượng làm", "Số lượng tăng ca", "Tiền thưởng", "Tiền phạt", "Nội dung phạt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(30);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jTable3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable3KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
            jTable3.getColumnModel().getColumn(2).setResizable(false);
            jTable3.getColumnModel().getColumn(3).setResizable(false);
            jTable3.getColumnModel().getColumn(4).setResizable(false);
            jTable3.getColumnModel().getColumn(5).setResizable(false);
            jTable3.getColumnModel().getColumn(6).setResizable(false);
            jTable3.getColumnModel().getColumn(7).setResizable(false);
            jTable3.getColumnModel().getColumn(8).setResizable(false);
            jTable3.getColumnModel().getColumn(9).setResizable(false);
        }

        jLabel5.setText("Tìm kiếm:");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(153, 153, 153));
        jTextField3.setText("Mã công nhân...");
        jTextField3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jTextField3MouseDragged(evt);
            }
        });
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField3MouseExited(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setText("Tổ/nhóm:");

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton5.setText("Tìm");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Chấm công công nhân", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Vắng", "Đi trễ", "Tiền phạt", "Nội dung phạt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton2.setText("Chấm công");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã nhân viên:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Phòng ban:");

        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton4.setText("Tìm");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 882, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Chấm công nhân viên", jPanel2);

        jPanel3.setBackground(new java.awt.Color(225, 240, 221));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("CÔNG TY GỐM SỨ TỨ VƯƠNG");

        jLabel2.setText("Ngày chấm công:");

        jTextField2.setText("27/10/2023");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        // TODO add your handling code here:
//        jTextField3.setText("");
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField3MouseExited

    private void jTextField3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseDragged
        // TODO add your handling code here:
//        jTextField3.setText("vjvhj");
    }//GEN-LAST:event_jTextField3MouseDragged

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        // TODO add your handling code here:
        jTextField3.setText("");
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3FocusLost

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int row = model.getRowCount();
        PhieuChamCongHanhChinh phieuChamCongHanhChinh = new PhieuChamCongHanhChinh();
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy")).toString();
        for (int i = 0; i < row; i++) {
            boolean isVang = (Boolean) (jTable2.getValueAt(i, 2));
            boolean isTre = (Boolean) (jTable2.getValueAt(i, 3));
            
            phieuChamCongHanhChinh.setMaPCCHC(today + model.getValueAt(i, 0).toString());
            phieuChamCongHanhChinh.setNgay(LocalDate.now());
            phieuChamCongHanhChinh.setMaNV(model.getValueAt(i, 0).toString());
            phieuChamCongHanhChinh.setVang(isVang);
            phieuChamCongHanhChinh.setDiTre(isTre);
            phieuChamCongHanhChinh.setGioTangCa(0);
            phieuChamCongHanhChinh.setTienPhat((int)model.getValueAt(i, 4));
            phieuChamCongHanhChinh.setNoiDungTienPhat((String)model.getValueAt(i, 5));
            try {
                DAO_PhieuChamCongNhanVien.insert(phieuChamCongHanhChinh);
            } catch (SQLException ex) {
                Logger.getLogger(GD_ChamCong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        loadDataTable2();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        int row = model.getRowCount();
        PhieuChamCongCongNhan phieuChamCongCongNhan = new PhieuChamCongCongNhan();
        for (int i = 0; i < row; i++) {
            String maCN = model.getValueAt(i, 0).toString();
            String maCTPC = DAO_ChiTietPhanCong.getMaChiTietPhanCongBymaCN(maCN);
            int soCDGiao = (int) model.getValueAt(i, 4);
            boolean isVang = (Boolean) (jTable3.getValueAt(i, 2));
            String maCD = DAO_ChiTietPhanCong.getMaCongDoanBymaCTPC(maCTPC);
            int donGiaCongDoan = (int) DAO_CongDoan.getInstance().get(maCD).getDonGia();

            phieuChamCongCongNhan.setMaPCCCN("PCCCN" + maCTPC);
            phieuChamCongCongNhan.setMaCTPC(maCTPC);
            phieuChamCongCongNhan.setNgay(LocalDate.now());
            phieuChamCongCongNhan.setVang(isVang);
            phieuChamCongCongNhan.setSoLuongSanPham((int) model.getValueAt(i, 5));
            phieuChamCongCongNhan.setSoLuongSanPhamTangCa((int) model.getValueAt(i, 6));
            phieuChamCongCongNhan.setNoiDungPhat((String) model.getValueAt(i, 9));
            phieuChamCongCongNhan.setTienCong((int) (phieuChamCongCongNhan.getSoLuongSanPham() + phieuChamCongCongNhan.getSoLuongSanPhamTangCa() * 1.2) * donGiaCongDoan);
            phieuChamCongCongNhan.setTienPhat((int) model.getValueAt(i, 8));
            phieuChamCongCongNhan.setTienThuong((int) (model.getValueAt(i, 7)));
            
            try {
                if (soCDGiao < phieuChamCongCongNhan.getSoLuongSanPham() + phieuChamCongCongNhan.getSoLuongSanPhamTangCa()) {
                    JOptionPane.showMessageDialog(this,
                    "Số lượng nhập công đoạn vượt quá số lượng giao!",
                    "Cảnh báo",
                    JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    boolean kq = DAO_PhieuChamCongCongNhan.getInstance().insert(phieuChamCongCongNhan);
                    DAO_ChiTietPhanCong.getInstance().updateChoPhanCong(maCN, true);
                }
//                if (kq) {
//                    JOptionPane.showMessageDialog(this,
//                            "Chấm công thành công",
//                            "Thông báo",
//                            JOptionPane.INFORMATION_MESSAGE);
//                    loadDataTabale1();
//                }
            } catch (SQLException ex) {
                Logger.getLogger(GD_ChamCong.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        loadDataTabale1();
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        loadDataTabale1();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        loadDataTable2();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int row = jTable3.getSelectedRow();
        int col = jTable3.getSelectedColumn();
        if (col == 2) {
            Object value = jTable3.getValueAt(row, col);
            if (value instanceof Boolean) {
                boolean isSelected = (Boolean) value;
                if (isSelected) {
                    jTable3.setValueAt(0, row, col + 2);
                    jTable3.setValueAt(0, row, col + 3);
                    jTable3.setValueAt(0, row, col + 4);
                    jTable3.setValueAt(0, row, col + 5);
                    jTable3.setValueAt(0, row, col + 6);
                    jTable3.setValueAt("", row, col + 7);

                } else {
                    String maCN = jTable3.getValueAt(row, 0).toString();
                    int soLuongCDGiao = DAO_ChiTietPhanCong.getSoLuongCongDoanGiaoByMaCongNHan(maCN);
                    
                    jTable3.setValueAt(soLuongCDGiao, row, col + 2);
                    jTable3.setValueAt(soLuongCDGiao, row, col + 3);
                }

            }
        }
        else if (5 <= col) {
            Object value = jTable3.getValueAt(row, 2);
            if (value instanceof Boolean) {
                boolean isSelected = (Boolean) value;
                if (isSelected) {
                    JOptionPane.showMessageDialog(this,
                        "Công nhân đang vắng làm!",
                        "Cảnh báo",
                    JOptionPane.INFORMATION_MESSAGE);    
                    jTable3.setRowSelectionInterval(row, row);
                    jTable3.setColumnSelectionInterval(0, 0);
                }
            }
            
        }
    }//GEN-LAST:event_jTable3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        String maCN = jTextField3.getText();
        if (maCN.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Mã công nhân trống!",
                    "Cảnh báo",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Object[] thongTinChamCong = DAO_PhieuChamCongCongNhan.getThongTinChamCongByMaCongNhan(maCN);
        Object[] rowdata = new Object[10];
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        rowdata[0] = thongTinChamCong[1];
        rowdata[1] = thongTinChamCong[2];
        rowdata[2] = false;
        rowdata[3] = thongTinChamCong[3];
        rowdata[4] = thongTinChamCong[4];
        rowdata[5] = rowdata[4];
        rowdata[6] = 0;
        rowdata[7] = 0;
        rowdata[8] = 0;
        rowdata[9] = "";
        model.addRow(rowdata);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        loadDataTable2();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        String maNV = jTextField1.getText();
        Object[] rowdata = DAO_PhieuChamCongNhanVien.gethongTinChamCongByMaNV(maNV);
        if (rowdata != null)
            model.addRow(rowdata);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int row = jTable2.getSelectedRow();
        int col = jTable2.getSelectedColumn();
        if (col == 3) {
            Object value = jTable2.getValueAt(row, col);
            if (value instanceof Boolean) {
                boolean isSelected = (Boolean) value;
                if (isSelected) {
                    jTable2.setValueAt(100000, row, col + 1);
                    jTable2.setValueAt(jTable2.getValueAt(row, col + 2).toString() + "Đi trễ", row, col + 2);
                } else {
                    jTable2.setValueAt(0, row, col + 1);
                    jTable2.setValueAt("", row, col + 2);
                    
                }

            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable3KeyReleased
        // TODO add your handling code here:
        int row = jTable3.getSelectedRow();
        int col = jTable3.getSelectedColumn();
        
        if (col == 5 || col == 6) {
            int sl = (int) jTable3.getValueAt(row, 4);
            int sl1 = (int) jTable3.getValueAt(row, 5);
            int sl2 = (int) jTable3.getValueAt(row, 6);
            System.out.println(sl + " " + sl1 + " " + sl2   );
            if (sl1 + sl2 > sl) {
                JOptionPane.showMessageDialog(this,
                    "Số lượng nhập công đoạn vượt quá số lượng giao!",
                    "Cảnh báo",
                    JOptionPane.INFORMATION_MESSAGE);
                String maCN = jTable3.getValueAt(row, 0).toString();
                int soLuongCDGiao = DAO_ChiTietPhanCong.getSoLuongCongDoanGiaoByMaCongNHan(maCN);
                    
                jTable3.setValueAt(soLuongCDGiao, row, 4);
                jTable3.setValueAt(soLuongCDGiao, row, 5);
                jTable3.setValueAt(0, row, 6);
                jTable3.setValueAt(0, row, 7);
                jTable3.setValueAt(0, row, 8);
                jTable3.setValueAt("", row, 9);
                
            }
            else {
                
            }
        }
        
    }//GEN-LAST:event_jTable3KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
