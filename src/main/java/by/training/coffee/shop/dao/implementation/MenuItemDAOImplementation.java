package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.Ingredient;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.crypto.spec.PSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuItemDAOImplementation extends AbstractDAO<MenuItem> {
    private final static Logger logger = LogManager.getLogger(MenuItemDAOImplementation.class);

    public MenuItemDAOImplementation(Connection connection) {
        super(connection);
    }

    public List<MenuItem> findAllMenuItemsInfo(int start, int total) throws DAOException {
        final String SQL_SELECT_ALL_MENU_ITEMS = "SELECT coffeeshop.menu_item.id, coffeeshop.menu_item.name,"
                + " coffeeshop.menu_item.weight, coffeeshop.menu_item.cost, coffeeshop.ingredient.name_list "
                + "FROM coffeeshop.menu_item "
                + "INNER JOIN coffeeshop.ingredient ON coffeeshop.menu_item.ingredient_id=coffeeshop.ingredient.id "
                + "LIMIT " + (start - 1) + ", " + total + ";";

        List<MenuItem> menuItems = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_MENU_ITEMS);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                MenuItem menuItem = new MenuItem();
                menuItem.setId(resultSet.getLong("id"));
                menuItem.setName(resultSet.getString("name"));
                menuItem.setWeight(resultSet.getInt("weight"));
                menuItem.setCost(resultSet.getBigDecimal("cost"));
                menuItem.setIngredientName(resultSet.getString("name_list"));

                menuItems.add(menuItem);
            }
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return menuItems;
    }

    public MenuItem findMenuItemById(Long id) throws DAOException {
        final String SQL_FIND_MENU_ITEM = "SELECT coffeeshop.menu_item.id, coffeeshop.menu_item.name,"
                + " coffeeshop.menu_item.weight, coffeeshop.menu_item.cost, coffeeshop.ingredient.name_list "
                + "FROM coffeeshop.menu_item "
                + "INNER JOIN coffeeshop.ingredient ON coffeeshop.menu_item.ingredient_id=coffeeshop.ingredient.id "
                + "WHERE coffeeshop.menu_item.id=?;";

        MenuItem menuItem = new MenuItem();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_MENU_ITEM);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            String name = resultSet.getString("name");
            Integer weight = resultSet.getInt("weight");
            BigDecimal cost = resultSet.getBigDecimal("cost");
            String ingredientName = resultSet.getString("name_list");

            menuItem.setId(id);
            menuItem.setName(name);
            menuItem.setWeight(weight);
            menuItem.setCost(cost);
            menuItem.setIngredientName(ingredientName);

        } catch (SQLException e) {
            throw new DAOException(e.getMessage(), e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return menuItem;
    }

    public boolean updateMenuItemAndIngredientInfo(MenuItem menuItem, Ingredient ingredient) throws DAOException {
        final String SQL_UPDATE_MENU_ITEM = "UPDATE coffeeshop.menu_item, coffeeshop.ingredient "
                + "SET coffeeshop.menu_item.name=?, coffeeshop.menu_item.weight=?, coffeeshop.menu_item.cost=?, "
                + "coffeeshop.ingredient.name_list=? WHERE coffeeshop.menu_item.ingredient_id=coffeeshop.ingredient.id "
                + "AND coffeeshop.menu_item.id=?;";

        PreparedStatement preparedStatement = null;
        boolean isUpdated;
        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_MENU_ITEM);
            preparedStatement.setString(1, menuItem.getName());
            preparedStatement.setString(2, menuItem.getWeight().toString());
            preparedStatement.setString(3, menuItem.getCost().toString());
            preparedStatement.setString(4, ingredient.getName());
            preparedStatement.setString(5, menuItem.getId().toString());

            preparedStatement.executeUpdate();

            isUpdated = true;

        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return isUpdated;
    }

    @Override
    public boolean create(MenuItem entity) throws DAOException {
        final String SQL_CREATE_MENU_ITEM = "INSERT INTO coffeeshop.menu_item(name, weight, cost, ingredient_id) "
                + "VALUES(?, ?, ?, ?);";

        PreparedStatement preparedStatement = null;

        boolean isCreated;

        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_MENU_ITEM);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getWeight().toString());
            preparedStatement.setString(3, entity.getCost().toString());
            preparedStatement.setString(4, entity.getIngredientId().toString());

            preparedStatement.executeUpdate();

            isCreated = true;

        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return isCreated;
    }
}
