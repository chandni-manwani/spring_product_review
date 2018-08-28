package com.chandni.product.review.service;

/**
 * Service Layer for Product Review Application
 */
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandni.product.review.dao.ICommentClassDao;
import com.chandni.product.review.dao.IToxicTextDao;
import com.chandni.product.review.model.CommentClass;
import com.chandni.product.review.model.ToxicText;

@Service
public class ProductReviewService {
	
	@Autowired
	IToxicTextDao toxicTextDao;
	

	@Autowired
	ICommentClassDao commentClassDao;
	
	public List<ToxicText> getToxicTexts()
	{
		return toxicTextDao.findAll();
	}
	
	public ToxicText getToxicTextById(Long id)
	{
		return toxicTextDao.findById(id).orElse(null);
	}
	
	public ToxicText addToxicText (ToxicText toxicText)
	{
		ToxicText tt = toxicTextDao.save(toxicText);
		return tt;
	}
	
	public List<ToxicText> addAllToxicTexts (Collection<ToxicText> toxicText)
	{
		List<ToxicText> tt = toxicTextDao.saveAll(toxicText);
		return tt;
	}
	
	public CommentClass getCommentClass(Long id)
	{
		return commentClassDao.findById(id).orElse(null);
	}

}
