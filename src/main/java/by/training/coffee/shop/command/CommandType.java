package by.training.coffee.shop.command;

import by.training.coffee.shop.command.implementation.administrator.*;
import by.training.coffee.shop.command.implementation.common.*;
import by.training.coffee.shop.command.implementation.menu.MenuItemInformationDisplayCommand;
import by.training.coffee.shop.command.implementation.user.ToBasketPageCommand;
import by.training.coffee.shop.command.implementation.user.ToPersonalInformationPageEditorCommand;
import by.training.coffee.shop.command.implementation.user.UserPersonalInformationEditorCommand;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class CommandType {
    private static final Logger logger = LogManager.getLogger(CommandType.class);
    //common
    private final static String LANGUAGE_CHANGER_COMMAND = "change_language";
    private final static String REGISTRATION_COMMAND = "registration";
    private final static String LOGIN_COMMAND = "login";
    private final static String LOGOUT_COMMAND = "logout";
    private final static String TO_MENU_PAGE_RETURNER_COMMAND = "back_to_menu_page";
    private final static String TO_ACCOUNT_PAGE_COMMAND = "to_account_page";
    private final static String TO_MENU_PAGE_COMMAND = "to_menu_page";
    //admin
    private final static String USER_LIST_DISPLAY_COMMAND = "users_list";
    private final static String MENU_ITEMS_DISPLAY_COMMAND = "menu_items_list";
    private final static String TO_EDIT_MENU_ITEM_PAGE_COMMAND = "to_edit_menu_item_page";
    private final static String MENU_ITEM_EDITOR_COMMAND = "edit_menu_item";
    private final static String TO_ADD_MENU_ITEM_PAGE_COMMAND = "to_add_menu_item_page";
    private final static String MENU_ITEM_ADDING_COMMAND = "add_menu_item";
    //user
    private final static String TO_EDIT_USER_INFO_PAGE_COMMAND = "to_edit_user_info_page";
    private final static String EDIT_USER_INFO_COMMAND = "edit_user";
    private final static String TO_BASKET_PAGE_COMMAND = "to_basket_page";

    public Command getCommand(String command) {
        switch (command) {
            case LANGUAGE_CHANGER_COMMAND:
                return new LanguageChangerCommand();
            case REGISTRATION_COMMAND:
                return new RegistrationCommand();
            case LOGIN_COMMAND:
                return new LoginCommand();
            case LOGOUT_COMMAND:
                return new LogoutCommand();
            case TO_ACCOUNT_PAGE_COMMAND:
                return new ToAccountPageCommand();
            case TO_EDIT_USER_INFO_PAGE_COMMAND:
                return new ToPersonalInformationPageEditorCommand();
            case EDIT_USER_INFO_COMMAND:
                return new UserPersonalInformationEditorCommand();
            case TO_BASKET_PAGE_COMMAND:
                return new ToBasketPageCommand();
            case TO_MENU_PAGE_COMMAND:
                return new MenuItemInformationDisplayCommand();
            case USER_LIST_DISPLAY_COMMAND:
                return new UsersListDisplayCommand();
            case MENU_ITEMS_DISPLAY_COMMAND:
                return new MenuItemsListDisplayCommand();
            case TO_EDIT_MENU_ITEM_PAGE_COMMAND:
                return new ToEditMenuItemPageCommand();
            case MENU_ITEM_EDITOR_COMMAND:
                return new MenuItemEditorCommand();
            case TO_ADD_MENU_ITEM_PAGE_COMMAND:
                return new ToAddMenuItemPageCommand();
            case MENU_ITEM_ADDING_COMMAND:
                return new MenuItemAddingCommand();
        }
        return new MenuPageReturnerCommand();
    }
}
