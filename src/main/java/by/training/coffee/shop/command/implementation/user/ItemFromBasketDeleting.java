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

public class ItemFromBasketDeleting implements Command {
    private final static Logger logger = LogManager.getLogger(ItemFromBasketDeleting.class);
    private final ItemService itemService = new ItemService();

    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("userByLoginAndPassword");
        String stringId = request.getParameter("id");
        Item item = new Item();
        if (stringId != null) {
            long id = Long.parseLong(stringId);
            item.setId(id);
        }
        boolean isDeleted = itemService.deleteItemFromBasket(item, Math.toIntExact(user.getId()));
        if (isDeleted) {
            logger.info("order item was deleted from basket");
        }
        return new ToBasketPageCommand().execute(request, response);
    }
}
