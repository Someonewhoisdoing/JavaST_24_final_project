package by.training.coffee.shop.command.implementation.administrator;

import by.training.coffee.shop.command.Command;
import by.training.coffee.shop.command.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.coffee.shop.entity.Item;
import by.training.coffee.shop.exception.ServiceException;
import by.training.coffee.shop.service.implementation.ItemService;

public class ItemEditorCommand implements Command {
    @Override
    public Page execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        ItemService itemService = new ItemService();
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        double weight = Double.parseDouble(request.getParameter("weight"));
        double cost = Double.parseDouble(request.getParameter("cost"));

        Item item = new Item();
        item.setId(id);
        item.setName(name);
        item.setWeight(weight);
        item.setCost(cost);
        itemService.update(item);
        request.setAttribute("itemUpdated", item);
        return new ItemsDisplayCommand().execute(request,response);
//        return new Page(Page.ADMINISTRATOR_MENU_ITEMS_PAGE_PATH, false);
    }
}
