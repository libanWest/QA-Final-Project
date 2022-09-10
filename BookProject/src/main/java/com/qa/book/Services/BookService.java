package com.qa.book.Services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qa.book.Persistance.Domain.Book;
import com.qa.book.Persistance.Repo.BookRepo;





@Component
@Service


public class BookService {
	
private BookRepo repo;


public BookService(BookRepo repo) {
	super();
	
	this.repo = repo;
	
}


	
	

	
// Add book
	
public Book addBook(Book newBook) {
	
	return this.repo.save(newBook);  // saves the new book into the repo 
	
	//Book saved = this.repo.save(newBook);
	//return this.mapToDTO(saved);
	
	
}


// Get all

public List<Book> getAll() {
	
	return this.repo.findAll(); 
}


// Update

public Book updateBook(Long id, Book book) {
	
java.util.Optional<Book> existingOptional = this.repo.findById(id); // the id in url as param


Book existing = existingOptional.get(); // retrieves the existing book to this var

existing.setTitle(book.getTitle());
existing.setAuthors(book.getAuthors());
existing.setPublishedDate(book.getPublishedDate());
existing.setIsbn(book.getIsbn());
existing.setPublishedDate(book.getPublishedDate());
existing.setPages(book.getPages());
existing.setCopies(book.getCopies()); // this allow us to change the fields 




return this.repo.save(existing);





// Book updated = this.repo.save(existing);
// return this.mapToDTO(updated)	
}

// Delete

public boolean removeBook(Long id) {
	
	this.repo.deleteById(id);
	
	boolean exists =  this.repo.existsById(id);
	
	return !exists;   // true if its deleted 
	
}
	

}
