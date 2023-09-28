package com.newop.newopcruduser.Model;

import com.newop.newopcruduser.Dao.Generos;

import java.time.LocalDate;

//Autores: Eduardo Toledo e Beatriz Belaparte
//Criando o model da tabela user, as variaveis privadas representam colunas
public class Users {
    private String name;
    private String telefone;
    private String email;
    private String cpf;
    private String nickname;//Pk da tabela, não tem metodo set
    private String profile_picture;
    private String descricao;

    private String banner;

    private LocalDate created_at;
    private LocalDate updated_at;
    private LocalDate deleted_at;
    private int int_is_creator; // Verifica se o usuario é um criador de conteúdo = 1 ou 0 se não é
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private UUID pk_users;
    private Generos gender;
    private String password;

    public Users(String name, String telefone, String email, String cpf, String nickname, String profile_picture, String descricao, String banner, int int_is_creator, String genero, String password) {
        this.name = name;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.nickname = nickname;
        this.profile_picture = profile_picture;
        this.descricao = descricao;
        this.banner = banner;
        this.int_is_creator = int_is_creator;
        this.gender = Generos.valueOf(genero);
        this.password = password;
    }

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

    public LocalDate getCreated_at() {
        return created_at;
    }



    public LocalDate getUpdated_at() {
        return updated_at;
    }


    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }

    public int getInt_is_creator() {
        return int_is_creator;
    }

    public void setInt_is_creator(int int_is_creator) {
        this.int_is_creator = int_is_creator;
    }

    public Generos getGender() {
        return gender;
    }

    public void setGender(Generos gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
