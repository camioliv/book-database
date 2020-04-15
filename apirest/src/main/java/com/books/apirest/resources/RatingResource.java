package com.books.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.apirest.models.Rating;
import com.books.apirest.repository.RatingRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class RatingResource {

	@Autowired
	RatingRepository ratingRepository;

	@GetMapping("/ratings")
	public List<Rating> listRatings(){
		return ratingRepository.findAll();
	}
	
	@GetMapping("/rating/{id}")
	public Rating listRatingById(@PathVariable(value="id") long id){
		return ratingRepository.findById(id);
	}
	
	@PostMapping("/rating")
	public Rating  saveRating(@RequestBody Rating rating) {
		return ratingRepository.save(rating);
	}
	
	@DeleteMapping("/rating")
	public void deleteRating(@RequestBody Rating rating) {
		ratingRepository.delete(rating);
	}
	
	@PutMapping("/rating")
	public Rating updateRating(@RequestBody Rating rating) {
		return ratingRepository.save(rating);
	}
	
}
