/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ptud.GUI;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteComboBoxEditor;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import ptud.DAO.*;
import ptud.Entity.BoPhan;
import ptud.Entity.ChiTietPhanCong;
import ptud.Entity.CongDoan;
import ptud.Entity.CongNhan;
import ptud.Entity.HopDong;
import ptud.Entity.SanPham;

/**
 *
 * @author Khanh
 */
public class GD_QLSP extends javax.swing.JPanel {

    /**
     * Creates new form GD_QLSP
     */
    public GD_QLSP() {
        initComponents();

        AutoCompleteDecorator.decorate(jComboBoxMaHopDong);
        AutoCompleteDecorator.decorate(jComboBoxMaBoPhan);
        AutoCompleteDecorator.decorate(jComboBoxCDTQ);

        ArrayList<HopDong> dsHopDong = DAO_HopDong.getInstance().getAll();
        dsCongNhan = new DAO_CongNhan().getAll();
        dsSanPham = DAO_SanPham.getInstance().getAll();
        dsCongDoan = new DAO_CongDoan().getAll();
        dsBoPhan = new ArrayList<BoPhan>(); 
        dsCTPC = new ArrayList<ChiTietPhanCong>();
        // loaddata to jComboBoxMaHopDong
        for (HopDong h : dsHopDong) {
            // if( h.getTrangThai().equql("đang thực thi") )
            jComboBoxMaHopDong.addItem(h.getMaHD());
        }

        loadDsSanPham();

        // loaddata to jComboBoxMaBoPhan
        for (BoPhan boPhan : new DAO_BoPhan().getAll()) {
            // Only take maBP prefixed with 'SX'
            if (boPhan.getMaBP().startsWith("SX")) {
                jComboBoxMaBoPhan.addItem(boPhan.getMaBP());
                jComboBoxBoPhan.addItem(boPhan.getTenBP());
                dsBoPhan.add(boPhan); 
            }
        }

        // loaddata sanpham vao jcombobox
        for (SanPham sanPham : dsSanPham) {
            jComboBoxSanPham.addItem(sanPham.getTenSanPham());
        }

        // loaddata to jtableCongDoan
        loadDsCongDoan();
        loadDsCongNhan(); 

        jDateChooser1.setDate(new Date());
        loadDsCTPC(); 
    }

    // biến toàn cục
    public ArrayList<CongDoan> dsCongDoan;
    public String maSP;
    public CongDoan congDoan;
    public ArrayList<SanPham> dsSanPham;
    public ArrayList<CongNhan> dsCongNhan;
    public ArrayList<BoPhan> dsBoPhan;
    public ArrayList<ChiTietPhanCong> dsCTPC;

    // loaddata SanPham
    private void loadDsSanPham() {
        dsSanPham = DAO_SanPham.getInstance().getAll();
        DefaultTableModel tblModel = (DefaultTableModel) jTableSanPham.getModel();
        tblModel.setRowCount(0);
        String maHD = jComboBoxMaHopDong.getSelectedItem().toString();
        for (SanPham sp : dsSanPham) {
            String maHD1 = "0511202301";
            maHD1 = sp.getMaHD();
            if (maHD1.equals(maHD) || maHD.equals("Tất cả")) {
                String tbData[] = { sp.getMaSanPham(), sp.getTenSanPham() };
                tblModel.addRow(tbData);
            }
        }
        tblModel.fireTableDataChanged();
    }

    // loaddata CongDoan
    private void loadDsCongDoan() {
        ArrayList<CongDoan> dsCongDoan = DAO_CongDoan.getInstance().getAll();
        ArrayList<CongDoan> dsCongDoan2 = new ArrayList<CongDoan>();
        for (CongDoan cd : dsCongDoan) {
            if (cd.getSoLuongChuanBi() < cd.getSoLuongChuanBiToiThieu())
                continue;

            if (jComboBoxBoPhan.getSelectedIndex() > 0) {
                int id = jComboBoxBoPhan.getSelectedIndex() - 1;
                if (cd.getMaBP().equals(dsBoPhan.get(id).getMaBP())) {
                    if (jComboBoxSanPham.getSelectedIndex() > 0) {
                        int id2 = jComboBoxSanPham.getSelectedIndex() - 1;
                        if (cd.getMaSP().equals(dsSanPham.get(id2).getMaSanPham()))
                            dsCongDoan2.add(cd);
                    } else
                        dsCongDoan2.add(cd);

                }
            } else {
                if (jComboBoxSanPham.getSelectedIndex() > 0) {
                    int id2 = jComboBoxSanPham.getSelectedIndex() - 1;
                    if (cd.getMaSP().equals(dsSanPham.get(id2).getMaSanPham()))
                        dsCongDoan2.add(cd);
                } else
                    dsCongDoan2.add(cd);
            }
        }

        // loaddata to jTableCongDoan1
        DefaultTableModel tblModelCongDoan = (DefaultTableModel) jTableCongDoan1.getModel();
        tblModelCongDoan.setRowCount(0);
        for (CongDoan cd : dsCongDoan2) {
            String tenBP = new DAO_BoPhan().get(cd.getMaBP()).getTenBP();
            String tbData[] = { cd.getMaCD(), cd.getTenCD(), tenBP, String.valueOf(cd.getSoLuongChuanBi()),
                    String.valueOf(cd.getSoLuongHoanThanh()) };
            tblModelCongDoan.addRow(tbData);
        }
        tblModelCongDoan.fireTableDataChanged();
    }

