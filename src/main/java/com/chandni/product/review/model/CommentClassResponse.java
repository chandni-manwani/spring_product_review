package com.chandni.product.review.model;

/**
 * The Object Represents Classification of comment text, does it have any objectionable content & what type
 * @author chandnimanwani
 *
 */
public class CommentClassResponse {
	
	private Boolean isObjectionable;
	
	private String commentClass;

	public CommentClassResponse() {
		super();
	}

	public CommentClassResponse(Boolean isObjectionable, String commentClass) {
		super();
		this.isObjectionable = isObjectionable;
		this.commentClass = commentClass;
	}

	public Boolean getIsObjectionable() {
		return isObjectionable;
	}

	public void setIsObjectionable(Boolean isObjectionable) {
		this.isObjectionable = isObjectionable;
	}

	public String getCommentClass() {
		return commentClass;
	}

	public void setCommentClass(String commentClass) {
		this.commentClass = commentClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentClass == null) ? 0 : commentClass.hashCode());
		result = prime * result + ((isObjectionable == null) ? 0 : isObjectionable.hashCode());
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
		CommentClassResponse other = (CommentClassResponse) obj;
		if (commentClass == null) {
			if (other.commentClass != null)
				return false;
		} else if (!commentClass.equals(other.commentClass))
			return false;
		if (isObjectionable == null) {
			if (other.isObjectionable != null)
				return false;
		} else if (!isObjectionable.equals(other.isObjectionable))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CommentClassResponse [isObjectionable=" + isObjectionable + ", commentClass=" + commentClass + "]";
	}
	

	
}
