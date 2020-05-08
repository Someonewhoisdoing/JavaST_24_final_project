package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplementation extends AbstractDAO<User> {
    private final static Logger logger = LogManager.getLogger(UserDAOImplementation.class);

    public UserDAOImplementation(Connection connection) {
        super(connection);
    }

    public User findUserByLoginAndPassword(String login, String password) throws DAOException {
        final String SQL_SELECT_USER_BY_LOGIN = "SELECT id, name, surname, phone, "
                + "role FROM coffeeshop.user WHERE login = ? and password = ?;";

        User user = new User();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_LOGIN);

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user.setId(resultSet.getLong("id"));
            user.setLogin(login);
            user.setPassword(password);
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setPhone(resultSet.getString("phone"));
            user.setRole(resultSet.getInt("role"));
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return user;
    }

    public List<User> findAllUsers() throws DAOException {
        final String SQL_SELECT_ALL_USERS = "SELECT id, login, password, name, surname, phone, "
                + "role FROM coffeeshop.user;";

        List<User> users = new ArrayList<>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setSurname(resultSet.getString("surname"));
                user.setPhone(resultSet.getString("phone"));
                user.setRole(resultSet.getInt("role"));

                users.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return users;
    }

    public User findUserById(Long id) throws DAOException {
        final String SQL_SELECT_USER_BY_ID = "SELECT login, password, name, surname, phone, "
                + "role FROM coffeeshop.user WHERE id = ?;";
        User user = new User();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet;

        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_USER_BY_ID);
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            user.setId(id);
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setPhone(resultSet.getString("phone"));
            user.setRole(resultSet.getInt("role"));

        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public boolean create(User entity) throws DAOException {
        final String SQL_CREATE_USER = "INSERT INTO coffeeshop.user (login, password, name, "
                + "surname, phone, role) + VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = null;
        boolean isCreated;
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_USER);
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setString(6, entity.getRole().toString());
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

    public boolean updateUser(User entity) throws DAOException {
        final String SQL_UPDATE_USER = "UPDATE coffeeshop.user SET login=?, password=?,"
                + " name=?, surname=?, phone=? WHERE id=?;";

        PreparedStatement preparedStatement = null;
        boolean isUpdated;

        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setString(5, entity.getPhone());
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
