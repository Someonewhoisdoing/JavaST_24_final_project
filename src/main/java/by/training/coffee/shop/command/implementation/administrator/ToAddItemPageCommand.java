package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToAddItemPageCommand implements Command {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new Page(Page.ADMINISTRATOR_TO_ADD_MENU_ITEM_PAGE_PATH, false);
    }
}
