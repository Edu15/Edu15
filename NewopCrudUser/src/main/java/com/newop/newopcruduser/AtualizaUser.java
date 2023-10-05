package com.newop.newopcruduser;

import com.newop.newopcruduser.Dao.UsersDao;
import com.newop.newopcruduser.Model.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/updateUser") // Mapeamento da URL para acessar este servlet
public class AtualizaUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletando parâmetros da requisição
        String apelido = request.getParameter("apelido");
        String name = request.getParameter("nome");
        String num = request.getParameter("telefone");

        // A data de aniversário não pode ser modificada, então não precisamos atualizá-la

        String senha = request.getParameter("senha");

        // Aqui você deve buscar o usuário existente no banco de dados com base no apelido original
        // e obter o CPF e o e-mail do usuário existente para manter esses valores inalterados
        UsersDao dao = new UsersDao();
        Users userExistente = dao.listarPorId(apelido);

        if (userExistente != null) {
            String cpf = userExistente.getCpf();
            String email = userExistente.getEmail();

            // Criando um objeto Users com os novos valores, mantendo CPF, e-mail e data de aniversário
            Users user = new Users(name, num, email, cpf, apelido, null, null, null, 1, 1, senha, userExistente.getDate_birthday());

            // Atualizando o usuário no banco de dados
            dao.atualizar(user);

            // Printando valores para a saída (pode ser removido em produção)
            System.out.println(apelido);

            // Resposta ao usuário
            PrintWriter valorSaida = response.getWriter();
            valorSaida.println("<html><body>");
            valorSaida.println("<h1>Usuário atualizado com sucesso!</h1>");
            valorSaida.println("</body></html>");
        } else {
            // Lidando com o caso em que o usuário com o apelido original não foi encontrado
            PrintWriter valorSaida = response.getWriter();
            valorSaida.println("<html><body>");
            valorSaida.println("<h1>Usuário não encontrado!</h1>");
            valorSaida.println("</body></html>");
        }
    }
}
