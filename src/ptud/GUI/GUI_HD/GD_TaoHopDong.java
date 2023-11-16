/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ptud.GUI.GUI_HD;

import java.awt.CardLayout;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ptud.DAO.DAO_HopDong;
import ptud.DAO.DAO_KhachHang;
import ptud.DAO.DAO_SanPham;
import ptud.Entity.HopDong;
import ptud.Entity.KhachHang;
import ptud.Entity.SanPham;
import ptud.GUI.GD_QLHD;

/**
 *
 * @author vohau
 */
public class GD_TaoHopDong extends javax.swing.JPanel {

    DAO_HopDong daohd = new DAO_HopDong();
    DAO_SanPham daosp = new DAO_SanPham();
    DAO_KhachHang daokh = new DAO_KhachHang();
    GD_QLHD gd_QLHD;
    DefaultTableModel modelSanPham;
    HopDong hopDong;

    /**
     * Creates new form GD_TaoHopDong
     */
    public GD_TaoHopDong() {
        initComponents();
        cardLayout = (CardLayout) body_body_2.getLayout();
        modelSanPham = (DefaultTableModel) jTable1.getModel();
        addListKH();
    }
    public void addListKH()
    {
        jComboBox1.removeAllItems();
        for(KhachHang khachHang : daokh.getAll())
        {
            jComboBox1.addItem(khachHang.getMaKhachHang());
        }
    }
    public void receiveGD_QLHD(GD_QLHD gd_qlhd) {
        gd_QLHD = gd_qlhd;
    }

    void createKhachHang() {
        try {
            boolean isCreate = true;
            if (!checkRegex("[A-Z]{1}", jTextFieldTenKH.getText())) {
                jLabel21.setText("Chữ cái đầu phải viết hoa");
                isCreate = false;
            }
            if (!checkRegex("^([a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6})*$", jTextFieldMail.getText())) {
                jLabel22.setText("email phải thuộc định dạng a@example.c");
                isCreate = false;
            }
            if (!checkRegex("^[0-9]{10}$", jTextFieldSDT.getText())) {
                jLabel23.setText("số điện thoại gồm 10 số");
                isCreate = false;
            }
            if (isCreate == true) {
                String tenKH, email, sdt;
                tenKH = jTextFieldTenKH.getText();
                sdt = jTextFieldSDT.getText();
                email = jTextFieldMail.getText();
                KhachHang khachHang = new KhachHang(daokh.getAll().size() + 1, tenKH, jRadioButtonToChuc.isEnabled(), email, sdt);
                daokh.insert(khachHang);
                gd_QLHD.updateTable();
                addListKH();
            }
        } catch (Exception e) {

        }
    }

    void insertSanPhamToDatabase() {

        for (int i = 0; i < modelSanPham.getRowCount(); i++) {
            Object[] objects = new Object[3];
            objects[0] = modelSanPham.getValueAt(i, 0);
            objects[1] = modelSanPham.getValueAt(i, 1);
            objects[2] = modelSanPham.getValueAt(i, 2);
            changeObjectToEnity(objects, i);
        }
    }

    void createSanPham() {
        try {
            double donGia;
            int soLuong = Integer.parseInt(jTextField8.getText());
            donGia = Double.parseDouble(jTextField9.getText());
            boolean isCreate = true;
            if (!checkRegex("^[A-Z]{1}", jTextField7.getText())) {
                jLabel15.setText("Chữ cái đầu phải viết hoa");
                isCreate = false;
            }
            if (donGia <= 0) {
                jLabel16.setText("Gía trị tài khoản phải là số không âm!");
                isCreate = false;
            }
            if (soLuong <= 0) {
                jLabel17.setText("Gía trị tài khoản phải là số không âm!");
                isCreate = false;
            }
            if (isCreate == true) {
                try {

                    changeEnityToObject();

                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(this, "Lỗi tạo hợp đồng!");
                }
            }
        } catch (Exception e) {
            jLabel16.setText("Gía trị tài khoản phải là số không âm!");
            jLabel17.setText("Gía trị tài khoản phải là số không âm!");
        }
    }

