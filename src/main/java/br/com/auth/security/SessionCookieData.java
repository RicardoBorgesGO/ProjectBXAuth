package br.com.auth.security;

import java.util.Date;

public class SessionCookieData {

	private Integer userId;

	private Date timeStamp;

	private String tenant;

	public SessionCookieData() {
		this(0);
	}

	public SessionCookieData(Integer userId) {
		super();
		this.userId = userId;
		this.timeStamp = new Date();
	}

	public SessionCookieData(Integer userId, String tenant) {
		super();
		this.userId = userId;
		this.timeStamp = new Date();
		this.tenant = tenant;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

}
