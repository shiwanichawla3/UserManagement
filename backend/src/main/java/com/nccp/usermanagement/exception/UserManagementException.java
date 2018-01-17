package com.nccp.usermanagement.exception;

import javax.servlet.ServletException;

public class UserManagementException extends ServletException {

	private static final long serialVersionUID = 1355066735935657964L;

	public UserManagementException(String message) {
		super(message);
	}

}
