package com.qa.book.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qa.book.Persistance.Domain.Author;
import com.qa.book.Persistance.Domain.Book;
import com.qa.book.Persistance.Domain.User;
import com.qa.book.Persistance.Repo.BookRepo;
import com.qa.book.Persistance.Repo.UserRepo;

@Component
@Service

public class UserService  {
	
	private UserRepo repo;
	private BookRepo bookRepo;

	public UserService(UserRepo repo,BookRepo bookRepo) {
		super();
		this.repo = repo;
		this.bookRepo = bookRepo;
		}
	
	// Add User
	
		public User addUser(User newUser) {
		return this.repo.save(newUser);  
	
		}
		
	// Get all

		public List<User> getAll() {
		return this.repo.findAll(); 
		}

	// Update

		public User updateUser(Long id, User user) {
		java.util.Optional<User> existingOptional = this.repo.findById(id); 


		User existing = existingOptional.get(); 

		existing.setFirstName(user.getFirstName());
		existing.setLastName(user.getLastName());
		existing.setEmail(user.getEmail());
		existing.setPassword(user.getPassword());

		return this.repo.save(existing);
		}

	// Delete

		public boolean removeUser(Long id) {
			this.repo.deleteById(id);
			boolean exists =  this.repo.existsById(id);
			return !exists;  		
		}
		
	// Borrow book
		
		public User BorrowBook(Long userId, Long bookId) {
			
			User user = this.repo.findById(userId).get();
		    Book book = this.bookRepo.findById(bookId).get();
		    
	 if (book.getAvailableCopies()!= 0) {
		    user.BorrowBook(book);
		    int copies = book.getAvailableCopies();
		    book.setAvailableCopies(copies-1);
		    this.repo.save(user);
   		 }
		// make an exception 
		 
		return  user;
		}
		
	// Return book
		
		public User ReturnBook(Long userId, Long bookId) {
				  
			User user = this.repo.findById(userId).get();
		    Book book = this.bookRepo.findById(bookId).get();
		    
		    user.ReturnBook(book);
		    int copies = book.getAvailableCopies();
		    book.setAvailableCopies(copies+1);
		    
		    return this.repo.save(user);
		}
		
	// Find by id
		public Optional<User> findById(Long userId) {
			return this.repo.findById(userId);	
		}
}
