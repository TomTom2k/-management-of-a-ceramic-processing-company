/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ptud.GUI.GUI_HD;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ptud.DAO.DAOInterface;
import ptud.DAO.DAO_CongDoan;
import ptud.DAO.DAO_HopDong;
import ptud.DAO.DAO_KhachHang;
import ptud.Entity.HopDong;
import ptud.Entity.KhachHang;
import ptud.Entity.SanPham;
import ptud.GUI.GD_QLHD;
import java.time.temporal.ChronoField; 
import java.util.HashSet;
import java.util.Set;
import ptud.DAO.DAO_SanPham;

/**
 *
 * @author vohau
 */
public class GD_ChiTietHopDong extends javax.swing.JPanel {

    HopDong hopDong;
    DefaultTableModel sanPhamModel,tienDoModel;
    DAO_HopDong daohd = new DAO_HopDong();
    GD_QLHD gD_QLHD;
    DAO_KhachHang daokh = new DAO_KhachHang();
    DAO_SanPham daosp = new DAO_SanPham();
 

    /**
     * Creates new form GD_ChiTietHopDong
     */
    public GD_ChiTietHopDong() {
        initComponents();
        tienDoSanPhamTable.getColumnModel().getColumn(1).setCellRenderer(new TienDoTableCellRender());
        sanPhamModel = (DefaultTableModel) sanPhamTable.getModel();
        tienDoModel = (DefaultTableModel) tienDoSanPhamTable.getModel();
        jDateChooser1.setEnabled(false);

    }
  
