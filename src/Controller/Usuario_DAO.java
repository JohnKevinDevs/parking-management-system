package Controller;

import Model.ConexaoBD;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario_DAO {
    public boolean inserir(Usuario u) {
        String sql = "INSERT INTO usuarios (nome, usuario, senha, tipo) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getUsuario());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTipo());
            
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Erro ao inserir usuário: " + e.getMessage());
            return false;
        }
    }

    public static String autenticar(String usuario, String senha) {
    String sql = "SELECT tipo FROM usuarios WHERE usuario = ? AND senha = ?";

    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, usuario);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getString("tipo"); // retorna o tipo do usuário
        }

    } catch (SQLException e) {
        System.out.println("Erro ao autenticar: " + e.getMessage());
    }

    return null; // se não encontrar
}
    public Usuario buscarUsuario(String usuario) {
    String sql = "SELECT * FROM usuarios WHERE usuario = ?";
    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, usuario);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setUsuario(rs.getString("usuario"));
            u.setSenha(rs.getString("senha"));
            u.setTipo(rs.getString("tipo"));
            return u;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao buscar usuário: " + e.getMessage());
    }
    return null;
}
    
    public boolean atualizarUsuario(Usuario u) {
    String sql = "UPDATE usuarios SET nome = ?, senha = ?, tipo = ? WHERE usuario = ?";
    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getSenha());
        stmt.setString(3, u.getTipo());
        stmt.setString(4, u.getUsuario());
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar: " + e.getMessage());
        return false;
    }
}
    
    public boolean excluirUsuario(String usuario) {
    String sql = "DELETE FROM usuarios WHERE usuario = ?";
    try (Connection conn = ConexaoBD.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, usuario);
        stmt.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Erro ao excluir usuário: " + e.getMessage());
        return false;
    }
}
}
