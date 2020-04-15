package com.books.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.apirest.models.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	List<Rating> findAllByUser(long user_id);
	
	List<Rating> findAllByBook(long user_id);
}
