package com.qa.book.Persistance.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.book.Persistance.Domain.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

	
	
	
}
