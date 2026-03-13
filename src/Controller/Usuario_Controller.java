package Controller;

import Model.Usuario;

public class Usuario_Controller {
    Usuario_DAO usuarioDAO = new Usuario_DAO();
    
    public boolean criarUsuario(String nome, String usuario, String senha, String tipo) {
        Usuario u = new Usuario(nome, usuario, senha, tipo);
        return usuarioDAO.inserir(u);
    }

    public String login(String usuario, String senha) {
    return usuarioDAO.autenticar(usuario, senha);
}
    
    public Usuario consultarUsuario(String usuario) {
    return usuarioDAO.buscarUsuario(usuario);
}
    
    public boolean atualizarUsuario(String nome, String usuario, String senha, String tipo) {
    Usuario u = new Usuario(nome, usuario, senha, tipo);
    return usuarioDAO.atualizarUsuario(u);
}
    public boolean excluirUsuario(String usuario) {
    return usuarioDAO.excluirUsuario(usuario);
}


}
