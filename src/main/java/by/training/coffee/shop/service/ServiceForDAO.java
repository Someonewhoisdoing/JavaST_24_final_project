package by.training.coffee.shop.service;

import by.training.coffee.shop.entity.Entity;
import by.training.coffee.shop.exception.DAOException;
import by.training.coffee.shop.exception.ServiceException;

public interface ServiceForDAO<T extends Entity> {

    boolean create(T entity) throws DAOException, ServiceException;
}
