package es.blackleg.springboot.exception;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApiRuntimeExceptionTest {
    private static final String CODE = "code";
    private static final String MESSAGE = "message";

    private ApiRuntimeException exception;

    @Before
    public void setUp() {
        exception = new ApiRuntimeException(CODE, MESSAGE);
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
        String expected = "es.blackleg.springboot.exception.ApiRuntimeException: code, message";
        assertEquals(expected, result);
    }

}