       void createSanPham() {
        try {
            double donGia;
            int soLuong = Integer.parseInt(jTextField8.getText());
            donGia = Double.parseDouble(jTextField9.getText());
            boolean isCreate = true;
            if (!checkRegex("^[A-Z]{1}", jTextField7.getText())) {
                jLabel18.setText("Chữ cái đầu phải viết hoa");
                isCreate = false;
            }
            if (donGia <= 0) {
                jLabel19.setText("Gía trị sản phẩm phải là số không âm!");
                isCreate = false;
            }
            if (soLuong <= 0) {
                jLabel20.setText("số lượng sản phẩm phải là số không âm!");
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
            jLabel18.setText("Gía trị sản phẩm phải là số không âm!");
            jLabel19.setText("số lượng sản phẩm phải là số không âm!");
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
        Object[] rowData = new Object[4];
        rowData[0] = "Sản phẩm chưa có mã";
        rowData[1] = tenSP;
        rowData[2] = soLuong;
        rowData[3] = donGia;
        sanPhamModel.addRow(rowData);
    }
     void changeObjectToEnity(Object[] rowData, int stt) 
     {
        double donGia;
        int soLuong = Integer.parseInt(rowData[1].toString());
        donGia = Double.parseDouble(rowData[2].toString());
        String tenSP = rowData[0].toString();
        SanPham sanPham = new SanPham(stt, tenSP, soLuong, donGia, hopDong.getMaHD());
        if(!hopDong.getSanPhams().contains(sanPham))
        {
            daosp.insert(sanPham); 
        }       
    }
    void createHopDong(){
        try {
            boolean isCreate = true;
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat vn = NumberFormat.getInstance(localeVN);
            hopDong.setDonGia(triGiamaHDTextField.getText());
            if (!checkRegex("^[A-Z]{1}", tenHDmaHDTextField.getText())) {
                jLabel10.setText("Chữ cái đầu phải viết hoa");
                isCreate = false;
            }
            if (!checkRegex("^[0-9]{6}$", maKHmaHDTextField.getText())) {
                jLabel13.setText("Mã khách hàng phải thuộc định dạng 6 ký tự số");
                isCreate = false;
            }            
            if (hopDong.getDonGia() <= 0) {
                jLabel11.setText("Gía trị tài khoản phải là số không âm!");
                isCreate = false;
            }
         
            if (isCreate == true) {
                try {
                    if(jDateChooser1.getCalendar()!=null)
                    {
                      LocalDate ngayKT = LocalDate.ofInstant(jDateChooser1.getCalendar().toInstant(), ZoneId.systemDefault());     
                      hopDong.setNgayKetThucDuKien(ngayKT);
                    } 
                    String tenHD = tenHDmaHDTextField.getText();
                    String maKH = maKHmaHDTextField.getText();                                
                    hopDong.setTenHD(tenHD);
                    hopDong.setMaKH(maKH);
                    daohd.update(hopDong);  
                   
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(this, "Lỗi tạo hợp đồng!");
                }
            }
        } catch (Exception e) {
            jLabel11.setText("Gía trị tài khoản phải là số không âm!");
        }
        // chu cai dau tenSP viet Hoa         
    }

    void changeEnityToObject(SanPham sanPham) {
        Object[] rowData = new Object[4];
        rowData[0] = sanPham.getMaSanPham();
        rowData[1] = sanPham.getTenSanPham();
        rowData[2] = sanPham.getSoLuong();
        rowData[3] = sanPham.getDonGia();
        Object[] tienDoData = new Object[2];
        tienDoData[0] = sanPham.getTenSanPham();;
        sanPham.setTienDo();
        tienDoData[1] = sanPham.getTienDo();
        sanPhamModel.addRow(rowData);
        tienDoModel.addRow(tienDoData);
        
    }
       void insertSanPhamToDatabase() 
       {

        for (int i = 0; i < sanPhamModel.getRowCount(); i++) 
        {
            Object[] objects = new Object[3];
            if(sanPhamModel.getValueAt(i, 0).toString().equals("Sản phẩm chưa có mã"))
            {
               objects[0] = sanPhamModel.getValueAt(i, 1);
               objects[1] = sanPhamModel.getValueAt(i, 2);
               objects[2] = sanPhamModel.getValueAt(i, 3);
               changeObjectToEnity(objects, i+1);
                System.out.println(i);
            }          
        }
    }
    public void receiveHopDong(HopDong hopDong1, GD_QLHD gD_QLHD) {
        hopDong = hopDong1;
        updateData();
        this.gD_QLHD = gD_QLHD;
        updateTable();     
    
        if (hopDong.getTrangThai().equals("Chờ xác nhận")) 
        {
            xacNhanButton.setEnabled(true);
            xacNhanButton.setVisible(true);
            capNhatButton.setEnabled(true);
            capNhatButton.setVisible(true);
            panelThemSanPham.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        } 
        else if (hopDong.getTrangThai().equals("Đang thực hiện"))
        {
             xacNhanButton.setEnabled(false);
             xacNhanButton.setVisible(false);
             capNhatButton.setEnabled(false);
             capNhatButton.setVisible(false);
             panelThemSanPham.setVisible(false);
             jButton1.setVisible(false);
             jButton2.setVisible(false);
        }
        else if (hopDong.getTrangThai().equals("Hoàn thành"))
        {
             xacNhanButton.setEnabled(false);
             xacNhanButton.setVisible(false);
             capNhatButton.setEnabled(false);
             capNhatButton.setVisible(false);
             panelThemSanPham.setVisible(false);
             jButton1.setVisible(false);
             jButton2.setVisible(false);
        }
       else if (hopDong.getTrangThai().equals("Hủy"))
        {
             xacNhanButton.setEnabled(false);
             xacNhanButton.setVisible(false);
             capNhatButton.setEnabled(false);
             capNhatButton.setVisible(false);
             panelThemSanPham.setVisible(false);
             jButton1.setVisible(false);
             jButton2.setVisible(false);
        }
        tenHDmaHDTextField.setEditable(false);
        maKHmaHDTextField.setEditable(false);
        triGiamaHDTextField.setEditable(false);
        ngayKTmaHDTextField.setEditable(false);
        jDateChooser1.setEnabled(false);
 
        double ngayChenhLechTong = timNgayChenhlech(hopDong.getNgayBatDau(),hopDong.getNgayKetThucDuKien());
        double ngayConLai = timNgayChenhlech(hopDong.getNgayBatDau(),LocalDate.now());
        
        double percent = 100*ngayConLai/ngayChenhLechTong;
        System.out.println(ngayChenhLechTong+"ngayConLai"+ ngayConLai);
        thoiGianProgessBar.setValue((int)percent);
        int sum = 0;
        int sumMax = 0;
        for(SanPham sanPham: hopDong.getSanPhams())
        {
            sanPham.setTienDo();
            sum += sanPham.getTienDo();
            sumMax +=100;
        }
        tienDoProgessBar.setMaximum(sumMax);
        tienDoProgessBar.setValue(sum);
        
    }
   public int timNgayChenhlech(LocalDate dateStart,LocalDate dateEnd)
    {
        if(dateStart.getYear() == dateEnd.getYear())
        {
            return  dateEnd.getDayOfYear()- dateStart.getDayOfYear();
        }
        else
        {
            int yearChenhLech =dateEnd.getYear()- dateStart.getYear();
            int ngayChenhLech = 0;
            for(int i = 1;i<yearChenhLech;i++)
            {
                ngayChenhLech += LocalDate.of( i +dateStart.getYear(),12,31).getDayOfYear();
                ngayChenhLech++;
            }
            ngayChenhLech += ( LocalDate.of(dateStart.getYear(),12,31).getDayOfYear() - dateStart.getDayOfYear())+1;
            ngayChenhLech += (dateEnd.getDayOfYear()-LocalDate.of(dateEnd.getYear(), 1, 1).getDayOfYear());
              return ngayChenhLech;
        } 
         
    }
    public void updateData() {
        maHDTextField.setText(hopDong.getMaHD());
        tenHDmaHDTextField.setText(hopDong.getTenHD());
        triGiamaHDTextField.setText(hopDong.getDonGiaString());
        trangThaimaHDTextField.setText(hopDong.getTrangThai());
        ngayBDmaHDTextField.setText(hopDong.getNgayBatDauString());
        ngayKTmaHDTextField.setText(hopDong.getNgayKetThucString());
        maKHmaHDTextField.setText(hopDong.getMaKH());
    }

    public void thayDoiTrangThaiHopDong(String trangThai) {
        hopDong.setTrangThai(trangThai);
        if (!daohd.update(hopDong)) {
            JOptionPane.showConfirmDialog(this, "Xác nhận thất bại,vui lòng thử lại sau ít phút!");
        }
    }

    void updateTable() {
        deleleTable();
        fillHopDongTable();
    }

    int deleleTable() {
         int rowIndex = sanPhamModel.getRowCount();
        for (int i = 0; i < rowIndex; i++) {
            if (sanPhamModel.getRowCount() == 0) {
                return 1;
            } else {
                sanPhamModel.removeRow(0);             
            }
        }
           for (int i = 0; i < rowIndex; i++) {
            if (tienDoModel.getRowCount() == 0) {
                return 1;
            } else {
                tienDoModel.removeRow(0);             
            }
        }
        return 0;
       
    }

    void fillHopDongTable() {
      
        hopDong.updateListSanPham();
        for (SanPham sanPham : hopDong.getSanPhams()) {            
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        huyButton = new javax.swing.JButton();
        xacNhanButton = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sanPhamTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tienDoSanPham = new javax.swing.JPanel();
        footer_1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tienDoProgessBar = new javax.swing.JProgressBar();
        thoiGianProgessBar = new javax.swing.JProgressBar();
        footer_2 = new javax.swing.JPanel();
        tienDoSanPhamScroll = new javax.swing.JScrollPane();
        tienDoSanPhamTable = new javax.swing.JTable();
        panelThemSanPham = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(capNhatButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(maKHmaHDTextField)
                                .addComponent(triGiamaHDTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tenHDmaHDTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(maHDTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(trangThaimaHDTextField)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel13Layout.createSequentialGroup()
                                    .addComponent(ngayKTmaHDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(ngayBDmaHDTextField)))
                .addGap(34, 34, 34))
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
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ngayBDmaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(ngayKTmaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(triGiamaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(maKHmaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trangThaimaHDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        javax.swing.GroupLayout header_bodyLayout = new javax.swing.GroupLayout(header_body);
        header_body.setLayout(header_bodyLayout);
        header_bodyLayout.setHorizontalGroup(
            header_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_bodyLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(header_header_body, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        header_bodyLayout.setVerticalGroup(
            header_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_bodyLayout.createSequentialGroup()
                .addComponent(header_header_body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        huyButton.setBackground(new java.awt.Color(198, 222, 192));
        huyButton.setText("Hủy hợp đồng");
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
                .addGap(19, 19, 19)
                .addComponent(xacNhanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(huyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setText("Thêm sản phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 255, 255));
        jButton2.setText("Xóa sản phẩm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header_body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(BodyLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2))
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addComponent(header_body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tienDoSanPham.setBackground(new java.awt.Color(255, 255, 255));

        footer_1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Tiến độ chính:");

        jLabel8.setText("Thời gian:");

        thoiGianProgessBar.setForeground(new java.awt.Color(204, 0, 51));
        thoiGianProgessBar.setToolTipText("");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        footer_2.setBackground(new java.awt.Color(255, 255, 255));

        tienDoSanPhamTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Sản Phẩm", "Tiến độ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        footer_2Layout.setVerticalGroup(
            footer_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footer_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tienDoSanPhamScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelThemSanPham.setBackground(new java.awt.Color(255, 255, 255));

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel14.setText("Tên sản phẩm");

        jLabel15.setText("Số lượng");

        jLabel16.setText("Đơn giá");

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

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("THÊM SẢN PHẨM");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 0));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelThemSanPhamLayout = new javax.swing.GroupLayout(panelThemSanPham);
        panelThemSanPham.setLayout(panelThemSanPhamLayout);
        panelThemSanPhamLayout.setHorizontalGroup(
            panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelThemSanPhamLayout.createSequentialGroup()
                        .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField7)
                                    .addComponent(jTextField8)
                                    .addComponent(jTextField9))
                                .addGap(141, 141, 141))
                            .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel18))
                                .addGap(0, 143, Short.MAX_VALUE))
                            .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton4)
                                .addGap(125, 125, 125))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelThemSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelThemSanPhamLayout.setVerticalGroup(
            panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThemSanPhamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelThemSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout tienDoSanPhamLayout = new javax.swing.GroupLayout(tienDoSanPham);
        tienDoSanPham.setLayout(tienDoSanPhamLayout);
        tienDoSanPhamLayout.setHorizontalGroup(
            tienDoSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tienDoSanPhamLayout.createSequentialGroup()
                .addGroup(tienDoSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tienDoSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(footer_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(footer_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        tienDoSanPhamLayout.setVerticalGroup(
            tienDoSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tienDoSanPhamLayout.createSequentialGroup()
                .addComponent(footer_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(footer_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelThemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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
                .addComponent(tienDoSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void xacNhanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xacNhanButtonActionPerformed

        if (xacNhanButton.getText().compareToIgnoreCase("Xác nhận") == 0) {
            jLabel10.setText("");
            jLabel11.setText("");
            jLabel13.setText("");
            createHopDong();
            gD_QLHD.updateTable();
            xacNhanButton.setText("Xác nhận hợp đồng");
            tenHDmaHDTextField.setEditable(false);
            maKHmaHDTextField.setEditable(false);
            triGiamaHDTextField.setEditable(false);
            ngayKTmaHDTextField.setEditable(false);
            jDateChooser1.setEnabled(false);
            insertSanPhamToDatabase();
            panelThemSanPham.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            updateTable();
            if(!(hopDong.getTrangThai().compareToIgnoreCase("Chờ xác nhận")==0))
            {
                xacNhanButton.setVisible(false);               
                
            }
           
        } else {
            if(hopDong.getTrangThai().compareToIgnoreCase("Chờ xác nhận")==0)
            {
                if (JOptionPane.showConfirmDialog(this, "Hợp đồng đã xác nhận sẽ không thể cập nhật thông tin. Vui lòng xác nhận!") == 0) {
                thayDoiTrangThaiHopDong("Đang thực hiện");
                gD_QLHD.updateTable();
            }             
            }         
            
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
        tenHDmaHDTextField.setEditable(true);
        maKHmaHDTextField.setEditable(true);
        triGiamaHDTextField.setEditable(true);
        ngayKTmaHDTextField.setEditable(false);
        jDateChooser1.setEnabled(true);
        xacNhanButton.setText("Xác nhận");
        xacNhanButton.setEnabled(true);
        xacNhanButton.setVisible(true);
        jButton1.setVisible(true);
        jButton2.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_capNhatButtonActionPerformed

    private void huyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyButtonActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Họp đồng bị hủy không thể hoàn tác. Vui Lòng xác nhận!") == 0) {
            thayDoiTrangThaiHopDong("Hủy");
            gD_QLHD.updateTable();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_huyButtonActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    createSanPham();                // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      panelThemSanPham.setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int rowIndex = sanPhamTable.getSelectedRow();    
        daosp.deleteById(sanPhamModel.getValueAt(rowIndex,0).toString());
        sanPhamModel.removeRow(rowIndex);
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JButton capNhatButton;
    private javax.swing.JPanel footer_1;
    private javax.swing.JPanel footer_2;
    private javax.swing.JPanel header_body;
    private javax.swing.JPanel header_header_body;
    private javax.swing.JButton huyButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField maHDTextField;
    private javax.swing.JTextField maKHmaHDTextField;
    private javax.swing.JTextField ngayBDmaHDTextField;
    private javax.swing.JTextField ngayKTmaHDTextField;
    private javax.swing.JPanel panelThemSanPham;
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
