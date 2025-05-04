package prjweb;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bnlivraison")
public class BnLivraisonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        String dateCreation = request.getParameter("datecreation");
        String client = request.getParameter("client");

        int id = Integer.parseInt(idParam); // basic parsing

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("BnLivraison created:");
        out.println("ID: " + id);
        out.println("Date Creation: " + dateCreation);
        out.println("Client: " + client);
    }

    // Optional GET for testing
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("Use POST to create a BnLivraison.");
    }
}
