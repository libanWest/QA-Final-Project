package com.qa.book.Services;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.qa.book.Persistance.Domain.User;
import com.qa.book.Persistance.Repo.UserRepo;

@Component
@Service
public class UserService  {
	
	private UserRepo repo;

	public UserService(UserRepo repo) {
		super();
		this.repo = repo;
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
	
	
	

}
