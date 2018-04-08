package es.blackleg.springboot.error;

import es.blackleg.springboot.error.exception.ApiException;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Hector Espert
 */
public class ApiErrorAttributesTest {

    private ApiErrorAttributes errorAttributes;

    private MockHttpServletRequest request;

    private RequestAttributes requestAttributes;

    @Before
    public void setUp() {
        errorAttributes = new ApiErrorAttributes();
        request = new MockHttpServletRequest();
        requestAttributes = new ServletRequestAttributes(request);
    }

    @Test
    public void testApiException() throws Exception {
        String code = "exception-code";
        String message = "message";
        ApiException apiException = new ApiException(code, message);
        request.setAttribute("javax.servlet.error.exception", apiException);
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(requestAttributes, false);
        assertThat(errorAttributes.getError(requestAttributes)).isSameAs(apiException);
        assertThat(attributes.get("exception")).isEqualTo(ApiException.class.getName());
        assertThat(attributes.get("message")).isEqualTo(message);
        assertThat(attributes.get("code")).isEqualTo(code);
    }

}
