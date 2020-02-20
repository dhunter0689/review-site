package org.wecancodeit;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;/// avoid jCore array import

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMvcTest {
	
	
	@Autowired
	private MockMvc mockMvc;// mocking of a user
	
	@Mock
	private Review reviewOne;
	
	@Mock
	private Review reviewTwo;
	
	@MockBean
	
	private ReviewRepository reviewRepo;
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToAllReviews() throws Exception {
		this.mockMvc.perform(get("/all-reviews")).andExpect(status().isOk())///access of user end-point
		.andExpect(view().name("reviews-template"));
	}
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToReviewOnePage() throws Exception{
		when(reviewRepo.findOneReview(1L)).thenReturn(reviewOne);
		this.mockMvc.perform(get("/single-review?id=1")).andExpect(status().isOk())
		.andExpect(view().name("review-template"));
	}
	
	@Test
	public void shouldAddAllReviewsToTheModel() throws Exception{
		when(reviewRepo.findAllReviews()).thenReturn(Arrays.asList(reviewOne,reviewTwo));
		this.mockMvc.perform(get("/all-reviews"))
		.andExpect(model().attribute("reviewsModel", hasSize(2)));
	}
	
	@Test
	public void shouldReturnNotFoundForBadRequest() throws Exception {
		Long badId = 7L;
		when(reviewRepo.findOneReview(badId)).thenReturn(null);
		this.mockMvc.perform(get("/single-review?id=7"))
		.andExpect(status().isNotFound());
	}

}
