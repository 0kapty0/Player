package hu.me.beadando.haladojava.Player.exception;

public class PictureNotFoundException extends Exception{

    public PictureNotFoundException(){}

    public PictureNotFoundException(String message) {
        super(message);
    }

    public PictureNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PictureNotFoundException(Throwable cause) {
        super(cause);
    }

    public PictureNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
