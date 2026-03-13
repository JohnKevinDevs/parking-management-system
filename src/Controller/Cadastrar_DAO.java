package Controller;

import Model.ConexaoBD;
import Model.Veiculo;
import Model.Visitante;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.edisoncor.gui.panel.PanelImage;

public class Cadastrar_DAO {

    public static boolean cadastrarVisitante(Visitante v) {
        String sql = "INSERT INTO visitantes (nome, documento, empresa, motivo, contato, colaborador, data_entrada, hora_entrada, status, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, v.getNome());
        stmt.setString(2, v.getDocumento());
        stmt.setString(3, v.getEmpresa());
        stmt.setString(4, v.getMotivo());
        stmt.setString(5, v.getContato());
        stmt.setString(6, v.getColaborador());
        stmt.setString(7, v.getDataEntrada());
        stmt.setString(8, v.getHoraEntrada());
        stmt.setString(9, v.getStatus());

        if (v.getFoto() != null && !v.getFoto().isEmpty())
            stmt.setString(10, v.getFoto());
        else
            stmt.setNull(10, java.sql.Types.VARCHAR);

        stmt.executeUpdate();
        return true;

    } catch (SQLException e) {
        System.out.println("Erro ao cadastrar visitante: " + e.getMessage());
        return false;
    }
    }

    // Método para gerar código automático (incremental)
    private static int gerarCodigo() {
        String sql = "SELECT MAX(codigo) AS max_codigo FROM visitantes";
        int codigo = 1; // começa em 1 se não houver ninguém

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                codigo = rs.getInt("max_codigo") + 1;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao gerar código: " + e.getMessage());
        }

        return codigo;
    }
    public static boolean cadastrarVeiculo(Veiculo v) {
        String sql = "INSERT INTO veiculos (codigo, nome, documento, contato, " +
                     "placa, modelo, marca, cor, tipo, categoria, data_entrada, hora_entrada, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Gera código automático
            int codigo = gerarCodigoVeiculo();
            v.setCodigo(codigo);

            // Data e hora automáticas
            LocalDate dataAtual = LocalDate.now();
            LocalTime horaAtual = LocalTime.now();
            String dataFormatada = dataAtual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String horaFormatada = horaAtual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            v.setDataEntrada(dataFormatada);
            v.setHoraEntrada(horaFormatada);
            v.setStatus("Estacionado");

            stmt.setInt(1, v.getCodigo());
            stmt.setString(2, v.getNome());
            stmt.setString(3, v.getDocumento());
            stmt.setString(4, v.getContato());
            stmt.setString(5, v.getPlaca());
            stmt.setString(6, v.getModelo());
            stmt.setString(7, v.getMarca());
            stmt.setString(8, v.getCor());
            stmt.setString(9, v.getTipo());
            stmt.setString(10, v.getCategoria());
            stmt.setString(11, v.getDataEntrada());
            stmt.setString(12, v.getHoraEntrada());
            stmt.setString(13, v.getStatus());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar veículo: " + e.getMessage());
            return false;
        }
    }

    private static int gerarCodigoVeiculo() {
        String sql = "SELECT MAX(codigo) AS max_codigo FROM veiculos";
        int codigo = 1;

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                codigo = rs.getInt("max_codigo") + 1;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao gerar código do veículo: " + e.getMessage());
        }

        return codigo;
    }
}