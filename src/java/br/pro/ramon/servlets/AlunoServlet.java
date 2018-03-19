package br.pro.ramon.servlets;

import br.pro.ramon.modelos.Aluno;
import br.pro.ramon.modelos.NotaInvalidaException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aluno")
public class AlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // ENTRADA
            String nome = request.getParameter("nome");
            double p1 = Double.parseDouble(request.getParameter("p1"));
            double p2 = Double.parseDouble(request.getParameter("p2"));

            // PROCESSAMENTO
            Aluno aluno = new Aluno(nome, p1, p2);
            double media = aluno.getMedia();
            boolean aprovado = aluno.getAprovado();

            // SAÍDA
            out.printf(Locale.US, "{ \"media\": %.2f, \"aprovado\": %s }", media, aprovado);
            // O Locale.US serve para que a média venha com ponto (6.0) e não com vírgula (6,0), o que resultaria em um JSON inválido.
        } catch (NullPointerException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.printf("{ \"erro\": \"%s\" }", "Entre com todos os parâmetros.");
        } catch (NumberFormatException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.printf("{ \"erro\": \"%s\" }", "Entre com números para p1 e p2.");
        } catch (IllegalArgumentException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.printf("{ \"erro\": \"%s\" }", "O nome é obrigatório.");
        } catch (NotaInvalidaException ex) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.printf("{ \"erro\": \"%s\" }", "Entre com notas válidas para p1 e p2.");
        }
    }

}
