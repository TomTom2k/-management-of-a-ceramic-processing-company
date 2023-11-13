/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.DAO;

/**
 *
 * @author TranLoc
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import ptud.Connection.ConnectDB;
import static ptud.Main.connection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class DAO_TaiKhoan {

    public static DAO_TaiKhoan getInstance() {
        return new DAO_TaiKhoan();
    }

    
    
    
    public static String hashPassword(String password, int length) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString().substring(0, Math.min(length, sb.length()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int getUserRole(String username, String password) throws SQLException {
        String query =  "select vaiTro\n" +
                        "from [dbo].[TaiKhoan]\n" +
                        "where userName like ? and matKhau like ?";
        PreparedStatement statement;
        statement = connection.prepareStatement(query);
        statement.setString(1, username);
        statement.setString(2, hashPassword(password, 16));
        ResultSet resultSet = statement.executeQuery(); 
        if (resultSet.next()) {
            return resultSet.getInt("vaiTro");
        }
        return 0;
    }
}