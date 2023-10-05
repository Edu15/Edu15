<%@ page import="com.newop.newopcruduser.Dao.UsersDao" %>
<%@ page import="com.newop.newopcruduser.Conexao.Conexao" %>
<%@ page import="com.newop.newopcruduser.Model.Users" %>
<%@ page import="java.util.List" %>

<%--
  User: eduardotoledo-ieg
  Date: 04/10/2023
  Time: 18:08
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html lang="pt-br"></html>
<head>
    <title>Dados</title>
    <style>
        th {
            background-color: hwb(235 26% 53%);
            padding: 2px 15px;
            color: white;
        }

        tr {
            background-color: #f0f0f0;
            text-align: center;
            color: #000;
        }

        table {
            border-collapse: collapse; /* Combinação de bordas de célula */
        }

        table, th, td {
            border: 1px solid black; /* Borda sólida de 1 pixel de largura e cor preta */
            font-size: 13px;
        }
    </style>
</head>
<body>
<table>
    <th>Nome</th>
    <th>Telefone</th>
    <th>Email</th>
    <th>Cpf</th>
    <th>Nickname</th>
    <th>Profile Picture</th>
    <th>Descrição</th>
    <th>Banner</th>
    <th>Data criação</th>
    <th>Data atualização</th>
    <th>É criador</th>
    <th>Data deleted</th>
    <th>Data aniversário</th>
    <th>Gênero</th>
    <%
        UsersDao usersDao = new UsersDao();
        List<Users> users = usersDao.listarTudo(); // Obtém a lista de usuários do banco de dados
        for (Users user : users) {
    %>

    <tr>
        <td><%= user.getName() %></td>
        <td><%= user.getTelefone() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getCpf() %></td>
        <td><%= user.getNickname() %></td>
        <td><%= user.getProfile_picture() %></td>
        <td><%= user.getDescricao() %></td>
        <td><%= user.getBanner() %></td>
        <td><%= user.getCreated_at() %></td>
        <td><%= user.getUpdated_at() %></td>
        <td><%= user.getInt_is_creator() %></td>
        <td><%= user.getDeleted_at() %></td>
        <td><%= user.getDate_birthday() %></td>
        <td><%= user.getGender() %></td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
