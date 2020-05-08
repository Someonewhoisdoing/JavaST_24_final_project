package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.UserDAOImplementation;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.pool.JDBCConnection;
import by.training.coffee.shop.service.ServiceForDAO;
import by.training.coffee.shop.exception.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImplementation implements ServiceForDAO<User> {
    private final static Logger logger = LogManager.getLogger(UserServiceImplementation.class);

    private Connection connection;
    private JDBCConnection jdbcConnection = JDBCConnection.getInstance();
    private UserDAOImplementation userDAOImplementation;

    public UserServiceImplementation() {
        connection = jdbcConnection.getConnection();
        userDAOImplementation = new UserDAOImplementation(connection);
    }

    public User findUserById(Long id) throws ServiceException {
        User user;
        try {
            user = userDAOImplementation.findUserById(id);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return user;
    }

    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {
        User user;
        try {
            user = userDAOImplementation.findUserByLoginAndPassword(login, password);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return user;
    }

    public List<User> findAllUsers() throws ServiceException {
        List<User> users;
        try {
            users = userDAOImplementation.findAllUsers();
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return users;
    }

    @Override
    public boolean create(User entity) throws ServiceException {
        boolean isCreated = false;
        try {
            connection.setAutoCommit(false);
            isCreated = userDAOImplementation.create(entity);
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

    public boolean updateUser(User entity) throws ServiceException {
        boolean isUpdated = false;
        try {
            connection.setAutoCommit(false);
            isUpdated = userDAOImplementation.updateUser(entity);
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
