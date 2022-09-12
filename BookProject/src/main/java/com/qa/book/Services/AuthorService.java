package com.qa.book.Services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qa.book.Persistance.Domain.Author;
import com.qa.book.Persistance.Repo.AuthorRepo;

@Component
@Service

public class AuthorService {

	
	
	
	private AuthorRepo repo;


	public AuthorService(AuthorRepo repo) {
		super();
		
		this.repo = repo;
		
	}
		
// Add Author
		
	public Author addAuthor(Author newAuthor) {
		
		return this.repo.save(newAuthor);  
		
	}


// Get all

	public List<Author> getAll() {
		
		return this.repo.findAll(); 
	}


// Update

	public Author updateAuthor(Long id, Author author) {
		
	java.util.Optional<Author> existingOptional = this.repo.findById(id); 


	Author existing = existingOptional.get(); 

	existing.setFullName(author.getFullName());
	existing.setNationality(author.getNationality());

	return this.repo.save(existing);

	}

	// Delete

	public boolean removeAuthor(Long id) {
		
		this.repo.deleteById(id);
		
		boolean exists =  this.repo.existsById(id);
		
		return !exists;  
		
	}
}
