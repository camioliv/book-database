package com.books.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.apirest.models.Author;
import com.books.apirest.repository.AuthorRepository;

@CrossOrigin
@RestController
@RequestMapping(value="/api")
public class AuthorResource {
	
	@Autowired
	AuthorRepository authorRepository;
	
	@GetMapping("/authors")
	public List<Author> listAuthors(){
		return authorRepository.findAll();
	}	
}
