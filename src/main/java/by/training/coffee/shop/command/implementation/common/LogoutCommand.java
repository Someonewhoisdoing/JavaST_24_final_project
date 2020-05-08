package by.training.coffee.shop.command.implementation.common;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    private final Logger logger = LogManager.getLogger(LogoutCommand.class);
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
//        User user = (User) httpSession.getAttribute("userByLoginAndPassword");
//        if(user != null){
//            user.setLogin(null);
//            user.setPassword(null);
//        }
        httpSession.invalidate();

        return new Page(Page.HOME_PAGE_PATH, true);
    }
}