package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuItemAddingCommand implements Command {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new Page(Page.ADMINISTRATOR_MENU_ITEMS_PAGE_PATH, false);
    }
}
