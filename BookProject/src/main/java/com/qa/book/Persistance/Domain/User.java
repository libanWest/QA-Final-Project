package com.qa.book.Persistance.Domain;

import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column (name = "user_Id")
	private long userId;
		
	@Column (name = "first_name",nullable = false)
	private String firstName;
	@Column (name = "last_name",nullable = false)
	private String lastName;
	@Column (name = "email",unique = true, nullable = false)
	private String email;
	@Column (name = "password",nullable = false)
	private String password;
		
	
	public User(long userId, String firstName, String lastName, String email, String password, Set<Book> books) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.books = books;
	}
	
    @ManyToMany (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	 @JoinTable( name = "Book_On_Loan", 
		joinColumns = {@JoinColumn(name = "userId", referencedColumnName = "user_Id")},
		inverseJoinColumns = {@JoinColumn(name = "bookId", referencedColumnName = "book_Id")})
  	
	@Setter(AccessLevel.NONE)
    private Set <Book> books = new HashSet<>();
	
	public void BorrowBook(Book book) {
		this.books.add(book);
	}
	public void ReturnBook(Book book) {
		this.books.remove(book);
	}

	
}
