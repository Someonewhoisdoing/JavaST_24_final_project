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

    public IngredientDAOImplementation(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Ingredient entity) throws DAOException {
        final String SQL_CREATE_INGREDIENT = "INSERT INTO ingredient(name) VALUES(?);";

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
}
