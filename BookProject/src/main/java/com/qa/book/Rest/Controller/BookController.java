package com.qa.book.Rest.Controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.book.Persistance.Domain.Book;
import com.qa.book.Services.BookService;

@RestController
public class BookController {
	
	@Autowired
	
	private BookService service;
	
	public BookController(BookService service) {
		super();
		this.service = service;
	}
	
	@PostMapping( "/books/create")
	public Book addBook (@RequestBody Book book) {
		return this.service.addBook(book);
	}
	
	@GetMapping("/books/getAll")
	
	public List<Book> getAll(){
		
		return this.service.getAll();
	}
	
	
	@PutMapping("/books/update")
	
	public Book updateBook(@PathParam("id") Long id, @RequestBody Book book) { 
		
		return this.service.updateBook(id, book);
	}
	
	@DeleteMapping("/books/delete/{id}")
	public boolean removeBook(@PathVariable Long id) {
		
		return this.service.removeBook(id);
	}
	
	@PutMapping("/{bookId}/addauthors/{authorId}")
	Book addAuthorToBook(
	        @PathVariable Long bookId,
	        @PathVariable Long authorId
	) {
	    return this.service.addAuthor(bookId, authorId);
	}
	
	@PutMapping("/{bookId}/delete-authors/{authorId}")
	Book deleteAuthors(
	        @PathVariable Long bookId,
	        @PathVariable Long authorId
	) {
	    return this.service.DeleteAuthor(bookId, authorId);
	
	}
	}
