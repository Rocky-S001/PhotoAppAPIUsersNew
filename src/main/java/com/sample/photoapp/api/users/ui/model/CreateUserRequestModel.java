package com.sample.photoapp.api.users.ui.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateUserRequestModel {

	@NotNull(message = "firstName cannot be null")
	@Size(min = 2, message = "FirstName cannot be less than 2 characters")
	private String firstName;

	@NotNull(message = "LastName cannot be null")
	@Size(min = 2, message = "LastName cannot be less than 2 characters")
	private String lastName;

	@NotNull(message = "email cannot be null")
	@Email
	private String email;

	@NotNull(message = "password cannot be null")
	@Size(min = 8, max = 16, message = "Password must be equal to or greater than 8 characters & less than 16 characters")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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
