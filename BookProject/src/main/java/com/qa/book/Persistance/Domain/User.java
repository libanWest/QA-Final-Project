package com.qa.book.Persistance.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long userId;
	
	
	@Column (nullable = false)
	private String firstName;
	@Column (nullable = false)
	private String lastName;
	@Column (unique = true, nullable = false)
	private String email;
	@Column (nullable = false)
	private String password;
	
	
	public User() {
		super();
	
	}


	public User(long userId, String firstName, String lastName, String email, String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


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
