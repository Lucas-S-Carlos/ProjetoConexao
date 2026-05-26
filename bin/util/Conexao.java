package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://localhost:3306/cadastro_java";

    private static final String USUARIO = "root";

    private static final String SENHA = "";

    public static Connection conectar() {

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(
                    URL,
                    USUARIO,
                    SENHA
            );

            System.out.println("Conexão realizada com sucesso!");

        } catch (SQLException e) {

            System.out.println(
                    "Erro ao conectar: " + e.getMessage()
            );
        }

        return conn;
    }
}
