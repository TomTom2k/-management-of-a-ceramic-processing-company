package haha;

public class SanPham 
{
	// Author VoPhuocHau
  String maSanPham;
  String tenSanPham;
  int soLuong;
  double donGia;
  public String getMaSanPham() 
    {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham,int stt) 
	{
		if(stt<10)
		{
			this.maSanPham = maSanPham+"0"+stt;
		}
		else 
		{
			this.maSanPham = maSanPham+stt;
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
	public SanPham(String maSanPham, String tenSanPham, int soLuong, double donGia,int stt) 
	{
		super();
		this.setDonGia(donGia);
		this.setMaSanPham(maSanPham, stt);
		this.setSoLuong(soLuong);
		this.setTenSanPham(tenSanPham);
	}
}
