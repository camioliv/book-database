package com.books.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.books.apirest.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	Author findById(long id);
	
	@Query("select a from Author a where a.name = ?1")
	Author findByName(String name);
}
