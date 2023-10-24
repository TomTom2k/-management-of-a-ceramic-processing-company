/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Entity;

/**
 *
 * @author TomTom
 */
public class BangDanhGia {
    private long id;
    private ThanhVien thanhVien;
    private int nam;
    private float diemChuyenCan;
    private float diemchuyenMon;
    private float diemThaiDo;
    private float diemHieuSuat;
    private char bac;

    public long getId() {
        return id;
    }

    public ThanhVien getThanhVien() {
        return thanhVien;
    }

    public int getNam() {
        return nam;
    }

    public float getDiemChuyenCan() {
        return diemChuyenCan;
    }

    public float getDiemchuyenMon() {
        return diemchuyenMon;
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

    public void setId(long id) {
        this.id = id;
    }

    public void setThanhVien(ThanhVien thanhVien) {
        this.thanhVien = thanhVien;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public void setDiemChuyenCan(float diemChuyenCan) {
        this.diemChuyenCan = diemChuyenCan;
    }

    public void setDiemchuyenMon(float diemchuyenMon) {
        this.diemchuyenMon = diemchuyenMon;
    }

    public void setDiemThaiDo(float diemThaiDo) {
        this.diemThaiDo = diemThaiDo;
    }

    public void setDiemHieuSuat(float diemHieuSuat) {
        this.diemHieuSuat = diemHieuSuat;
    }
    
    public void tinhBac() {
        float tong = this.diemChuyenCan + this.diemHieuSuat + this.diemThaiDo + this.diemchuyenMon;
        if(tong < 20)   
            this.bac = 'D';
        else if(tong <25)
            this.bac = 'C';
        else if(tong <35)
            this.bac = 'B';
        else 
            this.bac = 'A';
    }

    public BangDanhGia() {
    }

    public BangDanhGia(long id, ThanhVien thanhVien, int nam, float diemChuyenCan, float diemchuyenMon, float diemThaiDo, float diemHieuSuat) {
        this.id = id;
        this.thanhVien = thanhVien;
        this.nam = nam;
        this.diemChuyenCan = diemChuyenCan;
        this.diemchuyenMon = diemchuyenMon;
        this.diemThaiDo = diemThaiDo;
        this.diemHieuSuat = diemHieuSuat;
    }

    @Override
    public String toString() {
        return "BangDanhGia{" + "id=" + id + ", thanhVien=" + thanhVien + ", nam=" + nam + ", diemChuyenCan=" + diemChuyenCan + ", diemchuyenMon=" + diemchuyenMon + ", diemThaiDo=" + diemThaiDo + ", diemHieuSuat=" + diemHieuSuat + ", bac=" + bac + '}';
    }
    
    
}