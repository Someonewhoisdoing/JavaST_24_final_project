package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.ItemDAO;
import by.training.coffee.shop.entity.Item;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;

import java.util.List;

public class ItemService {

    private ItemDAO itemDAO = new ItemDAO();

    public boolean deleteItemFromBasket(Item entity) throws ServiceException {
        try {
            return itemDAO.delete(entity, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Item> selectAllItems(int start, int total) throws ServiceException {
        try {
            return itemDAO.selectAllItems(start, total, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public List<Item> findAllOrderItemsInfo() throws ServiceException {
        try {
            return itemDAO.selectAll(true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean create(Item entity) throws ServiceException {
        try {
            return itemDAO.insert(entity, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
