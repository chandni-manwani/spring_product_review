package com.chandni.product.review.controller;


import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
@WebMvcTest(ToxicTextController.class)
public class ToxicTextControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductReviewService service;

    @Test
    public void getToxicTextsTest() throws Exception {
    	ArrayList<ToxicText> mockList = new ArrayList<ToxicText>();
    	mockList.add(new ToxicText(1l, "bitch", new CommentClass(231l, "insult")));
    	
        when(service.getToxicTexts()).thenReturn(mockList);
        		
        this.mockMvc.perform(get("/toxicText/getToxicText")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("insult")));
    }

    @Test
    public void addToxicTextTest() throws Exception
    {
    	ToxicText mocktext = new ToxicText(1l, "bitch", new CommentClass(231l, "insult"));
    	
    	String mockJson = "{"+
    	        "\"id\": 1,"+
    	        "\"toxicText\": \"asshole\","+
    	        "\"toxicTextClass\": {"+
    	            "\"class_id\": 2,"+
    	            "\"class_name\": \"Insult\""+
    	        "}"+
    	    "}";
    	
		Mockito.when(
				service.addToxicText(Mockito.any(ToxicText.class))).thenReturn(mocktext);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/toxicText/addToxicText")
				.accept(MediaType.APPLICATION_JSON).content(mockJson)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
  
}
