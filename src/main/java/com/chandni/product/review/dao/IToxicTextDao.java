package com.chandni.product.review.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandni.product.review.model.ToxicText;

@Repository
public interface IToxicTextDao extends JpaRepository<ToxicText, Long> {

}
