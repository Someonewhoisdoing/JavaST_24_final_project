package by.training.coffee.shop.dao.implementation;

import by.training.coffee.shop.dao.AbstractDAO;
import by.training.coffee.shop.entity.Receipt;
import by.training.coffee.shop.exception.DAOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ReceiptDAOImplementation extends AbstractDAO<Receipt> {
    private final static Logger logger = LogManager.getLogger(ReceiptDAOImplementation.class);


    public ReceiptDAOImplementation(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(Receipt entity) throws DAOException {
        final String SQL_CREATE_RECEIPT = "INSERT INTO coffeeshop.receipt(number, date, user_id) "
                + "VALUES(?, ?, ?);";
        PreparedStatement preparedStatement = null;
        boolean isCreated;
        try {
            preparedStatement = connection.prepareStatement(SQL_CREATE_RECEIPT);
            preparedStatement.setString(1, entity.getNumber().toString());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            preparedStatement.setString(2, dateFormat.format(entity.getDate()));
            preparedStatement.setString(3, entity.getUserId().toString());
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

    public boolean updateReceipt(Receipt entity) throws DAOException {
        throw new DAOException();
    }
}
