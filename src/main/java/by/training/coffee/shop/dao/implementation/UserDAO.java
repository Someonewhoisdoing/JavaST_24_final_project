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
    private static final String SQL_UPDATE_USER = "UPDATE users SET login=?, name=?, surname=?, phone=? WHERE id=?";

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
            if (isEndTrans) {
                getConnection().commit();
                endTransaction();
            }
            return user;
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
    }

    public List<User> selectAll(boolean isEndTrans) throws DAOException {
        List<User> users = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
            while (resultSet.next()) {
                users.add(fetchEntity(resultSet));
            }
            if (isEndTrans) {
                getConnection().commit();
                endTransaction();
            }
            return users;
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
    }

    public User selectById(int id, boolean isEndTrans) throws DAOException {
        User user = new User();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_USER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = fetchEntity(resultSet);
            }
            if (isEndTrans) {
                getConnection().commit();
                endTransaction();
            }
            return user;
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
    }

    public boolean update(User entity, boolean isEndTrans) throws DAOException {
        boolean isUpdated;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_UPDATE_USER)) {
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.setString(3, entity.getSurname());
            preparedStatement.setString(4, entity.getPhone());
            preparedStatement.setInt(5, (entity.getId()));

            isUpdated = preparedStatement.executeUpdate() > 0;
            if (isEndTrans) {
                getConnection().commit();
                endTransaction();
            }
            return isUpdated;
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
    }

    @Override
    protected User fetchEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
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
