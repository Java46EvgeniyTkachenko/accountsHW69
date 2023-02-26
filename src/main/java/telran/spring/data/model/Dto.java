package telran.spring.data.model;

import java.time.LocalDateTime;

public class Dto {
	public String userName;
	public String password;
	public LocalDateTime experation;
	public String roles[];
	
	public Dto(String userName, String password, LocalDateTime experation, String[] roles) {		
		this.userName = userName;
		this.password = password;
		this.experation = experation;
		this.roles = roles;
	}
	
	public Dto() {
		
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getExperation() {
		return experation;
	}

	public void setExperation(LocalDateTime experation) {
		this.experation = experation;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}


	
	

}
