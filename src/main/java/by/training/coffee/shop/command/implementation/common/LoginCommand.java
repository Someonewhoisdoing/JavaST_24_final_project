package by.training.coffee.shop.command.implementation.common;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.UserService;
import by.training.coffee.shop.util.SHAPassword;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class);
    private static final UserService userService = new UserService();

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        logger.info("login and password received");
        String encodedPass = SHAPassword.hashPassword(password);

        User user = userService.selectUserByLoginAndPassword(login, encodedPass);
        httpSession.setAttribute("user", user);

        if (user != null) {
            if (user.getRole() == 1) {
                return new Page(Page.ADMINISTRATOR_PAGE_PATH, false);
            } else if (user.getRole() == 2) {
                return (new Page(Page.USER_PERSONAL_PAGE_PATH, false));
            }
        }
        return new Page(Page.LOGIN_PAGE_PATH, false);
    }
}
