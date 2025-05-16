package prjweb;

import org.junit.jupiter.api.Test;
import jakarta.servlet.http.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ClientServletTest {
    @Test
    public void testDoPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Simuler les paramètres
        when(request.getParameter("nom")).thenReturn("Ahmed");
        when(request.getParameter("email")).thenReturn("ahmed@example.com");
        when(request.getParameter("telephone")).thenReturn("0600123456");

        // Capture de la sortie
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Exécuter la méthode
        ClientServlet servlet = new ClientServlet();
        servlet.doPost(request, response);
        writer.flush();

        // Vérification
        String result = stringWriter.toString();
        assertTrue(result.contains("Client created:"));
        assertTrue(result.contains("Nom: Ahmed"));
        assertTrue(result.contains("Email: ahmed@example.com"));
        assertTrue(result.contains("Téléphone: 0600123456"));
    }
}
