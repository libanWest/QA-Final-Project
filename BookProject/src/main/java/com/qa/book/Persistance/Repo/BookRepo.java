package com.qa.book.Persistance.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.book.Persistance.Domain.Book;



@Repository 
public interface BookRepo extends JpaRepository<Book, Long>{

}
