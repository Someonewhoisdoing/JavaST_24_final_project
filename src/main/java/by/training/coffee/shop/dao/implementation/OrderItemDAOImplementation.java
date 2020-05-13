package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderItemDAOImplementation extends AbstractDAO<OrderItem> {
    private final static Logger logger = LogManager.getLogger(OrderItemDAOImplementation.class);

    public OrderItemDAOImplementation(Connection connection) {
        super(connection);
    }

    public boolean deleteOrderItemFromBasket(OrderItem entity) throws DAOException {
        final String SQL_DELETE_ORDER_ITEM = "DELETE FROM coffeeshop.order_item WHERE id=?;";

        PreparedStatement preparedStatement = null;
        boolean isDeleted;

        try {
            preparedStatement = connection.prepareStatement(SQL_DELETE_ORDER_ITEM);

            preparedStatement.setLong(1, entity.getId());

            isDeleted = preparedStatement.executeUpdate() > 0;

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
        return isDeleted;
    }

    public List<OrderItem> findAllOrderItemsInfo() throws DAOException {
        final String SQL_SELECT_ALL_ORDER_ITEMS = "SELECT coffeeshop.order_item.id,"
                + " coffeeshop.order_item.name, coffeeshop.order_item.price"
                + " FROM coffeeshop.order_item;";

        List<OrderItem> orderItems = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_ORDER_ITEMS);

            ResultSet resultSet = Objects.requireNonNull(preparedStatement).executeQuery();

            while (resultSet.next()) {
                OrderItem orderItem = new OrderItem();

                orderItem.setId(resultSet.getLong("id"));
                orderItem.setName(resultSet.getString("name"));
                orderItem.setPrice(resultSet.getBigDecimal("price"));

                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    logger.info("prepared statement in findAllOrderItemsInfo() closed");
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return orderItems;
    }

    @Override
    public boolean create(OrderItem entity) throws DAOException {
        final String SQL_CREATE_ORDER_ITEM = "INSERT INTO coffeeshop.order_item"
                + " (name, price, menu_item_id) VALUES(?,?,?);";

        PreparedStatement preparedStatement = null;
        boolean isCreated;

        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_ORDER_ITEM);

            preparedStatement.setString(1, entity.getName());
            preparedStatement.setBigDecimal(2, entity.getPrice());
            preparedStatement.setLong(3, entity.getMenuItemId());

            isCreated = preparedStatement.executeUpdate() > 0;
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
}
