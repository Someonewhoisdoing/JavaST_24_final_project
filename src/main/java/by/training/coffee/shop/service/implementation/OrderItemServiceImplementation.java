package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.MenuItemDAOImplementation;
import by.training.coffee.shop.dao.implementation.OrderItemDAOImplementation;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.pool.JDBCConnection;
import by.training.coffee.shop.service.ServiceForDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderItemServiceImplementation implements ServiceForDAO<OrderItem> {
    private final static Logger logger = LogManager.getLogger(OrderItemServiceImplementation.class);

    private Connection connection;
    private JDBCConnection jdbcConnection = JDBCConnection.getInstance();
    private OrderItemDAOImplementation orderItemDAOImplementation;

    public OrderItemServiceImplementation() {
        connection = jdbcConnection.getConnection();
        orderItemDAOImplementation = new OrderItemDAOImplementation(connection);
    }

    public List<OrderItem> findAllOrderItemsInfo() throws ServiceException {
        List<OrderItem> orderItems;
        try {
            orderItems = orderItemDAOImplementation.findAllOrderItemsInfo();
            if (orderItems != null) {
                logger.info("order items is not null");
            }
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException();
        }
        return orderItems;
    }

    @Override
    public boolean create(OrderItem entity) throws ServiceException {
        boolean isCreated = false;
        try {
            connection.setAutoCommit(false);
            isCreated = orderItemDAOImplementation.create(entity);
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

    public void closeConnection() throws ServiceException {
        jdbcConnection.closeConnection();
        logger.info("connection in OrderItemServiceImplementation closed");
    }
}
