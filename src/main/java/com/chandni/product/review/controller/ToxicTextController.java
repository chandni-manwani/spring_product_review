package com.chandni.product.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chandni.product.review.model.ToxicText;
import com.chandni.product.review.service.ProductReviewService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RequestMapping("/toxicText")
@Controller
public class ToxicTextController {
	
	@Autowired
	ProductReviewService productReviewService;
	
	
	@GetMapping(path = "/getToxicText", produces = "application/json")
	public @ResponseBody List<ToxicText> getToxicText()
	{
		return productReviewService.getToxicTexts();
	}
	
	@PostMapping(path = "/addToxicText", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ResponseEntity<Object> addToxicText(@RequestBody ToxicText toxicText)
	{
		try {
			ToxicText text = productReviewService.addToxicText(toxicText);
			System.out.println("Saving "+text+" to database! ");
		}
		catch(Exception e)
		{
			System.out.println("Error while trying to save the toxic text "+e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(HttpStatus.CREATED);
	}
}
