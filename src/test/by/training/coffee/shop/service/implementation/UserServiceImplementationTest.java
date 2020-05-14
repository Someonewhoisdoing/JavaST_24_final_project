package by.training.coffee.shop.service.implementation;

import by.training.coffee.shop.entity.User;
import by.training.coffee.shop.exception.ServiceException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void findUserByLoginAndPasswordExpectedAndActualAreEquals() throws ServiceException {
        String login = "admin";
        String password = "666666";

        User expected = userServiceImplementation.findUserByLoginAndPassword(login, password);

        User actual = new User(1L, "admin", "666666", "Alex", "Cold", "+375339991317", 1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findUserByLoginAndPasswordNotNullExpected() throws ServiceException {
        String login = "admin";
        String password = "666666";

        User expected = userServiceImplementation.findUserByLoginAndPassword(login, password);

        Assert.assertNotNull(expected);
    }

    @Test
    public void findUserByLoginAndPasswordThrowsExceptionIfWrongLogin() {
        boolean thrown = false;

        //login should be "admin"
        String login = "a";
        String password = "666666";

        try {
            userServiceImplementation.findUserByLoginAndPassword(login, password);
        } catch (ServiceException e) {
            thrown = true;
        }

        Assert.assertTrue(thrown);
    }


    @Test
    public void findAllUsersExpectedAndActualAreEquals() throws ServiceException {
        List<User> userListExpected = new ArrayList<>();
        userListExpected.add(new User(1L, "admin", "666666", "Alex", "Cold", "+375339991317", 1));
        userListExpected.add(new User(2L, "savage", "12345", "Max", "Wrong", "+375299998877", 2));

        List<User> userListActual = userServiceImplementation.findAllUsers();

        boolean actual = (userListActual.contains(userListExpected.get(0)) && userListActual.contains(userListExpected.get(1)));

        Assert.assertTrue(actual);
    }

    @Test
    public void findAllUsersNotNullExpected() throws ServiceException {
        List<User> expected = userServiceImplementation.findAllUsers();

        Assert.assertNotNull(expected);
    }

    @Test
    public void findAllUsersReturnsFalseIfWrongUserInExpectedList() throws ServiceException {
        List<User> userListExpected = new ArrayList<>();

        //login should be "admin"
        String login = "a";

        userListExpected.add(new User(1L, login, "666666", "Alex", "Cold", "+375339991317", 1));
        userListExpected.add(new User(2L, "savage", "12345", "Max", "Wrong", "+375299998877", 2));

        List<User> userListActual = userServiceImplementation.findAllUsers();

        boolean actual = (userListActual.contains(userListExpected.get(0)) && userListActual.contains(userListExpected.get(1)));

        Assert.assertFalse(actual);
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