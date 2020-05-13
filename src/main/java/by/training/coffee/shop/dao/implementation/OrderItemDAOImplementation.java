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


//    public boolean updateOrder(OrderItem entity) throws DAOException {
//        final String SQL_UPDATE_ORDER_ITEM = "UPDATE coffeeshop.order_item SET "
//                + "menu_item_id=?, receipt_id=? WHERE id=?;";
//
//        PreparedStatement preparedStatement = null;
//        boolean isUpdated;
//        try {
//            preparedStatement = connection.prepareStatement(SQL_UPDATE_ORDER_ITEM);
//            preparedStatement.setString(1, entity.getMenuItemId().toString());
//            // preparedStatement.setString(2, entity.getReceiptId().toString());
//            preparedStatement.setString(3, entity.getId().toString());
//            preparedStatement.executeUpdate();
//            isUpdated = true;
//        } catch (SQLException e) {
//            throw new DAOException();
//        } finally {
//            if (preparedStatement != null) {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    logger.error(e.getMessage());
//                }
//            }
//        }
//        return isUpdated;
//    }
}
