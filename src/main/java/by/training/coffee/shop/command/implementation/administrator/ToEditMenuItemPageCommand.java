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


public class ToEditMenuItemPageCommand implements Command {
    private final static Logger logger = LogManager.getLogger(ToEditMenuItemPageCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        Long id = Long.parseLong(request.getParameter("id"));
        MenuItemServiceImplementation menuItemServiceImplementation = new MenuItemServiceImplementation();

        try {
            MenuItem menuItemById = menuItemServiceImplementation.findMenuItemById(id);

            if (menuItemById != null) {
                request.setAttribute("menuItemById", menuItemById);
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

        return new Page(Page.ADMINISTRATOR_TO_EDIT_MENU_ITEM_PAGE_PATH, false);
    }
}
