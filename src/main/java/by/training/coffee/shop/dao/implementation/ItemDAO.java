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
    private static final String SQL_DELETE_ORDER_ITEM_FROM_BASKET = "DELETE FROM basket_items b WHERE b.user_id=?";
    private static final String SQL_SELECT_ALL_ITEMS = "SELECT * FROM items";
    private static final String SQL_DELETE_ALL_ITEMS_FROM_BASKET = "delete FROM basket_items bi where bi.user_id = ? and bi.item_id =?";
    private static final String SQL_SELECT_ALL_ITEMS_FROM_BASKET = "SELECT * FROM basket_items bi inner join items i on bi.item_id = i.id where bi.user_id = ?";
    private static final String SQL_SELECT_ITEM_BY_ID = SQL_SELECT_ALL_ITEMS + " WHERE id = ?";
    private static final String SQL_CREATE_ORDER_ITEM_INTO_BASKET = "INSERT INTO basket_items (user_id, item_id) VALUES(?,?)";
    private static final String SQL_UPDATE_ITEM = "UPDATE items SET name=?, weight=?, cost=? WHERE id=?";

    public boolean deleteFromBasket(Item entity, int id, boolean isEndTrans) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_DELETE_ALL_ITEMS_FROM_BASKET)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, Math.toIntExact(entity.getId()));
            boolean isDeleted = preparedStatement.executeUpdate() > 0;
            if (isEndTrans) {
                getConnection().commit();
                endTransaction();
            }
            return isDeleted;
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
    }

    public boolean deleteAllFromBasket(int id, boolean isEndTrans) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_DELETE_ORDER_ITEM_FROM_BASKET)) {
            preparedStatement.setInt(1, id);
            boolean isDeleted = preparedStatement.executeUpdate() > 0;
            if (isEndTrans) {
                getConnection().commit();
                endTransaction();
            }
            return isDeleted;
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
    }

    public Item selectById(Long id, boolean isEndTrans) throws DAOException {
        Item item = null;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_ITEM_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               item = fetchEntity(resultSet);
            }
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans) {
            endTransaction();
        }
        return item;
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

    public List<Item> selectAll(int id, boolean isEndTrans) throws DAOException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_ALL_ITEMS_FROM_BASKET)) {
            preparedStatement.setInt(1,id);
            ResultSet resultSet = Objects.requireNonNull(preparedStatement).executeQuery();
            List<Item> items = new ArrayList<>();
            while (resultSet.next()) {
                items.add(fetchEntity(resultSet));
            }
            if (isEndTrans) {
                getConnection().commit();
                endTransaction();
            }
            return items;
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
    }

    public boolean insert(Item entity, int id, boolean isEndTrans) throws DAOException {
        boolean isCreated;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_CREATE_ORDER_ITEM_INTO_BASKET)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, Math.toIntExact(entity.getId()));
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

    public boolean update(Item item, boolean isEndTrans) throws DAOException {
        boolean isUpdated;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_UPDATE_ITEM)) {
            System.out.println(item);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setDouble(2, item.getWeight());
            preparedStatement.setDouble(3, item.getCost());
            preparedStatement.setLong(4,item.getId());
            preparedStatement.executeUpdate();
            getConnection().commit();
            isUpdated = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans){
            endTransaction();
        }
        return isUpdated;
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
