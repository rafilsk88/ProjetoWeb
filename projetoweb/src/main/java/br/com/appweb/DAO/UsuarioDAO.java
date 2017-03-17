package br.com.appweb.DAO;

import java.sql.Connection;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.com.appweb.model.Usuario;
import br.com.appweb.util.CriaConexao;

public class UsuarioDAO {

	public void salvar (Usuario usuario){
		
		try {
			Connection conexao = CriaConexao.getConexao(); 
			PreparedStatement ps = (PreparedStatement) conexao.prepareCall("INSERT INTO `login` ('usuario', 'senha') VALUES (?,?) ");
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getSenha());
			ps.execute();
			CriaConexao.fecharConexao();
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Erro ao gravar usuario");
		}
	}
}
