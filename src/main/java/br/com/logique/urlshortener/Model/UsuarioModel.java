package br.com.logique.urlshortener.Model;

public class UsuarioModel {
	private int id_usuario;
	private String login_user;
	private String password_user;
	
	
	public UsuarioModel(int id_usuario, String login_user, String senha_user) {
		super();
		this.id_usuario = id_usuario;
		this.login_user = login_user;
		this.password_user = senha_user;
	}
	
	public UsuarioModel() {
		
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getLogin_user() {
		return login_user;
	}

	public void setLogin_user(String login_user) {
		this.login_user = login_user;
	}

	public String getPassword_user() {
		return password_user;
	}

	public void setPassword_user(String senha_user) {
		this.password_user = senha_user;
	}
	
	
	
	

}
