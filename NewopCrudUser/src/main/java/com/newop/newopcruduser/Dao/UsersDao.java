package com.newop.newopcruduser.Dao;

import com.newop.newopcruduser.Conexao.Conexao;
import com.newop.newopcruduser.Model.Users;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersDao implements InterfaceUsersDao{
    @Override
    public Users inserir(Users user) {
        try (Connection conexao = Conexao.conectar()) {

            String sql = ("INSERT INTO tb_users (str_name, str_telephone, str_email, str_cpf, pk_str_nickname, str_profile_picture, str_description, str_banner_image, int_is_creator, fk_str_genders, str_password, date_birthday_day) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getTelefone());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCpf());
            preparedStatement.setString(5, user.getNickname());
            preparedStatement.setString(6, user.getProfile_picture());
            preparedStatement.setString(7, user.getDescricao());
            preparedStatement.setString(8, user.getBanner());
            preparedStatement.setInt(9, user.getInt_is_creator());
            preparedStatement.setString(10, String.valueOf(user.getGender()));
            preparedStatement.setString(11, user.getPassword());
            preparedStatement.setString(12, String.valueOf(user.getDate_birthday()));


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    @Override
    public List<Users> listarTudo() {
        String sql = "SELECT str_name, str_telephone, str_email, str_cpf, pk_str_nickname, str_profile_picture, str_description, str_banner_image, date_created_at, date_updated_at,  int_is_creator, date_deleted_at, fk_str_genders, str_password, date_birthday_day FROM tb_users";
        List<Users> users = new ArrayList<>();
        try(Connection conexao = Conexao.conectar()){
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();//Usamos execute query pois fazemos apenas uma consulta
            while(rs.next()){
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
                String gender = rs.getString(13);
                String password = rs.getString(14);
                LocalDate date_birthday = LocalDate.parse(rs.getString(15));//Transformando data de aniversario para local date pois o método construtor de user pede local date


                Users user = new Users(name, telephone, email, cpf, nickname, profile_picture, description, banner,ehCriador, gender,password, date_birthday );
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public Optional<Users> listarPorId(String nickName) {
        String sql = "SELECT str_name, str_telephone, str_email, str_cpf, pk_str_nickname, str_profile_picture, str_description, str_banner_image, date_created_at, date_updated_at,  int_is_creator, date_deleted_at, fk_str_genders, str_password, date_birthday_day FROM tb_users WHERE  pk_str_nickname = ?";
        Users user = null;//Declarando o Objeto Users como nulo
        try(Connection conexao = Conexao.conectar()){//try usado para conectar e desconectar do banco de dados
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, nickName);//setando valor que será usado como parâmetro na consulta sql

            ResultSet rs = preparedStatement.executeQuery();//Usamos execute query pois fazemos apenas uma consulta
            while(rs.next()){

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
                String gender = rs.getString(13);
                String password = rs.getString(14);
                LocalDate date_birthday = LocalDate.parse(rs.getString(15));//Transformando data de aniversario para local date pois o método construtor de user pede local date


                user = new Users(name, telephone, email, cpf, nickname, profile_picture, description, banner,ehCriador, gender,password, date_birthday );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Users atualizar(Users user) {
        try(Connection conexao = Conexao.conectar()){

            String sql = "UPDATE tb_users SET str_name = ?, str_telephone = ?, str_email = ? , str_cpf = ?, pk_str_nickname = ?, str_profile_picture = ?, str_description = ?, str_banner_image = ?, date_created_at = ?, date_updated_at = ?,  int_is_creator = ?, date_deleted_at = ?, fk_str_genders = ?, str_password = ?, date_birthday_day = ? WHERE pk_str_nickname = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getTelefone());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getCpf());
            preparedStatement.setString(5, user.getNickname());
            preparedStatement.setString(6, user.getProfile_picture());
            preparedStatement.setString(7, user.getDescricao());
            preparedStatement.setString(8, user.getBanner());
            preparedStatement.setInt(9, user.getInt_is_creator());
            preparedStatement.setString(10, String.valueOf(user.getGender()));
            preparedStatement.setString(11, user.getPassword());
            preparedStatement.setString(12, user.getDate_birthday());
            preparedStatement.executeUpdate();
            return user;


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

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
