package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.Order;
import by.training.coffee.shop.exception.DAOException;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class OrderDAO extends AbstractDAO<Order> {

    private static final String SQL_CREATE_ORDER_INFO = "INSERT INTO orders(user_id, date) VALUES(?, ?)";

    public boolean insert(Order entity, boolean isEndTrans) throws DAOException {
        boolean isCreated;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_CREATE_ORDER_INFO)) {
            preparedStatement.setInt(1, entity.getUserId());
            preparedStatement.setString(2, entity.getDate());


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
    protected Order fetchEntity(ResultSet res) throws SQLException {
        return null;
    }
}
