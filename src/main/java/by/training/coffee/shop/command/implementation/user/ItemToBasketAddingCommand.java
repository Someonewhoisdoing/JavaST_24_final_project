package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.Item;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ItemToBasketAddingCommand implements Command {
    private final static Logger logger = LogManager.getLogger(ItemToBasketAddingCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        ItemService itemService = new ItemService();
        String id = request.getParameter("id");
        User user = (User) httpSession.getAttribute("userByLoginAndPassword");
        Item item = itemService.findItemById(Long.parseLong(id));
        if (item == null) {
            return new Page(Page.MENU_PAGE_PATH, false);
        }
        boolean isOrderItemCreated = itemService.insert(item, Math.toIntExact(user.getId()));

        if (isOrderItemCreated) {
            httpSession.setAttribute("orderItemToBasket", item);
            logger.info("orderItemToBasket was added to basket");
        }
        return new Page(Page.MENU_PAGE_PATH, false);
    }
}
