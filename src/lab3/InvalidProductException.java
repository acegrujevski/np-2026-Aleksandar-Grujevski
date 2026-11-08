package lab3;

public class InvalidProductException extends Exception {
    public InvalidProductException(String line) {
        super(String.format("Invalid product: %s",line));
    }
}
