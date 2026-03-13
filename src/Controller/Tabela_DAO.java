package Controller;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabela_DAO {
    public static void exportarTabelaParaCSV(JTable tabela, String caminhoArquivo) {
    try (FileWriter csv = new FileWriter(caminhoArquivo)) {
        int colunas = tabela.getColumnCount();
        int linhas = tabela.getRowCount();

        // Cabeçalho
        for (int i = 0; i < colunas; i++) {
            csv.write(tabela.getColumnName(i));
            if (i < colunas - 1) csv.write(";");
        }
        csv.write("\n");

        // Dados
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Object valor = tabela.getValueAt(i, j);
                csv.write(valor != null ? valor.toString() : "");
                if (j < colunas - 1) csv.write(";");
            }
            csv.write("\n");
        }

        csv.flush();
        javax.swing.JOptionPane.showMessageDialog(null, "Tabela exportada com sucesso!");
    } catch (IOException e) {
        e.printStackTrace();
JOptionPane.showMessageDialog(null, "Erro ao exportar: " + e.getMessage());

    }
}
    
    public static DefaultTableModel visitante(ResultSet rs) {
        try {
            Vector<String> colunas = new Vector<>();
            colunas.add("Código");
            colunas.add("Nome");
            colunas.add("Documento");
            colunas.add("Empresa");
            colunas.add("Motivo");
            colunas.add("Colaborador");
            colunas.add("Data");
            colunas.add("Horário");
            colunas.add("Status");

            Vector<Vector<Object>> linhas = new Vector<>();
            while (rs.next()) {
                Vector<Object> novaLinha = new Vector<>();
                novaLinha.add(rs.getInt("codigo")); // ⚠️ Verifica o nome certo no banco
                novaLinha.add(rs.getString("nome"));
                novaLinha.add(rs.getString("documento"));
                novaLinha.add(rs.getString("empresa"));
                novaLinha.add(rs.getString("motivo"));
                novaLinha.add(rs.getString("colaborador"));
                novaLinha.add(rs.getDate("data_entrada"));
                novaLinha.add(rs.getTime("hora_entrada"));
                novaLinha.add(rs.getString("status"));
                linhas.add(novaLinha);
            }

            return new DefaultTableModel(linhas, colunas);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao montar tabela: " + e.getMessage());
            return null;
        }
    }
}