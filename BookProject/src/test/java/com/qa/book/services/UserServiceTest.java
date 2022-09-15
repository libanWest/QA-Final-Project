package com.qa.book.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.qa.book.Persistance.Domain.Author;
import com.qa.book.Persistance.Domain.User;
import com.qa.book.Persistance.Repo.AuthorRepo;
import com.qa.book.Persistance.Repo.UserRepo;
import com.qa.book.Services.AuthorService;
import com.qa.book.Services.UserService;


@SpringBootTest
public class UserServiceTest {

	
	
	@Autowired 
	
	private UserService service;
	
	
	@MockBean
	
	private UserRepo repo;
	
	@Test 

	void CreateUserTest() {
		
		
		// mocking input and testing what should be returned when save method is called by the service 
		   Mockito.when(this.repo.save(new User(2,"harris", "ford","hford@hotmail.com", "French",null))).thenReturn(new User(2,"harris","ford","hford@hotmail.com", "French",null));
		   
		//check that the object returned by the service layer's create method is the same as the one returned by the repo's save method
		   Assertions.assertThat(this.service.addUser(new User(2,"harris", "ford","hford@hotmail.com", "French",null))).isEqualTo(new User(2,"harris", "ford","hford@hotmail.com", "French",null)); 
		
		//Finally, we want to verify that the methods we're mocking have been called the correct amount of times:
		   Mockito.verify(this.repo, Mockito.times(1)).save(new User(2,"harris", "ford","hford@hotmail.com", "French",null));
	}

	@Test
	public void deleteUserTest() {
		User user = new User (1, "jack", "Black", "jack@hotmail.com", "spanish",null);
		service.removeUser(user.getUserId());
		verify(repo, times(1)).delete(user);
	}
	
	
	
	@Test
	public void getUsersTest() {
		when(repo.findAll()).thenReturn(Stream
				.of(new User(376, "Danile", "smith", "dsmith@hotmail.com", "British", null), new User(958, "Huy","Owen", "howen@hotmail.com", "British",null)).collect(Collectors.toList()));
		assertEquals(2, service.getAll().size());
	}
}

