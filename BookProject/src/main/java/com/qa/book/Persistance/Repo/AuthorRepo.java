package com.qa.book.Persistance.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.book.Persistance.Domain.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
	
	
}
