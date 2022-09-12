package com.qa.book.Persistance.Domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Book {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long bookId;
	
	@Column (nullable = false)
	private String title;
	
	private Date publishedDate;
	@Column (unique = true, nullable = false)
	private String isbn;
	private int pages;
	@Column (nullable = false)
	private int copies;
	
	

	public Book(long bookId, String title, Date publishedDate, String isbn, int pages, int copies) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publishedDate = publishedDate;
		this.isbn = isbn;
		this.pages = pages;
		this.copies = copies;
	}

		
	@ManyToMany	(cascade = CascadeType.ALL)
	@JoinTable( name = "Book_Authors", 
	joinColumns = {@JoinColumn(name = "Bookid")},
	inverseJoinColumns = {@JoinColumn(name = "Authorid")})

	private Set<Author> authors = new HashSet<>();



		
		
		
		
	
	
	
	
}
