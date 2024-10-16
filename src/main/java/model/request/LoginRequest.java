package model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	private String username;
	private String password;
	
	public LoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean isValid() {
		return username.equals("admin") && password.equals("admin");
	}
}
