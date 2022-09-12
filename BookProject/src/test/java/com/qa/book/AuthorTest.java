package com.qa.book;

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
public class AuthorTest {
	
	
	@Autowired 
	
	private AuthorService service;
	
	@MockBean
	
	
	private AuthorRepo repo;
	
	@Test 

	void testCreate() {
		
		
		// mocking input and testing what should be returned when save method is called by the service 
		   Mockito.when(this.repo.save(new Author(1,"harris", "French"))).thenReturn(new Author(1, "harris", "French"));
		   
		//check that the object returned by the service layer's create method is the same as the one returned by the repo's save method
		   Assertions.assertThat(this.service.addAuthor(new Author(1,"harris", "French"))).isEqualTo(new Author(1, "harris", "French")); 
		
		//Finally, we want to verify that the methods we're mocking have been called the correct amount of times:
		   Mockito.verify(this.repo, Mockito.times(1)).save(new Author(1,"harris", "French"));
	}

	

}
