package Server.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by alexd on 6/1/2017.
 */
@WebFilter(urlPatterns = "/logout.do")
public class LogoutServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }


}
