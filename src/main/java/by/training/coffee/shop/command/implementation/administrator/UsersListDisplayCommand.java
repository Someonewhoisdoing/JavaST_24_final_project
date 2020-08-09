package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UsersListDisplayCommand implements Command {
    private final static Logger logger = LogManager.getLogger(UsersListDisplayCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        UserService userService = new UserService();
        List<User> users = userService.findAllUsers();
        if (users != null) {
            request.setAttribute("users", users);
            logger.info("all users were found successfully");
        }
        return new Page(Page.ADMINISTRATOR_USERS_PAGE_PATH, false);
    }
}
