package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemImplementation extends AbstractDAO<OrderItem> {

    private final static Logger logger = LogManager.getLogger(OrderItemImplementation.class);

    public OrderItemImplementation(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(OrderItem entity) throws DAOException {
        final String SQL_CREATE_ORDER_ITEM = "INSERT INTO coffeeshop.order_item"
                + "(menu_item_id, receipt_id) VALUES(?, ?);";

        PreparedStatement preparedStatement = null;
        boolean isCreated;

        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_ORDER_ITEM);
            preparedStatement.setString(1, entity.getMenuItemId().toString());
            preparedStatement.setString(2, entity.getReceiptId().toString());
            preparedStatement.executeUpdate();
            isCreated = true;
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return isCreated;
    }

    public boolean updateOrder(OrderItem entity) throws DAOException {
        final String SQL_UPDATE_ORDER_ITEM = "UPDATE coffeeshop.order_item SET "
                + "menu_item_id=?, receipt_id=? WHERE id=?;";

        PreparedStatement preparedStatement = null;
        boolean isUpdated;
        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ORDER_ITEM);
            preparedStatement.setString(1, entity.getMenuItemId().toString());
            preparedStatement.setString(2, entity.getReceiptId().toString());
            preparedStatement.setString(3, entity.getId().toString());
            preparedStatement.executeUpdate();
            isUpdated = true;
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return isUpdated;
    }
}
