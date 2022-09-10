package com.qa.book.Persistance.Domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Books {



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private long bookId;

private String title;

private int pages;

@Column (unique = true, nullable = false)
private String isbn;

private Date publishedDate;

private String authors;


// Super constructor
public Books() {
	super();
	
}


// Constructor
public Books(long id, String title, int pages, String isbn, Date publishedDate, String authors, long bookId) {
	super();
	this.bookId = bookId;
	this.title = title;
	this.pages = pages;
	this.isbn = isbn;
	this.publishedDate = publishedDate;
	this.authors = authors;
}


//Getters & Setters

public long getId() {
	return bookId;
}



public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public int getPages() {
	return pages;
}


public void setPages(int pages) {
	this.pages = pages;
}


public String getIsbn() {
	return isbn;
}


public void setIsbn(String isbn) {
	this.isbn = isbn;
}


public Date getPublishedDate() {
	return publishedDate;
}


public void setPublishedDate(Date publishedDate) {
	this.publishedDate = publishedDate;
}


public String getAuthors() {
	return authors;
}


public void setAuthors(String authors) {
	this.authors = authors;
}






	
	
	
	
	
	
	
	
	
	
	
}
