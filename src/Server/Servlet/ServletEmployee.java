package Server.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServletEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rank = request.getParameter("rank");

        String addSQL = "insert into hotel_employees(username, password, rank)" + "?, ?, ?";

        try(Connection connection = (Connection) this.getServletContext().getAttribute("connection");
            PreparedStatement preparedStatement = connection.prepareStatement(addSQL))
        {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, rank);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String deleteSQL = "delete from hotel_employees where username = ?" + username;

        try(Connection connection = (Connection) this.getServletContext().getAttribute("connection");
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL))
        {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
