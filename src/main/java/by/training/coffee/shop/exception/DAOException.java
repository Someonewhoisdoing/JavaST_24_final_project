package by.training.coffee.shop.exception;

public class DAOException extends Exception {
    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Exception cause) {
        super(message, cause);
    }

    public DAOException(Exception cause) {
        super(cause);
    }
}
