package br.com.appweb.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "login")
@SessionScoped
public class UsuarioController implements Serializable {
	
	private String usuario;
	private String senha;
	
	public String LoginController(String usuario, String senha){
		return "";
		
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
