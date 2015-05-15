package br.com.auth.security;

import br.com.infra.commons.entity.Usuario;

public class UserSession {

	private Usuario user;

	public SessionCookieData generateSessionCookieData(){
		return new SessionCookieData(user.getId(), user.getTenanty());
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
