/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksiMySQL;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class connect {
       public static Connection koneksi;
 
    public static Connection getConnection() throws SQLException {
        if (koneksi == null) {
            // panggil Driver MySQL
            new Driver();
            // buat koneksi
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/deteksi_anomali_knn", "root", "");
        }
        return koneksi;
    }

   
}
