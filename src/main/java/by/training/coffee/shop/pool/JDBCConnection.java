package by.training.coffee.shop.pool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JDBCConnection {
    private final static Logger logger = LogManager.getLogger(JDBCConnection.class);

    private final static Lock connectionLock = new ReentrantLock();

//    private List<Connection> connectionPool;
//    private List<Connection> usedConnections = new ArrayList<>();
//    private static int INITIAL_POOL_SIZE = 10;

    private final static String URL = "jdbc:mysql://localhost:3306/coffeeshop";
    private final ConnectionProperties connectionProperties = new ConnectionProperties();
    private final Properties properties = new Properties();

    private JDBCConnection() {
        //empty constructor
    }

    private static JDBCConnection instance = null;

    public static JDBCConnection getInstance() {
        if (instance == null) {
            instance = new JDBCConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            putProperties();
            registerDriver();
            connection = DriverManager.getConnection(URL, properties);
            connectionLock.lock();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }finally {
            connectionLock.unlock();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void putProperties() throws SQLException {
        connectionProperties.putProperties(properties);
    }

    private void registerDriver() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    }
}