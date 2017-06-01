package Server.Repository;

import Server.Model.User;

import javax.servlet.http.HttpServlet;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepUser {
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;

    public RepUser() {
        conn = DatabaseConnection.connToDB();
    }

    public void insertUser(User user)  {
        try {
            String insertQuery = "insert into user" + "('" + "name" + "'," + "'" + "address" + "','" + "phone" + "','" + "type" + "')"
                    + " values('"
                    + user.getUsername() + "','"
                    + user.getAddress() + "'" + ",'"
                    + user.getPhone_no() + "'" + ",'"
                    + user.getType() + "'"
                    + ")";

            statement = conn.prepareStatement(insertQuery);
            statement.execute();

            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, "successfully inserted new Customer");

        }
        catch (SQLException e) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, e.toString() + "\n" + "InsertQuery Failed");
        }
        finally {
            closeStatementOnly();
        }
    }

    public void updateUser(User user) {
        try {
            String updateQuery = "update userInfo set name = '"
                    + user.getUsername() + "',"
                    + "address = '" + user.getAddress() + "',"
                    + "phone = '" + user.getPhone_no() + "',"
                    + "type = '" + user.getType() + "' where user_id= "
                    + user.getUserId();

            statement = conn.prepareStatement(updateQuery);
            statement.execute();

            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, "successfully updated new Customer");
        }
        catch (SQLException e) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, e.toString() + "\n" + "Update query Failed");
        }
        finally {
            closeStatementOnly();
        }
    }

    public void deleteUser(int userId) {
        try {
            String deleteQuery = "delete from userInfo where user_id=" + userId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();

            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, "Deleted user");
        }
        catch (SQLException e) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, e.toString() + "\n" + "Delete query Failed");
        }
        finally {
            closeStatementOnly();
        }
    }


    public int getNoAllUsers(){
        return 0;
    }

    public int getNoAllCustomers(){
        return 0;
    }

    public int getNoAllEmployees(){
        return 0;
    }


    public ResultSet getAllUsers() {
        try {
            String query = "select * from userInfo";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch (SQLException e) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, e.toString() + "\n error coming from returning all customer DB Operation");
        }
        return result;
    }

    public ResultSet getAllCustomers(){
        return result;
    }

    public ResultSet getAllEmployees(){
        return result;
    }

    public ResultSet getAllAdmins(){
        return result;
    }


    public ResultSet searchCustomerById(String customerID){
        return result;
    }

    public void closeAll() {
        try {
            statement.close();
            result.close();
        }
        catch (SQLException e) {
            System.err.print(e.toString() + " >> CLOSING");
        }
    }

    public void closeStatementOnly() {
        try {
            statement.close();
            conn.close();
        }
        catch (SQLException e) {
            System.err.print(e.toString() + " >> CLOSING");
        }
    }
}
