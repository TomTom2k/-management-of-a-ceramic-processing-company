/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import ptud.Connection.ConnectDB;
import ptud.Entity.PhieuChamCongHanhChinh;
import static ptud.Main.connection;
/**
 *
 * @author DELL
 */
public class DAO_PhieuChamCongNhanVien {
    public static DAO_PhieuChamCongCongNhan getInstance() {
        return new DAO_PhieuChamCongCongNhan();
    }
    
    public static String formatChuoi(int thang, int nam, String idNV) {
        String thangStr = String.format("%02d", thang);
        String namStr = String.format("%02d", nam % 100);
        return thangStr + namStr + idNV;
    }
        
    public int getSoNgayLam(String idNV, int thang, int nam) throws SQLException {
            String query = "select count(*) as soLuong\n" +
                            "from [dbo].[PhieuChamCongHanhChinh]\n" +
                            "where maPCCHC like ? and vang = 0";
            PreparedStatement statement;
            statement = connection.prepareStatement(query);
            statement.setString(1, "%" + formatChuoi(thang, nam, idNV));
            ResultSet resultSet = statement.executeQuery(); 
            if (resultSet.next()) {
                return resultSet.getInt("soLuong");
            }
            return -1;

    }
    public static String formatID_PCCHC(LocalDate date, String idNV) {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("ddMMyy"));
        return formattedDate + idNV;
    }
    public boolean insert(PhieuChamCongHanhChinh PCCHC) throws SQLException {
        String query = "INSERT INTO [dbo].[PhieuChamCongHanhChinh]\n" +
"           ([maPCCHC]\n" +
"           ,[ngayChamCong]\n" +
"           ,[maNV]\n" +
"           ,[vang]\n" +
"           ,[diTre]\n" +
"           ,[gioTangCa]\n" +
"           ,[tienPhat]\n" +
"           ,[noiDungPhat])\n" +
"     VALUES\n" +
"           (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);   
        statement.setString(1, formatID_PCCHC(PCCHC.getNgay(), PCCHC.getMaNV()));
        statement.setDate(2, Date.valueOf(PCCHC.getNgay()));
        statement.setString(3, PCCHC.getMaNV());
        statement.setBoolean(4, PCCHC.isVang());
        statement.setBoolean(5, PCCHC.isDiTre());
        statement.setInt(6, PCCHC.getGioTangCa());
        statement.setFloat(7, (float) PCCHC.getTienPhat());
        statement.setString(8, PCCHC.getNoiDungTienPhat());
        int rowsAffected = statement.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        }
        return false;
    }
    public float getTongGioTangCaTrongThang(String idNV, int thang, int nam) throws SQLException {
        String query =  "select sum(gioTangCa) as tongGio\n" +
                        "from [dbo].[PhieuChamCongHanhChinh]\n" +
                        "where maPCCHC like ? and vang = 0";
        PreparedStatement statement;
        statement = connection.prepareStatement(query);
        statement.setString(1, "%" + formatChuoi(thang, nam, idNV));
        ResultSet resultSet = statement.executeQuery(); 
        if (resultSet.next()) {
            return resultSet.getFloat("tongGio");
        }
        return 0;
    }
}
