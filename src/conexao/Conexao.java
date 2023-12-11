package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/projetoSalao";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "power123";

    private static Connection conexao;

    public static Connection getConexao(){
        try {
            if(conexao == null){
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
                return conexao;
            }
            Class.forName("org.postgresql.Driver"); // Carrega o driver JDBC do PostgreSQL
            System.out.println("Conexão com o banco de dados estabelecida com sucesso.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
        return conexao;
    }
    
}
