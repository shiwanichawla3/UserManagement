package com.nccp.usermanagement.form;

import java.io.Serializable;

public class LoginForm  implements Serializable{
	private static final long serialVersionUID = -4959525990468100348L;
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
