package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.OrderDAO;
import by.training.coffee.shop.entity.OrderInfo;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public List<OrderInfo> showOrderInfo() throws ServiceException {
        try {
            List<OrderInfo> orderInfos = orderDAO.showOrderInfo(true);
            orderInfos.forEach(o->{

            });
            return orderInfos;
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
