/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package ptud.GUI;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import ptud.DAO.DAO_CongNhan;
import ptud.DAO.DAO_NhanVien;
import ptud.Entity.CongNhan;
import ptud.Entity.NhanVien;
import ptud.ults.ImageCus;

/**
 *
 * @author TomTom
 */
public class GD_DanhGia extends javax.swing.JPanel {

//  thêm NV vào table
	private void populateNhanVienTable() {
		DefaultTableModel model = (DefaultTableModel) tableNV.getModel();
		model.setRowCount(0); // Clear existing data

		DAO_NhanVien daoNhanVien = DAO_NhanVien.getInstance();
		ArrayList<NhanVien> danhSachNhanVien = daoNhanVien.getAll();
		System.out.println("Danh gia: "+ danhSachNhanVien);

		for (NhanVien nhanVien : danhSachNhanVien) {
			// Add each NhanVien object to the table
			model.addRow(new Object[] { nhanVien.getMaNV(), nhanVien.getTen(), "", "", "", "", "", ""});
		}
	}
//  thêm CN vào table
	private void populateCongNhanTable() {
		DefaultTableModel model = (DefaultTableModel) tableCN.getModel();
		model.setRowCount(0); // Clear existing data

		DAO_CongNhan daoCongNhan = DAO_CongNhan.getInstance();
		ArrayList<CongNhan> danhSachCongNhan = daoCongNhan.getAll();

		for (CongNhan congNhan : danhSachCongNhan) {
			// Add each NhanVien object to the table
			model.addRow(new Object[] { congNhan.getTen(), congNhan.getTen(), "", "", "", "", "", ""});
		}
	}

