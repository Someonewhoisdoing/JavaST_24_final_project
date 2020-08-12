package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.Order;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class OrderDisplayCommand implements Command {
    private static final Logger logger = LogManager.getLogger(OrderDisplayCommand.class);
    private static final OrderService orderService = new OrderService();

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        Order order = orderService.order(user);
        if (order != null) {
            httpSession.setAttribute("order", order);
            logger.info("orderInfoList is not null and added to session in OrderInfoDisplayCommand");
        }
        return new Page(Page.ORDER_INFO_PAGE, false);
    }
}
