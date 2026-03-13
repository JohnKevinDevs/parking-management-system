package Controller;

import Model.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Excluir_DAO {
    public static boolean excluirVisitante(int codigo) {
    String sql = "DELETE FROM visitantes WHERE codigo = ?";
    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, codigo);
        int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0;

    } catch (SQLException e) {
        System.out.println("Erro ao excluir visitante: " + e.getMessage());
        return false;
    }
}

public static boolean excluirVeiculo(int codigo) {
    String sql = "DELETE FROM veiculos WHERE codvei = ?";
    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, codigo);
        int linhasAfetadas = stmt.executeUpdate();
        return linhasAfetadas > 0;

    } catch (SQLException e) {
        System.out.println("Erro ao excluir veículo: " + e.getMessage());
        return false;
    }
}

}
