package prjweb;

import org.junit.jupiter.api.Test;
import jakarta.servlet.http.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class LigneLivraisonServletTest {
    @Test
    public void testDoPost() throws Exception {
        // Mock request and response
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        // Mock parameters
        when(request.getParameter("libelle")).thenReturn("1001");
        when(request.getParameter("qte")).thenReturn("5");
        when(request.getParameter("price")).thenReturn("19.99");
        
        // Capture the response output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        
        // Call servlet
        LigneLivraisonServlet servlet = new LigneLivraisonServlet();
        servlet.doPost(request, response);
        
        writer.flush(); // ensure everything is written
        
        // Assert output
        String result = stringWriter.toString();
        assertTrue(result.contains("LigneLivraison created:"));
        assertTrue(result.contains("Libelle: 1001"));
        assertTrue(result.contains("Quantity: 5"));
        assertTrue(result.contains("Price: 19.99"));
    }
}