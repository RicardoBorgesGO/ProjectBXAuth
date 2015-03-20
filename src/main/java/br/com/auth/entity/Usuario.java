package br.com.auth.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.auth.constant.RoleEnum;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_SQ")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "USUARIO_SQ", sequenceName = "USUARIO_SEQ")
	private Integer id;

	@Column(name = "LOGIN")
	private String login;

	@JsonIgnore
	@Column(name = "SENHA")
	private String password;

	@JsonIgnore
	@Column(name = "password_salt")
	private String salt;

	@JsonIgnore
	@ManyToMany(mappedBy = "users")
	private List<Role> roles;

	@JsonIgnore
	@Transient
	public List<RoleEnum> getUserRoles() {
		List<RoleEnum> userRoles = new ArrayList<>();
		if (roles != null) {
			for (Role userRole : roles) {
				userRoles.add(userRole.getRoleEnum());
			}
		}
		return userRoles;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
