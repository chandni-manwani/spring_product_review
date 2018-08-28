package com.chandni.product.review.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chandni.product.review.model.CommentClassResponse;
import com.chandni.product.review.model.ReviewComment;
import com.chandni.product.review.model.ToxicText;
import com.chandni.product.review.service.ProductReviewService;
import com.chandni.product.review.util.CommentClassificationUtil;

@RequestMapping("/productReview")
@Controller
public class ProductReviewController {
	
	@Autowired
	ProductReviewService productReviewService;
	
	@PostMapping(path = "/checkObjectionable", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public CommentClassResponse checkReviewComment(@RequestBody ReviewComment reviewComment)
	{
		//Get all Toxic Text
		List<ToxicText> toxicTexts= productReviewService.getToxicTexts();
		
		String comment = reviewComment!=null ?  reviewComment.getCommentText() : null;
		
		//Check if any objectionable content is found
		CommentClassResponse response = CommentClassificationUtil.checkCommentTextClass(toxicTexts,comment);
		
		//Return response - by default it will return clean
		return response;
		
	}
	
}
