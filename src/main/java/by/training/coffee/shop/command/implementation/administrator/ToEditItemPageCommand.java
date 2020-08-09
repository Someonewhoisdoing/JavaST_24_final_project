package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.Item;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ToEditItemPageCommand implements Command {

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Long id = Long.parseLong(request.getParameter("id"));
        ItemService itemService = new ItemService();
        Item itemById = itemService.findItemById(id);
        if (itemById != null) {
            request.setAttribute("itemById", itemById);
        }
        return new Page(Page.ADMINISTRATOR_TO_EDIT_MENU_ITEM_PAGE_PATH, false);
    }
}
