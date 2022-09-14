package com.qa.book.Persistance.Domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data

@NoArgsConstructor
@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_Id")
	private long authorId;
	
	@Column (name = "first_name",nullable = false)
	private String firstName;
	
	@Column (name = "last_name",nullable = false)
	private String lastName;
	
	@Column (name = "ORCID_No",unique = true, nullable = false)
	private long orcidNumber;
	
	@Column (nullable = false)
	private String nationality;
	


	public Author(long authorId, String firstName,String lastName, long orcidNumber, String nationality) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.orcidNumber = orcidNumber;
		this.nationality = nationality;
	}
	
	
	@JsonIgnore
	@ManyToMany	(mappedBy = "authors")	
	
	//@JsonBackReference
		private Set <Book> bookSet = new HashSet<>();





}
