package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.ItemDAO;
import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.Service;

import java.util.List;

public class ItemService implements Service<OrderItem> {

    private ItemDAO itemDAO = new ItemDAO();

    public boolean deleteOrderItemFromBasket(OrderItem entity) throws ServiceException {
        try {
            return itemDAO.deleteOrderItemFromBasket(entity, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<OrderItem> findAllOrderItemsInfo() throws ServiceException {
        try {
            return itemDAO.findAllOrderItemsInfo(true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean create(OrderItem entity) throws ServiceException {
        try {
            return itemDAO.create(entity, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
