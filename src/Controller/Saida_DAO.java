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

public class Saida_DAO {
    public static String[] buscarVeiculo(String placa) {
        String sql = "SELECT modelo, cor, colaborador FROM veiculos WHERE placa = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, placa);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new String[]{
                    rs.getString("modelo"),
                    rs.getString("cor"),
                    rs.getString("colaborador")
                };
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar veículo: " + e.getMessage());
        }
        return null;
    }

    // 🔹 Registrar saída
    public static boolean registrarSaida(String placa, String modelo, String cor, String colaborador) {
        String sql = "INSERT INTO saidas (placa, modelo, cor, colaborador, data_saida, hora_saida) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            LocalDate dataSaida = LocalDate.now();
            LocalTime horaSaida = LocalTime.now().withNano(0);

            stmt.setString(1, placa);
            stmt.setString(2, modelo);
            stmt.setString(3, cor);
            stmt.setString(4, colaborador);
            stmt.setDate(5, Date.valueOf(dataSaida));
            stmt.setTime(6, Time.valueOf(horaSaida));

            stmt.executeUpdate();

            // Opcional: atualizar status do veículo
            atualizarStatusVeiculo(placa, "Saiu");

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar saída: " + e.getMessage());
            return false;
        }
    }

    // 🔹 Atualiza status do veículo na tabela principal (opcional)
    private static void atualizarStatusVeiculo(String placa, String novoStatus) {
        String sql = "UPDATE veiculos SET status = ? WHERE placa = ?";
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setString(2, placa);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar status do veículo: " + e.getMessage());
        }
    }
}