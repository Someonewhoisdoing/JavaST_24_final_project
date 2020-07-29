package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.MenuService;
import by.training.coffee.shop.service.implementation.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderItemToBasketAddingCommand implements Command {
    private final static Logger logger = LogManager.getLogger(OrderItemToBasketAddingCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        ItemService itemService = new ItemService();
        MenuService menuService = new MenuService();
        String id = request.getParameter("id");
        MenuItem menuItemFromMenuPage;
        OrderItem orderItemToBasket;
        menuItemFromMenuPage = menuService.findMenuItemById(Long.parseLong(id));
        if (menuItemFromMenuPage == null) {
            return new Page(Page.MENU_PAGE_PATH, false);
        }
        orderItemToBasket = new OrderItem();
        orderItemToBasket.setName(menuItemFromMenuPage.getName());
        orderItemToBasket.setPrice(menuItemFromMenuPage.getCost());
        orderItemToBasket.setMenuItemId(menuItemFromMenuPage.getId());
        boolean isOrderItemCreated = itemService.create(orderItemToBasket);
        if (isOrderItemCreated) {
            httpSession.setAttribute("orderItemToBasket", orderItemToBasket);
            logger.info("orderItemToBasket was added to basket");
        }
        return new Page(Page.MENU_PAGE_PATH, false);
    }
}
