package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.UserDAO;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();


    public User findUserById(Long id) throws ServiceException {
        User user;
        try {
            user = userDAO.selectById(id, true);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return user;
    }

    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {
        User user;
        try {
            user = userDAO.selectByUserAndPassword(login, password, true);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return user;
    }

    public List<User> findAllUsers() throws ServiceException {
        List<User> users;
        try {
            users = userDAO.selectAll(true);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return users;
    }

    public boolean updateUser(User entity) throws ServiceException {
        try {
            return userDAO.update(entity, true);
        } catch ( DAOException e) {
            throw new ServiceException();
        }
    }
}
