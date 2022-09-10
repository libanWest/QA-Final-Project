package com.qa.book.Persistance.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private long userId;
	private String firstName;
	private String lastName;
	
	
	public Users() {
		super();
	
	}


	public Users(long userId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
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


	public long getUserId() {
		return userId;
	}
	
	
	
	
	
}
