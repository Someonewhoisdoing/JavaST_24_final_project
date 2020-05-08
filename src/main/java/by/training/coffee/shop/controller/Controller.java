package by.training.coffee.shop.controller;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.command.factory.CommandFactory;
import by.training.coffee.shop.pool.JDBCConnection;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private final static Logger logger = LogManager.getLogger(Controller.class);

    public Controller() {
        //empty constructor
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            process(request, response);
            logger.info("process in get method");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            process(request, response);
            logger.info("process in post method");
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();

        JDBCConnection jdbcConnection = JDBCConnection.getInstance();
        jdbcConnection.closeConnection();

        logger.info("connection closed");
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Page page;

        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.getCommand(request);

        page = command.execute(request, response);
        logger.info("page received in Controller");

        boolean isRedirect = page.isRedirect();
        if (isRedirect) {
            redirect(page, request, response);
        } else {
            forward(page, request, response);
        }
    }

    private void redirect(Page page, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String url = page.getPageUrl();

        response.sendRedirect(request.getContextPath() + url);
        logger.info("response redirected");
    }

    private void forward(Page page, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = page.getPageUrl();

        request.getRequestDispatcher(url).forward(request, response);
        logger.info("request forwarded");
    }
}
