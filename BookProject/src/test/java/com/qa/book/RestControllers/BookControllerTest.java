package com.qa.book.RestControllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.book.Persistance.Domain.Book;
import com.qa.book.Persistance.Repo.BookRepo;
import com.qa.book.Rest.Controller.BookController;
import com.qa.book.Services.BookService;

//import io.netty.handler.codec.http.HttpMethod;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(classes =BookService.class)


@AutoConfigureMockMvc
@Transactional



public class BookControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private BookRepo repository;

	private List<Book> booksDb = new ArrayList<>();
	private Book testBook;
	private long testBookId;
	private Book expectedTestBook;
	private Book bookUpdateInfo;




	
	
	@BeforeEach
	public void init() {
		List<Book> books = List.of(
				new Book(1, "Jack and the bean", "1957","145-263-594", 53,null),
				new Book(2, "Wally west", "2000","145-365-256",23,null));
		booksDb.addAll(repository.saveAll(books));
		testBook = new Book(3, "The Trail, English Translation", "145-256-125", "Franz", 14,null);
		testBookId = testBook.getBookId();
		expectedTestBook = new Book(testBook.getBookId(), testBook.getTitle(), testBook.getPublishedDate(),testBook.getIsbnNumber(),testBook.getAvailableCopies(),testBook.getAuthors());
		bookUpdateInfo = new Book(1,"Jack and the bean stoke, second edition", "1957","145-263-594", 53,null);

	}

	
	@Test
	public void getBooksTest() throws Exception {
		// mock http request builder
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/books/getAll");
		// specifying accept header return type
		mockRequest.accept(MediaType.APPLICATION_JSON);
		// JSON string for obj mapper
		String books = objectMapper.writeValueAsString(booksDb);
		// result matcher
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(books);
		// request and assert
		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

	

	@Test
	public void deleteByIsbn() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/books/" + bookUpdateInfo.getBookId());
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isAccepted();
		

	
}
//	@Test
//	public void getByIsbnTest() throws Exception {
//		booksDb.add(repository.save(testBook));
//		// mock http request builder
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
//				"/books/" + testBookId);
//		// specifying accept header return type
//		mockRequest.accept(MediaType.APPLICATION_JSON);
//		// JSON string for obj mapper
//		String testBookStr = objectMapper.writeValueAsString(testBook);
//		// result matcher
//		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
//		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(testBookStr);
//		// request and assert
//		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
//	}

//	@Test
//	public void createBookTest() throws Exception {
//		// test object
//		Book expectedTestBook = new Book(testBook.getBookId(), testBook.getTitle(), testBook.getPublishedDate(),testBook.getIsbnNumber(),testBook.getAvailableCopies(),testBook.getAuthors());
//		// mock request
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/books/create");
//		// specifying accept header return type
//		mockRequest.contentType(MediaType.APPLICATION_JSON);
//		mockRequest.content(objectMapper.writeValueAsString(testBook));
//
//		mockRequest.accept(MediaType.APPLICATION_JSON);
//		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
//		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
//				.json(objectMapper.writeValueAsString(expectedTestBook));
//
//		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
//
//	}
//
//	@Test
//	public void updateBookTest() throws Exception {
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,
//				"/books/update" + bookUpdateInfo.getBookId());
//		// specifying accept header return type
//		mockRequest.contentType(MediaType.APPLICATION_JSON);
//		mockRequest.content(objectMapper.writeValueAsString(bookUpdateInfo));
//		mockRequest.accept(MediaType.APPLICATION_JSON);
//		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isAccepted();
//		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
//				.json(objectMapper.writeValueAsString(bookUpdateInfo));
//
//		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
//	}

	
}
