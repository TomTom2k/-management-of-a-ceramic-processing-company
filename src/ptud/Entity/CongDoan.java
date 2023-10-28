/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.util.ArrayList;
import java.util.Objects;

/**
 *  
 * @author KHANH PC
 */
public class CongDoan {
    private String maCD; 
    private String maSP; 
    private String maBP;
    private String tenCD; 
    private double donGia; 
    private boolean trangThai; 
    private int soLuongChuanBiToiThieu;    
    // private int soLuongChuanBi;     
    // private int soLuongHoanThanh; 
    private ArrayList<String> dsCDTQ; 

    public CongDoan() {
    }

    public CongDoan(String maCD, String maSP, String maBP, String tenCD, double donGia, boolean trangThai, int soLuongChuanBiToiThieu, ArrayList<String> dsCDTQ) {
        setMaCD(maCD);
        setMaSP(maSP);
        setMaBP(maBP);
        setTenCD(tenCD);
        setDonGia(donGia);
        setTrangThai(trangThai);
        setSoLuongChuanBiToiThieu(soLuongChuanBiToiThieu);
        setDsCDTQ(dsCDTQ);
    }

    public String getMaCD() {
        return maCD;
    }

    public String getMaSP() {
        return maSP;
    }

    public String getMaBP() {
        return maBP;
    }

    public String getTenCD() {
        return tenCD;
    }

    public double getDonGia() {
        return donGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public int getSoLuongChuanBi() {
        int soLuongChuanBi = 0;
        // xử lý tính toán 
        return soLuongChuanBi;
    }

    public int getSoLuongChuanBiToiThieu() {
        return soLuongChuanBiToiThieu;
    }

    public int getSoLuongHoanThanh() {
        int soLuongHoanThanh = 0;
        // xử lý tính toán 
        return soLuongHoanThanh;
    }

    public ArrayList<String> getDsCDTQ() {
        return dsCDTQ;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setMaBP(String maBP) {
        this.maBP = maBP;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setSoLuongChuanBiToiThieu(int soLuongChuanBiToiThieu) {
        this.soLuongChuanBiToiThieu = soLuongChuanBiToiThieu;
    }


    public void setDsCDTQ(ArrayList<String> dsCDTQ) {
        this.dsCDTQ = dsCDTQ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.maCD);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CongDoan other = (CongDoan) obj;
        return Objects.equals(this.maCD, other.maCD);
    }
    
    
    
}
