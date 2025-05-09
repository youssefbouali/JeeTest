package prjweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lignelivraison")
public class LigneLivraisonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String libelleParam = request.getParameter("libelle");
        String qteParam = request.getParameter("qte");
        String priceParam = request.getParameter("price");

        int libelle = Integer.parseInt(libelleParam);
        int qte = Integer.parseInt(qteParam);
        float price = Float.parseFloat(priceParam);

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("LigneLivraison created:");
        out.println("Libelle: " + libelle);
        out.println("Quantity: " + qte);
        out.println("Price: " + price);
    }

    // Optional GET for testing
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("Use POST to create a LigneLivraison.");
    }
}