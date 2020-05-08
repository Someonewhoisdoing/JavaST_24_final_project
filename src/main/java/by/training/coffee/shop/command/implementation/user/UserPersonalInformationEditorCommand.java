package by.training.coffee.shop.command.implementation.user;

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

public class UserPersonalInformationEditorCommand implements Command {
    private static final Logger logger = LogManager.getLogger(UserPersonalInformationEditorCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        User currentUser = (User) httpSession.getAttribute("userByLoginAndPassword");

        UserServiceImplementation userServiceImplementation = new UserServiceImplementation();

        if (currentUser != null) {
            currentUser.setId(currentUser.getId());
            currentUser.setLogin(request.getParameter("login"));
            currentUser.setPassword(request.getParameter("password"));
            currentUser.setName(request.getParameter("name"));
            currentUser.setSurname(request.getParameter("surname"));
            currentUser.setPhone(request.getParameter("phone"));
        }
        try {
            boolean isUserUpdated = userServiceImplementation.updateUser(currentUser);
            if (isUserUpdated) {
                httpSession.setAttribute("userUpdated", currentUser);
                logger.info("user updated");
            }
        } catch (ServiceException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                userServiceImplementation.closeConnection();
                logger.info("connection closed");
            } catch (ServiceException e) {
                logger.error(e.getMessage());
            }
        }
        return new Page(Page.USER_PERSONAL_PAGE_PATH, false);
    }
}
