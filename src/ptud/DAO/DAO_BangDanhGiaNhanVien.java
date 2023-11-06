package ptud.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ptud.DAO.DAOInterface;
import ptud.Entity.BangDanhGiaNhanVien;
import ptud.Entity.NhanVien;
import static ptud.Main.connection;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TomTom
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ptud.DAO.DAOInterface;
import ptud.Entity.BangDanhGiaNhanVien;
import ptud.Entity.NhanVien;
import static ptud.Main.connection;

public class DAO_BangDanhGiaNhanVien implements DAOInterface<BangDanhGiaNhanVien>{
    
    public static DAO_BangDanhGiaNhanVien getInstance() {
        return new DAO_BangDanhGiaNhanVien();
    }

    @Override
    public BangDanhGiaNhanVien get(String id) {
        BangDanhGiaNhanVien bangDanhGia = null;
        try {
            String query = "SELECT * FROM BangDanhGiaNhanVien WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String maBDG = resultSet.getString("maBDG");
                NhanVien nhanVien = new DAO_NhanVien().get(resultSet.getString("maNV"));
                int nam = resultSet.getInt("nam");
                float diemChuyenCan = resultSet.getFloat("diemChuyenCan");
                float diemChuyenMon = resultSet.getFloat("diemChuyenMon");
                float diemThaiDo = resultSet.getFloat("diemThaiDo");
                float diemHieuSuat = resultSet.getFloat("diemHieuSuat");
                char bac = resultSet.getString("bac").charAt(0);
                bangDanhGia = new BangDanhGiaNhanVien(maBDG, nhanVien, nam, diemChuyenCan, diemChuyenMon, diemThaiDo, diemHieuSuat, bac);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bangDanhGia;
    }

    @Override
    public ArrayList<BangDanhGiaNhanVien> getAll() {
        ArrayList<BangDanhGiaNhanVien> dsBangDanhGia = new ArrayList<BangDanhGiaNhanVien>();
        try {
            String query = "SELECT * FROM BangDanhGiaNhanVien";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String maBDG = resultSet.getString("maBDG");
                NhanVien nhanVien = new DAO_NhanVien().get(resultSet.getString("maNV"));
                int nam = resultSet.getInt("nam");
                float diemChuyenCan = resultSet.getFloat("diemChuyenCan");
                float diemChuyenMon = resultSet.getFloat("diemChuyenMon");
                float diemThaiDo = resultSet.getFloat("diemThaiDo");
                float diemHieuSuat = resultSet.getFloat("diemHieuSuat");
                char bac = resultSet.getString("bac").charAt(0);
                BangDanhGiaNhanVien bangDanhGia = new BangDanhGiaNhanVien(maBDG, nhanVien, nam, diemChuyenCan, diemChuyenMon, diemThaiDo, diemHieuSuat, bac);
                
                dsBangDanhGia.add(bangDanhGia);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dsBangDanhGia;
    }

    @Override
    public boolean insert(BangDanhGiaNhanVien bangDanhGia) {
        try {
            String sql = "INSERT INTO BangDanhGiaNhanVien ([id], [maNV], [nam], [diemChuyenCan], [diemChuyenMon], [diemThaiDo], [diemHieuSuat], [bac]) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bangDanhGia.getMaBDG());
            statement.setString(2, bangDanhGia.getNhanVien().getMaNV());
            statement.setInt(3, bangDanhGia.getNam());
            statement.setFloat(4, bangDanhGia.getDiemChuyenCan());
            statement.setFloat(5, bangDanhGia.getDiemChuyenMon());
            statement.setFloat(6, bangDanhGia.getDiemThaiDo());
            statement.setFloat(7, bangDanhGia.getDiemHieuSuat());
            statement.setString(8, String.valueOf(bangDanhGia.getBac()));
            
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
    public boolean update(BangDanhGiaNhanVien bangDanhGia) {
        try {
            String sql = "UPDATE [dbo].[BangDanhGiaNhanVien] SET [maNV] = ?, [nam] = ?, [diemChuyenCan] = ?, [diemChuyenMon] = ?, [diemThaiDo] = ?, [diemHieuSuat] = ?, [bac] = ? WHERE [id] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bangDanhGia.getNhanVien().getMaNV());
            statement.setInt(2, bangDanhGia.getNam());
            statement.setFloat(3, bangDanhGia.getDiemChuyenCan());
            statement.setFloat(4, bangDanhGia.getDiemChuyenMon());
            statement.setFloat(5, bangDanhGia.getDiemThaiDo());
            statement.setFloat(6, bangDanhGia.getDiemHieuSuat());
            statement.setString(7, String.valueOf(bangDanhGia.getBac()));
            statement.setString(8, bangDanhGia.getMaBDG());
            
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
    public boolean deleteById(String maBDG) {
        try {
            String sql = "DELETE FROM [dbo].[BangDanhGiaNhanVien] WHERE [id] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, maBDG);

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
