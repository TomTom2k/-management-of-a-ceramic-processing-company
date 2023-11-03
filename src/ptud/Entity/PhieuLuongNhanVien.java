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


public class PhieuLuongNhanVien {
    private String maPL;     
    private int thang; 
    private int nam; 
    private String maNV; 
    private double phat; 
    // private double phuCap; 
    // private double luong; 
    // private double thuong; 
    // private int soNgayLam; 
    // private double luongThucNhan; 

    public PhieuLuongNhanVien() {
    }

    public PhieuLuongNhanVien(String maPL, int thang, int nam, String maNV, double phat) {
        setMaPL(maPL);
        setThang(thang);
        setNam(nam);
        setMaNV(maNV);
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
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public double getPhat() {
        return phat;
    }

    public void setPhat(double phat) {
        this.phat = phat;
    }
    
    public double getPhuCap() {
        double PhuCap = 0;
        // xử lý tính toán
        return PhuCap;
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
                ", maNV='" + maNV + '\'' +
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
        final PhieuLuongNhanVien other = (PhieuLuongNhanVien) obj;
        return Objects.equals(this.maPL, other.maPL);
    }    
}


// CREATE TABLE PhieuLuongNhanVien (
// 	maPL VARCHAR(20) PRIMARY KEY,
//     thang INT,
//     nam INT,
//     maNV VARCHAR(20),
//     maNV VARCHAR(20),
//     phat FLOAT(10),
//     luong FLOAT(10),
//     thuong FLOAT(10),
//     soNgayLam INT,
//     luongThucNhan FLOAT(10),
//     FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
//     FOREIGN KEY (maNV) REFERENCES CongNhan(maNV)
// );