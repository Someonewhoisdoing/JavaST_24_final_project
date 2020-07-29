package by.training.coffee.shop.controller;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.CommandFactory;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private final static Logger logger = LogManager.getLogger(Controller.class);
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
            process(request, response);
            logger.info("process in get method");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
            process(request, response);
            logger.info("process in post method");
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String commandValue = request.getParameter("command");
        Command command = CommandFactory.getCommand(commandValue);

        logger.info("page received in Controller");
        try {
            Page page = command.execute(request, response);
            if (page.isRedirect()) {
                redirect(page, request, response);
            } else {
                forward(page, request, response);
            }
        } catch (ServiceException | IOException e) {
            throw new ServletException(e.getMessage(),e);
        }
    }

    private void redirect(Page page, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String url = page.getPageUrl();
        response.sendRedirect(request.getContextPath() + url);
        logger.info("response redirected");
    }

    private void forward(Page page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = page.getPageUrl();
        request.getRequestDispatcher(url).forward(request, response);
        logger.info("request forwarded");
    }
}
