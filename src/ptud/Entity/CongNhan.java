/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.time.LocalDate;

/**
 *
 * @author TomTom
 */
public class CongNhan {
    private String maCN;
    private String ten;
    private boolean gioiTinh;
    private LocalDate ngaySinh;
    private LocalDate ngayBatDauLam;
    private String cccd;
    private String dienThoai;
    private boolean trangThai;
    private byte[] avatar;
    private boolean choPhanCong;

    public String getMaCN() {
        return maCN;
    }

    public String getTen() {
        return ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public LocalDate getNgayBatDauLam() {
        return ngayBatDauLam;
    }

    public String getCccd() {
        return cccd;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public boolean isChoPhanCong() {
        return choPhanCong;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setNgayBatDauLam(LocalDate ngayBatDauLam) {
        this.ngayBatDauLam = ngayBatDauLam;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public void setChoPhanCong(boolean choPhanCong) {
        this.choPhanCong = choPhanCong;
    }

    public CongNhan(String maCN, String ten, boolean gioiTinh, LocalDate ngaySinh, LocalDate ngayBatDauLam, String cccd, String dienThoai, boolean trangThai, byte[] avatar, boolean choPhanCong) {
        this.maCN = maCN;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.ngayBatDauLam = ngayBatDauLam;
        this.cccd = cccd;
        this.dienThoai = dienThoai;
        this.trangThai = trangThai;
        this.avatar = avatar;
        this.choPhanCong = choPhanCong;
    }

    public CongNhan() {
    }

    @Override
    public String toString() {
        return "CongNhan{" + "maCN=" + maCN + ", ten=" + ten + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", ngayBatDauLam=" + ngayBatDauLam + ", cccd=" + cccd + ", dienThoai=" + dienThoai + ", trangThai=" + trangThai + ", avatar=" + avatar + ", choPhanCong=" + choPhanCong + '}';
    }

    
}
