package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.MenuItemServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MenuItemsListDisplayCommand implements Command {
    private final static Logger logger = LogManager.getLogger(MenuItemsListDisplayCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        String pageString = request.getParameter("page");
        int page = 0;
        final int total = 4;

        if (pageString != null) {
            page = Integer.parseInt(pageString);
            logger.info("page was gotten");
        }

        if (page == 1) {
            logger.info("page == 1");
        } else {
            page = page - 1;
            page = page * total + 1;
        }

        MenuItemServiceImplementation menuItemServiceImplementation = new MenuItemServiceImplementation();

        try {
            List<MenuItem> menuItemList = menuItemServiceImplementation.findAllMenuItemsInfo(page, total);
            if (menuItemList != null) {
                request.setAttribute("menuItemList", menuItemList);
            } else {
                logger.info("menuItemList == null");
            }
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                menuItemServiceImplementation.closeConnection();
            } catch (ServiceException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return new Page(Page.ADMINISTRATOR_MENU_ITEMS_PAGE_PATH, false);
    }
}