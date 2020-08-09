package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.exception.ServiceException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class MenuItemServiceImplementationTest {

    private MenuItemServiceImplementation menuItemServiceImplementation;

    @Before
    public void setUp() throws Exception {
        menuItemServiceImplementation = new MenuItemServiceImplementation();
    }

    @After
    public void tearDown() throws Exception {
        menuItemServiceImplementation.closeConnection();
    }

    @Test
    public void findAllMenuItemsInfoExpectedAndActualAreEquals() throws ServiceException {
        int start = 1;
        int total = 5;

        int expected = 5;

        int actual = menuItemServiceImplementation.findAllMenuItemsInfo(start, total).size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllMenuItemsInfoNotNullExpected() throws ServiceException {
        int start = 1;
        int total = 5;

        Integer expected = menuItemServiceImplementation.findAllMenuItemsInfo(start, total).size();

        Assert.assertNotNull(expected);
    }

    @Test
    public void findAllMenuItemsInfoThrowsExceptionIfWrongStartNumber() {
        boolean thrown = false;

        //there is wrong negative number
        int start = -1;
        int total = 5;

        try {
            menuItemServiceImplementation.findAllMenuItemsInfo(start, total);
        } catch (ServiceException e) {
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void findMenuItemByIdExpectedAndActualAreEquals() throws ServiceException {
        Long id = 1L;

        MenuItem actual = new MenuItem();

        actual.setId(1L);
        actual.setName("Americano");
        actual.setWeight(50);
        actual.setCost(new BigDecimal(2));
        actual.setIngredientName("water espresso");

        MenuItem expected = menuItemServiceImplementation.findMenuItemById(id);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findMenuItemByIdNotNullExpected() throws ServiceException {
        Long id = 1L;

        MenuItem expected = menuItemServiceImplementation.findMenuItemById(id);

        Assert.assertNotNull(expected);
    }

    @Test
    public void findMenuItemByIdThrowsExceptionIfWrongId() {
        boolean thrown = false;

        //there is no user with such id
        Long id = 1111111111L;

        try {
            menuItemServiceImplementation.findMenuItemById(id);
        } catch (ServiceException e) {
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void create() {
    }

    @Test
    public void updateMenuItemAndIngredientInfoExpectedAndActualAreEquals() {
    }
}