    private void loadDsCongNhan() {
        dsCongNhan = DAO_CongNhan.getInstance().getAll();
        DefaultTableModel tblModelCongNhan = (DefaultTableModel) jTableCongNhan.getModel();
        tblModelCongNhan.setRowCount(0);
        for( CongNhan cn : dsCongNhan ) {
            int idBP = jComboBoxBoPhan.getSelectedIndex() - 1;
            if(!cn.isTrangThai()) 
                continue; 
            if(idBP >= 0) {
                if( !cn.getBoPhan().getMaBP().equals(dsBoPhan.get(idBP).getMaBP()) ) 
                    continue; 
            } else {
                int row = jTableCongDoan1.getSelectedRow();
                if(row>=0) {
                    String macd = (String) jTableCongDoan1.getValueAt(row, 0);
                    String mabp = DAO_CongDoan.getInstance().get(macd).getMaBP();
                    if( !cn.getBoPhan().getMaBP().equals(mabp) )
                        continue;
                }
            }
            if( cn.isChoPhanCong() ) {
                // add to jTableCongNhan
                String tbData[] = { cn.getMaCN(), cn.getTen(), "" };
                tblModelCongNhan.addRow(tbData);
            }
        }
    }

    private void loadDsCTPC() {
        Instant instant = jDateChooser1.getDate().toInstant();
        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        ArrayList<ChiTietPhanCong> dsCTPC = DAO_ChiTietPhanCong.getInstance().getAllByNgay(localDate);
        DefaultTableModel tblModelCTPC = (DefaultTableModel) jTableCTPC.getModel();
        tblModelCTPC.setRowCount(0);
        for (ChiTietPhanCong ctpc : dsCTPC) {
            CongNhan cn = DAO_CongNhan.getInstance().get(ctpc.getMaCN());
            int soLuongHoanThanh = 0;
            // tính số lượng hoàn thành từ PhieuChamCongCongNhan
            CongDoan cd = DAO_CongDoan.getInstance().get(ctpc.getMaCD());
            String tbData[] = { ctpc.getMaCN(), cn.getTen(), cn.getBoPhan().getTenBP(), cd.getMaSP(), ctpc.getMaCD(), ctpc.getSoLuongCDGiao()+"",soLuongHoanThanh+"" };
            tblModelCTPC.addRow(tbData);
        }
    
    }

