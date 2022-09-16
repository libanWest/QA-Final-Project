package com.qa.book.RestControllers;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.qa.book.Persistance.Domain.User;

import com.qa.book.Persistance.Repo.UserRepo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc
@Transactional

public class UserControllerTest {
	
	
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private UserRepo repo;
	
	private List<User> usersInDb = new ArrayList<>();
	private User testUser;
	private long testUserId;
	private User expectedTestUser;
	private User userUpdateInfo;




	
	
	@BeforeEach
	public void init() {
		List<User> users = List.of(
				new User(1, "jack","black","jb@hotmail,com","helloworld",null),
				new User(2, "wally", "west", "ww@hotmail.com","blueorchid",null));
		usersInDb.addAll(repo.saveAll(users));
		testUser = new User(3, "john","smith","js@hotmail.com", "parissaint",null);
		testUserId = testUser.getUserId();
		expectedTestUser = new User(testUser.getUserId(), testUser.getFirstName(), testUser.getLastName(),testUser.getEmail(),testUser.getPassword(), testUser.getBooks());
		userUpdateInfo = new User(1, "jack","black","jb@hotmail,com","helloworld",null);

	}

	//@Disabled
	@Test
	public void getusersTest() throws Exception {
		// mock http request builder
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/users/getAll");
		// specifying accept header return type
		mockRequest.accept(MediaType.APPLICATION_JSON);
		// JSON string for obj mapper
		String users = objectMapper.writeValueAsString(usersInDb);
		// result matcher
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(users);
		// request and assert
		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

//	@Test
//	public void getByIsbnTest() throws Exception {
//		usersDb.add(repository.save(testuser));
//		// mock http request builder
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET,
//				"/users/" + testuserId);
//		// specifying accept header return type
//		mockRequest.accept(MediaType.APPLICATION_JSON);
//		// JSON string for obj mapper
//		String testuserStr = objectMapper.writeValueAsString(testuser);
//		// result matcher
//		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
//		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(testuserStr);
//		// request and assert
//		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
//	}

	@Test
	public void createuserTest() throws Exception {
		// test object
		User expectedTestUser = new User(testUser.getUserId(), testUser.getFirstName(), testUser.getLastName(),testUser.getEmail(),testUser.getPassword(), testUser.getBooks());
		// mock request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/users/create");
		// specifying accept header return type
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(testUser));

		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedTestUser));

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);

	}

	@Test
	public void updateuserTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT,
				"/users/update" + userUpdateInfo.getUserId());
		// specifying accept header return type
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(userUpdateInfo));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(userUpdateInfo));

		mockMvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

	@Test
	public void deleteByIsbn() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE,
				"/users/" + userUpdateInfo.getUserId());
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isAccepted();
		

	
}


}
