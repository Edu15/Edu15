package com.newop.newopcruduser.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Classe conexão usado para conectar com o banco
public class Conexao {
    private Conexao(){}//Singleton
    public static Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/newop_data_yzvn","postgres", "1234");
            // troque esses dados e coloque o do seu
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
