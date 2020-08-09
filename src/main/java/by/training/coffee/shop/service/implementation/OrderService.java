package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.ItemDAO;
import by.training.coffee.shop.dao.implementation.OrderDAO;
import by.training.coffee.shop.entity.Item;
import by.training.coffee.shop.entity.Order;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();
    private ItemDAO itemDAO = new ItemDAO();

    public Order order(User user) throws ServiceException {
        try {
            Order order = new Order();
            order.setUserId(Math.toIntExact(user.getId()));
            boolean isOrdered = orderDAO.insert(order,false);
            if (isOrdered){
                List<Item> items = itemDAO.selectAll(Math.toIntExact(user.getId()), false);
                order.setItems(items);
                itemDAO.deleteAllFromBasket(Math.toIntExact(user.getId()),true);
                return order;
            }
            return null;
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
