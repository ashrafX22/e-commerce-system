package errors;

public class CartEmptyException extends Exception {
    public CartEmptyException(String message) {
        super(message);
    }
}
