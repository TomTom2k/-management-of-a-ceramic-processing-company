package ptud.Entity;

import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TomTom
 */
public class NhanVien extends ThanhVien {
    private String maNV;
    private double luongCoBan;
    private double phuCap;

    public String getMaNV() {
        return maNV;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public double getPhuCap() {
        return phuCap;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public void setPhuCap(double phuCap) {
        this.phuCap = phuCap;
    }

    public NhanVien() {
    }

    public NhanVien(String maNV, double luongCoBan, double phuCap, String ten, boolean gioiTinh, LocalDate ngaySinh, LocalDate ngayBatDauLam, String cccd, String dienThoai, boolean trangThai, byte[] avatar) {
        super(ten, gioiTinh, ngaySinh, ngayBatDauLam, cccd, dienThoai, trangThai, avatar);
        this.maNV = maNV;
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + super.toString() + ", luongCoBan=" + luongCoBan + ", phuCap=" + phuCap + '}';
    }
    
    
}
