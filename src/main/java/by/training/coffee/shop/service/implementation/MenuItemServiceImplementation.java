package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.MenuItemDAOImplementation;
import by.training.coffee.shop.entity.Ingredient;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.pool.JDBCConnection;
import by.training.coffee.shop.service.ServiceForDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MenuItemServiceImplementation implements ServiceForDAO<MenuItem> {
    private final static Logger logger = LogManager.getLogger(MenuItemServiceImplementation.class);

    private Connection connection;
    private JDBCConnection jdbcConnection = JDBCConnection.getInstance();
    private MenuItemDAOImplementation menuItemDAOImplementation;

    public MenuItemServiceImplementation() {
        connection = jdbcConnection.getConnection();
        menuItemDAOImplementation = new MenuItemDAOImplementation(connection);
    }

    public List<MenuItem> findAllMenuItemsInfo(int start, int total) throws ServiceException {
        List<MenuItem> menuItems;
        try {
            menuItems = menuItemDAOImplementation.findAllMenuItemsInfo(start, total);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException();
        }
        return menuItems;
    }

    public MenuItem findMenuItemById(Long id) throws ServiceException {
        MenuItem menuItem;
        try {
            menuItem = menuItemDAOImplementation.findMenuItemById(id);
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException();
        }
        return menuItem;
    }

    @Override
    public boolean create(MenuItem entity) throws ServiceException {
        boolean isCreated = false;
        try {
            connection.setAutoCommit(false);
            isCreated = menuItemDAOImplementation.create(entity);
            connection.commit();
            return isCreated;
        } catch (SQLException | DAOException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                logger.error(ex.getMessage(), ex);
                throw new ServiceException();
            }
        }
        return isCreated;
    }


    public boolean updateMenuItemAndIngredientInfo(MenuItem menuItem, Ingredient ingredient) throws ServiceException {
        boolean isUpdated = false;
        try {
            connection.setAutoCommit(false);
            isUpdated = menuItemDAOImplementation.updateMenuItemAndIngredientInfo(menuItem, ingredient);
            connection.commit();
            return isUpdated;
        } catch (SQLException | DAOException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                logger.error(ex.getMessage(), ex);
                throw new ServiceException();
            }
        }
        return isUpdated;
    }

    public void closeConnection() throws ServiceException {
        jdbcConnection.closeConnection();
        logger.info("connection closed");
    }
}