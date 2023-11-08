package ptud.DAO;


import java.util.ArrayList;
import ptud.DAO.DAOInterface;
import ptud.Entity.BoPhan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static ptud.Main.connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TomTom
 */
public class DAO_BoPhan implements DAOInterface<BoPhan> {

    @Override
    public BoPhan get(String id) {
        BoPhan boPhan = null;
        try {
            String query = "SELECT * FROM BoPhan WHERE maBP = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String tenBP = resultSet.getString("tenBP");
                boPhan = new BoPhan(id, tenBP);
            }

    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return boPhan;
    }

    @Override
    public ArrayList<BoPhan> getAll() {
        ArrayList<BoPhan> dsBoPhan = new ArrayList<BoPhan>();
        try {
            String query = "SELECT * FROM BoPhan";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String maBP = resultSet.getString("maBP");
                String tenBP = resultSet.getString("tenBP");
                BoPhan boPhan = new BoPhan(maBP, tenBP);
                dsBoPhan.add(boPhan);

        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dsBoPhan;
    }

    @Override
    public boolean insert(BoPhan boPhan) {
        try {
            String query = "INSERT INTO BoPhan (maBP, tenBP) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, boPhan.getMaBP());
            statement.setString(2, boPhan.getTenBP());

            int rowAffected = statement.executeUpdate();
            if (rowAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(BoPhan boPhan) {
        try {
            String query = "UPDATE BoPhan SET tenBP = ? WHERE maBP = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, boPhan.getTenBP());
            statement.setString(2, boPhan.getMaBP());

            int rowAffected = statement.executeUpdate();
            if (rowAffected > 0) {
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
            String query = "DELETE FROM SanPham WHERE maBP = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, id);

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
