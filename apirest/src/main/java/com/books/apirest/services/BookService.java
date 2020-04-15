package com.books.apirest.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.apirest.exceptions.ApiRestException;
import com.books.apirest.models.Book;
import com.books.apirest.models.BookRecommenderBuilder;
import com.books.apirest.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	
	public List<Book> recomendBooks(Long user_id) throws ApiRestException {
		List<Book> booksRecomended = new ArrayList<Book>();
		try {
			DataModel user_books = null;
			Recommender recommender = new BookRecommenderBuilder().buildRecommender(user_books);
			List<RecommendedItem> recommendations = recommender.recommend(user_id, 10, false);
			
		
			for (RecommendedItem recommendation : recommendations) {
				Book book = bookRepository.findById(recommendation.getItemID());
				booksRecomended.add(book);
			}
					
		} catch (Exception e) {
			throw new ApiRestException(e.getMessage());
		}
		return booksRecomended;
	}
}
