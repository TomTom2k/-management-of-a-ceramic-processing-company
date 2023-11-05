package ptud.Entity;

public class KhachHang 
{
	// Author VoPhuocHau
	String maKhachHang;
	String tenKhachHang;
	boolean isToChuc;
	String email;
	String sdt;
	public String getMaKhachHang() 
	{
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) 
	{
		this.maKhachHang = maKhachHang;
	}
        public void setMaKhachHang() 
	{
		
	}
	public String getTenKhachHang() 
	{
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) 
	{
		this.tenKhachHang = tenKhachHang;
	}
	public boolean isToChuc() 
	{
		return isToChuc;
	}
	public void setToChuc(boolean isToChuc) 
	{
		this.isToChuc = isToChuc;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getSdt() 
	{
		return sdt;
	}
	public void setSdt(String sdt) 
	{
		this.sdt = sdt;
	}
        public KhachHang()
        {
            
        }       
        public KhachHang(String maKhachHang, String tenKhachHang, boolean isToChuc, String email, String sdt) 
        {
	 super();
	 this.setMaKhachHang(maKhachHang);
         this.setSdt(sdt);
         this.setEmail(email);
         this.setTenKhachHang(tenKhachHang);
         this.setToChuc(isToChuc);
	}
        public KhachHang( String tenKhachHang, boolean isToChuc, String email, String sdt) 
        {
	 super();	
         this.setSdt(sdt);
         this.setEmail(email);
         this.setTenKhachHang(tenKhachHang);
         this.setToChuc(isToChuc);
         this.setMaKhachHang();
	}
}
