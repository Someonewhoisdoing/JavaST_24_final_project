package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.OrderInfo;
import by.training.coffee.shop.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class OrderInfoDAOImplementation extends AbstractDAO<OrderInfo> {
    private final static Logger logger = LogManager.getLogger(OrderInfoDAOImplementation.class);


    public OrderInfoDAOImplementation(Connection connection) {
        super(connection);
    }

    public List<OrderInfo> showOrderInfo() throws DAOException {
        final String SQL_SHOW_ORDER_INFO = "SELECT order_info.id, "
                + "order_info.date, user.name, "
                + "address.street, address.house, "
                + "address.flat, order_item.name AS coffee,"
                + " order_item.price "
                + "FROM(((order_info "
                + "INNER JOIN user "
                + "ON order_info.user_id = user.id)"
                + " INNER JOIN address "
                + "ON order_info.address_id = address.id) "
                + "RIGHT JOIN order_item "
                + "ON order_info.order_item_id = order_item.id);";

        List<OrderInfo> orderInfoList = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SHOW_ORDER_INFO);

            ResultSet resultSet = Objects.requireNonNull(preparedStatement).executeQuery();

            while (resultSet.next()) {
                OrderInfo orderInfo = new OrderInfo();

                orderInfo.setId(resultSet.getLong("id"));
                orderInfo.setDate(resultSet.getDate("date"));
                orderInfo.setUserName(resultSet.getString("name"));
                orderInfo.setAddressDelivery(resultSet.getString("street")
                        + " " + resultSet.getString("house")
                        + " " + resultSet.getString("flat"));
                List<String> orderInfos = new ArrayList<>();
                BigDecimal finalPrice = new BigDecimal("0");

                resultSet.previous();

                while (resultSet.next()) {
                    orderInfos.add(resultSet.getString("coffee"));
                    finalPrice = finalPrice.add(resultSet.getBigDecimal("price"));

                    orderInfo.setOrderItems(orderInfos);
                    orderInfo.setFinalCost(finalPrice);
                }

                orderInfoList.add(orderInfo);
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    logger.info("prepared statement in showOrderInfo() closed");
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return orderInfoList;
    }

    @Override
    public boolean create(OrderInfo entity) throws DAOException {
        final String SQL_CREATE_ORDER_INFO = "INSERT INTO order_info(date, user_id,"
                + " address_id, order_item_id) VALUES(?, ?, ?, ?);";

        PreparedStatement preparedStatement = null;

        boolean isCreated;
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_ORDER_INFO);
            preparedStatement.setDate(1, (Date) entity.getDate());
            preparedStatement.setLong(2, entity.getUserId());
            preparedStatement.setLong(3, entity.getAddressId());
            preparedStatement.setLong(4, entity.getOrderItemId());

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
