package es.blackleg.springboot.error;

import es.blackleg.springboot.exception.ExceptionWithCode;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Hector Espert
 */
public class ApiErrorAttributes extends DefaultErrorAttributes {
    
    private static final String CODE = "code";

    public ApiErrorAttributes() {
        super();
    }

    public ApiErrorAttributes(boolean includeException) {
        super(includeException);
    }

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        Throwable error = getError(webRequest);
        if (Objects.nonNull(error) && error instanceof ExceptionWithCode) {
            ExceptionWithCode exception = (ExceptionWithCode)error;
            String errorCode = exception.getCode();
            if (!StringUtils.isEmpty(errorCode)) {
                errorAttributes.put(CODE, errorCode);
            }
        }
        return errorAttributes;
    }

    
}
