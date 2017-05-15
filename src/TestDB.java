import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Robert Iacob on 10.05.2017.
 */
public class TestDB {
     /**
     * Connect to a sample database
     */
    public static void connect1() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/Robert Iacob/Desktop/Files Origin/1.Java Work/Manager de hotel/chinook.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     *//*
    *//*public static void main(String[] args) {
        connect();
    }*/


    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:C:/Users/Robert Iacob/Desktop/Files Origin/1.Java Work/Manager de hotel/database/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        createNewDatabase("test.db");
    }*/


    /**
     * Create a new table in the test database
     *
     */
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/Robert Iacob/Desktop/Files Origin/1.Java Work/Manager de hotel/database/tests.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        createNewTable();
    }*/


    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/Robert Iacob/Desktop/Files Origin/1.Java Work/Manager de hotel/database/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
    public void insert(String name, double capacity) {
        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //InsertApp app = new InsertApp();
        // insert three new rows
        //app.insert("Raw Materials", 3000);
        //app.insert("Semifinished Goods", 4000);
        //app.insert("Finished Goods", 5000);
    }
}
