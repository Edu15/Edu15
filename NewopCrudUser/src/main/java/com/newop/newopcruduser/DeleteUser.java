package com.newop.newopcruduser;

import com.newop.newopcruduser.Dao.UsersDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteUser") // Mapeamento da URL para acessar este servlet
public class DeleteUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletando o parâmetro "nick" da requisição, que representa o apelido do usuário a ser deletado
        String nick = request.getParameter("nick");

        // Criando uma instância do UsersDao para executar a operação de exclusão
        UsersDao dao = new UsersDao();

        // Deletando o usuário com o apelido especificado
        dao.deletar(nick);

        // Resposta ao usuário
        PrintWriter valorSaida = response.getWriter();
        valorSaida.println("<html><body>");
        valorSaida.println("<h1>Usuário deletado com sucesso!</h1>");
        valorSaida.println("</body></html>");
    }
}
