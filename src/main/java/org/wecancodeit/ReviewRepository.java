package org.wecancodeit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	private Review reviewOne = new Review(1L, "Miami, Florida", "description");
	private Review reviewTwo = new Review(2L, "San Juan, Puerto Rico", "description");
	
	public ReviewRepository() {
		reviewList.put(reviewOne.getId(), reviewOne);
		reviewList.put(reviewTwo.getId(), reviewTwo);
	}
	//use varargs(variable argument) for testing purposes for many (make an object
	public ReviewRepository(Review...reviews) {
		for(Review review: reviews) {
			reviewList.put(review.getId(), review);
		}
	
	}

	public Review findOneReview(long id) {
		return reviewList.get(id);
	}

	public Collection<Review> findAllReviews() {
		return reviewList.values();
	}
	

}
