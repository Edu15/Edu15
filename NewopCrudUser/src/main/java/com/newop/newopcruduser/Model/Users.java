package com.newop.newopcruduser.Model;

import com.newop.newopcruduser.Dao.Generos;

import java.sql.Date;

// Autores: Eduardo Toledo e Beatriz Belaparte
// Esta classe representa o modelo (entidade) da tabela 'tb_users' no banco de dados.
public class Users {
    private String name; // Nome do usuário
    private String telefone; // Número de telefone do usuário
    private String email; // Endereço de email do usuário
    private String cpf; // CPF do usuário
    private String nickname; // Apelido do usuário (chave primária da tabela, não tem método set)
    private String profile_picture; // URL da imagem de perfil do usuário
    private String descricao; // Descrição do perfil do usuário

    private String banner; // URL da imagem de banner do usuário

    private Date created_at; // Data de criação do usuário
    private Date updated_at; // Data de atualização do usuário
    private Date deleted_at; // Data de exclusão do usuário
    private int int_is_creator; // Indica se o usuário é um criador de conteúdo (1 para sim, 0 para não)
    private int gender; // Gênero do usuário (referência a outra tabela de gêneros)
    private String password; // Senha do usuário (não é recomendado armazenar em texto puro)
    private Date date_birthday; // Data de nascimento do usuário

    // Construtor para criar um objeto Users com todos os campos preenchidos
    public Users(String name, String telefone, String email, String cpf, String nickname, String profile_picture, String descricao, String banner, int int_is_creator, int genero, String password, Date date_birthday) {
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.nickname = nickname;
        this.profile_picture = profile_picture;
        this.descricao = descricao;
        this.banner = banner;
        this.int_is_creator = int_is_creator;
        this.gender = genero;
        this.password = password;
        this.date_birthday = date_birthday;
        this.created_at = new Date(System.currentTimeMillis()); // Define a data de criação como a data atual
        this.updated_at = new Date(System.currentTimeMillis()); // Define a data de atualização como a data atual
        this.deleted_at = null; // Inicialmente, não há data de exclusão
    }

    // Métodos getters e setters para acessar e modificar os campos da classe

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDate_birthday() {
        return date_birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public Date getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Date deleted_at) {
        this.deleted_at = deleted_at;
    }

    public int getInt_is_creator() {
        return int_is_creator;
    }

    public void setInt_is_creator(int int_is_creator) {
        this.int_is_creator = int_is_creator;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
