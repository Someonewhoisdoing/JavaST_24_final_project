package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.dao.implementation.UserDAO;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.service.Service;
import by.training.coffee.shop.exception.ServiceException;

import java.util.List;

public class UserService implements Service<User> {
    private UserDAO userDAO = new UserDAO();


    public User findUserById(Long id) throws ServiceException {
        User user;
        try {
            user = userDAO.findUserById(id, true);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return user;
    }

    public User findUserByLoginAndPassword(String login, String password) throws ServiceException {
        User user;
        try {
            user = userDAO.findUserByLoginAndPassword(login, password, true);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return user;
    }

    public List<User> findAllUsers() throws ServiceException {
        List<User> users;
        try {
            users = userDAO.findAllUsers(true);
        } catch (DAOException e) {
            throw new ServiceException();
        }
        return users;
    }

    @Override
    public boolean create(User entity) throws ServiceException {
        try {
            return userDAO.create(entity,true);
        } catch (DAOException e) {
                throw new ServiceException(e.getMessage(), e);
        }
    }

    public boolean updateUser(User entity) throws ServiceException {
        try {
            return userDAO.updateUser(entity, true);
        } catch ( DAOException e) {
            throw new ServiceException();
        }
    }
}
