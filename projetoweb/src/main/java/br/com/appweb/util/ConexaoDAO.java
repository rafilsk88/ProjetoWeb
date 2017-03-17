package br.com.appweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

import br.com.appweb.controller.ErroSistema;
import br.com.appweb.model.Usuario;


public class ConexaoDAO {

	private static Connection conexao;
	private static final String URL_CONEXAO = "jdbc:nysql://localhost:3306/projetoweb";
	private static final String USUARIO = "root";
	private static final String SENHA = "1234";
	
	public static Connection getConexao() {
		if(conexao == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conexao = DriverManager.getConnection(null);
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "Erro a URL nao encontrada.");
			}
		}
		
		return conexao;
	}
	
	public static void fecharConexao() {
		if(conexao != null){
			try {
				conexao.close();
				conexao = null;
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "Erro ao encerrar a conexao com o Banco de Dados.");
			}
		}
		
	}
	
}
