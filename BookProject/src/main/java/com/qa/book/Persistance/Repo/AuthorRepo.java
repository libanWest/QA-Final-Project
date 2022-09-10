package com.qa.book.Persistance.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.book.Persistance.Domain.Author;


public interface AuthorRepo extends JpaRepository<Author, Long> {

}
