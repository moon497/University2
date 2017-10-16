package kh.com.model;

import java.io.Serializable;

public class QueryComment implements Serializable {
	private static final long serialVersionUID = -2619339902153486228L;
	
	private String boardUrl;					//게시판 제목
	private int bbsSeq;							//게시물 번호
	private int commentSeq;						//코멘트 번호
	private int commentGroupNo;					//코멘트그룹 번호
	private int startArticle;					//시작 코멘트
	private int endArticle;						//끝 코멘트
	
	public String getBoardUrl() {
		return boardUrl;
	}
	public void setBoardUrl(String boardUrl) {
		this.boardUrl = boardUrl;
	}
	public int getBbsSeq() {
		return bbsSeq;
	}
	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}
	public int getStartArticle() {
		return startArticle;
	}
	public void setStartArticle(int startArticle) {
		this.startArticle = startArticle;
	}
	public int getEndArticle() {
		return endArticle;
	}
	public void setEndArticle(int endArticle) {
		this.endArticle = endArticle;
	}
	public int getCommentGroupNo() {
		return commentGroupNo;
	}
	public void setCommentGroupNo(int commentGroupNo) {
		this.commentGroupNo = commentGroupNo;
	}
	@Override
	public String toString() {
		return "QueryComment [boardUrl=" + boardUrl + ", bbsSeq=" + bbsSeq + ", commentSeq=" + commentSeq
				+ ", commentGroupNo=" + commentGroupNo + ", startArticle=" + startArticle + ", endArticle=" + endArticle
				+ "]";
	}
	
	
}
