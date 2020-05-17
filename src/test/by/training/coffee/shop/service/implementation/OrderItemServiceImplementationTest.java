package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.entity.OrderItem;
import by.training.coffee.shop.exception.ServiceException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class OrderItemServiceImplementationTest {
    private OrderItemServiceImplementation orderItemServiceImplementation;

    @Before
    public void setUp() {
        orderItemServiceImplementation = new OrderItemServiceImplementation();
    }

    @After
    public void tearDown() throws Exception {
        orderItemServiceImplementation.closeConnection();
    }

    @Test
    public void deleteOrderItemFromBasketReturnsTrue() throws ServiceException {
        final Long id = 2L;
        final String name = "Macchiato";
        final BigDecimal price = new BigDecimal(3);
        final Long menuItemId = 7L;

        OrderItem orderItem = new OrderItem();

        orderItem.setId(id);
        orderItem.setName(name);
        orderItem.setPrice(price);
        orderItem.setMenuItemId(menuItemId);

        boolean actual = orderItemServiceImplementation.deleteOrderItemFromBasket(orderItem);

        Assert.assertTrue(actual);
    }

    @Test
    public void findAllOrderItemsInfoNotNullExpected() throws ServiceException {
        List<OrderItem> expected = orderItemServiceImplementation.findAllOrderItemsInfo();

        Assert.assertNotNull(expected);
    }

    @Test
    public void createActualIsTrue() throws ServiceException {
        final String name = "Macchiato";
        final BigDecimal price = new BigDecimal(3);
        final Long menuItemId = 7L;

        OrderItem orderItem = new OrderItem();

        orderItem.setName(name);
        orderItem.setPrice(price);
        orderItem.setMenuItemId(menuItemId);

        boolean actual = orderItemServiceImplementation.create(orderItem);

        Assert.assertTrue(actual);
    }
}