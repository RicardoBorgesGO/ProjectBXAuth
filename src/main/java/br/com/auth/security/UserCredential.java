package br.com.auth.security;

public class UserCredential {

	private String userName;

	private String password;


	public UserCredential(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
