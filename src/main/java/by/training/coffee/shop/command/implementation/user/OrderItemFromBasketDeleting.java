package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.OrderItemServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderItemFromBasketDeleting implements Command {
    private final static Logger logger = LogManager.getLogger(OrderItemFromBasketDeleting.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        String stringId = request.getParameter("id");
        long id;

        OrderItem orderItem = new OrderItem();

        if (stringId != null) {
            id = Long.parseLong(stringId);
            orderItem.setId(id);
        }

        OrderItemServiceImplementation orderItemServiceImplementation = new OrderItemServiceImplementation();

        try {
            boolean isDeleted = orderItemServiceImplementation.deleteOrderItemFromBasket(orderItem);

            if (isDeleted) {
                logger.info("order item was deleted from basket");
            }
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
        }
        return new Page(Page.BASKET_PAGE, false);
    }
}
