package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.MenuItemServiceImplementation;
import by.training.coffee.shop.service.implementation.OrderItemServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderItemToBasketAddingCommand implements Command {
    private final static Logger logger = LogManager.getLogger(OrderItemToBasketAddingCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();

        OrderItemServiceImplementation orderItemServiceImplementation = new OrderItemServiceImplementation();

        MenuItemServiceImplementation menuItemServiceImplementation = new MenuItemServiceImplementation();

        String id = request.getParameter("id");

        MenuItem menuItemFromMenuPage;
        OrderItem orderItemToBasket;

        try {
            if (id != null) {
                menuItemFromMenuPage = menuItemServiceImplementation.findMenuItemById(Long.parseLong(id));

                if (menuItemFromMenuPage != null) {
                    orderItemToBasket = new OrderItem();

                    orderItemToBasket.setName(menuItemFromMenuPage.getName());
                    orderItemToBasket.setPrice(menuItemFromMenuPage.getCost());
                    orderItemToBasket.setMenuItemId(menuItemFromMenuPage.getId());

                    boolean isOrderItemCreated = orderItemServiceImplementation.create(orderItemToBasket);

                    if (isOrderItemCreated) {
                        httpSession.setAttribute("orderItemToBasket", orderItemToBasket);

                        logger.info("orderItemToBasket was added to basket");
                    }
                }
            }
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
        }
        try {
            menuItemServiceImplementation.closeConnection();
            orderItemServiceImplementation.closeConnection();
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
        }
        return new Page(Page.MENU_PAGE_PATH, false);
    }
}
