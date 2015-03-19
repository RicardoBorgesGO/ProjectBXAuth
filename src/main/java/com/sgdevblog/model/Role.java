package com.sgdevblog.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sgdevblog.enums.RoleEnum;

@Entity
@Table(name="ROLES")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SQ")
	@SequenceGenerator(allocationSize = 1, name = "ROLES_SQ", sequenceName = "ROLES_SEQ", initialValue = 1)
    private int id;

	@Enumerated(EnumType.STRING)
	@Column(name="NOME")
    private RoleEnum roleEnum;

    @ManyToMany
    @JoinTable (name = "USUARIO_ROLES",
    joinColumns = {@JoinColumn(name = "USER_ID")},
    inverseJoinColumns = {@JoinColumn(name = "ROLES_ID", referencedColumnName = "ID")})
    private List<Usuario> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleEnum getRoleEnum() {
		return roleEnum;
	}

	public void setRoleEnum(RoleEnum role) {
		this.roleEnum = role;
	}

}
