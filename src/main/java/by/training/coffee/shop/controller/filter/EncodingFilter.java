package by.training.coffee.shop.controller.filter;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private final static Logger logger = LogManager.getLogger(EncodingFilter.class);
    private String code;

    /**
     * Method for initializing filter
     *
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        code = fConfig.getInitParameter("encoding");
        logger.info("filter is initialised");
    }

    /**
     * Method to make filtration
     *
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String codeRequest = request.getCharacterEncoding();

        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            request.setCharacterEncoding(code);
            response.setCharacterEncoding(code);
            logger.info("encoding is set");
        }
        chain.doFilter(request, response);
    }

    /**
     * Method to free resources
     *
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        code = null;
        logger.info("resources of filter are released");
    }
}
