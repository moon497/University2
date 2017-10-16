package kh.com.util;

import java.util.List;

import kh.com.model.CommentDto;

public class CommentReply {
	private String commentShape;
	
	@SuppressWarnings("unused")
	private CommentReply() {
	}
	
	public CommentReply(List<CommentDto> list, String replyBase) {
		System.out.println("replyBase : "+replyBase);
		
		//init
		if (replyBase == null || replyBase.equals("-1")) {
			replyBase = "";
		}
		System.out.println("변경된 replyBase : "+replyBase);
		System.out.println("replyBase 길이: "+replyBase.length());
		char replyStep = 'A';
		
		for (CommentDto commentDto : list) {
			String replys = commentDto.getCommentShape();
			if (replys != null && replys.equals("0") == false && (replyBase.length() + 1) == replys.length()) {
				replyStep += 1;
			}
		}
		
		commentShape = replyBase + replyStep;
		
	}
	
	public String getCommentShape() {
		return commentShape;
	}
	
	

}
