package by.training.coffee.shop.pool;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Properties;

public class ConnectionProperties {
    private final static Logger logger = LogManager.getLogger(ConnectionProperties.class);

    public void putProperties(Properties properties) {

        properties.put("user", "olya");
        properties.put("password", "66613777");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        logger.info("properties added");
    }
}
