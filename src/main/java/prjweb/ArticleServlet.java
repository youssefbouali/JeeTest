package prjweb;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");
        String ref = request.getParameter("ref");
        String libelle = request.getParameter("libelle");
        String qteStockParam = request.getParameter("qte_stock");

        int id = Integer.parseInt(idParam); // basic parsing
        int qteStock = Integer.parseInt(qteStockParam); // basic parsing

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Article created:");
        out.println("ID: " + id);
        out.println("Reference: " + ref);
        out.println("Libelle: " + libelle);
        out.println("Quantité en stock: " + qteStock);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getWriter().write("Use POST to create an Article.");
    }
}