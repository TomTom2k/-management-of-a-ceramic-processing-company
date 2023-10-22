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
public class CongNhan extends ThanhVien {
    private String maCN;
    private boolean choPhanCong;

    public String getMaCN() {
        return maCN;
    }

    public boolean isChoPhanCong() {
        return choPhanCong;
    }

    public void setMaCN(String maCN) {
        this.maCN = maCN;
    }

    public void setChoPhanCong(boolean choPhanCong) {
        this.choPhanCong = choPhanCong;
    }

    public CongNhan() {}

    public CongNhan(String maCN, boolean choPhanCong, String ten, boolean gioiTinh, LocalDate ngaySinh, LocalDate ngayBatDauLam, String cccd, String dienThoai, boolean trangThai, byte[] avatar) {
        super(ten, gioiTinh, ngaySinh, ngayBatDauLam, cccd, dienThoai, trangThai, avatar);
        this.maCN = maCN;
        this.choPhanCong = choPhanCong;
    }

    @Override
    public String toString() {
        return "CongNhan{" + "maCN=" + maCN + super.toString() + ", choPhanCong=" + choPhanCong + '}';
    }


    
    
}
