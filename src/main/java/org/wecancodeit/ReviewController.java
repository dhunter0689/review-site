package org.wecancodeit;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
	
	@Resource
	private ReviewRepository reviewRepo;
	
	@GetMapping("/all-reviews")
	public String findAllReviews(Model model) { //model
		model.addAttribute("reviewsModel", reviewRepo.findAllReviews());
		return "reviews-template";
	}
	
	@GetMapping("/single-review")
	public String findOneReview(@RequestParam Long id, Model model) throws ReviewNotFoundException{
		
		if(reviewRepo.findOneReview(id) == null) {
			throw new ReviewNotFoundException();
		}
		model.addAttribute("reviewModel", reviewRepo.findOneReview(id));
		return "review-template";
	}
	
}
