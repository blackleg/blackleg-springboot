package es.blackleg.springboot.error.exception;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hector Espert
 */
public class ApiExceptionTest {
    
    private static final String CODE = "code";
    private static final String MESSAGE = "message";
            
    private ApiException exception;
    
    @Before
    public void setUp() {
        exception = new ApiException(CODE, MESSAGE);
    }

    @Test
    public void testGetCode() {
        String result = exception.getCode();
        assertEquals(CODE, result);
    }

    @Test
    public void testGetMessage() {
        String result = exception.getMessage();
        assertEquals(MESSAGE, result);
    }

    @Test
    public void testToString() {
        String result = exception.toString();
        String expected = "es.blackleg.springboot.error.exception.ApiException: code, message";
        assertEquals(expected, result);
    }
    
}
