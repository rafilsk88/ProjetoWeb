package br.com.appweb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectarDAO {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	public void conectar() {
		String servidor = "jdbc:nysql://localhost:3306/projetoweb";
		String usuario = "root";
		String senha = "1234";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario,
					senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	public void listarUsuarios(){
		try {
			String query = "SELECT * FROM login ORDE BY usuario";
			this.resultset = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			while(this.resultset.next()){
				System.out.println("ID:" + this.resultset.getString("id") 
						+ " - Usuario: " + this.resultset.getString("usuario")
						+ " - Senha: " + this.resultset.getString("senha"));
				}
			}catch(Exception e){
			System.out.println("ERRO : " + e.getMessage());
		}
	}

	public void inserirUsuario(String usuario, String senha) {
		try {
			String query = "INSERT INTO login (usuario, senha) VALUES ('"
					+ usuario + "', ''" + senha + "');";
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("ERRO : " + e.getMessage());
		}
	}

	public void editarUsuario(String id, String usuario, String senha) {
		try {
			String query = "UPDATE login SET usuario = " + usuario
					+ ", senha = " + senha + " WHERE id = " + id + ";";
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("ERRO : " + e.getMessage());
		}
	}

	public void apagarUsuario(String id) {
		try {
			String query = "DELET FROM login WHERE id = " + id + ";";
			this.statement.execute(query);
		} catch (Exception e) {
			System.out.println("ERRO : " + e.getMessage());
		}
	}
}
