package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.Address;
import by.training.coffee.shop.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressDAOImplementation extends AbstractDAO<Address> {
    private final static Logger logger = LogManager.getLogger(AddressDAOImplementation.class);

    public AddressDAOImplementation(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Address entity) throws DAOException {
        final String SQL_CREATE_ADDRESS = "INSERT INTO coffeeshop.address(city, street, house, flat, user_id) "
                + "VALUES(?, ?, ?, ?, ?);";

        PreparedStatement preparedStatement = null;
        boolean isCreated;
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_ADDRESS);
            preparedStatement.setString(1, entity.getCity());
            preparedStatement.setString(2, entity.getStreet());
            preparedStatement.setString(3, entity.getHouse().toString());
            preparedStatement.setString(4, entity.getFlat().toString());
            preparedStatement.setString(5, entity.getUserId().toString());
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

    public boolean updateAddress(Address entity) throws DAOException {
        final String SQL_UPDATE_ADDRESS = "UPDATE coffeeshop.address SET city=?, street=?, house=?, "
                + "flat=?, user_id=? WHERE id=?;";

        PreparedStatement preparedStatement = null;
        boolean isUpdated;
        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_ADDRESS);
            preparedStatement.setString(1, entity.getCity());
            preparedStatement.setString(2, entity.getStreet());
            preparedStatement.setString(3, entity.getHouse().toString());
            preparedStatement.setString(4, entity.getFlat().toString());
            preparedStatement.setString(5, entity.getUserId().toString());
            preparedStatement.setString(6, entity.getId().toString());
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
