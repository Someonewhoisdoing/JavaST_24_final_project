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

public class PersonalInformationDisplayCommand implements Command {
    private final static Logger logger = LogManager.getLogger(PersonalInformationDisplayCommand.class);
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        User user = null;
        UserServiceImplementation userServiceImplementation = new UserServiceImplementation();
        String id = request.getParameter("id");
        try {
            if(id != null) {
                user = userServiceImplementation.findUserById(Long.parseLong(id));
                logger.info("user found by ID");
            }
            httpSession.setAttribute("currentUser", user);
        }catch (ServiceException e){
            logger.error(e.getMessage(), e);
        }finally {
            try {
                userServiceImplementation.closeConnection();
                logger.info("connection closed");
            } catch (ServiceException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return new Page(Page.USER_PERSONAL_PAGE_PATH, true);
    }
}
