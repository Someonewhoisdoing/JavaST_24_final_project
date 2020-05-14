package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.Ingredient;
import by.training.coffee.shop.entity.MenuItem;
import by.training.coffee.shop.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuItemDAOImplementation extends AbstractDAO<MenuItem> {
    private final static Logger logger = LogManager.getLogger(MenuItemDAOImplementation.class);

    public MenuItemDAOImplementation(Connection connection) {
        super(connection);
    }

    public List<MenuItem> findAllMenuItemsInfo(int start, int total) throws DAOException {
        final String SQL_SELECT_ALL_MENU_ITEMS = "SELECT menu_item.id, menu_item.name,"
                + " menu_item.weight, menu_item.cost, ingredient.name_list "
                + "FROM menu_item "
                + "INNER JOIN ingredient "
                + "ON menu_item.ingredient_id = ingredient.id "
                + "LIMIT " + (start - 1) + ", " + total + ";";

        List<MenuItem> menuItems = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_MENU_ITEMS);

            ResultSet resultSet = Objects.requireNonNull(preparedStatement).executeQuery();

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
                    logger.info("prepared statement in findAllMenuItemsInfo(...) closed");
                } catch (SQLException e) {
                    logger.error(e.getMessage());
                }
            }
        }
        return menuItems;
    }

    public MenuItem findMenuItemById(Long id) throws DAOException {
        final String SQL_FIND_MENU_ITEM = "SELECT menu_item.id, menu_item.name,"
                + " menu_item.weight, menu_item.cost, ingredient.name_list "
                + "FROM menu_item "
                + "INNER JOIN ingredient "
                + "ON menu_item.ingredient_id=ingredient.id "
                + "WHERE menu_item.id=?;";

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
        final String SQL_UPDATE_MENU_ITEM = "UPDATE menu_item, ingredient "
                + "SET menu_item.name=?, menu_item.weight=?, menu_item.cost=?, "
                + "ingredient.name_list=? WHERE menu_item.ingredient_id=ingredient.id "
                + "AND menu_item.id=?;";

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
        final String SQL_CREATE_MENU_ITEM = "INSERT INTO menu_item(name, weight, cost, ingredient_id) "
                + "VALUES(?, ?, ?, ?);";

        PreparedStatement preparedStatement = null;

        boolean isCreated;

        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_MENU_ITEM);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getWeight().toString());
            preparedStatement.setString(3, entity.getCost().toString());
            preparedStatement.setString(4, entity.getIngredientId().toString());

            isCreated = preparedStatement.executeUpdate() > 0;;

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
