package by.training.coffee.shop.command.implementation.menu;

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

public class ItemInformationDisplayCommand implements Command {
    private final static Logger logger = LogManager.getLogger(ItemInformationDisplayCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        String pageString = request.getParameter("page");
        int page = 0;

        if (pageString != null) {
            page = Integer.parseInt(pageString);
            logger.info("number of page in MenuItemInformationDisplayCommand was gotten");
        }
        final int total = 6;
        if (page == 1) {
            logger.info("page == 1");
        } else {
            page = page - 1;
            page = page * total + 1;
        }
        ItemService itemService = new ItemService();
        List<Item> itemsInfo = itemService.selectAllItems(page, total);
        if (itemsInfo != null) {
            httpSession.setAttribute("itemsInfo", itemsInfo);
        }
        return new Page(Page.MENU_PAGE_PATH, false);
    }
}
