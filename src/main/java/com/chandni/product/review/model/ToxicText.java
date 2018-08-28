package com.chandni.product.review.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * The object represents a toxic / objectionable word and its classification
 * @author chandnimanwani
 *
 */
@EnableAutoConfiguration
@Entity
@Table(name="TOXIC_TEXT")
public class ToxicText {
	
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="TEXT")
	private String toxicText;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinColumn(
        name = "classId", 
        referencedColumnName = "CLASS_ID"
    )
	private CommentClass toxicTextClass;
	
		
	public ToxicText() {
		super();
	}
	public ToxicText(Long id, String toxicText, CommentClass toxicTextClass) {
		super();
		this.id = id;
		this.toxicText = toxicText;
		this.toxicTextClass = toxicTextClass;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToxicText() {
		return toxicText;
	}
	public void setToxicText(String toxicText) {
		this.toxicText = toxicText;
	}
	public CommentClass getToxicTextClass() {
		return toxicTextClass;
	}
	public void setToxicTextClass(CommentClass toxicTextClass) {
		this.toxicTextClass = toxicTextClass;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((toxicText == null) ? 0 : toxicText.hashCode());
		result = prime * result + ((toxicTextClass == null) ? 0 : toxicTextClass.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToxicText other = (ToxicText) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (toxicText == null) {
			if (other.toxicText != null)
				return false;
		} else if (!toxicText.equals(other.toxicText))
			return false;
		if (toxicTextClass == null) {
			if (other.toxicTextClass != null)
				return false;
		} else if (!toxicTextClass.equals(other.toxicTextClass))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ToxicText [id=" + id + ", toxicText=" + toxicText + ", toxicTextClass=" + toxicTextClass + "]";
	}
	
	

}
