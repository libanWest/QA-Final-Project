package com.qa.book.services;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.qa.book.Persistance.Domain.Author;
import com.qa.book.Persistance.Domain.Book;
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
	void testGetById() {
		final Long Id = (long) 1;
		final Optional<User> user = Optional.ofNullable(new User(Id,"Jack", "Kangaroo", "jk@hotmail.com","qwerty",null));

		Mockito.when(this.repo.findById(Id)).thenReturn(user);

		assertThat(this.service.findById(Id)).isEqualTo(user);

		Mockito.verify(this.repo, Mockito.times(1)).findById(Id);
	}
	
	@Test
	void testGetAllUsers() {
		final List<User> users = List.of(new User(1,"Jack", "Kangaroo", "jk@hotmail.com","qwerty",null),
				new User(2, "Wally", "west", "ww@hotmail.com","ww145",null));

		Mockito.when(this.repo.findAll()).thenReturn(users);

		assertThat(this.service.getAll()).isEqualTo(users);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testUpdate() { // REMEMBER TO OVERRIDE THE equals() METHOD IN YOUR ENTITY
		final Long id = (long) 1;
		User user = new User(id,"Jack", "Kangaroo", "jk@hotmail.com","qwerty",null);
		Optional<User> optionalUser = Optional.of(user);

		User newUser = new User (id,"Wally", "west", "ww@hotmail.com","ww145",null);

		Mockito.when(this.repo.findById(id)).thenReturn(optionalUser);
		Mockito.when(this.repo.save(newUser)).thenReturn(newUser);

		assertThat(this.service.updateUser(user.getUserId(),newUser)).isEqualTo(newUser);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(newUser);
	}

	
	@Test
	void testDelete() {
		final Long id = (long) 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.removeUser(id)).isEqualTo(true);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}

