package Model;

import Model.ConexaoBD;
import java.sql.Connection;

public class TestarConexao {
    public static void main(String[] args) {
        Connection conn = ConexaoBD.conectar();
        if (conn != null) {
            System.out.println("✅ Conectado com sucesso!");
        } else {
            System.out.println("❌ Falha na conexão!");
        }
    }
}
