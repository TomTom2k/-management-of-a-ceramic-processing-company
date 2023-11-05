/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.util.Objects;

/**
 * 
 * @author KHANH PC
 */


public class PhieuLuongCongNhan {
    private String maPL;     
    private int thang; 
    private int nam; 
    private String maCN; 
    private double phat; 
    // private double luong; 
    // private double thuong; 
    // private int soNgayLam; 
    // private double luongThucNhan; 

    public PhieuLuongCongNhan() {
    }

    public PhieuLuongCongNhan(String maPL, int thang, int nam, String maCN, double phat) {
        setMaPL(maPL);
        setThang(thang);
        setNam(nam);
        setMaNV(maCN);
        setPhat(phat);
    }

    public String getMaPL() {
        return maPL;
    }

    public void setMaPL(String maPL) {
        this.maPL = maPL;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getMaNV() {
        return maCN;
    }

    public void setMaNV(String maCN) {
        this.maCN = maCN;
    }

    public double getPhat() {
        return phat;
    }

    public void setPhat(double phat) {
        this.phat = phat;
    }
    

    public double getLuong() {
        double luong = 0;
        // xử lý tính toán
        return luong;
    }

    public double getThuong() {
        double thuong = 0;
        // xử lý tính toán
        return thuong;
    }


    public int getSoNgayLam() {
        int soNgayLam = 0; 
        // xử lý tính toán
        return soNgayLam;
    }

    public double getLuongThucNhan() {
        double luongThucNhan = 0;
        // xử lý tính toán
        return luongThucNhan;
    }


    @Override
    public String toString() {
        return "PhieuLuong{" +
                "maPL='" + maPL + '\'' +
                ", thang=" + thang +
                ", nam=" + nam +
                ", maCN='" + maCN + '\'' +
                ", phat=" + phat +
                ", luong=" + getLuong() +
                ", thuong=" + getThuong() +
                ", soNgayLam=" + getSoNgayLam() +
                ", luongThucNhan=" + getLuongThucNhan() +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.maPL);
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
        final PhieuLuongCongNhan other = (PhieuLuongCongNhan) obj;
        return Objects.equals(this.maPL, other.maPL);
    }    
}
