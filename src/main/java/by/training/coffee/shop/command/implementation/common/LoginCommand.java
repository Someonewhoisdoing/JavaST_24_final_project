package by.training.coffee.shop.command.implementation.common;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.UserServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private final static Logger logger = LogManager.getLogger(LoginCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserServiceImplementation userServiceImplementation = new UserServiceImplementation();

        try {
            if ((login != null) && (password != null)) {
                logger.info("login and password received");

                User userByLoginAndPassword = userServiceImplementation.findUserByLoginAndPassword(login, password);
                httpSession.setAttribute("userByLoginAndPassword", userByLoginAndPassword);

                if (userByLoginAndPassword != null) {
                    if (userByLoginAndPassword.getRole() == 1) {
                        return new Page(Page.ADMINISTRATOR_PAGE_PATH, false);
                    } else if (userByLoginAndPassword.getRole() == 2) {
                        return (new Page(Page.USER_PERSONAL_PAGE_PATH, false));
                    }
                }
            }
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
        }
        //error page??
        return new Page(Page.LOGIN_PAGE_PATH, false);
    }
}
