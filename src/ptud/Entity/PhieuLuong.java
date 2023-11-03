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


public class PhieuLuong {
    private String maPL;     
    private int thang; 
    private int nam; 
    private String maNV; 
    private String maCN; 
    private double phat; 
    // private double luong; 
    // private double thuong; 
    private int soNgayLam; 
    // private double luongThucNhan; 

    public PhieuLuong() {
    }

    public PhieuLuong(String maPL, int thang, int nam, String maNV, String maCN, double phat, int soNgayLam) {
        setMaPL(maPL);
        setThang(thang);
        setNam(nam);
        setMaNV(maNV);
        setMaCN(maCN);
        setPhat(phat);
        setSoNgayLam(soNgayLam);
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

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
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
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
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
                ", maCN='" + maCN + '\'' +
                ", phat=" + phat +
                ", luong=" + getLuong() +
                ", thuong=" + getThuong() +
                ", soNgayLam=" + soNgayLam +
                ", luongThucNhan=" + getLuongThucNhan() +
                '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.maPL);
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
        final PhieuLuong other = (PhieuLuong) obj;
        return Objects.equals(this.maPL, other.maPL);
    }
    
}


// CREATE TABLE PhieuLuong (
// 	maPL VARCHAR(20) PRIMARY KEY,
//     thang INT,
//     nam INT,
//     maNV VARCHAR(20),
//     maCN VARCHAR(20),
//     phat FLOAT(10),
//     luong FLOAT(10),
//     thuong FLOAT(10),
//     soNgayLam INT,
//     luongThucNhan FLOAT(10),
//     FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
//     FOREIGN KEY (maCN) REFERENCES CongNhan(maCN)
// );