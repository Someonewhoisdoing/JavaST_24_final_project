package by.training.coffee.shop.command;

import by.training.coffee.shop.command.implementation.administrator.*;
import by.training.coffee.shop.command.implementation.common.*;
import by.training.coffee.shop.command.implementation.menu.ItemInformationDisplayCommand;
import by.training.coffee.shop.command.implementation.user.*;

public class CommandFactory {
    private CommandFactory() {
    }
    //common
    private final static String LANGUAGE_CHANGER_COMMAND = "change_language";
    private final static String LOGIN_COMMAND = "login";
    private final static String LOGOUT_COMMAND = "logout";
    private final static String TO_HOME_PAGE_RETURNER_COMMAND = "back_to_home_page";
    private final static String TO_ACCOUNT_PAGE_COMMAND = "to_account_page";
    private final static String TO_MENU_PAGE_COMMAND = "to_menu_page";
    //admin
    private final static String USER_LIST_DISPLAY_COMMAND = "users_list";
    private final static String ITEMS_DISPLAY_COMMAND = "items_list";
    private final static String TO_EDIT_MENU_ITEM_PAGE_COMMAND = "to_edit_menu_item_page";
    private final static String MENU_ITEM_EDITOR_COMMAND = "edit_menu_item";
    private final static String TO_ADD_MENU_ITEM_PAGE_COMMAND = "to_add_menu_item_page";
    private final static String MENU_ITEM_ADDING_COMMAND = "add_menu_item";
    //user
    private final static String TO_EDIT_USER_INFO_PAGE_COMMAND = "to_edit_user_info_page";
    private final static String EDIT_USER_INFO_COMMAND = "edit_user";
    private final static String TO_BASKET_PAGE_COMMAND = "to_basket_page";
    private final static String ADD_ORDER_ITEM_TO_BASKET = "add_order_item_to_basket";
    private final static String MAKE_ORDER_AND_SHOW_ORDER_INFO = "make_order_and_show_order_info";
    private final static String DELETE_ORDER_ITEM_FROM_BASKET = "delete_order_item_from_basket";

    public static Command getCommand(String command) {
        switch (command) {
            case LANGUAGE_CHANGER_COMMAND:
                return new LanguageChangerCommand();
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
                return new ItemInformationDisplayCommand();
            case USER_LIST_DISPLAY_COMMAND:
                return new UsersListDisplayCommand();
            case ITEMS_DISPLAY_COMMAND:
                return new ItemsDisplayCommand();
            case TO_EDIT_MENU_ITEM_PAGE_COMMAND:
                return new ToEditItemPageCommand();
            case MENU_ITEM_EDITOR_COMMAND:
                return new ItemEditorCommand();
            case TO_ADD_MENU_ITEM_PAGE_COMMAND:
                return new ToAddMenuItemPageCommand();
            case MENU_ITEM_ADDING_COMMAND:
                return new MenuItemAddingCommand();
            case ADD_ORDER_ITEM_TO_BASKET:
                return new ItemToBasketAddingCommand();
            case MAKE_ORDER_AND_SHOW_ORDER_INFO:
                return new OrderInfoDisplayCommand();
            case DELETE_ORDER_ITEM_FROM_BASKET:
                return new ItemFromBasketDeleting();
            case TO_HOME_PAGE_RETURNER_COMMAND:
                return new HomePageReturnerCommand();
        }
        return new HomePageReturnerCommand();
    }
}
