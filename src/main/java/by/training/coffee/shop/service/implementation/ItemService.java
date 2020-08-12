package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.ItemDAO;
import by.training.coffee.shop.entity.Item;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;

import java.util.List;

public class ItemService {

    private ItemDAO itemDAO = new ItemDAO();

    public boolean deleteItemFromBasket(Item item, int id) throws ServiceException {
        try {
            return itemDAO.deleteFromBasket(item, id, true);
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

    public List<Item> selectAllOrderItemsInfo(int id) throws ServiceException {
        try {
            return itemDAO.selectAll(id,true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public Item findItemById(int id) throws ServiceException {
        try {
            return itemDAO.selectById(id, true);
        } catch (DAOException e) {
            throw new ServiceException();
        }
    }

    public boolean insert(Item item, int id) throws ServiceException {
        try {
            return itemDAO.insert(item, id,true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean update(Item item) throws ServiceException {
        try {
            return itemDAO.update(item, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
