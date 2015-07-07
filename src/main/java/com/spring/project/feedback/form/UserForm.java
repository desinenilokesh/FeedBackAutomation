package com.spring.project.feedback.form;

import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {
	@NotEmpty
private String Username;
	@NotEmpty
private String Password;

public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

}
