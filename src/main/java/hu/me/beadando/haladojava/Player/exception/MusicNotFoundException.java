package hu.me.beadando.haladojava.Player.exception;

public class MusicNotFoundException extends Exception{

    public MusicNotFoundException(){}

    public MusicNotFoundException(String message) {
        super(message);
    }

    public MusicNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MusicNotFoundException(Throwable cause) {
        super(cause);
    }

    public MusicNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
