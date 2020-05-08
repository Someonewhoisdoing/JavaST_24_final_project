package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.AddressDAOImplementation;
import by.training.coffee.shop.entity.Address;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.pool.JDBCConnection;
import by.training.coffee.shop.service.ServiceForDAO;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.SQLException;

public class AddressServiceImplementation implements ServiceForDAO<Address> {
    private final static Logger logger = LogManager.getLogger(AddressServiceImplementation.class);

    private Connection connection;
    private JDBCConnection jdbcConnection = JDBCConnection.getInstance();
    private AddressDAOImplementation addressDAOImplementation;

    public AddressServiceImplementation() {
        connection = jdbcConnection.getConnection();
        addressDAOImplementation = new AddressDAOImplementation(connection);
    }

    @Override
    public boolean create(Address entity) throws DAOException, ServiceException {
        boolean isCreated = false;
        try {
            connection.setAutoCommit(false);
            isCreated = addressDAOImplementation.create(entity);
            connection.commit();
            return isCreated;
        } catch (SQLException | DAOException e) {
            try {
                connection.rollback();
            } catch (SQLException exception) {
                throw new ServiceException();
            }
        }
        return isCreated;
    }

    public boolean updateAddress(Address entity) throws DAOException, ServiceException {
        boolean isUpdated = false;
        try {
            connection.setAutoCommit(false);
            isUpdated = addressDAOImplementation.updateAddress(entity);
            connection.commit();
            return isUpdated;
        } catch (SQLException | DAOException e) {
            try {
                connection.rollback();
            } catch (SQLException exception) {
                throw new ServiceException();
            }
        }
        return isUpdated;
    }

    public void closeConnection() throws ServiceException {
        jdbcConnection.closeConnection();
        logger.info("connection closed");
    }
}
