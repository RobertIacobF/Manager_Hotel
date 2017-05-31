package Server.Servlet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServletCustomer extends HttpServlet {
    @Resource (name="hcalifornia")
    private DataSource res;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            res.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String cnp = request.getParameter("cnp");
        String ci = request.getParameter("ci");
        String nrtel = request.getParameter("nrtel");
        String email = request.getParameter("email");
        //RequestDispatcher dispatcher = //lab 9
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String deleteSQL = "delete from hotel_customers where username = ?" + username;

        try(Connection connection = (Connection) this.getServletContext().getAttribute("connection");
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL))
        {
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
