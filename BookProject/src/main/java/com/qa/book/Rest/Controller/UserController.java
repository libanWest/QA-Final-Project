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

import com.qa.book.Persistance.Domain.Book;
import com.qa.book.Persistance.Domain.User;
import com.qa.book.Services.UserService;

@RestController
public class UserController {
	
@Autowired	
	

private UserService service;


public UserController(UserService service) {
	super();
	this.service = service;}



@PostMapping("/users/create")
public User addUser (@RequestBody User user) {
	return this.service.addUser(user);
}


@GetMapping("/users/getAll")

public List<User> getAll(){
	
	return this.service.getAll();
}

@PutMapping("/users/update")

public User updateUser(@PathParam("id") Long id, @RequestBody User user) { // request the id to retrieve and the body to update it
	
	return this.service.updateUser(id, user);
	
}

@DeleteMapping("/users/delete/{id}")
public boolean removeUser(@PathVariable Long id) {
	
	return this.service.removeUser(id);
}

@PutMapping("/{userId}/borrow-book/{bookId}")
User 
borrowBook(
        @PathVariable Long userId,
        @PathVariable Long bookId
) {
    return this.service.BorrowBook(userId,bookId);

}


@PutMapping("/{userId}/return-book/{bookId}")
User 
returnBook(
        @PathVariable Long userId,
        @PathVariable Long bookId
) {
    return this.service.ReturnBook(userId,bookId);

}

}
