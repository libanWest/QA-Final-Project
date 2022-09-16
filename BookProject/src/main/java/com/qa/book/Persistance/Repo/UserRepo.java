package com.qa.book.Persistance.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.book.Persistance.Domain.User;

@Repository 

public interface UserRepo extends JpaRepository<User, Long>{

}
