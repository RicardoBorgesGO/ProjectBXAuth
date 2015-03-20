package br.com.auth.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.auth.constant.RoleEnum;

public class UserAuthentication implements Authentication {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2828124704728695144L;
	
	private UserSession session;

	public UserAuthentication(UserSession session) {
		super();
		this.session = session;
	}

	@Override
	public String getName() {
		return session.getUser().getLogin();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<RoleEnum> userRoles = session.getUser().getUserRoles();
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		for (RoleEnum roleEnum : userRoles){
			authorities.add(new SimpleGrantedAuthority("ROLE_"+roleEnum.name()));
		}
		return authorities;
	}

	@Override
	public Object getCredentials() {
		throw new UnsupportedOperationException("Do not expose user credential here");
	}

	@Override
	public Object getDetails() {
		return session;
	}

	@Override
	public Object getPrincipal() {
		if (session==null || session.getUser()==null){
			return null;
		}

		return session.getUser().getLogin();
	}

	@Override
	public boolean isAuthenticated() {
		return session!=null && session.getUser()!=null;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated)
			throws IllegalArgumentException {
		throw new UnsupportedOperationException("hardcoded to true");
	}

}
