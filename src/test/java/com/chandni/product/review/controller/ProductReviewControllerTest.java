package com.chandni.product.review.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.chandni.product.review.model.CommentClass;
import com.chandni.product.review.model.ToxicText;
import com.chandni.product.review.service.ProductReviewService;

@ComponentScan(basePackages = {"com.chandni.product.review.controller","com.chandni.product.review.service"}) 
@RunWith(SpringRunner.class)
@WebMvcTest(ProductReviewController.class)
public class ProductReviewControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductReviewService service;

    //Positive test case - comment contains bitch - objectionable
    @Test
    public void checkObjectionableComments() throws Exception {
    	ArrayList<ToxicText> mockList = new ArrayList<ToxicText>();
    	mockList.add(new ToxicText(1l, "bitch", new CommentClass(231l, "insult")));
    	
        when(service.getToxicTexts()).thenReturn(mockList);
        		
    	
    	String mockJson = "{\n" + 
    			"	\"commentText\" : \"complete bitch!\"\n" + 
    			"}";
    
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/productReview/checkObjectionable")
				.accept(MediaType.APPLICATION_JSON).content(mockJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(response.getContentAsString().contains("insult"), true);

		assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
    

  //Positive test case - comment contains no objectionable word - clean
    @Test
    public void checkCleanComments() throws Exception {
    	ArrayList<ToxicText> mockList = new ArrayList<ToxicText>();
    	mockList.add(new ToxicText(1l, "bitch", new CommentClass(231l, "insult")));
    	
        when(service.getToxicTexts()).thenReturn(mockList);
        		
    	
    	String mockJson = "{\n" + 
    			"	\"commentText\" : \"Awesome Product!\"\n" + 
    			"}";
    
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/productReview/checkObjectionable")
				.accept(MediaType.APPLICATION_JSON).content(mockJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(response.getContentAsString().contains("clean"), true);

		assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
    
    
    
    //Empty Toxic word list - negative test case
    @Test
    public void checkObjectionableCommentsForNullToxicList() throws Exception {
    	//return null from mock list
    	when(service.getToxicTexts()).thenReturn(null);
       
    	String mockJson = "{\n" + 
    			"	\"commentText\" : \"Toxic List is null - test Bitch !\"\n" + 
    			"}";
    
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/productReview/checkObjectionable")
				.accept(MediaType.APPLICATION_JSON).content(mockJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		assertEquals(response.getContentAsString().contains("clean"), true);

		assertEquals(HttpStatus.OK.value(), response.getStatus());
    }
   
}
