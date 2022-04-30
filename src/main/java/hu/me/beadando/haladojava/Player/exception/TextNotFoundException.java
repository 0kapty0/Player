package hu.me.beadando.haladojava.Player.exception;

public class TextNotFoundException extends Exception{

    public TextNotFoundException(){}

    public TextNotFoundException(String message) {
        super(message);
    }

    public TextNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextNotFoundException(Throwable cause) {
        super(cause);
    }

    public TextNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
