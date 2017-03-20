package br.com.appweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class CriaConexao {

	private static Connection conexao;
	private static final String URL_CONEXAO = "jdbc:mysql://localhost:3306/projetoweb";
	private static final String USUARIO = "root";
	private static final String SENHA = "1234";
	
	public static Connection getConexao() {
		if(conexao == null){
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Erro ao carregar o driver. " + e.getMessage());
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro a URL nao encontrada. "+ e.getMessage());
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
