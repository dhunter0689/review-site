package org.wecancodeit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	private Review reviewOne = new Review(1L, "review name", "description");

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
		// TODO Auto-generated method stub
		return reviewList.values();
	}
	

}
