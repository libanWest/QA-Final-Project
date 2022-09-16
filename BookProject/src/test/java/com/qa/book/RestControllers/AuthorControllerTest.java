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
import com.qa.book.Persistance.Domain.Author;
import com.qa.book.Persistance.Domain.Author;
import com.qa.book.Persistance.Repo.AuthorRepo;




@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc
@Transactional

public class AuthorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private AuthorRepo repo;
	
	private List<Author> authorsInDb = new ArrayList<>();
	private Author testAuthor;
	private long testAuthorId;
	private Author expectedTestauthor;
	private Author authorUpdateInfo;




	
	
	@BeforeEach
	public void init() {
		List<Author> authors = List.of(
				new Author(1, "jack","black",145263,"british"),
				new Author(2, "wally", "west", 14236,"american"));
		authorsInDb.addAll(repo.saveAll(authors));
		testAuthor = new Author(3, "john","smith",256125, "French");
		testAuthorId = testAuthor.getAuthorId();
		expectedTestauthor = new Author(testAuthor.getAuthorId(), testAuthor.getFirstName(), testAuthor.getLastName(),testAuthor.getOrcidNumber(),testAuthor.getNationality());
		authorUpdateInfo = new Author(1, "jackson","black",145263,"british");

	}


	@Test
	public void getauthorsTest() throws Exception {
		// mock http request builder
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/authors/getAll");
		// specifying accept header return type
		mockRequest.accept(MediaType.APPLICATION_JSON);
		// JSON string for obj mapper
		String authors = objectMapper.writeValueAsString(authorsInDb);
		// result matcher
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(authors);
		// request and assert
		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

//	@Test
//	public void getByIsbnTest() throws Exception {
//		authorsDb.add(repository.save(testauthor));
//		// mock http request builder
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
//				"/authors/" + testauthorId);
//		// specifying accept header return type
//		mockRequest.accept(MediaType.APPLICATION_JSON);
//		// JSON string for obj mapper
//		String testauthorStr = objectMapper.writeValueAsString(testauthor);
//		// result matcher
//		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
//		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(testauthorStr);
//		// request and assert
//		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
//	}

	@Test
	public void createauthorTest() throws Exception {
		// test object
		Author expectedTestauthor = new Author(testAuthor.getAuthorId(), testAuthor.getFirstName(), testAuthor.getLastName(),testAuthor.getOrcidNumber(),testAuthor.getNationality());
		// mock request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/authors/create");
		// specifying accept header return type
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(testAuthor));

		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedTestauthor));

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

	}

	@Test
	public void updateauthorTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,
				"/authors/update" + authorUpdateInfo.getAuthorId());
		// specifying accept header return type
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(authorUpdateInfo));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(authorUpdateInfo));

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

	@Test
	public void deleteByIsbn() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/authors/" + authorUpdateInfo.getAuthorId());
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isAccepted();
		

	
}

}
