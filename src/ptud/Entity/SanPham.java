package ptud.Entity;

public class SanPham 
{
	// Author VoPhuocHau
  String maHD;

    public String getMaHD() 
    {
        return maHD;
    }

    public void setMaHD(String maHD) 
    {
        this.maHD = maHD;
    }
  String maSanPham;
  String tenSanPham;
  int soLuong;
  double donGia;
  
  public String getMaSanPham() 
    {
		return maSanPham;
	}
	public void setMaSanPham(int stt) 
	{
		if(stt<10)
		{
			this.maSanPham = this.maHD+"0"+stt;
		}
		else 
		{
			this.maSanPham = this.maHD+stt;
		}
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		if(tenSanPham.trim().equals(""))
		{
			tenSanPham = "Khong xac dinh";
		}
		this.tenSanPham = tenSanPham;
	}
	public int getSoLuong() 
	{
		
		return soLuong;
	}
	public void setSoLuong(int soLuong) 
	{
		if(soLuong<0)
		{
			soLuong = 0;
		}
		this.soLuong = soLuong;
	}
	public double getDonGia() 
	{
		
		return donGia;
	}
	public void setDonGia(double donGia) 
	{
		if(donGia<0)
		{
			donGia = 0;
		}
		this.donGia = donGia;
	}
        public void setMaSanPham(String maSanPham)
        {
            this.maSanPham = maSanPham;
        }
	public SanPham(String maSanPham, String tenSanPham, int soLuong, double donGia,String maHD) 
	{
		super();
		this.setDonGia(donGia);               
		this.setMaSanPham(maSanPham);
		this.setSoLuong(soLuong);
		this.setTenSanPham(tenSanPham);
                this.setMaHD(maHD);
	}
}
