package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToPersonalInformationPageEditorCommand implements Command {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) {
        return new Page(Page.EDIT_USER_PERSONAL_INFO_PAGE, false);
    }
}
