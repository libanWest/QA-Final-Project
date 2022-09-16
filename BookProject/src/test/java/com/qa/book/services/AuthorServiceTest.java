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
import org.springframework.test.context.ActiveProfiles;

import com.qa.book.Persistance.Domain.Author;
import com.qa.book.Persistance.Repo.AuthorRepo;
import com.qa.book.Services.AuthorService;

@SpringBootTest  //(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class AuthorServiceTest {
	
@Autowired 
	
	private AuthorService service;
	
	@MockBean
	
	
	private AuthorRepo repo;
	
	@Test
	void testGetById() {
		final Long Id = (long) 1;
		final Optional<Author> author = Optional.ofNullable(new Author(Id, "Jack", "Kangaroo",145289, "Australia"));

		Mockito.when(this.repo.findById(Id)).thenReturn(author);

		assertThat(this.service.findById(Id)).isEqualTo(author);

		Mockito.verify(this.repo, Mockito.times(1)).findById(Id);
	}
	
	@Test
	void testGetAllAuthors() {
		final List<Author> authors = List.of(new Author(1, "Jack", "Kangaroo", 145289,"Australia"),
				new Author(2, "Wally", "Wallaby",145993, "Holland"));

		Mockito.when(this.repo.findAll()).thenReturn(authors);

		assertThat(this.service.getAll()).isEqualTo(authors);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	void testUpdate() { // REMEMBER TO OVERRIDE THE equals() METHOD IN YOUR ENTITY
		final Long id = (long) 1;
		Author author = new Author(id, "Jack", "Kangaroo",145289, "Australia");
		Optional<Author> optionalAuthor = Optional.of(author);

		Author newAuthor = new Author (id, "Wally", "Wallabee", 145993, "Holland");

		Mockito.when(this.repo.findById(id)).thenReturn(optionalAuthor);
		Mockito.when(this.repo.save(newAuthor)).thenReturn(newAuthor);

		assertThat(this.service.updateAuthor(author.getAuthorId(),newAuthor)).isEqualTo(newAuthor);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(newAuthor);
	}

	
	@Test
	void testDelete() {
		final Long id = (long) 1;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.removeAuthor(id)).isEqualTo(true);

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}
