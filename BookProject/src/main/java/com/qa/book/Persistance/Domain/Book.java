package com.qa.book.Persistance.Domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Book {



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private long bookId;


private String title;

private String authors;
private Date publishedDate;
@Column (unique = true, nullable = false)
private String isbn;
private int pages;
private int copies;


// Super constructor
public Book() {
	super();
	
}


// Constructor

public Book(long bookId, String title, Date publishedDate, String authors, String isbn, int pages, int copies) {
	super();
	this.bookId = bookId;
	this.title = title;
	this.publishedDate = publishedDate;
	this.authors = authors;
	this.isbn = isbn;
	this.pages = pages;
	this.copies = copies;
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


public int getCopies() {
	return copies;
}


public void setCopies(int copies) {
	this.copies = copies;
}






	
	
	
	
	
	
	
	
	
	
	
}
