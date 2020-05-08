package by.training.coffee.shop.pool;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

public class JDBCConnection {
    private final static Logger logger = LogManager.getLogger(JDBCConnection.class);
    //private static ReentrantLock reentrantLock = new ReentrantLock();

    private final static String URL = "jdbc:mysql://localhost:3306/coffeeshop";
    private ConnectionProperties connectionProperties = new ConnectionProperties();
    private Properties properties = new Properties();

    private JDBCConnection() {
    }

    private static JDBCConnection instance = null;

    public static JDBCConnection getInstance() {
        //reentrantLock.lock();
        logger.info("blocking");
        try {
            if (instance == null)
                instance = new JDBCConnection();
        } finally {
            //reentrantLock.unlock();
            logger.info("unblocking");
        }
        return instance;
    }

    public Connection getConnection() {
        connectionProperties.putProperties(properties);
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            logger.info("driver is registered");
            connection = DriverManager.getConnection(URL, properties);
            logger.info("connection is established");
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
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
}
