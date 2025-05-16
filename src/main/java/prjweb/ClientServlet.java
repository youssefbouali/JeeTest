package prjweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Client created:");
        out.println("Nom: " + nom);
        out.println("Email: " + email);
        out.println("Téléphone: " + telephone);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("Use POST to create a Client.");
    }
}
