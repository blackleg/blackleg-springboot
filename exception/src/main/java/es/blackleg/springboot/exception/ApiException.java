package es.blackleg.springboot.exception;

/**
 *
 * @author Hector Espert
 */
public class ApiException extends RuntimeException implements ExceptionWithCode {
    
    private static final String FORMAT = "%s: %s, %s";

    private final String code;

    public ApiException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ApiException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public ApiException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public ApiException(String code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return String.format(FORMAT, getClass().getName(), getCode(), getLocalizedMessage());
    }

}
