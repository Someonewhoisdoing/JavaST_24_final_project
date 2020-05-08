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

public class RegistrationCommand implements Command {
    private final static Logger logger = LogManager.getLogger(RegistrationCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        UserServiceImplementation userServiceImplementation = new UserServiceImplementation();

        User newUser = new User();
        newUser.setLogin(request.getParameter("login"));
        newUser.setPassword("password");
        newUser.setName("name");
        newUser.setSurname("surname");
        newUser.setPhone("phone");
        //guest=0; admin=1; client=2;
        newUser.setRole(Integer.parseInt("role"));

        try {
            userServiceImplementation.create(newUser);
            httpSession.setAttribute("newUser", newUser);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
        }
        return new Page(Page.USER_PERSONAL_PAGE_PATH, false);
    }
}
