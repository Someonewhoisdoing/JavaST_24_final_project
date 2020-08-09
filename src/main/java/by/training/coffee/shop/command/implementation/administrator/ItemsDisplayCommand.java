package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.Item;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ItemsDisplayCommand implements Command {
    private final static Logger logger = LogManager.getLogger(ItemsDisplayCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        String pageString = request.getParameter("page");
        final int total = 6;
        int page = Integer.parseInt(pageString);

        if (page != 1) {
            page = page - 1;
            page = page * total + 1;
        }
        ItemService itemService = new ItemService();
        List<Item> itemList = itemService.selectAllItems(page, total);
        if (itemList != null) {
            httpSession.setAttribute("itemList", itemList);
        } else {
            logger.info("itemList == null");
        }
        return new Page(Page.ADMINISTRATOR_MENU_ITEMS_PAGE_PATH + "?page=" + pageString, true);
    }
}