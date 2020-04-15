package com.books.apirest.services;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.apirest.exceptions.ApiRestException;
import com.books.apirest.models.Book;
import com.books.apirest.models.Rating;
import com.books.apirest.recommendation.BookRecommenderBuilder;
import com.books.apirest.repository.BookRepository;
import com.books.apirest.repository.RatingRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private RatingRepository ratingRepository;
	
	public List<Book> recomendBooks(Long userId) throws ApiRestException {
		List<Book> booksRecomended = new ArrayList<Book>();
		List<Rating> ratings = ratingRepository.findAllByUser(userId);
		
		try {
			DataModel userBooks = RatingsToDataModel(ratings);
			Recommender recommender = new BookRecommenderBuilder().buildRecommender(userBooks);
			List<RecommendedItem> recommendations = recommender.recommend(userId, 10, false);
			
		
			for (RecommendedItem recommendation : recommendations) {
				Book book = bookRepository.findById(recommendation.getItemID());
				booksRecomended.add(book);
			}
					
		} catch (Exception e) {
			throw new ApiRestException(e.getMessage());
		}
		return booksRecomended;
	}

	
	private DataModel RatingsToDataModel(List<Rating> ratings) throws ApiRestException{
			
			StringBuffer fileBuffer = new StringBuffer();
			File file = null;
			LocalDate today = LocalDate.now();	
			String fileName = "file_"+today.toString()+".csv";
			FileDataModel fileDataModel = null;
			
			for (Rating rating : ratings ) {
				String line = "" + rating.getUser().getId();
				line = line + "," + rating.getBook().getId();
				line = line + "," + rating.getStars();
				
				fileBuffer.append(line);
			}  		
			
			try {
	 
				file = new File(System.getProperty("java.io.tmpdir") + File.separator + fileName);			
				
				fileDataModel = new FileDataModel(file);
				
			} catch (Exception e) {
				throw new ApiRestException(e.getMessage());
			}
			return fileDataModel;
		}
}
