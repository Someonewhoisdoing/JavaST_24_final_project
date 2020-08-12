package by.training.coffee.shop.command.implementation.user;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;
import by.training.coffee.shop.entity.Item;
import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.ItemService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ToBasketPageCommand implements Command {
    private static final Logger logger = LogManager.getLogger(ToBasketPageCommand.class);
    private static final ItemService itemService = new ItemService();

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        List<Item> itemList = itemService.selectAllOrderItemsInfo(user.getId());
        if (itemList != null) {
            logger.info("orderItemList in ToBasketPageCommand is not null");
            httpSession.setAttribute("orderItemList", itemList);
        }
        return new Page(Page.BASKET_PAGE, false);
    }
}
