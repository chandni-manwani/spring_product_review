package com.chandni.product.review.util;

import java.util.List;

import com.chandni.product.review.model.CommentClassResponse;
import com.chandni.product.review.model.ToxicText;

/**
 * Utility class to check if text is in a list of toxic texts
 * @author chandnimanwani
 *
 */
public class CommentClassificationUtil {
	
	private static final String CLEAN ="clean";
	
	
	public static CommentClassResponse checkCommentTextClass(List<ToxicText> toxicTexts, String comment) 
	{
		CommentClassResponse commentClassResponse = new CommentClassResponse(false,CLEAN);
		
		if(comment==null || toxicTexts==null)
		{//Invalid Input -return non objectionable
			return commentClassResponse;
		}
		
		for(ToxicText toxicText : toxicTexts)
		{
			String text = toxicText.getToxicText() !=null ? toxicText.getToxicText() : null;
			if(text==null)
			{//Invalid Reference Data - continue with other texts in list
				continue;
			}
		
			if( comment.toLowerCase().indexOf(text.toLowerCase()) != -1 )
			{//Found objectionable no need to check further
				commentClassResponse.setIsObjectionable(true);
				commentClassResponse.setCommentClass(toxicText.getToxicTextClass().getClass_name());
				break;
			}
		}
			
		return commentClassResponse;
		
	}

	

}
