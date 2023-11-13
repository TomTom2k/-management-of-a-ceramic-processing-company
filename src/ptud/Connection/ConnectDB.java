/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud.Connection;

/**
 *
 * @author TomTom
 */
public class ConnectDB {

    private static ConnectDB instance = new ConnectDB();
    private static java.sql.Connection connection = null;

    //Constructor
    public ConnectDB() {
    }

    //Get
    public static ConnectDB getInstance() {
        return instance;
    }

    public static java.sql.Connection getConnection() {
        return connection;
    }

    //Methods
    public static boolean connectDatabase() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyLSP;encrypt=true;trustServerCertificate=true;";
            String username = "sa";
            String password = "12345678";
            connection = java.sql.DriverManager.getConnection(url, username, password);
            return true; // Trả về true nếu kết nối thành công
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return false; // Trả về false nếu kết nối không thành công
        }
    }

    public static boolean disconnectDatabase() {
        if (connection != null) {
            try {
                connection.close();
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
        return connection != null;
    }
}
