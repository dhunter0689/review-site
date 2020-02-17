package org.wecancodeit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMvcTest {
	
	
	@Autowired
	private MockMvc mockMvc;// mocking of a user
	
	@Test
	public void shouldGetStatusOfOkWhenNavigatingToAllReviews() throws Exception {
		this.mockMvc.perform(get("/show-reviews")).andExpect(status().isOk()); ///access of user end-point
	}

}
