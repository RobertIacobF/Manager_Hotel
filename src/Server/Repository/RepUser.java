package Server.Repository;

import Server.Model.User;

import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Robert Iacob on 14.05.2017.
 */
public class RepUser extends HttpServlet implements IRepUser {
    //TODO adauga, sterge, update useri, indiferent de tip

    private static RepUser repUserInstance = null;

    private RepUser() { }

    public static RepUser getRepUserInstance() {
        if(repUserInstance == null)
            repUserInstance = new RepUser();
        return repUserInstance;
    }

    @Override
    public void createUser(User newUser) {
        String addSQL = "insert into hotel_customers (username, password, name, surname, cnp, ci, nrtel, email)" + "values(?, ?, ?, ?, ?, ?, ?, ?)";
        DatabaseConnection databaseConnection = DatabaseConnection.getDatabaseConnection();

        try(Connection connection = (Connection) this.getServletContext().getAttribute("connection");
            PreparedStatement preparedStatement = connection.prepareStatement(addSQL))
        {
            /*preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, surname);
            preparedStatement.setString(5, cnp);
            preparedStatement.setString(6, ci);
            preparedStatement.setString(7, nrtel);
            preparedStatement.setString(8, email);
            preparedStatement.execute();*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User readUser(String username) {
        return null;
    }

    @Override
    public void updateUser(String username, User newUserModel) {

    }

    @Override
    public void deleteUser(String username) {

    }
}
