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


import com.qa.book.Persistance.Domain.Book;

import com.qa.book.Persistance.Repo.BookRepo;

import com.qa.book.Services.BookService;





@SpringBootTest  //(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class BookServiceTest {


		
	@Autowired 
		
		private BookService service;
		
		@MockBean
		
		
		private BookRepo repo;
		
		@Test
		void testGetById() {
			final Long Id = (long) 1;
			final Optional<Book> book = Optional.ofNullable(new Book(Id, "Jack and the bean", "1957","145-263-594", 53,null));

			Mockito.when(this.repo.findById(Id)).thenReturn(book);

			assertThat(this.service.findById(Id)).isEqualTo(book);

			Mockito.verify(this.repo, Mockito.times(1)).findById(Id);
		}
		
		@Test
		void testGetAllAuthors() {
			final List<Book> books = List.of(new Book(1, "Jack and the bean", "1957","145-263-594", 53,null),
					new Book(2, "Wally west", "2000","145-365-256",23,null));

			Mockito.when(this.repo.findAll()).thenReturn(books);

			assertThat(this.service.getAll()).isEqualTo(books);

			Mockito.verify(this.repo, Mockito.times(1)).findAll();
		}
		
		@Test
		void testUpdate() { // REMEMBER TO OVERRIDE THE equals() METHOD IN YOUR ENTITY
			final Long id = (long) 1;
			Book book = new Book(id,"Jack and the bean", "1957","145-263-594", 53,null);
			Optional<Book> optionalBook = Optional.of(book);

			Book newBook = new Book (id, "Wally west", "2000","145-263-594",23,null);

			Mockito.when(this.repo.findById(id)).thenReturn(optionalBook);
			Mockito.when(this.repo.save(newBook)).thenReturn(newBook);

			assertThat(this.service.updateBook(book.getBookId(),newBook)).isEqualTo(newBook);

			Mockito.verify(this.repo, Mockito.times(1)).findById(id);
			Mockito.verify(this.repo, Mockito.times(1)).save(newBook);
		}

		
		@Test
		void testDelete() {
			final Long id = (long) 1;

			Mockito.when(this.repo.existsById(id)).thenReturn(false);

			assertThat(this.service.removeBook(id)).isEqualTo(true);

			Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
		}

	}
