package com.qa.book.Persistance.Domain;

import lombok.AccessLevel;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@Entity

public class Book {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_Id")
	private long bookId;
	
	@Column (nullable = false)
	private String title;
	
	@Column (name = "published_date",nullable = false)
	private Date publishedDate;
	@Column (name = "ISBN_No",unique = true, nullable = false)
	private String isbnNumber;
	
	@Column (name = "Number_Of_Pages", nullable = false)
	private int numPages;
	@Column (name = "Available_Copies",nullable = false)
	private int availableCopies;
	
	

	public Book(long bookId, String title, Date publishedDate, String isbnNumber, int numPages, int availableCopies,
			Set<Author> authors) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publishedDate = publishedDate;
		this.isbnNumber = isbnNumber;
		this.numPages = numPages;
		this.availableCopies = availableCopies;
		this.authors = authors;
	}
		
	@ManyToMany	(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable( name = "Book_Authors", 
	joinColumns = {@JoinColumn(name = "Bookid", referencedColumnName = "book_Id")},
	inverseJoinColumns = {@JoinColumn(name = "Authorid", referencedColumnName = "author_Id")})
	
	@Setter(AccessLevel.NONE)
    private Set <Author> authors = new HashSet<>();

		

	public void setAuthors(Author author) {
			this.authors.add(author);
	}
	
	public void DeleteAuthor(Author author) {
		this.authors.remove(author);
	}

	








		
		
		
		
	
	
	
	
}
