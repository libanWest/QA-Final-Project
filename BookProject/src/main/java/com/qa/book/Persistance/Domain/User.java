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
@AllArgsConstructor
@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column (name = "user_Id")
	private long userId;
	
	
	@Column (nullable = false)
	private String firstName;
	@Column (nullable = false)
	private String lastName;
	@Column (unique = true, nullable = false)
	private String email;
	@Column (nullable = false)
	private String password;
	
	
	
	
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
