package by.training.coffee.shop.command;

public class Page {
    //common
    public static final String LOGIN_PAGE_PATH = "/jsp/common/login.jsp";
    public static final String MENU_PAGE_PATH = "/jsp/common/menu.jsp";
    public static final String HOME_PAGE_PATH = "/";
    public static final String GUEST_PAGE_PATH = "/jsp/common/guest.jsp";
    //administrator
    public static final String ADMINISTRATOR_PAGE_PATH = "/jsp/administrator/administrator_page.jsp";
    public static final String ADMINISTRATOR_USERS_PAGE_PATH = "/jsp/administrator/users_list_page.jsp";
    public static final String ADMINISTRATOR_MENU_ITEMS_PAGE_PATH = "/jsp/administrator/menu_items_list_page.jsp";
    public static final String ADMINISTRATOR_TO_EDIT_MENU_ITEM_PAGE_PATH = "/jsp/administrator/edit_menu_item.jsp";
    public static final String ADMINISTRATOR_TO_ADD_MENU_ITEM_PAGE_PATH = "/jsp/administrator/add_menu_item.jsp";
    //user
    public static final String USER_PERSONAL_PAGE_PATH = "/jsp/user/user_personal_page.jsp";
    public static final String EDIT_USER_PERSONAL_INFO_PAGE = "/jsp/user/edit_personal_information.jsp";
    public static final String ORDER_INFO_PAGE = "/jsp/user/order_information.jsp";
    public static final String BASKET_PAGE = "/jsp/user/basket.jsp";

    private String pageUrl;
    private boolean isRedirect;

    public Page(String pageUrl, boolean isRedirect) {
        this.pageUrl = pageUrl;
        this.isRedirect = isRedirect;
    }

    public Page(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean isRedirect() {
        return isRedirect;
    }
}
