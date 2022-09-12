package com.qa.book.Persistance.Domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long authorId;
	@Column (nullable = false)
	private String firstName;
	@Column (nullable = false)
	private String lastName;
	@Column (nullable = false)
	private String nationality;
	


	public Author(long authorId, String firstName, String lastName, String nationality) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
	}
	
	@JsonIgnore
	@ManyToMany	(cascade = CascadeType.ALL, mappedBy = "authorsSet")	

	private Set<Book> bookSet =  new HashSet<>();



}
