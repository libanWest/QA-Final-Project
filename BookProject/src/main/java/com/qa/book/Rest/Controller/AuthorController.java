package com.qa.book.Rest.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.book.Persistance.Domain.Author;
import com.qa.book.Services.AuthorService;




@RestController

public class AuthorController {

	@Autowired

	private AuthorService service;


	public AuthorController(AuthorService service) {
		super();
		this.service = service;}
	
	
	
	@PostMapping( "/authors/create")
	public Author addAuthor (@RequestBody Author author) {
		return this.service.addAuthor(author);
	}
	
	
	@GetMapping("/authors/getAll")
	
	public List<Author> getAll(){
		
		return this.service.getAll();
	}
	
	@PutMapping("/authors/update")
	
	public Author updateAuthor(@PathParam("id") Long id, @RequestBody Author author) { // request the id to retrieve and the body to update it
		
		return this.service.updateAuthor(id, author);
		
	}
	
	@DeleteMapping("/authors/delete/{id}")
	public boolean removeAuthor(@PathVariable Long id) {
		
		return this.service.removeAuthor(id);
	}

}
