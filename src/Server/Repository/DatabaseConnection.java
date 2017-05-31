package Server.Repository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection{
    private static Connection conn = null;
    private static String DB_URL = "jdbc:mysql://://localhost:3306/hcalifornia";
    private static String DB_USER = "root";
    private static String DB_PASS = "themachinist.23";

    public static Connection connToDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            return conn;
        } catch (Exception ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString());
            return null;
        }
    }

    public void destroyConnToDB(){
        try {
            if (conn != null)
                conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
