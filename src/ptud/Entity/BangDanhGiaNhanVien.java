/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

/**
 *
 * @author TomTom
 */
public class BangDanhGiaNhanVien {
    private String maBDG;
    private NhanVien nhanVien;
    private int nam;
    private float diemChuyenCan;
    private float diemChuyenMon;
    private float diemThaiDo;
    private float diemHieuSuat;
    private char bac;

    public String getMaBDG() {
        return maBDG;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public int getNam() {
        return nam;
    }

    public float getDiemChuyenCan() {
        return diemChuyenCan;
    }

    public float getDiemChuyenMon() {
        return diemChuyenMon;
    }

    public float getDiemThaiDo() {
        return diemThaiDo;
    }

    public float getDiemHieuSuat() {
        return diemHieuSuat;
    }

    public char getBac() {
        return bac;
    }

    public void setMaBDG(String maBDG) {
        this.maBDG = maBDG;
    }

    public void setNhanVien(NhanVien thanhVien) {
        this.nhanVien = thanhVien;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public void setDiemChuyenCan(float diemChuyenCan) {
        this.diemChuyenCan = diemChuyenCan;
    }

    public void setDiemChuyenMon(float diemchuyenMon) {
        this.diemChuyenMon = diemchuyenMon;
    }

    public void setDiemThaiDo(float diemThaiDo) {
        this.diemThaiDo = diemThaiDo;
    }

    public void setDiemHieuSuat(float diemHieuSuat) {
        this.diemHieuSuat = diemHieuSuat;
    }
    
    public void tinhBac() {
        float tong = this.diemChuyenCan + this.diemHieuSuat + this.diemThaiDo + this.diemChuyenMon;
        if(tong < 20)   
            this.bac = 'D';
        else if(tong <25)
            this.bac = 'C';
        else if(tong <35)
            this.bac = 'B';
        else 
            this.bac = 'A';
    }

    public BangDanhGiaNhanVien() {
    }

    public BangDanhGiaNhanVien(String maBDG, NhanVien nhanVien, int nam, float diemChuyenCan, float diemchuyenMon, float diemThaiDo, float diemHieuSuat) {
        this.maBDG = maBDG;
        this.nhanVien = nhanVien;
        this.nam = nam;
        this.diemChuyenCan = diemChuyenCan;
        this.diemChuyenMon = diemchuyenMon;
        this.diemThaiDo = diemThaiDo;
        this.diemHieuSuat = diemHieuSuat;
    }

    public BangDanhGiaNhanVien(String maBDG, NhanVien nhanVien, int nam, float diemChuyenCan, float diemChuyenMon, float diemThaiDo, float diemHieuSuat, char bac) {
        this.maBDG = maBDG;
        this.nhanVien = nhanVien;
        this.nam = nam;
        this.diemChuyenCan = diemChuyenCan;
        this.diemChuyenMon = diemChuyenMon;
        this.diemThaiDo = diemThaiDo;
        this.diemHieuSuat = diemHieuSuat;
        this.bac = bac;
    }
    
    

    @Override
    public String toString() {
        return "BangDanhGia{" + "maBDG=" + maBDG + ", nhanVien=" + nhanVien + ", nam=" + nam + ", diemChuyenCan=" + diemChuyenCan + ", diemchuyenMon=" + diemChuyenMon + ", diemThaiDo=" + diemThaiDo + ", diemHieuSuat=" + diemHieuSuat + ", bac=" + bac + '}';
    }
    
    
}
