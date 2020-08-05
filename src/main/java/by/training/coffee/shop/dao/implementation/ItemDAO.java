package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.Item;
import by.training.coffee.shop.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemDAO extends AbstractDAO<Item> {
    private static final String SQL_DELETE_ORDER_ITEM = "DELETE FROM items WHERE id=?";
    private static final String SQL_SELECT_ALL_ITEMS = "SELECT * FROM items";
    private static final String SQL_CREATE_ORDER_ITEM = "INSERT INTO items (order_id, name, weight, cost) VALUES(?,?,?,?)";

    public boolean delete(Item entity, boolean isEndTrans) throws DAOException {
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
        if (isEndTrans) {
            endTransaction();
        }
        return isDeleted;
    }

    public List<Item> selectAllItems(int start, int total, boolean isEndTrans) throws DAOException {
        String query = SQL_SELECT_ALL_ITEMS + " LIMIT " + (start - 1) + ", " + total;
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                items.add(fetchEntity(resultSet));
            }
            getConnection().commit();
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans) {
            endTransaction();
        }
        return items;
    }

    public List<Item> selectAll(boolean isEndTrans) throws DAOException {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_ALL_ITEMS)) {
            ResultSet resultSet = Objects.requireNonNull(preparedStatement).executeQuery();
            getConnection().commit();
            while (resultSet.next()) {
                items.add(fetchEntity(resultSet));
            }
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans) {
            endTransaction();
        }
        return items;
    }

    public boolean insert(Item entity, boolean isEndTrans) throws DAOException {
        boolean isCreated;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_CREATE_ORDER_ITEM)) {
            preparedStatement.setInt(1, entity.getOrderId());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setDouble(3, entity.getWeight());
            preparedStatement.setDouble(4, entity.getCost());
            isCreated = preparedStatement.executeUpdate() > 0;
            getConnection().commit();
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans) {
            endTransaction();
        }
        return isCreated;
    }

    @Override
    protected Item fetchEntity(ResultSet resultSet) throws SQLException {
        Item item = new Item();
        item.setId(resultSet.getLong("id"));
        item.setOrderId(resultSet.getInt("order_id"));
        item.setName(resultSet.getString("name"));
        item.setWeight(resultSet.getDouble("weight"));
        item.setCost(resultSet.getDouble("cost"));
        return item;
    }
}