    public boolean checkRegex(String pattern, String input) {
        Pattern patternCore = Pattern.compile(pattern);
        Matcher matcher = patternCore.matcher(input);
        boolean matchFound = matcher.find();
        return matchFound;
    }

    
    void changeEnityToObject() {
        String tenSP = jTextField7.getText();
        double donGia;
        int soLuong = Integer.parseInt(jTextField8.getText());
        donGia = Double.parseDouble(jTextField9.getText());
        Object[] rowData = new Object[3];
        rowData[0] = tenSP;
        rowData[1] = soLuong;
        rowData[2] = donGia;
        modelSanPham.addRow(rowData);
    }
void createHopDong() {
        try {
            boolean isCreate = true;
            double giaTri = Double.parseDouble(jTextFieldGiaHD.getText());
            // chu cai dau tenSP viet Hoa
            if (!checkRegex("^[A-Z]{1}", jTextFieldTenHD.getText())) {
                err_tenHD.setText("Chữ cái đầu phải viết hoa");
                isCreate = false;
            }
        
            if (giaTri <= 0) {
                err_TriGiaHD.setText("Gía trị tài khoản phải là số không âm!");
                isCreate = false;
            }
            LocalDate ngayBD = LocalDate.ofInstant(jDateChooser3.getCalendar().toInstant(), ZoneId.systemDefault());
            LocalDate ngayKT = LocalDate.ofInstant(jDateChooser4.getCalendar().toInstant(), ZoneId.systemDefault());
            if (!((ngayBD.isBefore(ngayKT))&&((ngayBD.isBefore(LocalDate.now()))||ngayBD.isEqual(LocalDate.now())))) {
                JOptionPane.showMessageDialog(jDateChooser3, "Ngày bắt đầu phải trước ngày kết thúc!");
                isCreate = false;
            }
            if (isCreate == true) {

                try {

                    String tenHD = jTextFieldTenHD.getText();

                    int stt = 1;
                    for (HopDong hopDong : daohd.getAll()) {
                        if (hopDong.getNgayBatDau().equals(ngayBD)) {
                            stt++;
                        }
                    }
                    hopDong = new HopDong(stt, tenHD, ngayBD, ngayKT, giaTri, jComboBox1.getSelectedItem().toString(), "Chờ xác nhận");
                    daohd.insert(hopDong);
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(this, "Lỗi tạo hợp đồng!");
                }
            }
        } catch (NumberFormatException e) 
        {
            err_TriGiaHD.setText("Gía trị tài khoản phải là số không âm!");
        }
    }

    void resetTextField() {
        err_maKH.setText("");
        err_tenHD.setText("");
        err_TriGiaHD.setText("");
    }



