package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.Address;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM users u INNER JOIN address a on u.id = a.user_id ";
    private static final String SQL_SELECT_USER_BY_LOGIN = SQL_SELECT_ALL_USERS + " WHERE login = ? and password = ?";
    private static final String SQL_SELECT_USER_BY_ID = SQL_SELECT_ALL_USERS + " WHERE id = ?";
    private static final String SQL_UPDATE_USER = "UPDATE users SET login=?, password=?, name=?, surname=?, phone=? WHERE id=?";

    public User selectByUserAndPassword(String login, String password, boolean isEndTrans) throws DAOException {
        User user = null;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_USER_BY_LOGIN)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = fetchEntity(resultSet);
                System.out.println(user);
            }
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans) {
            endTransaction();
        }
        return user;
    }

    public List<User> selectAll(boolean isEndTrans) throws DAOException {
        List<User> users = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()) {
                users.add(fetchEntity(resultSet));
            }
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans) {
            endTransaction();
        }
        return users;
    }

    public User selectById(Long id, boolean isEndTrans) throws DAOException {
        User user = new User();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_USER_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = fetchEntity(resultSet);
            }
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans) {
            endTransaction();
        }
        return user;
    }

    public boolean update(User entity, boolean isEndTrans) throws DAOException {
        boolean isUpdated;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_UPDATE_USER)) {
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setString(6, entity.getId().toString());

            isUpdated = preparedStatement.executeUpdate() > 0;
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

    @Override
    protected User fetchEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setLogin(resultSet.getString("login"));
        user.setPassword(resultSet.getString("password"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setPhone(resultSet.getString("phone"));
        user.setRole(resultSet.getInt("role"));
        Address address = new Address();
        address.setStreet(resultSet.getString("street"));
        address.setHouse(resultSet.getInt("house"));
        address.setFlat(resultSet.getInt("flat"));
        user.setAddress(address);
        return user;
    }
}
