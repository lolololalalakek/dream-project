package uz.stajirovka.exception;

public class SorryException extends RuntimeException {
    public SorryException() {
        super("Sorry, we dont have that book");
    }
}
