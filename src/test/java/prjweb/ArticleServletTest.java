package prjweb;

import org.junit.jupiter.api.Test;
import jakarta.servlet.http.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ArticleServletTest {
    @Test
    public void testDoPost() throws Exception {
        // Mock request and response
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Mock parameters
        when(request.getParameter("id")).thenReturn("456");
        when(request.getParameter("ref")).thenReturn("ART-123");
        when(request.getParameter("libelle")).thenReturn("Article Test");
        when(request.getParameter("qte_stock")).thenReturn("100");

        // Capture the response output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Call servlet
        ArticleServlet servlet = new ArticleServlet();
        servlet.doPost(request, response);
        writer.flush(); // ensure everything is written

        // Assert output
        String result = stringWriter.toString();
        assertTrue(result.contains("Article created:"));
        assertTrue(result.contains("ID: 456"));
        assertTrue(result.contains("Reference: ART-123"));
        assertTrue(result.contains("Libelle: Article Test"));
        assertTrue(result.contains("Quantité en stock: 100"));
    }
}