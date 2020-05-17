package by.training.coffee.shop.command.implementation.common;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageReturnerCommand  implements Command {
    private final Logger logger = LogManager.getLogger(HomePageReturnerCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new Page(Page.HOME_PAGE_PATH, false);
    }
}
