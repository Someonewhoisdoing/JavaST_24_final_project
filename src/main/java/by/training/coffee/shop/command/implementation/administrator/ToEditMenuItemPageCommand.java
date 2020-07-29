package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.MenuService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ToEditMenuItemPageCommand implements Command {

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Long id = Long.parseLong(request.getParameter("id"));
        MenuService menuService = new MenuService();
        MenuItem menuItemById = menuService.findMenuItemById(id);
        if (menuItemById != null) {
            request.setAttribute("menuItemById", menuItemById);
        }
        return new Page(Page.ADMINISTRATOR_TO_EDIT_MENU_ITEM_PAGE_PATH, false);
    }
}
