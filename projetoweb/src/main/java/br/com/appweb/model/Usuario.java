package br.com.appweb.model;

public class Usuario {
	
	private int id;
	private String nome;
	private String senha;
	
	
	
	// Generet and Getters & Setters
	
	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
