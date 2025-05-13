package prjweb;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;

@WebServlet("/facture")
public class FactureServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String idParam = request.getParameter("id");
        String date = request.getParameter("date");
        String client = request.getParameter("client");
        String totalParam = request.getParameter("total");

        int id = Integer.parseInt(idParam);
        double total = Double.parseDouble(totalParam); // total as a decimal number

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Facture created:");
        out.println("ID: " + id);
        out.println("Date: " + date);
        out.println("Client: " + client);
        out.println("Total: " + total + " MAD");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getWriter().write("Use POST to create a Facture.");
    }
}
