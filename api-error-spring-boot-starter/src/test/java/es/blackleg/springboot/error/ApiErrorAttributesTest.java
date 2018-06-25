package es.blackleg.springboot.error;

import java.util.Map;

import es.blackleg.springboot.exception.ApiException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Hector Espert
 */
public class ApiErrorAttributesTest {

    private ApiErrorAttributes errorAttributes;

    private MockHttpServletRequest request;

    private WebRequest webRequest;

    @Before
    public void setUp() {
        errorAttributes = new ApiErrorAttributes();
        request = new MockHttpServletRequest();
        webRequest = new ServletWebRequest(request);
    }

    @Test
    public void testApiException() {
        String code = "exception-code";
        String message = "message";
        ApiException apiException = new ApiException(code, message);
        request.setAttribute("javax.servlet.error.exception", apiException);
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(webRequest, false);
        assertThat(errorAttributes.getError(webRequest)).isSameAs(apiException);
        assertThat(attributes.get("message")).isEqualTo(message);
        assertThat(attributes.get("code")).isEqualTo(code);
    }

}
