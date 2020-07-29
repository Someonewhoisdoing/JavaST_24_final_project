package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.OrderInfo;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderInfoDisplayCommand implements Command {
    private final static Logger logger = LogManager.getLogger(OrderInfoDisplayCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        OrderService orderService = new OrderService();
        List<OrderInfo> orderInfoList = orderService.showOrderInfo();
        if (orderInfoList != null) {
            httpSession.setAttribute("orderInfoList", orderInfoList);
            logger.info("orderInfoList is not null and added to session in OrderInfoDisplayCommand");
        }
        return new Page(Page.ORDER_INFO_PAGE, false);
    }
}
