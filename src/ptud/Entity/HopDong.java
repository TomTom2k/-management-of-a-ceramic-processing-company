/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

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
    
    
    // khai bao thuoc tinh
   private String maHD;
   private String tenHD;
   private LocalDate ngayBatDau;
   private LocalDate ngayKetThucDuKien;
   private String trangThai;
   public static String oldMaHD = null;
   private double donGia; 
   private String maKH; 
   
   
   
   
    public void setMaKH(String maKH)
    {
        if(maKH.trim().equals(""))
        {
            maKH = "Khong xac dinh!";
        }
        this.maHD = maHD;
    }  
    public void setMaHD(String maHD)
    {
        this.maHD = maHD;
    }
    public void setMaHD() 
    {
	maHD = generateMaHD();
	}
	public void setTenHD(String tenHD) 
	{
		if(tenHD.trim().equals(""))
		{
			this.tenHD ="Không xác định";
		}
		else 
                {
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
	   if(oldMaHD==null)
	   {
		 maHD = generateNgayBatDau()+"01";
		 oldMaHD = maHD;
		  
	   }
	   else
	   {
		 if(oldMaHD.substring(0,6).compareTo(generateNgayBatDau())==0)
		 {
			int stt = Integer.parseInt(oldMaHD.substring(6,8));
		    
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
   public String getMaKH()
   {
       return maKH;
   }
   public double getDonGia() 
   {
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
	   if(year%100<10)
	   {
		   return ""+day+month+"0"+year%100;
	   }
	   else 
	   {
		   return ""+day+month+year%100;
	   }
	  
   }
   public LocalDate getNgayBatDau() 
   {
        return ngayBatDau;   
   }
   public LocalDate getNgayKetThuc() 
   {
        return ngayKetThucDuKien;
   }
   public String  getNgayBatDauString()
   {      
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");	
	return ngayKetThucDuKien.format(formatter);
   }
   public String  getNgayKetThucString()
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
public HopDong(String tenHD, LocalDate ngayBatDau, LocalDate ngayKetThucDuKien,double donGia,String maKH) 
{
	super();
	this.setNgayBatDau(ngayBatDau);
	this.setNgayKetThucDuKien(ngayKetThucDuKien);
	this.setTenHD(tenHD);
	this.setTrangThai(trangThai);
	this.setDonGia(donGia);
	this.setMaHD();
         this.setMaKH(maKH);
}
public HopDong(String maHD,String tenHD, LocalDate ngayBatDau, LocalDate ngayKetThucDuKien,double donGia,String maKH)
{
        super();
	this.setNgayBatDau(ngayBatDau);
	this.setNgayKetThucDuKien(ngayKetThucDuKien);
	this.setTenHD(tenHD);
	this.setTrangThai(trangThai);
	this.setDonGia(donGia);
	this.setMaHD(maHD);
        this.setMaKH(maKH);
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