	/** Creates new form GD_DanhGia */
	public GD_DanhGia() {
		initComponents();
		btnSearchCN.setIcon(ImageCus.getScaledImageIcon("/assets/icons/search.jpeg", 30, 30));
		btnSearchNV.setIcon(ImageCus.getScaledImageIcon("/assets/icons/search.jpeg", 30, 30));
		populateCongNhanTable();
		populateNhanVienTable();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bode = new javax.swing.JTabbedPane();
        tabCN = new javax.swing.JPanel();
        contentCN = new javax.swing.JPanel();
        scrollTableCN = new javax.swing.JScrollPane();
        tableCN = new javax.swing.JTable();
        option = new javax.swing.JPanel();
        txtSearchCN = new javax.swing.JTextField();
        btnSearchCN = new javax.swing.JButton();
        seachCriteriaCN = new javax.swing.JComboBox<>();
        btnDanhGiaCN = new javax.swing.JButton();
        tabNV = new javax.swing.JPanel();
        contentNV = new javax.swing.JPanel();
        scrollTableNV = new javax.swing.JScrollPane();
        tableNV = new javax.swing.JTable();
        optionNV = new javax.swing.JPanel();
        txtSearchNV = new javax.swing.JTextField();
        btnSearchNV = new javax.swing.JButton();
        searchCriteriaNV = new javax.swing.JComboBox<>();
        btnDanhGiaNV = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(198, 222, 192));
        jPanel1.setPreferredSize(new java.awt.Dimension(715, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 896, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐÁNH GIÁ NHÂN SỰ");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(header, java.awt.BorderLayout.PAGE_START);

        tabCN.setLayout(new java.awt.BorderLayout());

        tableCN.setBackground(new java.awt.Color(255, 255, 255));
        tableCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "1", null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã CN", "Tên công nhân", "Điểm hiệu suất", "Điểm chuyên môn", "Điểm thái độ", "Điểm chuyên cần", "Tổng điểm", "Xếp loại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableCN.setRowHeight(30);
        scrollTableCN.setViewportView(tableCN);

        option.setPreferredSize(new java.awt.Dimension(884, 60));

        txtSearchCN.setText("Tìm công nhân");
        txtSearchCN.setBorder(null);
        txtSearchCN.setPreferredSize(new java.awt.Dimension(71, 30));
        txtSearchCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchCNActionPerformed(evt);
            }
        });

        btnSearchCN.setBackground(new java.awt.Color(198, 222, 192));
        btnSearchCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/search.jpeg"))); // NOI18N
        btnSearchCN.setBorder(null);
        btnSearchCN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchCN.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSearchCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCNActionPerformed(evt);
            }
        });

        seachCriteriaCN.setBackground(new java.awt.Color(198, 222, 192));
        seachCriteriaCN.setForeground(new java.awt.Color(0, 0, 0));
        seachCriteriaCN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã CN", "Tên công nhân" }));
        seachCriteriaCN.setBorder(null);
        seachCriteriaCN.setMinimumSize(new java.awt.Dimension(100, 30));
        seachCriteriaCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seachCriteriaCNActionPerformed(evt);
            }
        });

        btnDanhGiaCN.setBackground(new java.awt.Color(198, 222, 192));
        btnDanhGiaCN.setForeground(new java.awt.Color(0, 0, 0));
        btnDanhGiaCN.setText("Đánh giá ");
        btnDanhGiaCN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDanhGiaCN.setPreferredSize(new java.awt.Dimension(150, 30));
        btnDanhGiaCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhGiaCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionLayout = new javax.swing.GroupLayout(option);
        option.setLayout(optionLayout);
        optionLayout.setHorizontalGroup(
            optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnDanhGiaCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSearchCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtSearchCN, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(seachCriteriaCN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );
        optionLayout.setVerticalGroup(
            optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(seachCriteriaCN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearchCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(optionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSearchCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDanhGiaCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout contentCNLayout = new javax.swing.GroupLayout(contentCN);
        contentCN.setLayout(contentCNLayout);
        contentCNLayout.setHorizontalGroup(
            contentCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTableCN)
            .addGroup(contentCNLayout.createSequentialGroup()
                .addComponent(option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        contentCNLayout.setVerticalGroup(
            contentCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentCNLayout.createSequentialGroup()
                .addComponent(option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollTableCN, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        tabCN.add(contentCN, java.awt.BorderLayout.CENTER);

        bode.addTab("Công nhân", tabCN);

        tabNV.setLayout(new java.awt.BorderLayout());

        tableNV.setBackground(new java.awt.Color(255, 255, 255));
        tableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên nhân viên", "Điểm hiệu suất", "Điểm chuyên môn", "Điểm thái độ", "Điểm chuyên cần", "Tổng điểm", "Xếp loại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableNV.setRowHeight(30);
        scrollTableNV.setViewportView(tableNV);

        optionNV.setPreferredSize(new java.awt.Dimension(884, 60));

        txtSearchNV.setText("Tìm nhân viên");
        txtSearchNV.setBorder(null);
        txtSearchNV.setPreferredSize(new java.awt.Dimension(71, 30));
        txtSearchNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchNVActionPerformed(evt);
            }
        });

        btnSearchNV.setBackground(new java.awt.Color(198, 222, 192));
        btnSearchNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/search.jpeg"))); // NOI18N
        btnSearchNV.setBorder(null);
        btnSearchNV.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchNV.setPreferredSize(new java.awt.Dimension(30, 30));
        btnSearchNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchNVActionPerformed(evt);
            }
        });

        searchCriteriaNV.setBackground(new java.awt.Color(198, 222, 192));
        searchCriteriaNV.setForeground(new java.awt.Color(0, 0, 0));
        searchCriteriaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã CN", "Tên nhân viên", " ", " " }));
        searchCriteriaNV.setBorder(null);
        searchCriteriaNV.setMinimumSize(new java.awt.Dimension(100, 30));
        searchCriteriaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCriteriaNVActionPerformed(evt);
            }
        });

        btnDanhGiaNV.setBackground(new java.awt.Color(198, 222, 192));
        btnDanhGiaNV.setForeground(new java.awt.Color(0, 0, 0));
        btnDanhGiaNV.setText("Đánh giá ");
        btnDanhGiaNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDanhGiaNV.setPreferredSize(new java.awt.Dimension(150, 30));
        btnDanhGiaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhGiaNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionNVLayout = new javax.swing.GroupLayout(optionNV);
        optionNV.setLayout(optionNVLayout);
        optionNVLayout.setHorizontalGroup(
            optionNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionNVLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnDanhGiaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnSearchNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtSearchNV, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(searchCriteriaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );
        optionNVLayout.setVerticalGroup(
            optionNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionNVLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(optionNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchCriteriaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSearchNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(optionNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSearchNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDanhGiaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout contentNVLayout = new javax.swing.GroupLayout(contentNV);
        contentNV.setLayout(contentNVLayout);
        contentNVLayout.setHorizontalGroup(
            contentNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollTableNV)
            .addGroup(contentNVLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(optionNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        contentNVLayout.setVerticalGroup(
            contentNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentNVLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(optionNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollTableNV, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        tabNV.add(contentNV, java.awt.BorderLayout.CENTER);

        bode.addTab("Nhân viên", tabNV);

        add(bode, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

	private void txtSearchCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSearchCNActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSearchCNActionPerformed

	private void btnSearchCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSearchCNActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnSearchCNActionPerformed

	private void seachCriteriaCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_seachCriteriaCNActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_seachCriteriaCNActionPerformed

	private void btnDanhGiaCNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDanhGiaCNActionPerformed
		// TODO add your handling code here:
		Layout.instance.showLayout("themNS");
	}// GEN-LAST:event_btnDanhGiaCNActionPerformed

	private void txtSearchNVActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSearchNVActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtSearchNVActionPerformed

	private void btnSearchNVActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSearchNVActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnSearchNVActionPerformed

	private void searchCriteriaNVActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchCriteriaNVActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_searchCriteriaNVActionPerformed

	private void btnDanhGiaNVActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDanhGiaNVActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnDanhGiaNVActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane bode;
    private javax.swing.JButton btnDanhGiaCN;
    private javax.swing.JButton btnDanhGiaNV;
    private javax.swing.JButton btnSearchCN;
    private javax.swing.JButton btnSearchNV;
    private javax.swing.JPanel contentCN;
    private javax.swing.JPanel contentNV;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel option;
    private javax.swing.JPanel optionNV;
    private javax.swing.JScrollPane scrollTableCN;
    private javax.swing.JScrollPane scrollTableNV;
    private javax.swing.JComboBox<String> seachCriteriaCN;
    private javax.swing.JComboBox<String> searchCriteriaNV;
    private javax.swing.JPanel tabCN;
    private javax.swing.JPanel tabNV;
    private javax.swing.JTable tableCN;
    private javax.swing.JTable tableNV;
    private javax.swing.JTextField txtSearchCN;
    private javax.swing.JTextField txtSearchNV;
    // End of variables declaration//GEN-END:variables

}
