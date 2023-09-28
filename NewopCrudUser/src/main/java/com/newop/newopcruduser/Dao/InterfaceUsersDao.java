package com.newop.newopcruduser.Dao;

import com.newop.newopcruduser.Model.Users;

import java.util.List;
import java.util.Optional;

//interface que contém os métodos crud para serem implementado na classe UsersDao
//DAO:DATA ACESS OBJECT
public interface InterfaceUsersDao {
    Users inserir(Users user);
    List<Users> listarTudo();
    Optional<Users> listarPorId(String nickname);
    Users atualizar(Users user);
    void deletar(String nickname);
}
