package Controller;

import Model.ConexaoBD;
import Model.Veiculo;
import Model.Visitante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultar_DAO {
    // Consulta visitante pelo documento
public static Visitante consultarVisitante(String documento) {
    String sql = "SELECT * FROM visitantes WHERE documento = ?";
    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, documento);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Visitante v = new Visitante();
            v.setCodigo(rs.getInt("codigo"));
            v.setNome(rs.getString("nome"));
            v.setDocumento(rs.getString("documento"));
            v.setEmpresa(rs.getString("empresa"));
            v.setMotivo(rs.getString("motivo"));
            v.setContato(rs.getString("contato"));
            v.setColaborador(rs.getString("colaborador"));
            v.setDataEntrada(rs.getString("data_entrada"));
            v.setHoraEntrada(rs.getString("hora_entrada"));
            v.setStatus(rs.getString("status"));
            v.setFoto(rs.getString("foto")); // ✅ Caminho da imagem
            return v;
        }

    } catch (SQLException e) {
        System.out.println("Erro ao consultar visitante: " + e.getMessage());
    }
    return null;
}


// Atualiza visitante
public static boolean atualizarVisitante(Visitante v) {
    String sql = "UPDATE visitantes SET nome=?, empresa=?, motivo=?, contato=?, colaborador=?, status=?, foto=? WHERE documento=?";

    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, v.getNome());
        stmt.setString(2, v.getEmpresa());
        stmt.setString(3, v.getMotivo());
        stmt.setString(4, v.getContato());
        stmt.setString(5, v.getColaborador());
        stmt.setString(6, v.getStatus());

        if (v.getFoto() != null && !v.getFoto().isEmpty())
            stmt.setString(7, v.getFoto());
        else
            stmt.setNull(7, java.sql.Types.VARCHAR);

        stmt.setString(8, v.getDocumento());

        int linhas = stmt.executeUpdate();
        return linhas > 0;

    } catch (SQLException e) {
        System.out.println("Erro ao atualizar visitante: " + e.getMessage());
        return false;
    }
}


// Consulta veículo pelo número da placa
public static Veiculo consultarVeiculo(String placa) {
    String sql = "SELECT * FROM veiculos WHERE placa = ?";
    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, placa);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Veiculo v = new Veiculo();
            v.setCodigo(rs.getInt("codvei"));
            v.setNome(rs.getString("nome"));
            v.setDocumento(rs.getString("documento"));
            v.setContato(rs.getString("contato"));
            v.setPlaca(rs.getString("placa"));
            v.setModelo(rs.getString("modelo"));
            v.setMarca(rs.getString("marca"));
            v.setCor(rs.getString("cor"));
            v.setTipo(rs.getString("tipo"));
            v.setCategoria(rs.getString("categoria"));
            v.setDataEntrada(rs.getString("data_entrada"));
            v.setHoraEntrada(rs.getString("hora_entrada"));
            v.setStatus(rs.getString("status"));
            return v;
        }

    } catch (SQLException e) {
        System.out.println("Erro ao consultar veículo: " + e.getMessage());
    }
    return null;
}

// Atualiza veículo
public static boolean atualizarVeiculo(Veiculo v) {
    String sql = "UPDATE veiculos SET nome=?, documento=?, contato=?, modelo=?, marca=?, cor=?, tipo=?, categoria=?, status=? WHERE placa=?";
    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, v.getNome());
        stmt.setString(2, v.getDocumento());
        stmt.setString(3, v.getContato());
        stmt.setString(4, v.getModelo());
        stmt.setString(5, v.getMarca());
        stmt.setString(6, v.getCor());
        stmt.setString(7, v.getTipo());
        stmt.setString(8, v.getCategoria());
        stmt.setString(9, v.getStatus());
        stmt.setString(10, v.getPlaca());

        stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Erro ao atualizar veículo: " + e.getMessage());
        return false;
    }
}


}
