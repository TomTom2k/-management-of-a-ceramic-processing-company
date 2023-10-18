/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author vohau
 */
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
// lưu ý khi đổ dữ liệu vào table thì phải set oldMaHD = maHD nằm cuối danh sách.
public class HopDong {
   String maHD;
   String tenHD;
   LocalDate ngayBatDau;
   LocalDate  ngayKetThucDuKien;
   String trangThai;
   static String oldMaHD = null; // mặc định null
   double donGia; 
    public void setMaHD() 
    {
		maHD = generateMaHD(); // khởi tạo mã hd
                oldMaHD = maHD;
	}
	public void setTenHD(String tenHD) 
	{
		if(tenHD.trim().equals("")) // kiểm tra chuỗi không rỗng
		{
			this.tenHD ="Không xác định";
		}
		else {
			this.tenHD = tenHD;
		}
	}
	public void setNgayBatDau(LocalDate ngayBatDau) 
	{
		this.ngayBatDau = ngayBatDau;
	}
	public void setNgayKetThucDuKien(LocalDate ngayKetThucDuKien)
	{
		this.ngayKetThucDuKien = ngayKetThucDuKien;
	}
	public void setTrangThai(String trangThai) 
	{
		this.trangThai = "Chờ xác nhận";
	}
   String generateMaHD()
   {
	   if(oldMaHD==null) // nếu đây là hợp đồng đầu tiên được tạo
	   {
		 maHD = generateNgayBatDau()+"01";
		  
	   }
	   else
	   {
		 if(oldMaHD.substring(0,5).compareTo(generateNgayBatDau())==0) 
		 {
			int stt = Integer.parseInt(oldMaHD.substring(6,7));
			stt++;
			if(stt<=9)
			{
				maHD = generateNgayBatDau()+"0"+stt;
			}
			else
			{
				maHD = generateNgayBatDau()+stt;
			}			
			oldMaHD = maHD;
		 }
		 else
		 {
				maHD = generateNgayBatDau()+ "01";
		 }
	   }
	   return maHD;
   }
   public double getDonGia() {
	return donGia;
}
   public String getDonGiaString()
   {
	   Locale localeVN = new Locale("vi", "VN");
	   NumberFormat vn = NumberFormat.getInstance(localeVN);		
	   return vn.format(donGia);
   }
public void setDonGia(double donGia) 
{
	if(donGia<0)
	{
		this.donGia = 0;
	}
	else
	{
		this.donGia = donGia;
	}	
}
String generateNgayBatDau()
   {
	   int day = ngayBatDau.getDayOfMonth();
	   int month = ngayBatDau.getMonthValue();
	   int year = ngayBatDau.getYear();
	   return ""+day+month+year%100;
   }
   public String getNgayBatDau() 
   {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	return ngayBatDau.format(formatter);
   }
   public String getNgayKetThuc() 
   {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	return ngayKetThucDuKien.format(formatter);
   }
public String getMaHD() {
	return maHD;
}
public String getTenHD() {
	return tenHD;
}
public LocalDate getNgayKetThucDuKien() {
	return ngayKetThucDuKien;
}
public String getTrangThai() {
	return trangThai;
}
public HopDong(String tenHD, LocalDate ngayBatDau, LocalDate ngayKetThucDuKien,double donGia) {
	super();
	this.setNgayBatDau(ngayBatDau);
	this.setNgayKetThucDuKien(ngayKetThucDuKien);
	this.setTenHD(tenHD);
	this.setTrangThai(trangThai);
	this.setDonGia(donGia);
	this.setMaHD();
}
public String ToString()
{
	String a = "";
	a += this.getMaHD() +"\n";
	a += this.getTenHD() +"\n";
	a += this.getNgayBatDau() +"\n";
	a += this.getNgayKetThuc() +"\n";
	a += this.getTrangThai() +"\n";
	a += this.getDonGiaString() +"\n";
	return a;
}
}
