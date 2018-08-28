package com.chandni.product.review.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandni.product.review.model.CommentClass;

public interface ICommentClassDao extends JpaRepository<CommentClass,Long>{
	
	
}
