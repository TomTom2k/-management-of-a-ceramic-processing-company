/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ptud.GUI.GUI_HD;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ptud.DAO.DAOInterface;
import ptud.DAO.DAO_HopDong;
import ptud.Entity.HopDong;
import ptud.Entity.SanPham;
import ptud.GUI.GD_QLHD;

/**
 *
 * @author vohau
 */
public class GD_ChiTietHopDong extends javax.swing.JPanel {

    HopDong hopDong;
    DefaultTableModel sanPhamModel;
    DAO_HopDong daohd = new DAO_HopDong();
    GD_QLHD gD_QLHD;

    
    /**
     * Creates new form GD_ChiTietHopDong
     */
    public GD_ChiTietHopDong() {
        initComponents();
        tienDoSanPhamTable.getColumnModel().getColumn(1).setCellRenderer(new TienDoTableCellRender());
        sanPhamModel = (DefaultTableModel)sanPhamTable.getModel();
      
    }
    void changeEnityToObject(SanPham sanPham)
    {
        Object[] rowData = new Object[4];
        rowData[0] = sanPham.getMaSanPham();
        rowData[1] = sanPham.getTenSanPham();
        rowData[2] = sanPham.getSoLuong();
        rowData[3] = sanPham.getDonGia();
        sanPhamModel.addRow(rowData);         
    }
    public void receiveHopDong(HopDong hopDong1,GD_QLHD gD_QLHD)
    {
         hopDong = hopDong1;
         updateData();
         this.gD_QLHD = gD_QLHD;
         updateTable();
    }
    public void updateData()
    {
        maHDTextField.setText(hopDong.getMaHD());
        tenHDmaHDTextField.setText(hopDong.getTenHD());
        triGiamaHDTextField.setText(hopDong.getDonGiaString());
        trangThaimaHDTextField.setText(hopDong.getTrangThai());
        ngayBDmaHDTextField.setText(hopDong.getNgayBatDauString());   
        ngayKTmaHDTextField.setText(hopDong.getNgayKetThucString());
        maKHmaHDTextField.setText(hopDong.getMaKH());
    }
    public void thayDoiTrangThaiHopDong(String trangThai)
    {      
            hopDong.setTrangThai(trangThai);
            if(!daohd.update(hopDong))
            {
                JOptionPane.showConfirmDialog(this, "Xác nhận thất bại,vui lòng thử lại sau ít phút!");
            }
    }
    void updateTable()
    {     
        deleleTable();
        filHopDongTable();   
    }
    int deleleTable()
    {
        int rowIndex = sanPhamModel.getRowCount();
        for(int i = 0; i< rowIndex;i++)
        {
            if(sanPhamModel.getRowCount()==0)
            {
                return 1;
            }
            else
            {
              sanPhamModel.removeRow(0);
            }          
        }
        return 0;
    }
    void filHopDongTable()
    {
        hopDong.updateListSanPham();
       for(SanPham sanPham :hopDong.getSanPhams())
       {
           changeEnityToObject(sanPham);
       }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Body = new javax.swing.JPanel();
        header_body = new javax.swing.JPanel();
        header_header_body = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        maHDTextField = new javax.swing.JTextField();
        tenHDmaHDTextField = new javax.swing.JTextField();
        ngayBDmaHDTextField = new javax.swing.JTextField();
        ngayKTmaHDTextField = new javax.swing.JTextField();
        triGiamaHDTextField = new javax.swing.JTextField();
        maKHmaHDTextField = new javax.swing.JTextField();
        trangThaimaHDTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        capNhatButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        huyButton = new javax.swing.JButton();
        xacNhanButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sanPhamTable = new javax.swing.JTable();
        tienDoSanPham = new javax.swing.JPanel();
        footer_1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tienDoProgessBar = new javax.swing.JProgressBar();
        thoiGianProgessBar = new javax.swing.JProgressBar();
        footer_2 = new javax.swing.JPanel();
        tienDoSanPhamScroll = new javax.swing.JScrollPane();
        tienDoSanPhamTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        Body.setBackground(new java.awt.Color(255, 255, 255));

        header_body.setBackground(new java.awt.Color(255, 255, 255));

        header_header_body.setBackground(new java.awt.Color(225, 240, 221));
        header_header_body.setPreferredSize(new java.awt.Dimension(434, 50));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("THÔNG TIN HỢP ĐỒNG");
        jLabel12.setMaximumSize(new java.awt.Dimension(192, 50));
        jLabel12.setMinimumSize(new java.awt.Dimension(192, 50));
        jLabel12.setPreferredSize(new java.awt.Dimension(192, 50));

        javax.swing.GroupLayout header_header_bodyLayout = new javax.swing.GroupLayout(header_header_body);
        header_header_body.setLayout(header_header_bodyLayout);
        header_header_bodyLayout.setHorizontalGroup(
            header_header_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_header_bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );
        header_header_bodyLayout.setVerticalGroup(
            header_header_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_header_bodyLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã hợp đồng");

        jLabel2.setText("Tên hợp đồng");

        jLabel3.setText("Ngày bắt đầu");

        jLabel4.setText("Ngày kết thúc");

        jLabel5.setText("Trị giá hợp đồng");

        jLabel6.setText("Mã khách hàng");

        maHDTextField.setEditable(false);
        maHDTextField.setBackground(new java.awt.Color(255, 255, 255));
        maHDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maHDTextFieldActionPerformed(evt);
            }
        });

        tenHDmaHDTextField.setEditable(false);
        tenHDmaHDTextField.setBackground(new java.awt.Color(255, 255, 255));

        ngayBDmaHDTextField.setEditable(false);
        ngayBDmaHDTextField.setBackground(new java.awt.Color(255, 255, 255));
        ngayBDmaHDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngayBDmaHDTextFieldActionPerformed(evt);
            }
        });

        ngayKTmaHDTextField.setEditable(false);
        ngayKTmaHDTextField.setBackground(new java.awt.Color(255, 255, 255));
        ngayKTmaHDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngayKTmaHDTextFieldActionPerformed(evt);
            }
        });

        triGiamaHDTextField.setEditable(false);
        triGiamaHDTextField.setBackground(new java.awt.Color(255, 255, 255));
        triGiamaHDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triGiamaHDTextFieldActionPerformed(evt);
            }
        });

        maKHmaHDTextField.setEditable(false);
        maKHmaHDTextField.setBackground(new java.awt.Color(255, 255, 255));

        trangThaimaHDTextField.setEditable(false);
        trangThaimaHDTextField.setBackground(new java.awt.Color(255, 255, 255));
        trangThaimaHDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangThaimaHDTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Trạng Thái");

        capNhatButton.setBackground(new java.awt.Color(198, 222, 192));
        capNhatButton.setText("Cập nhật");
        capNhatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capNhatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(maKHmaHDTextField)
                    .addComponent(triGiamaHDTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ngayBDmaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tenHDmaHDTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(maHDTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(ngayKTmaHDTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trangThaimaHDTextField))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(capNhatButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(capNhatButton)
                .addGap(17, 17, 17)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tenHDmaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ngayBDmaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ngayKTmaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(triGiamaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(maKHmaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trangThaimaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        javax.swing.GroupLayout header_bodyLayout = new javax.swing.GroupLayout(header_body);
        header_body.setLayout(header_bodyLayout);
        header_bodyLayout.setHorizontalGroup(
            header_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header_header_body, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        header_bodyLayout.setVerticalGroup(
            header_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_bodyLayout.createSequentialGroup()
                .addComponent(header_header_body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        huyButton.setBackground(new java.awt.Color(198, 222, 192));
        huyButton.setText("hủy hợp đồng");
        huyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyButtonActionPerformed(evt);
            }
        });

        xacNhanButton.setBackground(new java.awt.Color(198, 222, 192));
        xacNhanButton.setText("Xác nhận hợp đồng");
        xacNhanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xacNhanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(xacNhanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(huyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xacNhanButton)
                    .addComponent(huyButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        sanPhamTable.setBackground(new java.awt.Color(225, 240, 221));
        sanPhamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(sanPhamTable);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header_body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addComponent(header_body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tienDoSanPham.setLayout(new java.awt.BorderLayout());

        footer_1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Tiến độ chính:");

        jLabel8.setText("Thời gian:");

        javax.swing.GroupLayout footer_1Layout = new javax.swing.GroupLayout(footer_1);
        footer_1.setLayout(footer_1Layout);
        footer_1Layout.setHorizontalGroup(
            footer_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footer_1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(footer_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(35, 35, 35)
                .addGroup(footer_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tienDoProgessBar, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(thoiGianProgessBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        footer_1Layout.setVerticalGroup(
            footer_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footer_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(footer_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(footer_1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(footer_1Layout.createSequentialGroup()
                        .addComponent(tienDoProgessBar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(thoiGianProgessBar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tienDoSanPham.add(footer_1, java.awt.BorderLayout.PAGE_START);

        footer_2.setBackground(new java.awt.Color(255, 255, 255));

        tienDoSanPhamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên Sản Phẩm", "Tiến độ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tienDoSanPhamScroll.setViewportView(tienDoSanPhamTable);

        javax.swing.GroupLayout footer_2Layout = new javax.swing.GroupLayout(footer_2);
        footer_2.setLayout(footer_2Layout);
        footer_2Layout.setHorizontalGroup(
            footer_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footer_2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(tienDoSanPhamScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );
        footer_2Layout.setVerticalGroup(
            footer_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footer_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tienDoSanPhamScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(120, 120, 120))
        );

        tienDoSanPham.add(footer_2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(tienDoSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tienDoSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void xacNhanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacNhanButtonActionPerformed

        if(JOptionPane.showConfirmDialog(this,"Hợp đồng đã xác nhận sẽ không thể cập nhật thông tin. Vui lòng xác nhận!")==0)
        {
               thayDoiTrangThaiHopDong("Đang thực hiện"); 
               gD_QLHD.updateTable();
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_xacNhanButtonActionPerformed

    private void ngayKTmaHDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngayKTmaHDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngayKTmaHDTextFieldActionPerformed

    private void ngayBDmaHDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngayBDmaHDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngayBDmaHDTextFieldActionPerformed

    private void triGiamaHDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triGiamaHDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_triGiamaHDTextFieldActionPerformed

    private void maHDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maHDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maHDTextFieldActionPerformed

    private void trangThaimaHDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangThaimaHDTextFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_trangThaimaHDTextFieldActionPerformed

    private void capNhatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capNhatButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capNhatButtonActionPerformed

    private void huyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyButtonActionPerformed

        if(JOptionPane.showConfirmDialog(this,"Họp đồng bị hủy không thể hoàn tác. Vui Lòng xác nhận!")==0)
        {
               thayDoiTrangThaiHopDong("Hủy"); 
               gD_QLHD.updateTable();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_huyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JButton capNhatButton;
    private javax.swing.JPanel footer_1;
    private javax.swing.JPanel footer_2;
    private javax.swing.JPanel header_body;
    private javax.swing.JPanel header_header_body;
    private javax.swing.JButton huyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maHDTextField;
    private javax.swing.JTextField maKHmaHDTextField;
    private javax.swing.JTextField ngayBDmaHDTextField;
    private javax.swing.JTextField ngayKTmaHDTextField;
    private javax.swing.JTable sanPhamTable;
    private javax.swing.JTextField tenHDmaHDTextField;
    private javax.swing.JProgressBar thoiGianProgessBar;
    private javax.swing.JProgressBar tienDoProgessBar;
    private javax.swing.JPanel tienDoSanPham;
    private javax.swing.JScrollPane tienDoSanPhamScroll;
    private javax.swing.JTable tienDoSanPhamTable;
    private javax.swing.JTextField trangThaimaHDTextField;
    private javax.swing.JTextField triGiamaHDTextField;
    private javax.swing.JButton xacNhanButton;
    // End of variables declaration//GEN-END:variables
}
