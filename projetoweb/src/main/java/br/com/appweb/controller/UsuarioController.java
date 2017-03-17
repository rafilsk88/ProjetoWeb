package br.com.appweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.JOptionPane;

import br.com.appweb.DAO.UsuarioDAO;
import br.com.appweb.model.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioController {

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void adicionar(){
		try {
			usuarios.add(usuario);
			new UsuarioDAO().salvar(usuario);
			usuario = new Usuario();		
			
		} catch (Exception e) {
			System.out.println( e.getMessage());
		}
	}

	
	
	// GETTERS and SETTERS
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
		
	
	
}
