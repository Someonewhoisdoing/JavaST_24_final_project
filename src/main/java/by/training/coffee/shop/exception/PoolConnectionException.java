package by.training.coffee.shop.exception;

public class PoolConnectionException extends Exception {
    public PoolConnectionException() {
    }

    public PoolConnectionException(String message) {
        super(message);
    }

    public PoolConnectionException(String message, Exception cause) {
        super(message, cause);
    }

    public PoolConnectionException(Exception cause) {
        super(cause);
    }
}
