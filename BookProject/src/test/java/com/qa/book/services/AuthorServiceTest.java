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
import com.qa.book.Persistance.Repo.AuthorRepo;
import com.qa.book.Services.AuthorService;

@SpringBootTest
public class AuthorServiceTest {
	
	
	@Autowired 
	
	private AuthorService service;
	
	@MockBean
	
	
	private AuthorRepo repo;
	
	@Test 

	void CreateAuthorTest() {
		
		
		
		   Mockito.when(this.repo.save(new Author(2,"harris", "ford",125698, "French"))).thenReturn(new Author(2,"harris","ford",125698, "French"));
		   	
		   Assertions.assertThat(this.service.addAuthor(new Author(2,"harris", "ford",125698, "French"))).isEqualTo(new Author(2,"harris", "ford",125698, "French")); 
		
		   Mockito.verify(this.repo, Mockito.times(1)).save(new Author(2,"harris", "ford",125698, "French"));
	}

	@Test
	public void deleteAuthorTest() {
		Author author = new Author (1, "jack", "Black", 12345, "spanish");
		service.removeAuthor((long) 1);
		verify(repo, times(1)).delete(author);
	}

	
	
	@Test
	public void getUsersTest() {
		when(repo.findAll()).thenReturn(Stream
				.of(new Author(376, "Danile", "smith", 314, "British"), new Author(958, "Huy","Owen", 35, "British")).collect(Collectors.toList()));
		assertEquals(2, service.getAll().size());
	}
}
