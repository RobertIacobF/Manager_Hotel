package Server.Servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by alexd on 6/1/2017.
 */
@WebFilter(urlPatterns = "*.do")
public class LoginRequiredFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletResponse;

        if (request.getSession().getAttribute("name") != null) {
            chain.doFilter(servletRequest, servletResponse);
        } else {
            request.getRequestDispatcher("/login.do").forward(servletRequest,
                    servletResponse);
        }
    }

    @Override
    public void destroy()
    {

    }


}
