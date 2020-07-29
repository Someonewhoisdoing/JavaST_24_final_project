package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.DAOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {

    private static final String SQL_SELECT_USER_BY_LOGIN = "SELECT id, name, surname, phone, role FROM user WHERE login = ? and password = ?";
    private static final String SQL_SELECT_ALL_USERS = "SELECT id, login, password, name, surname, phone, role FROM user";
    private static final String SQL_SELECT_USER_BY_ID = "SELECT login, password, name, surname, phone, role FROM user WHERE id = ?";
    private static final String SQL_CREATE_USER = "INSERT INTO user (login, password, name, surname, phone, role) + VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE user SET login=?, password=?, name=?, surname=?, phone=? WHERE id=?";

    public User findUserByLoginAndPassword(String login, String password, boolean isEndTrans) throws DAOException {
        User user = new User();
        ResultSet resultSet = null;

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_USER_BY_LOGIN)) {
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
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans){
            endTransaction();
        }
        return user;
    }

    public List<User> findAllUsers(boolean isEndTrans) throws DAOException {
        List<User> users = new ArrayList<>();
        try (Statement statement = getConnection().createStatement()) {
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
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans){
            endTransaction();
        }
        return users;
    }

    public User findUserById(Long id, boolean isEndTrans) throws DAOException {
        User user = new User();
        ResultSet resultSet;
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_SELECT_USER_BY_ID)) {
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
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans){
            endTransaction();
        }
        return user;
    }

    @Override
    public boolean create(User entity, boolean isEndTrans) throws DAOException {
        boolean isCreated;
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_CREATE_USER)) {
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getName());
            preparedStatement.setString(4, entity.getSurname());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setString(6, entity.getRole().toString());

            isCreated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            rollBack();
            close();
            throw new DAOException();
        }
        if (isEndTrans){
            endTransaction();
        }
        return isCreated;
    }

    public boolean updateUser(User entity, boolean isEndTrans) throws DAOException {
        boolean isUpdated;
        try(PreparedStatement preparedStatement = getConnection().prepareStatement(SQL_UPDATE_USER)) {
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
        if (isEndTrans){
            endTransaction();
        }
        return isUpdated;
    }
}
