package br.com.auth.security;

import java.util.Date;


public class SessionCookieData {

	private Integer userId;

	private Date timeStamp;

	public SessionCookieData() {
		this(0);
	}

	public SessionCookieData(Integer userId) {
		super();
		this.userId = userId;
		this.timeStamp = new Date();
	}

	public Integer getUserId() {
		return userId;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
}
