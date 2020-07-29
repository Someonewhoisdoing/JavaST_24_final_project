package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemDAO extends AbstractDAO<OrderItem> {
    private static final String SQL_DELETE_ORDER_ITEM = "DELETE FROM order_item WHERE id=?";
    final String SQL_SELECT_ALL_ORDER_ITEMS = "SELECT order_item.id, order_item.name, order_item.price FROM order_item";
    final String SQL_CREATE_ORDER_ITEM = "INSERT INTO order_item (name, price, menu_item_id) VALUES(?,?,?)";

    public boolean deleteOrderItemFromBasket(OrderItem entity, boolean isEndTrans) throws DAOException {
        boolean isDeleted;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_DELETE_ORDER_ITEM)) {
            preparedStatement.setLong(1, entity.getId());
            isDeleted = preparedStatement.executeUpdate() > 0;
            getConnection().commit();
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans){
            endTransaction();
        }
        return isDeleted;
    }

    public List<OrderItem> findAllOrderItemsInfo(boolean isEndTrans) throws DAOException {
        List<OrderItem> orderItems = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_ALL_ORDER_ITEMS)) {
            ResultSet resultSet = Objects.requireNonNull(preparedStatement).executeQuery();
            getConnection().commit();
            while (resultSet.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setId(resultSet.getLong("id"));
                orderItem.setName(resultSet.getString("name"));
                orderItem.setPrice(resultSet.getBigDecimal("price"));
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans){
            endTransaction();
        }
        return orderItems;
    }

    @Override
    public boolean create(OrderItem entity, boolean isEndTrans) throws DAOException {
        boolean isCreated;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_CREATE_ORDER_ITEM)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setBigDecimal(2, entity.getPrice());
            preparedStatement.setLong(3, entity.getMenuItemId());
            isCreated = preparedStatement.executeUpdate() > 0;
            getConnection().commit();
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans){
            endTransaction();
        }
        return isCreated;
    }
}
