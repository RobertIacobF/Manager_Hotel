package Server.Repository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Robert Iacob on 16.05.2017.
 */
public class DatabaseConnection implements ServletContextListener {
    private static Connection connection = null;
    private static DatabaseConnection databaseConnection = null;

    private  DatabaseConnection(){}

    public static DatabaseConnection getDatabaseConnection() {

        if(databaseConnection == null)
            databaseConnection = new DatabaseConnection();

        return databaseConnection;
    }

    public static Connection getConnection() {
        return connection;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        final String DB_URL = "jdbc:mysql://://localhost:3306/hcalifornia";
        final String DB_USER = "root";
        final String DB_PASS = "themachinist.23";
        Connection myConn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            myConn = java.sql.DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            if(myConn != null && !myConn.isClosed()){
                context.setAttribute("connection", myConn);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try{
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
