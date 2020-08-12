package by.training.coffee.shop.command.implementation.common;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToAccountPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ToAccountPageCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();

        User currentUser = (User) httpSession.getAttribute("user");
        Integer role = null;

        if (currentUser != null) {
            role = currentUser.getRole();
        }

        if (role == null) {
            logger.info("role is null");
            return new Page(Page.LOGIN_PAGE_PATH, false);
        }

        return (role == 1)
                ? new Page(Page.ADMINISTRATOR_PAGE_PATH, false)
                : new Page(Page.USER_PERSONAL_PAGE_PATH, false);
    }
}
