package com.sgdevblog.security;

import com.sgdevblog.model.Site;
import com.sgdevblog.model.Usuario;

public class UserSession {

	private Usuario user;

	private Site site;

	public SessionCookieData generateSessionCookieData(){

		return new SessionCookieData(user.getId(), site.getId());
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}