    private void clearData() {
        jTextFieldMaCD.setText("");
        jTextFieldTenCD.setText("");
        jTextFieldDonGia.setText("");
        if (jComboBoxMaBoPhan.getItemCount() > 0)
            jComboBoxMaBoPhan.setSelectedIndex(0);
        jTextFieldSLCBTT.setText("1");
        jCheckBoxHoanThanh.setSelected(false);
        if (jComboBoxCDTQ.getItemCount() > 0)
            jComboBoxCDTQ.setSelectedIndex(0);
        DefaultTableModel tblModel = (DefaultTableModel) jTableCDTQ.getModel();
        tblModel.setRowCount(0);
        tblModel.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonTaoMoi = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jButtonXoa = new javax.swing.JButton();
        jButtonLuu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxMaBoPhan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDonGia = new javax.swing.JTextField();
        jCheckBoxHoanThanh = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCDTQ = new javax.swing.JTable();
        jButtonXoaCDTQ = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jComboBoxCDTQ = new javax.swing.JComboBox<>();
        jButtonThemCDTQ = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSanPham = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxMaHopDong = new javax.swing.JComboBox<>();
        jTextFieldMaCD = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCongDoan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxSapXep = new javax.swing.JComboBox<>();
        jToggleButtonSort = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldSLCBTT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldTenCD = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxSanPham = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCongDoan1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableCongNhan = new javax.swing.JTable();
        jButtonPhanCong = new javax.swing.JButton();
        jButtonNhapSoLuong = new javax.swing.JButton();
        jComboBoxBoPhan = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCTPC = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxMaHopDong1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jComboBoxMaHopDong4 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBoxSapXep1 = new javax.swing.JComboBox<>();
        jToggleButton2 = new javax.swing.JToggleButton();

        jButtonTaoMoi.setText("Tạo mới");
        jButtonTaoMoi.setEnabled(false);
        jButtonTaoMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonTaoMoiMouseReleased(evt);
            }
        });
        jButtonTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTaoMoiActionPerformed(evt);
            }
        });

        jButtonSua.setText("Sửa");
        jButtonSua.setEnabled(false);
        jButtonSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonSuaMouseReleased(evt);
            }
        });
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });

        jButtonXoa.setText("Xoá");
        jButtonXoa.setEnabled(false);
        jButtonXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonXoaMouseReleased(evt);
            }
        });
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });

        jButtonLuu.setText("Lưu");
        jButtonLuu.setEnabled(false);
        jButtonLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonLuuMouseReleased(evt);
            }
        });
        jButtonLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLuuActionPerformed(evt);
            }
        });

        jLabel3.setText("Mã công đoạn:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel4.setText("Mã bộ phận");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jComboBoxMaBoPhan.setEditable(true);
        jComboBoxMaBoPhan.setEnabled(false);
        jComboBoxMaBoPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaBoPhanActionPerformed(evt);
            }
        });

        jLabel5.setText("Đơn giá:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextFieldDonGia.setEditable(false);
        jTextFieldDonGia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDonGiaActionPerformed(evt);
            }
        });

        jCheckBoxHoanThanh.setText("Hoàn thành");
        jCheckBoxHoanThanh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCheckBoxHoanThanh.setEnabled(false);
        jCheckBoxHoanThanh.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jCheckBoxHoanThanh.setIconTextGap(30);
        jCheckBoxHoanThanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jCheckBoxHoanThanhMouseReleased(evt);
            }
        });
        jCheckBoxHoanThanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxHoanThanhActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách công đoạn tiên quyết"));

        jTableCDTQ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã công đoạn", "Tên công đoạn"
            }
        ));
        jTableCDTQ.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCDTQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableCDTQMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCDTQ);
        jTableCDTQ.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jButtonXoaCDTQ.setText("Xoá");
        jButtonXoaCDTQ.setEnabled(false);
        jButtonXoaCDTQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonXoaCDTQMouseReleased(evt);
            }
        });
        jButtonXoaCDTQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaCDTQActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jButtonXoaCDTQ, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(26, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(jButtonXoaCDTQ)
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(43, Short.MAX_VALUE)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Thêm công đoạn tiên quyết"));

        jComboBoxCDTQ.setEditable(true);
        jComboBoxCDTQ.setEnabled(false);
        jComboBoxCDTQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCDTQActionPerformed(evt);
            }
        });

        jButtonThemCDTQ.setText("Thêm");
        jButtonThemCDTQ.setEnabled(false);
        jButtonThemCDTQ.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonThemCDTQMouseReleased(evt);
            }
        });
        jButtonThemCDTQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemCDTQActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jComboBoxCDTQ, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButtonThemCDTQ, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jComboBoxCDTQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonThemCDTQ)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Chọn sản phẩm"));

        jTableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSanPham.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableSanPhamMouseReleased(evt);
            }
        });
        jTableSanPham.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableSanPhamKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSanPham);
        jTableSanPham.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel6.setText("Mã hợp đồng");

        jComboBoxMaHopDong.setEditable(true);
        jComboBoxMaHopDong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBoxMaHopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaHopDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxMaHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTextFieldMaCD.setEditable(false);
        jTextFieldMaCD.setEnabled(false);
        jTextFieldMaCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMaCDActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách công đoạn"));

        jTableCongDoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã công đoạn", "Tên công đoạn", "Đơn giá", "Bộ phận", "Mã sản phẩm", "Trạng thái", "Số lượng chuẩn bị tối thiểu", "Số lượng chuẩn bị", "Số lượng hoàn thành"
            }
        ));
        jTableCongDoan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCongDoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableCongDoanMouseReleased(evt);
            }
        });
        jTableCongDoan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCongDoanKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableCongDoan);

        jLabel1.setText("Sắp xếp theo:");

        jComboBoxSapXep.setEditable(true);
        jComboBoxSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã công đoạn", "Tên công đoạn", "Đơn giá", "Bộ phận", "Mã sản phẩm", "Trạng thái", "Số lượng chẩn bị tối thiểu", "Số lượng chuẩn bị", "Số lượng hoàn thành" }));
        jComboBoxSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSapXepActionPerformed(evt);
            }
        });

        jToggleButtonSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/icons8-sort2-50.png"))); // NOI18N
        jToggleButtonSort.setToolTipText("");
        jToggleButtonSort.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jToggleButtonSortMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButtonSort, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1250, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBoxSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToggleButtonSort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setText("Số lượng chuẩn bị tối thiểu:");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextFieldSLCBTT.setEditable(false);
        jTextFieldSLCBTT.setText("1");
        jTextFieldSLCBTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSLCBTTActionPerformed(evt);
            }
        });

        jLabel13.setText(".000đ");

        jTextFieldTenCD.setEditable(false);
        jTextFieldTenCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenCDActionPerformed(evt);
            }
        });

        jLabel14.setText("Tên công đoạn:");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldMaCD))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxMaBoPhan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldDonGia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBoxHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldSLCBTT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldTenCD)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(155, 155, 155))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldMaCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jTextFieldTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxMaBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTextFieldDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextFieldSLCBTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jCheckBoxHoanThanh))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonTaoMoi)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSua)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonXoa)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLuu))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("Quản lý công đoạn", jPanel1);

        jLabel2.setText("Bộ phận");

        jComboBoxSanPham.setEditable(true);
        jComboBoxSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBoxSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSanPhamActionPerformed(evt);
            }
        });

        jLabel8.setText("Sản phẩm:");

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách công đoạn"));

        jTableCongDoan1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã công đoạn", "Tên công đoạn", "Bộ phận", "Số lượng chuẩn bị", "Số lượng hoàn thành"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCongDoan1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCongDoan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableCongDoan1MouseReleased(evt);
            }
        });
        jTableCongDoan1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTableCongDoan1PropertyChange(evt);
            }
        });
        jTableCongDoan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCongDoan1KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jTableCongDoan1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách công nhân"));

        jTableCongNhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã công nhân", "Tên công nhân", "Số lượng giao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCongNhan.setEnabled(false);
        jTableCongNhan.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(jTableCongNhan);

        jButtonPhanCong.setText("Phân công");
        jButtonPhanCong.setEnabled(false);
        jButtonPhanCong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonPhanCongMouseReleased(evt);
            }
        });
        jButtonPhanCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPhanCongActionPerformed(evt);
            }
        });

        jButtonNhapSoLuong.setText("Nhập số lượng");
        jButtonNhapSoLuong.setEnabled(false);
        jButtonNhapSoLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonNhapSoLuongMouseReleased(evt);
            }
        });
        jButtonNhapSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNhapSoLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jButtonNhapSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPhanCong, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPhanCong)
                    .addComponent(jButtonNhapSoLuong)))
        );

        jComboBoxBoPhan.setEditable(true);
        jComboBoxBoPhan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBoxBoPhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBoPhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jComboBoxSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxBoPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng phân công"));

        jTableCTPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã công đoạn", "Tên công đoạn", "Bộ phận", "Mã sản phẩm", "Công đoạn", "Số lượng được giao", "Số lượng hoàn thành"
            }
        ));
        jTableCTPC.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCTPC.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCTPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableCTPCMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jTableCTPC);

        jLabel9.setText("Ngày:");

        jButton9.setText("Sửa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Xoá");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Lưu");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel10.setText("Bộ phận:");

        jComboBoxMaHopDong1.setEditable(true);
        jComboBoxMaHopDong1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBoxMaHopDong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaHopDong1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Công đoạn:");

        jComboBoxMaHopDong4.setEditable(true);
        jComboBoxMaHopDong4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        jComboBoxMaHopDong4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMaHopDong4ActionPerformed(evt);
            }
        });

        jLabel12.setText("Sắp xếp theo:");

        jComboBoxSapXep1.setEditable(true);
        jComboBoxSapXep1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "DATABASE", "SQL", "SYSTEM DESIGN", "MYSQL", "ORACLE", "WEB DESIGN", "DESKTOP APPLICATION", "GRAPHICS" }));
        jComboBoxSapXep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSapXep1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Giảm dần");
        jToggleButton2.setToolTipText("");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMaHopDong4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMaHopDong1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jComboBoxSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jToggleButton2))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jComboBoxMaHopDong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jComboBoxMaHopDong4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(18, 18, 18)
                .addComponent(jButton11)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(49, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phân chia công đoạn", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1392, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableCongDoan1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCongDoan1MouseReleased
        // TODO add your handling code here:
        if( jTableCongDoan1.isEnabled() ) {
            loadDsCongNhan();
            jButtonNhapSoLuong.setEnabled(true);
        }
    }//GEN-LAST:event_jTableCongDoan1MouseReleased

    private void jTableCongDoan1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTableCongDoan1PropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTableCongDoan1PropertyChange

    private void jTableCongDoan1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCongDoan1KeyReleased
        // TODO add your handling code here:
        if( jTableCongDoan1.isEnabled() ) {
            loadDsCongNhan();
            jButtonNhapSoLuong.setEnabled(true);
        }
    }//GEN-LAST:event_jTableCongDoan1KeyReleased

    private void jTableSanPhamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableSanPhamKeyReleased
        // TODO add your handling code here:
        if (jTableSanPham.isEnabled()) {
            int row = jTableSanPham.getSelectedRow();
            maSP = (String) jTableSanPham.getValueAt(row, 0);
            loadDataJTableCongDoan();
            loadDataJComboBoxCDTQ();
            jButtonTaoMoi.setEnabled(true);
            jButtonXoa.setEnabled(false);
            jButtonSua.setEnabled(false);
            jTableCongDoan.setEnabled(true);
            clearData();
        }
    }//GEN-LAST:event_jTableSanPhamKeyReleased

    private void jTableCongDoanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCongDoanKeyReleased
        // TODO add your handling code here:
        if (jTableCongDoan.isEnabled()) {
            if (jTableCongDoan.getSelectedRowCount() > 0) {
                jButtonXoa.setEnabled(true);
                jButtonSua.setEnabled(true);

                int selectedRow = jTableCongDoan.getSelectedRow();
                String maCD = (String) jTableCongDoan.getValueAt(selectedRow, 0);
                congDoan = DAO_CongDoan.getInstance().get(maCD);
                jTextFieldMaCD.setText(congDoan.getMaCD());
                jComboBoxMaBoPhan.setSelectedItem(congDoan.getMaBP());
                jTextFieldTenCD.setText(congDoan.getTenCD());
                jTextFieldDonGia.setText(String.format("%.0f", congDoan.getDonGia() / 1000));
                // String.format("%.0f", congDoan.getDonGia()/1000);
                jCheckBoxHoanThanh.setSelected(congDoan.isTrangThai());
                jTextFieldSLCBTT.setText(String.valueOf(congDoan.getSoLuongChuanBiToiThieu()));
                // loadDataJTableCongDoanTienQuyet(maCD);
                loadDataJTableCDTQ();
                loadDataJComboBoxCDTQ();
            }
        }
    }//GEN-LAST:event_jTableCongDoanKeyReleased

    private void jButtonNhapSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNhapSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNhapSoLuongActionPerformed

    private void jButtonNhapSoLuongMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNhapSoLuongMouseReleased
        if( jButtonNhapSoLuong.isEnabled() ) {
            if( !jButtonNhapSoLuong.getText().equals("Hủy") ) {
                jButtonNhapSoLuong.setText("Hủy");
                jButtonPhanCong.setEnabled(true); 
                jComboBoxBoPhan.setEnabled(false); 
                jComboBoxSanPham.setEnabled(false);
                jTableCongDoan1.setEnabled(false);
                jTableCongNhan.setEnabled(true);

                jTableCongNhan.editCellAt(0, 2); 
                Component editor = jTableCongNhan.getEditorComponent();
                if (editor instanceof JTextField) {
                    JTextField textField = (JTextField) editor;
                    textField.requestFocus();

                    // Đặt con trỏ chuột ở cuối cell
                    textField.setCaretPosition(textField.getText().length());
                }
                
            } else {
                jButtonNhapSoLuong.setText("Nhập số lượng");
                jButtonPhanCong.setEnabled(false); 
                jComboBoxBoPhan.setEnabled(true); 
                jComboBoxSanPham.setEnabled(true);
                jTableCongDoan1.setEnabled(true);
                jTableCongNhan.setEnabled(false);
                jTableCongNhan.removeEditor();
                jTableCongNhan.requestFocus();
                

                loadDsCongNhan();
            }  
        }
    }//GEN-LAST:event_jButtonNhapSoLuongMouseReleased

    private void jButtonPhanCongMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPhanCongMouseReleased
        // TODO add your handling code here:
        if(jButtonPhanCong.isEnabled()) {
            try {
                boolean have = false; 
                for (int i = 0; i < jTableCongNhan.getRowCount(); i++) {
                    String maCN = jTableCongNhan.getValueAt(i, 0).toString();
                    String sl = jTableCongNhan.getValueAt(i, 2).toString(); 
                    if(!sl.matches("\\d+")) 
                        continue; 
                    int soLuong = Integer.parseInt(sl);
                    if(soLuong <= 0) 
                        continue;
                    have = true;
                    System.out.println(soLuong + " " + soLuong);
                    String ngay = new SimpleDateFormat("ddMMyyyy").format(new Date());
                    String maCTPC = ngay + maCN;
                    String macd = jTableCongDoan1.getValueAt(jTableCongDoan1.getSelectedRow(), 0).toString();
                    DAO_ChiTietPhanCong.getInstance().insert(new ChiTietPhanCong(maCTPC, macd, maCN, LocalDate.now(), soLuong));
                    DAO_ChiTietPhanCong.getInstance().updateChoPhanCong(maCN, false);
                    
                }   
                if(!have) 
                    throw new Exception("Vui lòng nhập số lượng cho ít nhất một công nhân");
                loadDsCongNhan();
                loadDsCongDoan();
                loadDsCTPC(); 
                // cập nhật vào bảng phân công 

                jButtonNhapSoLuong.setText("Nhập số lượng");
                jButtonPhanCong.setEnabled(false); 
                jComboBoxBoPhan.setEnabled(true); 
                jComboBoxSanPham.setEnabled(true);
                jTableCongDoan1.setEnabled(true);
                jTableCongNhan.setEnabled(false);
                jTableCongNhan.removeEditor();
                jTableCongNhan.requestFocus();
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonPhanCongMouseReleased

    private void jTableCTPCMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCTPCMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableCTPCMouseReleased

    private void jCheckBoxHoanThanhMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jCheckBoxHoanThanhMouseReleased
        // TODO add your handling code here:
        // if( jCheckBoxHoanThanh.isEnabled() )
        // jCheckBoxHoanThanh.setSelected(jCheckBoxHoanThanh.isSelected());
    }// GEN-LAST:event_jCheckBoxHoanThanhMouseReleased

    private void jToggleButtonSortMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jToggleButtonSortMouseReleased
        // change the icon of this button

        if (jToggleButtonSort.isSelected())
            jToggleButtonSort
                    .setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/icons8-sort-50.png")));
        else
            jToggleButtonSort
                    .setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons/icons8-sort2-50.png")));
        loadDataJTableCongDoan();
    }// GEN-LAST:event_jToggleButtonSortMouseReleased
     // TODO add your handling code here:
     // TODO add your handling code here:

    private void jComboBoxMaHopDong1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxMaHopDong1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxMaHopDong1ActionPerformed

    private void jComboBoxSanPhamActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxMaHopDong2ActionPerformed
        // TODO add your handling code here:
        loadDsCongDoan();
    }// GEN-LAST:event_jComboBoxMaHopDong2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton9ActionPerformed

    private void jButtonPhanCongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton11ActionPerformed

    private void jComboBoxBoPhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxMaHopDong3ActionPerformed
        // TODO add your handling code here:
     
        loadDsCongDoan();
        loadDsCongNhan();
    }// GEN-LAST:event_jComboBoxMaHopDong3ActionPerformed

    private void jComboBoxMaHopDong4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxMaHopDong4ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxMaHopDong4ActionPerformed

    private void jComboBoxSapXep1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxSapXep1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxSapXep1ActionPerformed

    private void jTextFieldSLCBTTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldSLCBTTActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldSLCBTTActionPerformed

    private void jComboBoxSapXepActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxSapXepActionPerformed
        // TODO add your handling code here:
        loadDataJTableCongDoan();
    }// GEN-LAST:event_jComboBoxSapXepActionPerformed

    private void jTextFieldMaCDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldMaCDActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldMaCDActionPerformed

    private void jComboBoxMaHopDongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxMaHopDongActionPerformed
        // TODO add your handling code here:
        loadDsSanPham();
        jButtonTaoMoi.setEnabled(false);
    }// GEN-LAST:event_jComboBoxMaHopDongActionPerformed

    private void jButtonThemCDTQActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonThemCDTQActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonThemCDTQActionPerformed

    private void jComboBoxCDTQActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxCDTQActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxCDTQActionPerformed

    private void jButtonXoaCDTQActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonXoaCDTQActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonXoaCDTQActionPerformed

    private void jTextFieldDonGiaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldDonGiaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldDonGiaActionPerformed

    private void jComboBoxMaBoPhanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxMaBoPhanActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxMaBoPhanActionPerformed

    private void jButtonLuuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonLuuActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonLuuActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonXoaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSuaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonSuaActionPerformed

    private void jButtonTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonTaoMoiActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonTaoMoiActionPerformed

    private void jCheckBoxHoanThanhActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBoxHoanThanhActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jCheckBoxHoanThanhActionPerformed

    private void jTableSanPhamMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableSanPhamMouseReleased
        // get the data of col 0 and selected row
        if (jTableSanPham.isEnabled()) {
            int row = jTableSanPham.getSelectedRow();
            maSP = (String) jTableSanPham.getValueAt(row, 0);
            loadDataJTableCongDoan();
            loadDataJComboBoxCDTQ();
            jButtonTaoMoi.setEnabled(true);
            jButtonXoa.setEnabled(false);
            jButtonSua.setEnabled(false);
            jTableCongDoan.setEnabled(true);
            clearData();
        }
    }// GEN-LAST:event_jTableSanPhamMouseReleased

    private void loadDataJTableCongDoan() {
        dsCongDoan = DAO_CongDoan.getInstance().getAllByMaSP(maSP);
        DefaultTableModel model = (DefaultTableModel) jTableCongDoan.getModel();
        model.setRowCount(0);
        int sapXepTheo = jComboBoxSapXep.getSelectedIndex();
        boolean tangDan = !jToggleButtonSort.isSelected();
        // sap xep dsCongDoan
        // Sort dsCongDoan based on sapXepTheo and tangDan
        Collections.sort(dsCongDoan, new Comparator<CongDoan>() {
            @Override
            public int compare(CongDoan cd1, CongDoan cd2) {
                // Compare based on sapXepTheo and tangDan
                // Modify the comparison logic based on your requirements
                if (sapXepTheo == 0) {
                    // Sort by maCD
                    if (tangDan) {
                        return cd1.getMaCD().compareTo(cd2.getMaCD());
                    } else {
                        return cd2.getMaCD().compareTo(cd1.getMaCD());
                    }
                } else if (sapXepTheo == 1) {
                    // Sort by tenCD
                    if (tangDan) {
                        return cd1.getTenCD().compareTo(cd2.getTenCD());
                    } else {
                        return cd2.getTenCD().compareTo(cd1.getTenCD());
                    }
                } else if (sapXepTheo == 2) {
                    // Sort by donGia
                    if (tangDan) {
                        return Double.compare(cd1.getDonGia(), cd2.getDonGia());
                    } else {
                        return Double.compare(cd2.getDonGia(), cd1.getDonGia());
                    }
                } else if (sapXepTheo == 3) {
                    // sorting by maBP
                    if (tangDan) {
                        return cd1.getMaBP().compareTo(cd2.getMaBP());
                    } else {
                        return cd2.getMaBP().compareTo(cd1.getMaBP());
                    }
                } else if (sapXepTheo == 4) {
                    // sorting by maSP
                    if (tangDan) {
                        return cd1.getMaSP().compareTo(cd2.getMaSP());
                    } else {
                        return cd2.getMaSP().compareTo(cd1.getMaSP());
                    }
                } else if (sapXepTheo == 5) {
                    // sorting by trangThai
                    if (tangDan) {
                        return Boolean.compare(cd1.isTrangThai(), cd2.isTrangThai());
                    } else {
                        return Boolean.compare(cd2.isTrangThai(), cd1.isTrangThai());
                    }
                } else if (sapXepTheo == 6) {
                    // sorting by soLuongChuanBiToiThieu
                    if (tangDan) {
                        return Integer.compare(cd1.getSoLuongChuanBiToiThieu(), cd2.getSoLuongChuanBiToiThieu());
                    } else {
                        return Integer.compare(cd2.getSoLuongChuanBiToiThieu(), cd1.getSoLuongChuanBiToiThieu());
                    }
                } else if (sapXepTheo == 7) {
                    // sorting by soLuongChuanBi
                    if (tangDan) {
                        return Integer.compare(cd1.getSoLuongChuanBi(), cd2.getSoLuongChuanBi());
                    } else {
                        return Integer.compare(cd2.getSoLuongChuanBi(), cd1.getSoLuongChuanBi());
                    }
                } else if (sapXepTheo == 8) {
                    // sorting by soLuongHoanThanh
                    if (tangDan) {
                        return Integer.compare(cd1.getSoLuongHoanThanh(), cd2.getSoLuongHoanThanh());
                    } else {
                        return Integer.compare(cd2.getSoLuongHoanThanh(), cd1.getSoLuongHoanThanh());
                    }
                } else {
                    // Default sorting
                    if (tangDan) {
                        return cd1.getMaCD().compareTo(cd2.getMaCD());
                    } else {
                        return cd2.getMaCD().compareTo(cd1.getMaCD());
                    }
                }
            }
        });
        for (CongDoan cd : dsCongDoan) {
            model.addRow(new Object[] { cd.getMaCD(), cd.getTenCD(), cd.getDonGia(), cd.getMaBP(), cd.getMaSP(),
                    cd.isTrangThai(), cd.getSoLuongChuanBiToiThieu(), cd.getSoLuongChuanBi(),
                    cd.getSoLuongHoanThanh() });

        }

        model.fireTableDataChanged();
    }

    private void loadDataJTableCDTQ() {
        if (congDoan != null) {
            ArrayList<String> dsCDTQ = congDoan.getDsCDTQ();
            DefaultTableModel model = (DefaultTableModel) jTableCDTQ.getModel();
            model.setRowCount(0);
            for (String maCDTQ : dsCDTQ) {
                model.addRow(new Object[] { maCDTQ, DAO_CongDoan.getInstance().get(maCDTQ).getTenCD() });
            }
            model.fireTableDataChanged();
        }
    }

    private void loadDataJComboBoxCDTQ() {
        // Lấy ra công đoạn con cháu cua congDoan hien tai
        ArrayList<CongDoan> dsCha = new ArrayList<CongDoan>();
        ArrayList<CongDoan> dsCon = new ArrayList<CongDoan>();
        ArrayList<CongDoan> dsCDTQTrongTable = new ArrayList<CongDoan>();

        if (congDoan != null) {
            dsCha.add(congDoan);
            dsCon.add(congDoan);
            while (!dsCha.isEmpty()) {
                CongDoan cd = dsCha.get(0);
                dsCha.remove(0);
                for (String macdhq : DAO_CongDoan.getInstance().getDsCDHQ(cd.getMaCD())) {
                    CongDoan cdhq = DAO_CongDoan.getInstance().get(macdhq);
                    dsCon.add(cdhq);
                    dsCha.add(cdhq);
                }
            }
        }

        for (int i = 0; i < jTableCDTQ.getRowCount(); i++) {
            String maCD = (String) jTableCDTQ.getValueAt(i, 0);
            dsCDTQTrongTable.add(DAO_CongDoan.getInstance().get(maCD));
        }

        jComboBoxCDTQ.removeAllItems();
        for (CongDoan cd : dsCongDoan) {
            if (dsCDTQTrongTable.contains(cd) || dsCon.contains(cd))
                continue;
            jComboBoxCDTQ.addItem(cd.getMaCD().substring(cd.getMaCD().length() - 2) + ". " + cd.getTenCD());
        }

        if (jComboBoxCDTQ.getItemCount() > 0) {
            jComboBoxCDTQ.setSelectedIndex(0);
            jButtonThemCDTQ.setEnabled(jButtonLuu.isEnabled());
        } else {
            jButtonThemCDTQ.setEnabled(false);
        }

    }

    private void AfterSaveOrCancel() {
        if (!jButtonSua.isEnabled())
            clearData();
        jTableSanPham.setEnabled(true);
        jTableCongDoan.setEnabled(true);
        jComboBoxMaHopDong.setEnabled(true);
        jButtonTaoMoi.setEnabled(true);
        jButtonTaoMoi.setText("Tạo mới");
        jButtonSua.setText("Sửa");
        jButtonThemCDTQ.setEnabled(false);
        jButtonLuu.setEnabled(false);
        jButtonSua.setEnabled(false);
        jButtonXoaCDTQ.setEnabled(false);
        jTextFieldTenCD.setEditable(false);
        jTextFieldDonGia.setEditable(false);
        jComboBoxMaBoPhan.setEnabled(false);
        jTextFieldSLCBTT.setEditable(false);
        jComboBoxCDTQ.setEnabled(false);
        jCheckBoxHoanThanh.setEnabled(false);
        jTableCDTQ.setEnabled(false);
        loadDataJComboBoxCDTQ();
    }

    private void editting() {
        jButtonLuu.setEnabled(true);
        jButtonThemCDTQ.setEnabled(true);
        jTextFieldTenCD.setEditable(true);
        jTextFieldDonGia.setEditable(true);
        jComboBoxMaBoPhan.setEnabled(true);
        jTextFieldSLCBTT.setEditable(true);
        jComboBoxCDTQ.setEnabled(true);
        jTableCDTQ.setEnabled(true);
        jTableCongDoan.setEnabled(false);
        jTableSanPham.setEnabled(false);
    }

    private void jButtonTaoMoiMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButtonTaoMoiMouseReleased
        if (jButtonTaoMoi.isEnabled()) {
            if (!jButtonTaoMoi.getText().equals("Hủy")) {
                clearData();
                DAO_CongDoan dao = DAO_CongDoan.getInstance();
                String lastMaCD = dao.getLastMaCD(maSP);
                // create new MaCD from lastMaCD, Increase the last 2 characters by 1 unit
                // example xxxx01 to xxxx02, xxxx11 to xxxx12
                String newMaCD = lastMaCD.substring(0, lastMaCD.length() - 2);
                int lastTwoDigits = Integer.parseInt(lastMaCD.substring(lastMaCD.length() - 2));
                lastTwoDigits++;
                String paddedLastTwoDigits = String.format("%02d", lastTwoDigits);
                newMaCD = newMaCD + paddedLastTwoDigits;
                jTableSanPham.setEnabled(false);
                jTableCongDoan.setEnabled(false);
                jComboBoxMaHopDong.setEnabled(false);
                jTextFieldMaCD.setText(newMaCD);
                jButtonTaoMoi.setText("Hủy");
                jButtonSua.setEnabled(false);
                jButtonXoa.setEnabled(false);
                editting();
            }

            else {
                AfterSaveOrCancel();
            }
        }
    }// GEN-LAST:event_jButtonTaoMoiMouseReleased

    private void jButtonThemCDTQMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButtonThemCDTQMouseReleased
        // TODO add your handling code here:
        if (jButtonThemCDTQ.isEnabled()) {
            // click sẽ thêm công đoạn tiên quyết đã chọn ở jcombox vào bảng cdtq
            String selectedCongDoan = jComboBoxCDTQ.getSelectedItem().toString();
            DefaultTableModel model = (DefaultTableModel) jTableCDTQ.getModel();

            // hãy lấy 2 ký tự đầu tiên của selectedCongDoan
            String firstTwoCharacters = selectedCongDoan.substring(0, 2);
            // Tìm kiếm trong dsCongDoan xem CongDoan nào có maCD với 2 ký tự cuối giống với
            // 2 ký tự ở trên, thì thêm công đoạn này vào jTableCDTQ
            for (CongDoan congDoan : dsCongDoan) {
                String maCD = congDoan.getMaCD();
                if (maCD.substring(maCD.length() - 2).equals(firstTwoCharacters)) {
                    Object[] rowData = { congDoan.getMaCD(), congDoan.getTenCD() };
                    model.addRow(rowData);
                }
            }
            loadDataJComboBoxCDTQ();
        }
    }// GEN-LAST:event_jButtonThemCDTQMouseReleased

    private void jTableCDTQMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableCDTQMouseReleased
        // TODO add your handling code here:
        if (jTableCDTQ.isEnabled()) {
            if (jTableCDTQ.getSelectedRowCount() >= 0)
                jButtonXoaCDTQ.setEnabled(true);
        }
    }// GEN-LAST:event_jTableCDTQMouseReleased

    private void jButtonXoaCDTQMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButtonXoaCDTQMouseReleased
        // TODO add your handling code here:
        if (jButtonXoaCDTQ.isEnabled()) {
            // getSeclect Row of jTableCDTQ
            // TODO add your handling code here: getSelected Row of jTableCDTQ
            int selectedRow = jTableCDTQ.getSelectedRow();
            if (selectedRow >= 0) {
                // delete this row from jTableCDTQ
                DefaultTableModel model = (DefaultTableModel) jTableCDTQ.getModel();
                model.removeRow(selectedRow);
                model.fireTableDataChanged();
                loadDataJComboBoxCDTQ();
            }
            jButtonXoaCDTQ.setEnabled(false);
        }
    }// GEN-LAST:event_jButtonXoaCDTQMouseReleased

    private void jButtonLuuMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButtonLuuMouseReleased
        // TODO add your handling code here:
        if (jButtonLuu.isEnabled()) {
            // tạo một của sở confirm
            // Create a confirmation dialog
            String maCD = "", maSP1 = "", maBP = "", tenCD = "";
            double donGia = 0;
            int soLuongChuanBiToiThieu = 0;
            boolean trangThai = false;
            try {
                maCD = jTextFieldMaCD.getText();
                maSP1 = maSP;
                maBP = jComboBoxMaBoPhan.getSelectedItem().toString();
                tenCD = jTextFieldTenCD.getText();
                if (tenCD.isBlank())
                    throw new Exception("Tên công đoạn không được để trống");
                try {
                    donGia = Double.parseDouble(jTextFieldDonGia.getText()) * 1000;
                } catch (Exception e) {
                    throw new Exception("Giá trị đơn giá phải là số không âm");
                }
                trangThai = jCheckBoxHoanThanh.isSelected();
                try {
                    soLuongChuanBiToiThieu = Integer.parseInt(jTextFieldSLCBTT.getText());
                    if (soLuongChuanBiToiThieu < 0)
                        throw new Exception("Giá trị số lượng phải là số không âm");
                } catch (Exception e) {
                    // TODO: handle exception
                    throw new Exception("Giá trị số lượng phải là số không âm");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "Bạn đã chắc chắn chưa ?", "Confirmation",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {

                ArrayList<String> dsCDTQ = new ArrayList<String>();
                for (int i = 0; i < jTableCDTQ.getRowCount(); i++) {
                    String maCDTQ = (String) jTableCDTQ.getValueAt(i, 0);
                    dsCDTQ.add(maCDTQ);
                }
                CongDoan congDoan = new CongDoan(maCD, maSP1, maBP, tenCD, donGia, trangThai, soLuongChuanBiToiThieu,
                        dsCDTQ);
                DAO_CongDoan dao = DAO_CongDoan.getInstance();
                if (jButtonTaoMoi.getText().equals("Hủy"))
                    dao.insert(congDoan);
                else
                    dao.update(congDoan);
                // update the JComboBox for dsCongDoanTienQuyet
                loadDataJTableCongDoan();
                loadDataJComboBoxCDTQ();
                AfterSaveOrCancel();
            }
        }
    }// GEN-LAST:event_jButtonLuuMouseReleased

    private void jTextFieldTenCDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldTenCDActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldTenCDActionPerformed

    private void jTableCongDoanMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableCongDoanMouseReleased
        if (jTableCongDoan.isEnabled()) {
            if (jTableCongDoan.getSelectedRowCount() > 0) {
                jButtonXoa.setEnabled(true);
                jButtonSua.setEnabled(true);

                int selectedRow = jTableCongDoan.getSelectedRow();
                String maCD = (String) jTableCongDoan.getValueAt(selectedRow, 0);
                congDoan = DAO_CongDoan.getInstance().get(maCD);
                jTextFieldMaCD.setText(congDoan.getMaCD());
                jComboBoxMaBoPhan.setSelectedItem(congDoan.getMaBP());
                jTextFieldTenCD.setText(congDoan.getTenCD());
                jTextFieldDonGia.setText(String.format("%.0f", congDoan.getDonGia() / 1000));
                // String.format("%.0f", congDoan.getDonGia()/1000);
                jCheckBoxHoanThanh.setSelected(congDoan.isTrangThai());
                jTextFieldSLCBTT.setText(String.valueOf(congDoan.getSoLuongChuanBiToiThieu()));
                // loadDataJTableCongDoanTienQuyet(maCD);
                loadDataJTableCDTQ();
                loadDataJComboBoxCDTQ();
            }
        }
    }// GEN-LAST:event_jTableCongDoanMouseReleased

    private void jButtonXoaMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButtonXoaMouseReleased
        // TODO add your handling code here:
        if (jButtonXoa.isEnabled()) {
            int selectedRow = jTableCongDoan.getSelectedRow();
            if (selectedRow != -1) {
                String maCD = jTableCongDoan.getValueAt(selectedRow, 0).toString();
                CongDoan cd = DAO_CongDoan.getInstance().get(maCD);
                JFrame confirmationFrame = new JFrame();
                String message = "Bạn chắc chắn muốn xóa công đoạn " + cd.getMaCD() + " ?";
                int option = JOptionPane.showConfirmDialog(confirmationFrame, message, "Xác nhận xóa",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Delete the CongDoan and update the table
                    DAO_CongDoan.getInstance().deleteById(maCD);
                    loadDataJTableCongDoan();
                    AfterSaveOrCancel();
                    jButtonXoa.setEnabled(false);
                    jButtonSua.setEnabled(false);
                    jButtonTaoMoi.setEnabled(true);
                    clearData();
                }
            }
        }
    }// GEN-LAST:event_jButtonXoaMouseReleased

    private void jButtonSuaMouseReleased(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jButtonSuaMouseReleased
        // TODO add your handling code here:
        if (jButtonSua.isEnabled()) {
            if (!jButtonSua.getText().equals("Hủy")) {
                jButtonSua.setText("Hủy");
                jButtonXoa.setEnabled(false);
                jButtonLuu.setEnabled(true);
                jCheckBoxHoanThanh.setEnabled(true);
                jButtonTaoMoi.setEnabled(false);
                editting();
            } else {
                jButtonSua.setText("Sửa");
                AfterSaveOrCancel();
                jButtonXoa.setEnabled(true);
                jButtonSua.setEnabled(true);
                jButtonLuu.setEnabled(false);
                jButtonTaoMoi.setEnabled(true);
            }
        }
    }// GEN-LAST:event_jButtonSuaMouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonLuu;
    private javax.swing.JButton jButtonNhapSoLuong;
    private javax.swing.JButton jButtonPhanCong;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonTaoMoi;
    private javax.swing.JButton jButtonThemCDTQ;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JButton jButtonXoaCDTQ;
    private javax.swing.JCheckBox jCheckBoxHoanThanh;
    private javax.swing.JComboBox<String> jComboBoxBoPhan;
    private javax.swing.JComboBox<String> jComboBoxCDTQ;
    private javax.swing.JComboBox<String> jComboBoxMaBoPhan;
    private javax.swing.JComboBox<String> jComboBoxMaHopDong;
    private javax.swing.JComboBox<String> jComboBoxMaHopDong1;
    private javax.swing.JComboBox<String> jComboBoxMaHopDong4;
    private javax.swing.JComboBox<String> jComboBoxSanPham;
    private javax.swing.JComboBox<String> jComboBoxSapXep;
    private javax.swing.JComboBox<String> jComboBoxSapXep1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCDTQ;
    private javax.swing.JTable jTableCTPC;
    private javax.swing.JTable jTableCongDoan;
    private javax.swing.JTable jTableCongDoan1;
    private javax.swing.JTable jTableCongNhan;
    private javax.swing.JTable jTableSanPham;
    private javax.swing.JTextField jTextFieldDonGia;
    private javax.swing.JTextField jTextFieldMaCD;
    private javax.swing.JTextField jTextFieldSLCBTT;
    private javax.swing.JTextField jTextFieldTenCD;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButtonSort;
    // End of variables declaration//GEN-END:variables
}
