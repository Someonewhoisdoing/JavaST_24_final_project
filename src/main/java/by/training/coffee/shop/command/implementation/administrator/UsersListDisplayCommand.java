package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.UserServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UsersListDisplayCommand implements Command {
    private final static Logger logger = LogManager.getLogger(UsersListDisplayCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        UserServiceImplementation userServiceImplementation = new UserServiceImplementation();

        try {
            List<User> users = userServiceImplementation.findAllUsers();

            if (users != null) {
                request.setAttribute("users", users);

                logger.info("all users were found successfully");
            }
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                userServiceImplementation.closeConnection();
            } catch (ServiceException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return new Page(Page.ADMINISTRATOR_USERS_PAGE_PATH, false);
    }
}
