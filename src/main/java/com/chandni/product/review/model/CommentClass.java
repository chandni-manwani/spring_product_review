package com.chandni.product.review.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * The object represents class of toxic comment - clean / insult / obscene..
 * @author chandnimanwani
 *
 */
@EnableAutoConfiguration
@Entity
@Table(name="COMMENT_CLASS")
public class CommentClass {
	

	@Id
	@Column(name="CLASS_ID")
	Long class_id;
	
	@Column(name="CLASS_NAME")
	String class_name;
	
	

	public CommentClass() {
		super();
	}

	public CommentClass(Long class_id, String class_name) {
		super();
		this.class_id = class_id;
		this.class_name = class_name;
	}

	public Long getClass_id() {
		return class_id;
	}

	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((class_id == null) ? 0 : class_id.hashCode());
		result = prime * result + ((class_name == null) ? 0 : class_name.hashCode());
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
		CommentClass other = (CommentClass) obj;
		if (class_id == null) {
			if (other.class_id != null)
				return false;
		} else if (!class_id.equals(other.class_id))
			return false;
		if (class_name == null) {
			if (other.class_name != null)
				return false;
		} else if (!class_name.equals(other.class_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentClass [class_id=" + class_id + ", class_name=" + class_name + "]";
	}

	
	
	

}
