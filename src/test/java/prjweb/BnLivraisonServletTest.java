package prjweb;
import org.junit.jupiter.api.Test;
import jakarta.servlet.http.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class BnLivraisonServletTest {
    @Test
    public void testDoPost() throws Exception {
        // Mock request and response
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        // Mock parameters
        when(request.getParameter("id")).thenReturn("123");
        when(request.getParameter("datecreation")).thenReturn("2025-05-04");
        when(request.getParameter("client")).thenReturn("Client XYZ");
        // Capture the response output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        // Call servlet
        BnLivraisonServlet servlet = new BnLivraisonServlet();
        servlet.doPost(request, response);
        writer.flush(); // ensure everything is written
        // Assert output
        String result = stringWriter.toString();
        assertTrue(result.contains("BnLivraison created:"));
        assertTrue(result.contains("ID: 123"));
        assertTrue(result.contains("Date Creation: 2025-05-04"));
        assertTrue(result.contains("Client: Client XYZ"));
    }
}
