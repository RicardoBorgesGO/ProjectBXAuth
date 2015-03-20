package br.com.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SITES")
public class Site {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SITE_SQ")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "SITE_SQ", sequenceName = "SITE_SEQ")
	private int id;

	@Column(name="NOME")
	private String name;

	@Column(name="CODIGO_SITE")
	private String siteCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
}
