package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.MenuDAO;
import by.training.coffee.shop.entity.Ingredient;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.Service;

import java.util.List;

public class MenuService implements Service<MenuItem> {
    private MenuDAO menuDAO = new MenuDAO();

    public List<MenuItem> findAllMenuItemsInfo(int start, int total) throws ServiceException {
        try {
            return menuDAO.findAllMenuItemsInfo(start, total, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public MenuItem findMenuItemById(Long id) throws ServiceException {
        try {
            return menuDAO.findMenuItemById(id, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public boolean create(MenuItem entity) throws ServiceException {
        try {
            return menuDAO.create(entity, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean updateMenuItemAndIngredientInfo(MenuItem menuItem, Ingredient ingredient) throws
            ServiceException {
        try {
            return menuDAO.updateMenuItemAndIngredientInfo(menuItem, ingredient, true);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
}