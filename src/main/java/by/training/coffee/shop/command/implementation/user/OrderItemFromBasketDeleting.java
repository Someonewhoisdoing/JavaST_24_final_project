package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderItemFromBasketDeleting implements Command {
    private final static Logger logger = LogManager.getLogger(OrderItemFromBasketDeleting.class);
    private final ItemService itemService = new ItemService();

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String stringId = request.getParameter("id");
        OrderItem orderItem = new OrderItem();
        if (stringId != null) {
            long id = Long.parseLong(stringId);
            orderItem.setId(id);
        }
        boolean isDeleted = itemService.deleteOrderItemFromBasket(orderItem);
        if (isDeleted) {
            logger.info("order item was deleted from basket");
        }
        return new ToBasketPageCommand().execute(request, response);
    }
}
