package by.training.coffee.shop.command.implementation.common;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.language.ResourceManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.util.Locale;

import static by.training.coffee.shop.language.ResourceManager.DEFAULT_LOCALE;

public class LanguageChangerCommand implements Command {
    private static final Logger logger = LogManager.getLogger(LanguageChangerCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        String localeValue = request.getParameter("locale");
        Locale locale;
        switch (localeValue) {
            case "ru_RU":
                locale = new Locale("ru", "RU");
                logger.info("language is ru");
                break;
            case "en_EN":
                locale = new Locale("en", "US");
                logger.info("language is en");
                break;
            default:
                locale = DEFAULT_LOCALE;
                logger.info("language is default");
        }

        Config.set(request.getSession(), Config.FMT_LOCALE, locale);

        ResourceManager resourceManager = ResourceManager.INSTANCE;
        resourceManager.changeResource(locale);

        return new Page(Page.HOME_PAGE_PATH, true);
    }
}
