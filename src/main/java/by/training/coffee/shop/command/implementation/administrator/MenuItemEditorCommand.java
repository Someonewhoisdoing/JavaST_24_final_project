package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.coffee.shop.entity.Ingredient;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.MenuItemServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class MenuItemEditorCommand implements Command {
    private final static Logger logger = LogManager.getLogger(MenuItemEditorCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        MenuItemServiceImplementation menuItemServiceImplementation = new MenuItemServiceImplementation();

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer weight = Integer.parseInt(request.getParameter("weight"));
        BigDecimal cost = new BigDecimal(request.getParameter("cost"));
        String ingredientName = request.getParameter("ingredientName");

        MenuItem menuItemUpdated = new MenuItem();
        Ingredient ingredientUpdated = new Ingredient();

        menuItemUpdated.setId(id);
        menuItemUpdated.setName(name);
        menuItemUpdated.setWeight(weight);
        menuItemUpdated.setCost(cost);
        ingredientUpdated.setName(ingredientName);
        menuItemUpdated.setIngredientName(ingredientUpdated.getName());

        try {
            menuItemServiceImplementation.updateMenuItemAndIngredientInfo(menuItemUpdated, ingredientUpdated);

            request.setAttribute("menuItemUpdated", menuItemUpdated);
            request.setAttribute("ingredientUpdated", ingredientUpdated);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                menuItemServiceImplementation.closeConnection();
            } catch (ServiceException e) {
                logger.error(e.getMessage(), e);
            }
        }

        return new Page(Page.ADMINISTRATOR_MENU_ITEMS_PAGE_PATH, false);
    }
}
