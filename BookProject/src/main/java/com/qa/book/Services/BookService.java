package com.qa.book.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qa.book.Persistance.Domain.Author;
import com.qa.book.Persistance.Domain.Book;
import com.qa.book.Persistance.Repo.AuthorRepo;
import com.qa.book.Persistance.Repo.BookRepo;





@Component
@Service


public class BookService {
	
	private BookRepo repo;
	
	private AuthorRepo authorRepo;
	public BookService(BookRepo repo , AuthorRepo authorRepo) {
		super();
		
		this.repo = repo;
		this.authorRepo = authorRepo;
	}
	
			
	// Add book
		
	public Book addBook(Book newBook) {
		
		return this.repo.save(newBook);  
		
	}
	
	// Get all
	
	public List<Book> getAll() {
		
		return this.repo.findAll(); 
	}
	
	
	// Update
	
	public Book updateBook(Long id, Book book) {
		
	java.util.Optional<Book> existingOptional = this.repo.findById(id); 
	
	Book existing = existingOptional.get(); 
	
	existing.setTitle(book.getTitle());
	existing.setPublishedDate(book.getPublishedDate());
	existing.setIsbnNumber(book.getIsbnNumber());
	existing.setPublishedDate(book.getPublishedDate());
	existing.setNumPages(book.getNumPages());
	existing.setAvailableCopies(book.getAvailableCopies()); 
		
	return this.repo.save(existing);
		
	
	}
	
	// Delete

	
	public boolean removeBook(Long id) {
		
		this.repo.deleteById(id);	
		boolean exists =  this.repo.existsById(id);
		return !exists; 
		}

	
	public Optional<Book> findById(Long bookId) {
		return this.repo.findById(bookId);
		}
		
	
	
	public Book addAuthor(Long bookId, Long authorId) {
		
	    Book book = this.repo.findById(bookId).get();
	    Author author = this.authorRepo.findById(authorId).get();
	    book.setAuthors(author); 
	 
	    return this.repo.save(book);
		}

	public Book DeleteAuthor(Long bookId, Long authorId) {
			  
	    Book book = this.repo.findById(bookId).get();
	    Author author = this.authorRepo.findById(authorId).get();
	    
	    book.DeleteAuthor(author);
	    return this.repo.save(book);
	}
}
