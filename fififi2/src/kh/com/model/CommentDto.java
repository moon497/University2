package kh.com.model;

import java.io.Serializable;

public class CommentDto implements Serializable {
	private static final long serialVersionUID = 7102612417387175157L;
	
	private int bbsSeq;
	private int commentGroupNo;
	private String commentShape;
	private int commentSeq;
	private String commentStatus;
	private String userId;
	private String commentContent;
	private String commentCreateAt;
	
	public int getBbsSeq() {
		return bbsSeq;
	}
	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}
	public int getCommentGroupNo() {
		return commentGroupNo;
	}
	public void setCommentGroupNo(int commentGroupNo) {
		this.commentGroupNo = commentGroupNo;
	}
	public String getCommentShape() {
		return commentShape;
	}
	public void setCommentShape(String commentShape) {
		this.commentShape = commentShape;
	}
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}
	public String getCommentStatus() {
		return commentStatus;
	}
	public void setCommentStatus(String commentStatus) {
		this.commentStatus = commentStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentCreateAt() {
		return commentCreateAt;
	}
	public void setCommentCreateAt(String commentCreateAt) {
		this.commentCreateAt = commentCreateAt;
	}
	
	@Override
	public String toString() {
		return "CommentDto [bbsSeq=" + bbsSeq + ", commentGroupNo=" + commentGroupNo + ", commentShape=" + commentShape
				+ ", commentSeq=" + commentSeq + ", commentStatus=" + commentStatus + ", userId=" + userId
				+ ", commentContent=" + commentContent + ", commentCreateAt=" + commentCreateAt + "]";
	}

}
