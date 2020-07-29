package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.Address;
import by.training.coffee.shop.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDAO extends AbstractDAO<Address> {
    private static final String SQL_CREATE_ADDRESS =
            "INSERT INTO address(city, street, house, flat, user_id) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_ADDRESS =
            "UPDATE address SET city=?, street=?, house=?, flat=?, user_id=? WHERE id=?";

    @Override
    public boolean create(Address entity, boolean isEndTrans) throws DAOException {
        boolean isCreated;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_CREATE_ADDRESS)) {
            preparedStatement.setString(1, entity.getCity());
            preparedStatement.setString(2, entity.getStreet());
            preparedStatement.setString(3, entity.getHouse().toString());
            preparedStatement.setString(4, entity.getFlat().toString());
            preparedStatement.setString(5, entity.getUserId().toString());
            preparedStatement.executeUpdate();
            getConnection().commit();
            isCreated = true;
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

    public boolean updateAddress(Address entity, boolean isEndTrans) throws DAOException {
        boolean isUpdated;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_UPDATE_ADDRESS)) {
            preparedStatement.setString(1, entity.getCity());
            preparedStatement.setString(2, entity.getStreet());
            preparedStatement.setString(3, entity.getHouse().toString());
            preparedStatement.setString(4, entity.getFlat().toString());
            preparedStatement.setString(5, entity.getUserId().toString());
            preparedStatement.setString(6, entity.getId().toString());
            preparedStatement.executeUpdate();
            getConnection().commit();
            isUpdated = true;
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans) {
            endTransaction();
        }
        return isUpdated;
    }
}
