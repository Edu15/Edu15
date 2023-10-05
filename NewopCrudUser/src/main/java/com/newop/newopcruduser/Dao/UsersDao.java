package com.newop.newopcruduser.Dao;

import com.newop.newopcruduser.Conexao.Conexao;
import com.newop.newopcruduser.Model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe responsável pelas operações de acesso a dados (CRUD) para a entidade Users
public class UsersDao implements InterfaceUsersDao {

    // Método para inserir um novo usuário no banco de dados
    @Override
    public Users inserir(Users user) {
        try (Connection conexao = Conexao.conectar()) {
            // Define a query SQL para a inserção dos dados do usuário
            String sql = "INSERT INTO tb_users (str_name, str_telephone, str_email, str_cpf, pk_str_nickname, str_profile_picture, str_description, str_banner_image, date_created_at, date_updated_at, int_is_creator, date_deleted_at, fk_int_genders, date_birth_day) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            // Define os parâmetros da query com os dados do usuário
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getTelefone());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCpf());
            preparedStatement.setString(5, user.getNickname());
            preparedStatement.setString(6, user.getProfile_picture());
            preparedStatement.setString(7, user.getDescricao());
            preparedStatement.setString(8, user.getBanner());
            preparedStatement.setDate(9,  user.getCreated_at());
            preparedStatement.setDate(10, user.getUpdated_at());
            preparedStatement.setInt(11, user.getInt_is_creator());
            preparedStatement.setDate(12,  user.getDeleted_at());
            preparedStatement.setInt(13, user.getGender());
            preparedStatement.setDate(14, user.getDate_birthday());

            // Executa a inserção no banco de dados
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    // Método para listar todos os usuários do banco de dados
    @Override
    public List<Users> listarTudo() {
        String sql = "SELECT str_name, str_telephone, str_email, str_cpf, pk_str_nickname, str_profile_picture, str_description, str_banner_image, date_created_at, date_updated_at,  int_is_creator, date_deleted_at, fk_int_genders, date_birth_day FROM tb_users";
        List<Users> users = new ArrayList<>();
        try(Connection conexao = Conexao.conectar()){
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery(); // Executa a consulta SQL
            while(rs.next()){
                // Obtém os dados do usuário a partir do ResultSet
                String name = rs.getString(1);
                String telephone = rs.getString(2);
                String email = rs.getString(3);
                String cpf = rs.getString(4);
                String nickname = rs.getString(5);
                String profile_picture = rs.getString(6);
                String description = rs.getString(7);
                String banner = rs.getString(8);
                Date created_at = rs.getDate(9);
                Date updated_at = rs.getDate(10);
                int ehCriador = rs.getInt(11);
                Date deleted_at = rs.getDate(12);
                int gender = rs.getInt(13);
                Date date_birthday = rs.getDate(14);

                // Cria um objeto Users com os dados obtidos e adiciona à lista
                Users user = new Users(name, telephone, email, cpf, nickname, profile_picture, description, banner,ehCriador, gender,null, date_birthday );
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    // Método para buscar um usuário pelo apelido (nickname) no banco de dados
    @Override
    public Users listarPorId(String nickname) {
        String sql = "SELECT str_name, str_telephone, str_email, str_cpf, pk_str_nickname, str_profile_picture, str_description, str_banner_image, date_created_at, date_updated_at,  int_is_creator, date_deleted_at, fk_int_genders, date_birth_day FROM tb_users WHERE  pk_str_nickname = ?";
        Users user = null;
        try(Connection conexao = Conexao.conectar()){
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nickname); // Define o apelido como parâmetro na consulta SQL

            ResultSet rs = preparedStatement.executeQuery(); // Executa a consulta SQL
            while(rs.next()){
                // Obtém os dados do usuário a partir do ResultSet
                String name = rs.getString(1);
                String telephone = rs.getString(2);
                String email = rs.getString(3);
                String cpf2 = rs.getString(4);
                String nickName = rs.getString(5);
                String profile_picture = rs.getString(6);
                String description = rs.getString(7);
                String banner = rs.getString(8);
                Date created_at = rs.getDate(9);
                Date updated_at = rs.getDate(10);
                int ehCriador = rs.getInt(11);
                Date deleted_at = rs.getDate(12);
                int gender = rs.getInt(13);
                Date date_birthday = rs.getDate(14);

                // Cria um objeto Users com os dados obtidos
                user = new Users(name, telephone, email, cpf2, nickName, profile_picture, description, banner,ehCriador, gender,null, date_birthday );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    // Método para atualizar as informações de um usuário no banco de dados
    @Override
    public Users atualizar(Users user) {
        if (user == null) {
            throw new IllegalArgumentException("O objeto Users não pode ser nulo.");
        }

        String sql = "UPDATE tb_users SET str_name = ?, str_telephone = ?, str_email = ?, str_cpf = ?, pk_str_nickname = ?, str_profile_picture = ?, str_description = ?, str_banner_image = ?, date_created_at = ?, date_updated_at = ?, int_is_creator = ?, date_deleted_at = ?, fk_int_genders = ?, date_birth_day = ? WHERE pk_str_nickname = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement preparedStatement = conexao.prepareStatement(sql)) {

            // Define os parâmetros da query com os dados do usuário
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getTelefone());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCpf());
            preparedStatement.setString(5, user.getNickname());
            preparedStatement.setString(6, user.getProfile_picture());
            preparedStatement.setString(7, user.getDescricao());
            preparedStatement.setString(8, user.getBanner());
            preparedStatement.setDate(9, user.getCreated_at());
            preparedStatement.setDate(10, user.getUpdated_at());
            preparedStatement.setInt(11, user.getInt_is_creator());
            preparedStatement.setDate(12, user.getDeleted_at());
            preparedStatement.setInt(13, user.getGender());
            preparedStatement.setDate(14, user.getDate_birthday());
            preparedStatement.setString(15, user.getNickname());

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated == 0) {
                throw new RuntimeException("Nenhum usuário foi atualizado. Apelido não encontrado.");
            }

            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o usuário.", e);
        }
    }

    // Método para deletar um usuário pelo apelido (nickname) no banco de dados
    @Override
    public void deletar(String nickname) {
        try(Connection conexao = Conexao.conectar()){

            String sql = "DELETE FROM tb_users WHERE pk_str_nickname = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nickname);
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
