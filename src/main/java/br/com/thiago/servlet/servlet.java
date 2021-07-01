package br.com.thiago.servlet;

import br.com.thiago.view.Palindromo;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Palindromo", urlPatterns = "/palindromo")
public class servlet extends HttpServlet {

    @Inject
    private Palindromo palindromo;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String name = "";
        if (null == (name = request.getParameter("name"))) {
            informarErro(response);
        } else {

            String result = String.format("<p>%s</p>", palindromo.palavraContrario(name));
            PrintWriter out = response.getWriter();
            out.println(result);
        }
    }

    private void informarErro(HttpServletResponse response) throws IOException {
        String result = "<p>A palavra não foi informada</p>";
        PrintWriter out = response.getWriter();
        out.println(result);
    }
}
