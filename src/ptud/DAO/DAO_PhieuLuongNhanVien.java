/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;

import ptud.Connection.ConnectDB;
import ptud.Entity.PhieuLuongNhanVien;
import static ptud.Main.connection;

/**
 *
 * @author KHANH PC
 */
public class DAO_PhieuLuongNhanVien implements DAOInterface<PhieuLuongNhanVien> {

    // make method to create an instance
    public ConnectDB connectDB = ConnectDB.getInstance(); 
    
    public static DAO_PhieuLuongNhanVien getInstance() {
        return new DAO_PhieuLuongNhanVien();
    }
   
    @Override
    public boolean insert(PhieuLuongNhanVien t) {
        //let code to insert PhieuLuongNhanVien t to database sqlserver 
        try {
            // Create a PreparedStatement to insert the data  
            
//            connectDB.connectDatabase();
//            Connection connection = ConnectDB.getConnection(); 
            String query = "INSERT INTO PhieuLuongNhanVien (maPL, thang, nam, maNV, luong, thuong, phat, phuCap, soNgayLam, luongThucNhan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            
            // Set the values of the parameters
            statement.setString(1, t.getMaPL());
            statement.setInt(2, t.getThang());
            statement.setInt(3, t.getNam());
            statement.setString(4, t.getMaNV());
            statement.setDouble(5, t.getLuong());
            statement.setDouble(6, t.getThuong());
            statement.setDouble(7, t.getPhat());
            statement.setDouble(8, t.getPhuCap());
            statement.setInt(9, t.getSoNgayLam());
            statement.setDouble(10, t.getLuongThucNhan());

            
            // Execute the query
            int rowsAffected = statement.executeUpdate();
          
            // Check if the insert was successful
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean update(PhieuLuongNhanVien t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PhieuLuongNhanVien get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<PhieuLuongNhanVien> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
// this is my database
/* 
CREATE TABLE PhieuLuongNhanVien (
    maPL VARCHAR(20) PRIMARY KEY,
thang INT,
nam INT,
maNV VARCHAR(20),
luong FLOAT(10),
thuong FLOAT(10),
    phat FLOAT(10),
    phuCap FLOAT(10),
soNgayLam INT,
luongThucNhan FLOAT(10),
FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
*/ 

    
