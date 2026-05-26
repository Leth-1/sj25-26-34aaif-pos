package at.spengergasse;

public class TanzschuleException extends Exception {
    public TanzschuleException(String message) {
        super(message);
    }

    public TanzschuleException(String message, Throwable cause) {
        super(message, cause);
    }
}
