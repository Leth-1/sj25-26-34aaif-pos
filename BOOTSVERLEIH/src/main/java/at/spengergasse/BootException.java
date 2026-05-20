package at.spengergasse;

public class BootException extends Exception {
    public BootException(String message) {
        super(message);
    }

    public BootException(String message, Throwable cause) {
        super(message, cause);
    }
}
