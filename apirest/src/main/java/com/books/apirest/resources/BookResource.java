package com.books.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.books.apirest.repository.BookRepository;
import com.books.apirest.models.Book;

@RestController
@RequestMapping(value="/api")
public class BookResource {

	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/books")
	public List<Book> listBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/book/{id}")
	public Book listBookById(@PathVariable(value="id") long id){
		return bookRepository.findById(id);
	}
	
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
	@DeleteMapping("/book")
	public void deleteBook(@RequestBody Book book) {
		bookRepository.delete(book);
	}
	
	@PutMapping("/book")
	public Book updateBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}
	
}
