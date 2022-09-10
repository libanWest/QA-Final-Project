package com.qa.book.Persistance.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.book.Persistance.Domain.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
