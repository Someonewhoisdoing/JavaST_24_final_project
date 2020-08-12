package by.training.coffee.shop.controller.filter;

import by.training.coffee.shop.entity.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ControllerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        //empty method
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String command = req.getParameter("command");
        if (user != null || command.equals("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletResponse resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect(req.getContextPath());
        }
    }

    @Override
    public void destroy() {
        //empty method
    }
}
