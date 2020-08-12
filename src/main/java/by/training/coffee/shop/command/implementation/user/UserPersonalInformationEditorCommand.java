package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.UserService;
import by.training.coffee.shop.validator.UserDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserPersonalInformationEditorCommand implements Command {
    private static final Logger logger = LogManager.getLogger(UserPersonalInformationEditorCommand.class);
    private static final UserService userService = new UserService();

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        User currentUser = (User) httpSession.getAttribute("user");
        String login = request.getParameter("login");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        boolean isValid = UserDataValidator.checkData(login, name, surname, phone);
        if (!isValid) {
            return new Page(Page.USER_PERSONAL_PAGE_PATH, false);
        }
        currentUser.setLogin(login);
        currentUser.setName(name);
        currentUser.setSurname(surname);
        currentUser.setPhone(phone);
        boolean isUserUpdated = userService.updateUser(currentUser);
        if (isUserUpdated) {
            httpSession.setAttribute("userUpdated", currentUser);
            logger.info("user updated");
        }
        return new Page(Page.USER_PERSONAL_PAGE_PATH, false);
    }
}
