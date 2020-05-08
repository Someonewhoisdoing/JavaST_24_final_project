package by.training.coffee.shop.controller.filter;

import by.training.coffee.shop.command.Page;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class ControllerFilter implements Filter {
    private final static Logger logger = LogManager.getLogger(ControllerFilter.class);
    private FilterConfig filterConfig;
    private boolean isActive = false;

    /**
     * Method for initializing filter
     *
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        String active = filterConfig.getInitParameter("active");

        if (active != null) {
            isActive = (active.equalsIgnoreCase("TRUE"));
            logger.info("filter is initialised");
        }
    }

    /**
     * Method to make filtration
     *
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        if (isActive) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String uri = httpServletRequest.getPathInfo();

            HttpSession httpSession = httpServletRequest.getSession();

            if ((httpSession == null)
                    && (uri.contains("home.jsp")
                    || (uri.contains("home.jsp") && uri.contains("menu.jsp")))) {
                logger.info("session is null");

                RequestDispatcher requestDispatcher = servletRequest.getServletContext().getRequestDispatcher(Page.LOGIN_PAGE_PATH);
                requestDispatcher.forward(servletRequest, servletResponse);
            } else {
                logger.info("session is not null");
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    /**
     * Method to free resources
     *
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        filterConfig = null;
        logger.info("resources of filter are released");
    }
}
