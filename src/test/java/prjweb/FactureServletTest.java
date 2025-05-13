package prjweb;

import org.junit.jupiter.api.Test;
import jakarta.servlet.http.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class FactureServletTest {
    @Test
    public void testDoPost() throws Exception {
        // Mock request and response
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Mock parameters
        when(request.getParameter("id")).thenReturn("789");
        when(request.getParameter("date")).thenReturn("2025-05-13");
        when(request.getParameter("client")).thenReturn("Client X");
        when(request.getParameter("total")).thenReturn("1500.75");

        // Capture the response output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Call servlet
        FactureServlet servlet = new FactureServlet();
        servlet.doPost(request, response);
        writer.flush(); // ensure everything is written

        // Assert output
        String result = stringWriter.toString();
        assertTrue(result.contains("Facture created:"), "Should indicate facture creation");
        assertTrue(result.contains("ID: 789"), "Should include the correct ID");
        assertTrue(result.contains("Date: 2025-05-13"), "Should include the correct date");
        assertTrue(result.contains("Client: Client X"), "Should include the correct client");
        assertTrue(result.contains("Total: 1500.75 MAD"), "Should include the correct total with currency");
    }
}
