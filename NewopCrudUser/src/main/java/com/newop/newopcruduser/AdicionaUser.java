package com.newop.newopcruduser;

import com.newop.newopcruduser.Dao.Generos;
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

// Diferença entre o método doGet e doPost
// Método doGet faz o envio dos dados pela URL, enquanto o método doPost envia pelo corpo da requisição, não poluindo a URL, sendo uma boa prática.

@WebServlet("/adicionaUser") // Mapeamento da URL para acessar este servlet
public class AdicionaUser extends HttpServlet {

    // Método Post
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Coletando parâmetros da requisição
        String name = request.getParameter("nome");
        String num = request.getParameter("telefone");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String apelido = request.getParameter("apelido");
        String senha = request.getParameter("senha");
        String niverdta = request.getParameter("niver");

        // Convertendo a data de aniversário para o formato LocalDate
        LocalDate dtaNiver = LocalDate.parse(niverdta, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // Convertendo a data de aniversário de LocalDate para Date e, em seguida, para java.sql.Date
        Date dataNiver = Date.from(dtaNiver.atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date dataNiverSQL = new java.sql.Date(dataNiver.getTime());

        // Printando os valores para saída (pode ser removido em produção)
        System.out.println(name);
        System.out.println(num);
        System.out.println(email);
        System.out.println(cpf);
        System.out.println(apelido);
        System.out.println(senha);
        System.out.println(niverdta);

        // Instanciando um objeto Users com os parâmetros coletados
        Users user = new Users(name, num, email, cpf, apelido, null, null, null, 1, 1, senha, dataNiverSQL);

        // Instanciando um objeto UsersDao para usar os métodos do JDBC
        UsersDao dao = new UsersDao();
        dao.inserir(user);

        // Respondendo ao usuário com uma mensagem HTML
        PrintWriter valorSaida = response.getWriter();
        valorSaida.println("<html><body>");
        valorSaida.println("<h1>Usuário adicionado com Sucesso!</h1>");
        valorSaida.println("</body></html>");
    }
}
