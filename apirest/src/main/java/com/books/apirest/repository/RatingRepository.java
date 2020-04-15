package com.books.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.apirest.models.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
	
	Rating findById(long id);
	List<Rating> findAllByUser(long userId);
	List<Rating> findAllByBook(long bookId);
}
