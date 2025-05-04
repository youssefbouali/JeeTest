package prjweb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
//import javax.servlet.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServletTest {
    @Test
    public void testHelloServlet() throws Exception {
        // Create mock objects
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        // Set up response writer
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Test the servlet
        HelloServlet servlet = new HelloServlet();
        servlet.doGet(request, response);

        // Verify behavior
        verify(response).getWriter();
        writer.flush();
        assertTrue(stringWriter.toString().contains("Hello, World!"));
    }
}