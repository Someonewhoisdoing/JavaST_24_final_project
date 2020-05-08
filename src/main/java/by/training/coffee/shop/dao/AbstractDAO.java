package by.training.coffee.shop.dao;

import by.training.coffee.shop.entity.Entity;
import by.training.coffee.shop.exception.DAOException;

import java.sql.Connection;

public abstract class AbstractDAO<T extends Entity> {
    protected Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract boolean create(T entity) throws DAOException;
}
