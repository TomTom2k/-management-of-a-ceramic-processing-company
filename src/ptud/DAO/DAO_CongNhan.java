package ptud.DAO;

import java.util.ArrayList;
import ptud.Entity.CongNhan;
import ptud.DAO.DAOInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import ptud.Entity.BoPhan;
import static ptud.Main.connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TomTom
 */
public class DAO_CongNhan implements DAOInterface<CongNhan> {

    @Override
    public CongNhan get(String id) {
         CongNhan congNhan = null;
        try {
            String query = "SELECT * FROM CongNhan WHERE maCN = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String maCN = resultSet.getString("maCN");
                String ten = resultSet.getString("ten");
                boolean gioiTinh = resultSet.getBoolean("gioiTinh");
                LocalDate ngaySinh = resultSet.getDate("ngaySinh").toLocalDate();
                LocalDate ngayBatDauLam = resultSet.getDate("ngayBatDauLam").toLocalDate();
                String cccd = resultSet.getString("CCCD");
                String dienThoai = resultSet.getString("dienThoai");
                boolean trangThai = resultSet.getBoolean("trangThai");
                byte[] avatar = resultSet.getBytes("avatar");
                boolean choPhanCong = resultSet.getBoolean("choPhanCong");
                congNhan = new CongNhan(maCN, ten, gioiTinh, ngaySinh, ngayBatDauLam, cccd, dienThoai, trangThai, avatar, choPhanCong);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return congNhan;
    }
    
    @Override
    public ArrayList<CongNhan> getAll() {
         ArrayList<CongNhan> dsCongNhan = new ArrayList<CongNhan>();
        try {
            String query = "SELECT * FROM CongNhan";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maCN = resultSet.getString("maCN");
                String ten = resultSet.getString("ten");
                boolean gioiTinh = resultSet.getBoolean("gioiTinh");
                LocalDate ngaySinh = resultSet.getDate("ngaySinh").toLocalDate();
                LocalDate ngayBatDauLam = resultSet.getDate("ngayBatDauLam").toLocalDate();
                String cccd = resultSet.getString("CCCD");
                String dienThoai = resultSet.getString("dienThoai");
                boolean trangThai = resultSet.getBoolean("trangThai");
                byte[] avatar = resultSet.getBytes("avatar");
                boolean choPhanCong = resultSet.getBoolean("choPhanCong");
                CongNhan congNhan = new CongNhan(maCN, ten, gioiTinh, ngaySinh, ngayBatDauLam, cccd, dienThoai, trangThai, avatar, choPhanCong);
                
                dsCongNhan.add(congNhan);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsCongNhan;
    }

    @Override
    public boolean insert(CongNhan congNhan) {
        try {
            String sql = "INSERT INTO CongNhan ([maCN], [ten], [gioiTinh], [ngaySinh], [ngayBatDauLam], [CCCD], [dienThoai], [trangThai], [avatar], [choPhanCong]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, congNhan.getMaCN());
            statement.setString(2, congNhan.getTen());
            statement.setBoolean(3, congNhan.isGioiTinh());
            statement.setDate(4, java.sql.Date.valueOf(congNhan.getNgaySinh()));
            statement.setDate(5, java.sql.Date.valueOf(congNhan.getNgayBatDauLam()));
            statement.setString(6, congNhan.getCccd());
            statement.setString(7, congNhan.getDienThoai());
            statement.setBoolean(8, congNhan.isTrangThai());
            statement.setBytes(9, congNhan.getAvatar());
            statement.setBoolean(10, congNhan.isChoPhanCong());
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

   @Override
    public boolean update(CongNhan congNhan) {
        try {
            String sql = "UPDATE [dbo].[CongNhan] SET [ten] = ?, [gioiTinh] = ?, [ngaySinh] = ?, [ngayBatDauLam] = ?, [CCCD] = ?, [dienThoai] = ?, [trangThai] = ?, [avatar] = ?, [choPhanCong] = ? WHERE [maCN] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, congNhan.getTen());
            statement.setBoolean(2, congNhan.isGioiTinh());
            statement.setDate(3, java.sql.Date.valueOf(congNhan.getNgaySinh()));
            statement.setDate(4, java.sql.Date.valueOf(congNhan.getNgayBatDauLam()));
            statement.setString(5, congNhan.getCccd());
            statement.setString(6, congNhan.getDienThoai());
            statement.setBoolean(7, congNhan.isTrangThai());
            statement.setBytes(8, congNhan.getAvatar());
            statement.setBoolean(9, congNhan.isChoPhanCong());
            statement.setString(10, congNhan.getMaCN());
            
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        try {
            String sql = "UPDATE [dbo].[CongNhan] SET [trangThai] = ? WHERE [maCN] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1, false);
            statement.setString(2, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
