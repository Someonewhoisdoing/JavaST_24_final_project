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
    private final static Logger logger = LogManager.getLogger(ToBasketPageCommand.class);

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        ItemService itemService = new ItemService();
        User user = (User) httpSession.getAttribute("userByLoginAndPassword");
        List<Item> itemList = itemService.selectAllOrderItemsInfo(Math.toIntExact(user.getId()));
        if (itemList != null) {
            logger.info("orderItemList in ToBasketPageCommand is not null");
            httpSession.setAttribute("orderItemList", itemList);
        }
        return new Page(Page.BASKET_PAGE, false);
    }
}
