package jm.stockx.http.service.exceptions;

public class UserRestServiceException extends RuntimeException {
    public UserRestServiceException() {
    }

    public UserRestServiceException(String message) {
        super(message);
    }

    public UserRestServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
