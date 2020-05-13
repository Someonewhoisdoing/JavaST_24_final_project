package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.OrderInfo;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.OrderInfoServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderInfoDisplayCommand implements Command {
    private final static Logger logger = LogManager.getLogger(OrderInfoDisplayCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();

        OrderInfoServiceImplementation orderInfoServiceImplementation = new OrderInfoServiceImplementation();
        try {
            List<OrderInfo> orderInfoList = orderInfoServiceImplementation.showOrderInfo();

            if (orderInfoList != null) {
                httpSession.setAttribute("orderInfoList", orderInfoList);

            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return new Page(Page.ORDER_INFO_PAGE, true);
    }
}
