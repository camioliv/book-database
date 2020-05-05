package com.books.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.apirest.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	Book findById(long id);

	// While you made the strings you send to this method all lowercase, the query is still going to be
	// case sensitive unless you specify for the query to ignore the case sensitivity.
	List<Book> findAllByTitleContainingIgnoreCaseOrIsbnEqualsOrAuthorsNameContainingIgnoreCaseOrTopicsEquals(String title, String isbn, String author, String topic);
	List<Book> findAllByPagesIsLessThan(int pages);
	List<Book> findAllByRatingsStarsAndRatingsUserId(int stars, long userId);
	List<Book> findTop10ByOrderByLastViewdDesc();
}
