package br.pro.ramon.servlets;

import br.pro.ramon.modelos.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/aluno-servlet")
public class AlunoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ENTRADA
        String nome = request.getParameter("nome");
        double p1 = Double.parseDouble(request.getParameter("p1"));
        double p2 = Double.parseDouble(request.getParameter("p2"));

        // PROCESSAMENTO
        Aluno aluno = new Aluno(nome, p1, p2);
        double media = aluno.getMedia();
        boolean aprovado = aluno.getAprovado();

        // SAÍDA
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.println("{ \"media\": " + media + ", \"aprovado\": " + aprovado + " }");
    }

}
