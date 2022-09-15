package com.qa.book.RestControllers;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.book.Persistance.Domain.Book;
import com.qa.book.Rest.Controller.BookController;
import com.qa.book.Services.BookService;




@WebMvcTest(BookController.class)
public class BookControllerTest {

	@Autowired
	private BookController controller;

	@MockBean
	private BookService bookService;

	private List<Book> books = new ArrayList<>();
	private Book testBook;
	private Book bookUpdateInfo;
	private Book updatedTestBook;
	private Long updatedBookId;

	@BeforeEach
	
//	public void init() {
//		books.addAll(List.of(
//				new Book(1,"Lord of the Rings",1937,"1933988673",19,null),
//				new Book(2,"The Catcher in the Rye", 1946, "9780140237504l", 46,null)));
//		testBook = new Book("The Trail", 1925,"9780141182902l",23, null);
//		updatedTestBook = new Book("The Trail, English translation", 1925,"9780141182902l",23, null);
//		bookUpdateInfo = new Book("The Trail, English translation", 1925,"9780141182902l",23, null);
//		updatedBookId = (long) 3;
//	}

	
	@Test
	public void getBooksTest() {
		// given
		ResponseEntity<List<Book>> expected = new ResponseEntity<List<Book>>(books, HttpStatus.OK);
		// when
		when(bookService.getAll()).thenReturn(books);
		// then
		List<Book> actual = controller.getAll();
		assertThat(expected).isEqualTo(actual);
		// verify service called
		verify(bookService, times(1)).getAll();
	}

//	@Test
//	public void getByIsbnTest() {
//		// given
//		ResponseEntity<Book> expected = ResponseEntity.status(HttpStatus.OK).body(testBook);
//		// when
//		when(bookService.getByIsbn(9780141182902l)).thenReturn(testBook);
//		// then
//		ResponseEntity<Book> actual = controller.getByIsbn(9780141182902l);
//		assertThat(expected).isEqualTo(actual);
//		// verify service called
//		verify(bookService, times(1)).(9780141182902l);
//	}

	@Test
	public void createBookTest() {
		// given
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/create");
		ResponseEntity<Book> expected = new ResponseEntity<Book>(testBook, headers, HttpStatus.CREATED);
		// when
		when(bookService.addBook(testBook)).thenReturn(testBook);
		// then
		Book actual = controller.addBook(testBook);
		assertThat(expected).isEqualTo(actual);
		// verify service called
		verify(bookService, times(1)).addBook(testBook);
	}

	@Test
	public void updateBookTest() {
		// given
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/books/" + updatedBookId);
		ResponseEntity<Book> expected = new ResponseEntity<Book>(updatedTestBook, headers, HttpStatus.ACCEPTED);
		// when
		when(bookService.updateBook(updatedBookId, bookUpdateInfo)).thenReturn(updatedTestBook);
		// then
		Book actual = controller.updateBook(updatedBookId, bookUpdateInfo);
		assertThat(expected).isEqualTo(actual);
		// verify
		verify(bookService, times(1)).updateBook(updatedBookId, bookUpdateInfo);

	}

	@Test
	public void deleteByIdTest() {
		// given
		ResponseEntity<?> expected = ResponseEntity.status(HttpStatus.ACCEPTED).build();
		// then
		boolean actual = controller.removeBook(updatedBookId);
		assertThat(expected).isEqualTo(actual);
		// verify
		verify(bookService, times(1)).removeBook(updatedBookId);
	}
}

	
	
	

