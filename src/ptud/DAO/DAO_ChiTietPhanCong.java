/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.DAO;

import java.util.ArrayList;
import ptud.Entity.ChiTietPhanCong;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import static ptud.Main.connection;
/**
 *
 * @author KHANH PC
 */


public class DAO_ChiTietPhanCong implements DAOInterface<ChiTietPhanCong>{

    public static DAO_ChiTietPhanCong getInstance() {
        return new DAO_ChiTietPhanCong();
    }
    @Override
    public ChiTietPhanCong get(String id) {
        // let code to get ChiTietPhanCong t from database
        ChiTietPhanCong t = null;
        try {
            String query = "SELECT * FROM ChiTietPhanCong WHERE maCTPC = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String maCTPC = resultSet.getString("maCTPC");
                String maCD = resultSet.getString("maCD");
                String maCN = resultSet.getString("maCN");
                LocalDate ngay = resultSet.getDate("ngay").toLocalDate();
                int soLuongCDGiao = resultSet.getInt("soLuongCDGiao");
                t = new ChiTietPhanCong(maCTPC, maCD, maCN, ngay, soLuongCDGiao);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return t;

    }

    @Override
    public ArrayList<ChiTietPhanCong> getAll() {
        // let code to get all ChiTietPhanCong t from database
        ArrayList<ChiTietPhanCong> chiTietPhanCongs = new ArrayList<>();
        try {
            String query = "SELECT * FROM ChiTietPhanCong";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                String maCTPC = resultSet.getString("maCTPC");
                String maCD = resultSet.getString("maCD");
                String maCN = resultSet.getString("maCN");
                LocalDate ngay = resultSet.getDate("ngay").toLocalDate();
                int soLuongCDGiao = resultSet.getInt("soLuongCDGiao");
                
                ChiTietPhanCong chiTietPhanCong = new ChiTietPhanCong(maCTPC, maCD, maCN, ngay, soLuongCDGiao);
                chiTietPhanCongs.add(chiTietPhanCong);
            }
            
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chiTietPhanCongs;
    }

    @Override
    public boolean insert(ChiTietPhanCong t) {
        // let code to get insert ChiTietPhanCong t from database
        try {
            String query = "INSERT INTO ChiTietPhanCong (maCTPC, maCD, maCN, ngay, soLuongCDGiao) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, t.getMaCTPC());
            statement.setString(2, t.getMaCD());
            statement.setString(3, t.getMaCN());
            statement.setDate(4, Date.valueOf(t.getNgay()));
            statement.setInt(5, t.getSoLuongCDGiao());
            
            int rowsAffected = statement.executeUpdate();
            statement.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(ChiTietPhanCong t) {
        // let code to get update ChiTietPhanCong t from database
        try {
            String query = "UPDATE ChiTietPhanCong SET maCD = ?, maCN = ?, ngay = ?, soLuongCDGiao = ? WHERE maCTPC = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, t.getMaCD());
            statement.setString(2, t.getMaCN());
            statement.setDate(3, Date.valueOf(t.getNgay()));
            statement.setInt(4, t.getSoLuongCDGiao());
            statement.setString(5, t.getMaCTPC());
            
            int rowsAffected = statement.executeUpdate();
            statement.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteById(String id) {
        // let code to get delete ChiTietPhanCong t from database
        try {
            String query = "DELETE FROM ChiTietPhanCong WHERE maCTPC = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setString(1, id);
            
            int rowsAffected = statement.executeUpdate();
            statement.close();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
}

// This is my table
//  CREATE TABLE ChiTietPhanCong (
// 	maCTPC VARCHAR(20),
//     maCD VARCHAR(20),
//     maCN VARCHAR(20),
//     ngay DATE,
//     soLuongCDGiao INT,
//     PRIMARY KEY (maCTPC),
//     FOREIGN KEY (maCD) REFERENCES CongDoan(maCD),
//     FOREIGN KEY (maCN) REFERENCES CongNhan(maCN)
// );

// this is my code entity
// public ChiTietPhanCong(String maCTPC, String maCD, String maCN, LocalDate ngay, int soLuongCDGiao) {
//     this.maCTPC = maCTPC;
//     this.maCD = maCD;
//     this.maCN = maCN;
//     this.ngay = ngay;
//     this.soLuongCDGiao = soLuongCDGiao;
// }