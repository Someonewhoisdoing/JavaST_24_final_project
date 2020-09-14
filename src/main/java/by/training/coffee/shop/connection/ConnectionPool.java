package by.training.coffee.shop.connection;

import by.training.coffee.shop.exception.PoolConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private final static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(10);
    private static final Properties PROPERTIES = new Properties();
    private static final String URL = "jdbc:mysql://localhost:3306/coffeeshop";

    static {
        PROPERTIES.put("user", "root");
        PROPERTIES.put("password", "1111");
        PROPERTIES.put("autoReconnect", "true");
        PROPERTIES.put("characterEncoding", "UTF-8");
        PROPERTIES.put("useUnicode", "true");
    }

    public ConnectionPool() {
        for (int i = 0; i < 10; i++) {
            Connection connection = createConnection();
            if (connection != null) {
                pool.add(connection);
            }
        }
    }

    public Connection getConnection() throws PoolConnectionException {
        try {
            while (pool.isEmpty()) {
                Thread.sleep(3000);
            }
            return pool.take();
        } catch (InterruptedException e) {
            throw new PoolConnectionException();
        }
    }

    public void returnConnection (Connection connection){
        pool.add(connection);
    }

    private Connection createConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, PROPERTIES);
            connection.setAutoCommit(false);
            return connection;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}