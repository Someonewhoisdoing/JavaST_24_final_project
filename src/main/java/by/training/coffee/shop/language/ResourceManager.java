package by.training.coffee.shop.language;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private final static Logger logger = LogManager.getLogger(ResourceManager.class);
    public static final Locale DEFAULT_LOCALE = new Locale("en", "US");

    public void changeResource(Locale locale) {
        String resourceName = "property.text";

        ResourceBundle.getBundle(resourceName, locale);
        logger.info("resource file was found");
    }
}
