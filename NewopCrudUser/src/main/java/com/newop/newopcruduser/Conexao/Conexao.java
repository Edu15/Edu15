package com.newop.newopcruduser.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe de conexão usada para conectar ao banco de dados PostgreSQL
public class Conexao {
    private Conexao() {} // Construtor privado para implementar o padrão Singleton

    // Método para obter uma conexão com o banco de dados
    public static Connection conectar() {
        try {
            // Carrega o driver JDBC do PostgreSQL
            Class.forName("org.postgresql.Driver");

            // Retorna uma conexão com o banco de dados PostgreSQL
            return DriverManager.getConnection("jdbc:postgresql://dpg-cjp5f9j6fquc73evacn0-a.ohio-postgres.render.com:5432/newop_data_yzvn", "newop", "n10qRIXwKd4sSMcABf0UNrC33AR3A9ca");

        } catch (SQLException e) {
            // Captura exceções de SQL e lança uma RuntimeException com a exceção original
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            // Captura exceções de classe não encontrada e lança uma RuntimeException com a exceção original
            throw new RuntimeException(e);
        }
    }
}
