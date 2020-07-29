package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.OrderDAO;
import by.training.coffee.shop.entity.OrderInfo;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.Service;

import java.util.List;

public class OrderService implements Service<OrderInfo> {
    private OrderDAO orderDAO = new OrderDAO();

    public List<OrderInfo> showOrderInfo() throws ServiceException {
        try {
            return orderDAO.showOrderInfo(true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean create(OrderInfo entity) {
        return false;
    }
}
