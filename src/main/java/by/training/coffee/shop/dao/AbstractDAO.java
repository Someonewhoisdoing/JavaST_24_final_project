package by.training.coffee.shop.dao;

import by.training.coffee.shop.connection.ConnectionPool;
import by.training.coffee.shop.entity.Entity;
import by.training.coffee.shop.exception.PoolConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAO<T extends Entity> {
    private final static Logger logger = LogManager.getLogger(AbstractDAO.class);
    private static final ConnectionPool pool = new ConnectionPool();
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

     protected abstract T fetchEntity (ResultSet res) throws SQLException;

    private void startTransaction() {
        try {
            threadLocal.set(pool.getConnection());
        } catch (PoolConnectionException e) {
            logger.error(e.getMessage(), e);
        }
    }

    protected void endTransaction() {
        pool.returnConnection(threadLocal.get());
        threadLocal.remove();
    }

    protected void rollBack() {
        try {
            threadLocal.get().rollback();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    protected void close() {
        pool.returnConnection(threadLocal.get());
        threadLocal.remove();
    }

    protected Connection getConnection() {
        Connection connection = threadLocal.get();
        if (connection != null) {
            return connection;
        }
        startTransaction();
        return threadLocal.get();
    }
}
