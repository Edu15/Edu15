package com.newop.newopcruduser.Dao;

import com.newop.newopcruduser.Model.Users;

import java.util.List;

// Interface que contém os métodos CRUD a serem implementados na classe UsersDao
// DAO: Data Access Object (Objeto de Acesso a Dados)
public interface InterfaceUsersDao {
    // Método para inserir um usuário no banco de dados
    Users inserir(Users user);

    // Método para listar todos os usuários do banco de dados
    List<Users> listarTudo();

    // Método para buscar um usuário pelo apelido (nickname) no banco de dados
    Users listarPorId(String nickname);

    // Método para atualizar as informações de um usuário no banco de dados
    Users atualizar(Users user);

    // Método para deletar um usuário pelo apelido (nickname) no banco de dados
    void deletar(String nickname);
}