    void changeObjectToEnity(Object[] rowData, int stt) {
        double donGia;
        int soLuong = Integer.parseInt(rowData[1].toString());
        donGia = Double.parseDouble(rowData[2].toString());
        String tenSP = rowData[0].toString();
        SanPham sanPham = new SanPham(stt, tenSP, soLuong, donGia, hopDong.getMaHD());
        daosp.insert(sanPham);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jPanel2 = new javax.swing.JPanel();
        jMenu1 = new javax.swing.JMenu();
        body = new javax.swing.JPanel();
        heading = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldTenHD = new javax.swing.JTextField();
        jTextFieldGiaHD = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        err_tenHD = new javax.swing.JLabel();
        err_maKH = new javax.swing.JLabel();
        err_nBD = new javax.swing.JLabel();
        errnKT = new javax.swing.JLabel();
        err_TriGiaHD = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        body_1 = new javax.swing.JPanel();
        heading_body_1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        body_body_2 = new javax.swing.JPanel();
        panelThemSanPham = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        panelTaoKhachHang = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldTenKH = new javax.swing.JTextField();
        jTextFieldSDT = new javax.swing.JTextField();
        jTextFieldMail = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jRadioButtonToChuc = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();

        jPanel8.setPreferredSize(new java.awt.Dimension(379, 50));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        body.setBackground(new java.awt.Color(255, 255, 255));

        heading.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tên Hợp Đồng");

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Ngày bắt đầu");

        jLabel4.setText("Ngày kết thúc");

        jLabel5.setText("Trị giá hợp đồng");

        jTextFieldTenHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenHDActionPerformed(evt);
            }
        });

        jTextFieldGiaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGiaHDActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(225, 240, 221));
        jPanel7.setPreferredSize(new java.awt.Dimension(0, 50));

        jLabel7.setBackground(new java.awt.Color(0, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TẠO HỢP ĐỒNG");
        jLabel7.setToolTipText("");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setMaximumSize(new java.awt.Dimension(157, 50));
        jLabel7.setMinimumSize(new java.awt.Dimension(157, 50));
        jLabel7.setPreferredSize(new java.awt.Dimension(157, 50));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDateChooser3.setMaxSelectableDate(new java.util.Date(253370743294000L));

        err_tenHD.setBackground(new java.awt.Color(255, 0, 0));
        err_tenHD.setForeground(new java.awt.Color(255, 0, 0));

        err_maKH.setBackground(new java.awt.Color(255, 0, 51));
        err_maKH.setForeground(new java.awt.Color(255, 0, 0));

        err_nBD.setBackground(new java.awt.Color(255, 0, 51));
        err_nBD.setForeground(new java.awt.Color(255, 0, 0));

        errnKT.setForeground(new java.awt.Color(255, 0, 0));

        err_TriGiaHD.setForeground(new java.awt.Color(255, 0, 0));

        jButton7.setBackground(new java.awt.Color(198, 222, 192));
        jButton7.setText("Tạo khách Hàng");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headingLayout = new javax.swing.GroupLayout(heading);
        heading.setLayout(headingLayout);
        headingLayout.setHorizontalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(err_tenHD))
            .addGroup(headingLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(err_TriGiaHD))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
            .addGroup(headingLayout.createSequentialGroup()
                .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(headingLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(err_nBD))
                    .addGroup(headingLayout.createSequentialGroup()
                        .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(headingLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7))
                            .addGroup(headingLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(headingLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldGiaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(headingLayout.createSequentialGroup()
                                        .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headingLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(err_maKH))
                                            .addGroup(headingLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jDateChooser4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldTenHD, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                        .addGap(18, 18, 18)))
                .addGap(39, 39, 39)
                .addComponent(errnKT))
        );
        headingLayout.setVerticalGroup(
            headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headingLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTenHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(err_tenHD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(err_maKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(headingLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(headingLayout.createSequentialGroup()
                                .addComponent(err_nBD)
                                .addGap(22, 22, 22))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(headingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(headingLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(errnKT))
                            .addComponent(jTextFieldGiaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(err_TriGiaHD)
                .addContainerGap())
        );

        body_1.setBackground(new java.awt.Color(255, 255, 255));

        heading_body_1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setBackground(new java.awt.Color(225, 240, 221));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        body_body_2.setBackground(new java.awt.Color(255, 255, 255));
        body_body_2.setLayout(new java.awt.CardLayout());

        panelThemSanPham.setBackground(new java.awt.Color(255, 255, 255));

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel9.setText("Tên sản phẩm");

        jLabel10.setText("Số lượng");

        jLabel11.setText("Đơn giá");

        jButton3.setBackground(new java.awt.Color(198, 222, 192));
        jButton3.setText("Xác nhận");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(198, 222, 192));
        jButton4.setText("Hủy");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(198, 222, 192));
        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(198, 222, 192));
        jButton1.setText("Xác Nhận ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("THÊM SẢN PHẨM");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 0));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 0, 0));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelThemSanPhamLayout = new javax.swing.GroupLayout(panelThemSanPham);
        panelThemSanPham.setLayout(panelThemSanPhamLayout);
        panelThemSanPhamLayout.setHorizontalGroup(
            panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelThemSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelThemSanPhamLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelThemSanPhamLayout.createSequentialGroup()
                        .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                                        .addComponent(jButton3)
                                        .addGap(30, 30, 30)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jTextField7)
                                    .addComponent(jTextField8)
                                    .addComponent(jTextField9))
                                .addGap(56, 56, 56))
                            .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(85, 85, 85))
        );
        panelThemSanPhamLayout.setVerticalGroup(
            panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(18, 80, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(27, 27, 27)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(325, 325, 325))
        );

        body_body_2.add(panelThemSanPham, "taoSP");

        panelTaoKhachHang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Tên Khách Hàng");

        jLabel12.setText("Email");

        jLabel13.setText("Số điện thoại");

        jLabel14.setText("Tổ chức");

        jTextFieldTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenKHActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(198, 222, 192));
        jButton5.setText("Tạo khách hàng");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(198, 222, 192));
        jButton6.setText("hủy");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jRadioButtonToChuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonToChucActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(255, 0, 0));

        jLabel19.setForeground(new java.awt.Color(255, 0, 0));

        jLabel20.setForeground(new java.awt.Color(255, 0, 0));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 0, 0));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelTaoKhachHangLayout = new javax.swing.GroupLayout(panelTaoKhachHang);
        panelTaoKhachHang.setLayout(panelTaoKhachHangLayout);
        panelTaoKhachHangLayout.setHorizontalGroup(
            panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTaoKhachHangLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTaoKhachHangLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelTaoKhachHangLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTaoKhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelTaoKhachHangLayout.createSequentialGroup()
                                .addGroup(panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel6)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldMail, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                        .addComponent(jRadioButtonToChuc, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldSDT)
                                        .addComponent(jTextFieldTenKH))
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelTaoKhachHangLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21)
                                .addGap(340, 340, 340))))))
        );
        panelTaoKhachHangLayout.setVerticalGroup(
            panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTaoKhachHangLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jRadioButtonToChuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTaoKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(365, Short.MAX_VALUE))
        );

        body_body_2.add(panelTaoKhachHang, "taoKH");

        javax.swing.GroupLayout heading_body_1Layout = new javax.swing.GroupLayout(heading_body_1);
        heading_body_1.setLayout(heading_body_1Layout);
        heading_body_1Layout.setHorizontalGroup(
            heading_body_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heading_body_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(heading_body_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(body_body_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 427, Short.MAX_VALUE)
                    .addGroup(heading_body_1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        heading_body_1Layout.setVerticalGroup(
            heading_body_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, heading_body_1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body_body_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout body_1Layout = new javax.swing.GroupLayout(body_1);
        body_1.setLayout(body_1Layout);
        body_1Layout.setHorizontalGroup(
            body_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(body_1Layout.createSequentialGroup()
                .addComponent(heading_body_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        body_1Layout.setVerticalGroup(
            body_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(heading_body_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addGroup(bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(body_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(body, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetTextField();
        createHopDong();
        insertSanPhamToDatabase();// TODO add your handling code here:
        gd_QLHD.updateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextFieldTenHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenHDActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        createSanPham();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenKHActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        cardLayout.show(body_body_2, "taoKH");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jRadioButtonToChucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonToChucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonToChucActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        cardLayout.show(body_body_2, "taoSP");        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextFieldGiaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGiaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGiaHDActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jLabel21.setText("");
        jLabel22.setText("");
        jLabel23.setText("");
        createKhachHang();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    CardLayout cardLayout;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JPanel body_1;
    private javax.swing.JPanel body_body_2;
    private javax.swing.JLabel err_TriGiaHD;
    private javax.swing.JLabel err_maKH;
    private javax.swing.JLabel err_nBD;
    private javax.swing.JLabel err_tenHD;
    private javax.swing.JLabel errnKT;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JPanel heading;
    private javax.swing.JPanel heading_body_1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButtonToChuc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldGiaHD;
    private javax.swing.JTextField jTextFieldMail;
    private javax.swing.JTextField jTextFieldSDT;
    private javax.swing.JTextField jTextFieldTenHD;
    private javax.swing.JTextField jTextFieldTenKH;
    private javax.swing.JPanel panelTaoKhachHang;
    private javax.swing.JPanel panelThemSanPham;
    // End of variables declaration//GEN-END:variables
}
