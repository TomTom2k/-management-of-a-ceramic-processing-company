/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ptud;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import ptud.Connection.ConnectDB;
import ptud.GUI.*;

/**
 *
 * @author TomTom, TranLoc
 */
public class Main {

    public static void main(String[] args) {
        begin();
    }
    public static Connection connection = null;

    public static void begin() {
        boolean isConnected = ConnectDB.connectDatabase(); // Thực hiện kết nối và lấy kết quả
        if (isConnected) {
            // Kết nối thành công, hiển thị giao diện người dùng
            System.out.println("Đã kết nối đến cơ sở dữ liệu.");
            SplashScreen sp = new SplashScreen();
            sp.setVisible(true);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            sp.setVisible(false);
            new Login().setVisible(true);
        } else {
            // Xử lý khi kết nối không thành công
             System.out.println("Chưa kết nối đến cơ sở dữ liệu.");
            // Thực hiện các xử lý khác tùy theo yêu cầu của bạn
        }
    }

}
