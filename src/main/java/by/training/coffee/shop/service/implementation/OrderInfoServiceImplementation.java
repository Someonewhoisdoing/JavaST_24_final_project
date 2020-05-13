package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.OrderInfoDAOImplementation;
import by.training.coffee.shop.entity.OrderInfo;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.pool.JDBCConnection;
import by.training.coffee.shop.service.ServiceForDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class OrderInfoServiceImplementation implements ServiceForDAO<OrderInfo> {
    private final static Logger logger = LogManager.getLogger(OrderInfoServiceImplementation.class);

    private Connection connection;
    private JDBCConnection jdbcConnection = JDBCConnection.getInstance();
    private OrderInfoDAOImplementation orderInfoDAOImplementation;

    public OrderInfoServiceImplementation() {
        connection = jdbcConnection.getConnection();
        orderInfoDAOImplementation = new OrderInfoDAOImplementation(connection);
    }

    public List<OrderInfo> showOrderInfo() throws ServiceException {
        List<OrderInfo> orderInfos;
        try {
            orderInfos = orderInfoDAOImplementation.showOrderInfo();
            if (orderInfos != null) {
                logger.info("orderInfos is not null in OrderInfoServiceImplementation");
            }
        } catch (DAOException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException();
        }
        return orderInfos;
    }

    @Override
    public boolean create(OrderInfo entity) throws DAOException, ServiceException {
        return false;
    }
}
