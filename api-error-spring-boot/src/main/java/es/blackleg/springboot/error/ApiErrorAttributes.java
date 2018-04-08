package es.blackleg.springboot.error;

import es.blackleg.springboot.error.exception.ApiException;
import java.util.Map;
import java.util.Objects;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;

/**
 *
 * @author Hector Espert
 */
public class ApiErrorAttributes extends DefaultErrorAttributes {
    
    private static final String CODE = "code";

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        Throwable error = getError(requestAttributes);
        if (Objects.nonNull(error) && error instanceof ApiException) {
            ApiException exception = (ApiException)error;
            String errorCode = exception.getCode();
            if (!StringUtils.isEmpty(errorCode)) {
                errorAttributes.put(CODE, errorCode);
            }
        }
        return errorAttributes;
    }

    
}
