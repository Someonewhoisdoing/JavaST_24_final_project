package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.Ingredient;
import by.training.coffee.shop.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngredientDAOImplementation extends AbstractDAO<Ingredient> {
    private final static Logger logger = LogManager.getLogger(IngredientDAOImplementation.class);

    //private final static String SQL_SELECT_ALL_INGREDIENTS = "SELECT coffeeshop.menu_item.id, coffeeshop.menu_item.name, coffeeshop.menu_item.weight, coffeeshop.menu_item.cost, coffeeshop.ingredient.name FROM coffeeshop.menu_item INNER JOIN coffeeshop.ingredient ON coffeeshop.menu_item.ingredient_id=coffeeshop.ingredient.id;";

    public IngredientDAOImplementation(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Ingredient entity) throws DAOException {
        final String SQL_CREATE_INGREDIENT = "INSERT INTO coffeeshop.ingredient(name) VALUES(?);";

        PreparedStatement preparedStatement = null;
        boolean isCreated;
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_INGREDIENT);
            preparedStatement.setString(1, entity.getName());
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

    public boolean updateIngredient(Ingredient entity) throws DAOException {
        final String SQL_UPDATE_INGREDIENT = "UPDATE coffeeshop.ingredient SET name=? WHERE id=?;";

        PreparedStatement preparedStatement = null;
        boolean isUpdated;
        try {
            preparedStatement = connection.prepareStatement(SQL_UPDATE_INGREDIENT);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getId().toString());
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
}
