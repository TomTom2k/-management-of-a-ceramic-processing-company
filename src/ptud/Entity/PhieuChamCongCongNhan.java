/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author TranLoc
 */
public class PhieuChamCongCongNhan {
    private String maCN;
    private LocalDate ngay;
    private boolean vang;
    private int soLuongSanPham;
    private String maCTPC;
    private String noiDungPhat;
    private double tienCong;
    private double tienThuong;
    private double tienPhat;
    private int soLuongSanPhamTangCa;

    public PhieuChamCongCongNhan() {
    }

    public PhieuChamCongCongNhan(String maCN, LocalDate ngay, boolean vang, int soLuongSanPham, String maCTPC, String noiDungPhat, double tongTienCD, double tienThuong, double tienPhat, int soLuongSanPhamTangCa) {
        this.maCN = maCN;
        this.ngay = ngay;
        this.vang = vang;
        this.soLuongSanPham = soLuongSanPham;
        this.maCTPC = maCTPC;
        this.noiDungPhat = noiDungPhat;
        this.tienCong = tienCong;
        this.tienThuong = tienThuong;
        this.tienPhat = tienPhat;
        this.soLuongSanPhamTangCa = soLuongSanPhamTangCa;
    }

    public boolean isVang() {
        return vang;
    }

    public void setVang(boolean vang) {
        this.vang = vang;
    }

    public String getMaCN() {
        return maCN;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public String getMaCTPC() {
        return maCTPC;
    }

    public void setMaCTPC(String maCTPC) {
        this.maCTPC = maCTPC;
    }

    public String getNoiDungPhat() {
        return noiDungPhat;
    }

    public void setNoiDungPhat(String noiDungPhat) {
        this.noiDungPhat = noiDungPhat;
    }

    public double getTienCong() {
        return tienCong;
    }

    public void setTienCong(double tienCong) {
        this.tienCong = tienCong;
    }

    public double getTienThuong() {
        return tienThuong;
    }

    public void setTienThuong(double tienThuong) {
        this.tienThuong = tienThuong;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    public int getSoLuongSanPhamTangCa() {
        return soLuongSanPhamTangCa;
    }

    public void setSoLuongSanPhamTangCa(int soLuongSanPhamTangCa) {
        this.soLuongSanPhamTangCa = soLuongSanPhamTangCa;
    }      
}
