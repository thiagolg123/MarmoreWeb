package br.com.marmoreweb.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.marmoreweb.abstracts.TestNull;

@Entity
@Table(name = "tb_user")
public class User implements Serializable{

	private static final long serialVersionUID = 4565543644165893481L;

	public User() {
	}

	public User(String login, String pass, Roles role){
		TestNull.test(login);
		TestNull.test(pass);
		TestNull.test(role);

		this.login = login;
		this.pass = pass;
		this.role = role;
	}

	@Id
	@GeneratedValue
	private long idUser;

	@Column(unique = true, nullable = false)
	private String login;

	@Column(nullable = false)
	private String pass;
	
	@Column(nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	private Roles role;

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
