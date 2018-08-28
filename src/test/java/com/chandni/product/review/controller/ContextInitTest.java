package com.chandni.product.review.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContextInitTest {
	
	@Autowired
	ProductReviewController productReviewController;
	
	@Autowired
	ToxicTextController  toxicTextController;
	
	@Test
	public void contextLoadTest()
	{
		assertThat(productReviewController).isNotNull();
		
		assertThat(toxicTextController).isNotNull();
		
	}

}
