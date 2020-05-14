package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceImplementationTest {

    private UserServiceImplementation userServiceImplementation;

    @Before
    public void setUp() throws Exception {
        userServiceImplementation = new UserServiceImplementation();
    }

    @After
    public void tearDown() throws Exception {
        userServiceImplementation.closeConnection();
    }

    @Test
    public void findUserByIdExpectedAndActualAreEquals() throws ServiceException {
        Long id = 1L;

        User expected = userServiceImplementation.findUserById(id);

        User actual = new User(1L, "admin", "666666", "Alex", "Cold", "+375339991317", 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findUserByIdNotNullExpected() throws ServiceException {
        Long id = 1L;

        User expected = userServiceImplementation.findUserById(id);

        Assert.assertNotNull(expected);
    }

    @Test
    public void findUserByIdThrowsExceptionIfWrongId() {
        boolean thrown = false;

        //there is no user with such id
        Long id = 1111111111L;

        try {
            userServiceImplementation.findUserById(id);
        } catch (ServiceException e) {
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void findUserByLoginAndPassword() {

    }

    @Test
    public void findAllUsers() {
    }

    @Test
    public void create() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void closeConnection() {
    }
}