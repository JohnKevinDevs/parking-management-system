package Controller;

import Model.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

public class Entrada_DAO {
    public static String[] buscarVisitante(String documento) {
        String sql = "SELECT nome, motivo FROM visitantes WHERE documento = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, documento);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new String[]{rs.getString("nome"), rs.getString("motivo")};
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar visitante: " + e.getMessage());
        }
        return null;
    }

    // 🔹 Buscar informações do veículo pela placa
    public static String[] buscarVeiculo(String placa) {
        String sql = "SELECT modelo, categoria FROM veiculos WHERE placa = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new String[]{rs.getString("modelo"), rs.getString("categoria")};
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar veículo: " + e.getMessage());
        }
        return null;
    }

    // 🔹 Registrar entrada
    public static boolean registrarEntrada(String documento, String nome, String motivo,
                                           String placa, String modelo, String categoria,
                                           String colaborador, String vaga, String plano) {
        String sql = "INSERT INTO entradas (documento, nome, motivo, placa, modelo, categoria, colaborador, vaga, plano, data_entrada, hora_entrada) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            LocalDate data = LocalDate.now();
            LocalTime hora = LocalTime.now();

            stmt.setString(1, documento);
            stmt.setString(2, nome);
            stmt.setString(3, motivo);
            stmt.setString(4, placa);
            stmt.setString(5, modelo);
            stmt.setString(6, categoria);
            stmt.setString(7, colaborador);
            stmt.setString(8, vaga);
            stmt.setString(9, plano);
            stmt.setDate(10, Date.valueOf(data));
            stmt.setTime(11, Time.valueOf(hora));

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar entrada: " + e.getMessage());
            return false;
        }
    }
}