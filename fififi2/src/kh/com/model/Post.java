package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1843374038002416069L;
	
	private int boardSeq;
	private int bbsRef;
	private String bbsReply;
	private int bbsSeq;
	private String userId;
	private String bbsTitle;
	private String bbsContent;
	private int bbsReadCount;
	private String bbsStoredFileName;
	private String bbsOrgFileName;
	private String bbsStatus;
	private String bbsWdate;
	
	//List용 추가 변수
	private int totalComment;
	
	//join용 추가 변수
	private String userName;
	
	//Query용 추가 변수
	private int startArticle;					//시작 게시물
	private int endArticle;						//끝 게시물

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public int getBbsRef() {
		return bbsRef;
	}

	public void setBbsRef(int bbsRef) {
		this.bbsRef = bbsRef;
	}

	public String getBbsReply() {
		return bbsReply;
	}

	public void setBbsReply(String bbsReply) {
		this.bbsReply = bbsReply;
	}

	public int getBbsSeq() {
		return bbsSeq;
	}

	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBbsTitle() {
		return bbsTitle;
	}

	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}

	public String getBbsContent() {
		return bbsContent;
	}

	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}

	public int getBbsReadCount() {
		return bbsReadCount;
	}

	public void setBbsReadCount(int bbsReadCount) {
		this.bbsReadCount = bbsReadCount;
	}

	public String getBbsStoredFileName() {
		return bbsStoredFileName;
	}

	public void setBbsStoredFileName(String bbsStoredFileName) {
		this.bbsStoredFileName = bbsStoredFileName;
	}

	public String getBbsOrgFileName() {
		return bbsOrgFileName;
	}

	public void setBbsOrgFileName(String bbsOrgFileName) {
		this.bbsOrgFileName = bbsOrgFileName;
	}

	public String getBbsStatus() {
		return bbsStatus;
	}

	public void setBbsStatus(String bbsStatus) {
		this.bbsStatus = bbsStatus;
	}

	public String getBbsWdate() {
		return bbsWdate;
	}

	public void setBbsWdate(String bbsWdate) {
		this.bbsWdate = bbsWdate;
	}

	public int getTotalComment() {
		return totalComment;
	}

	public void setTotalComment(int totalComment) {
		this.totalComment = totalComment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return "Post [boardSeq=" + boardSeq + ", bbsRef=" + bbsRef + ", bbsReply=" + bbsReply + ", bbsSeq=" + bbsSeq
				+ ", userId=" + userId + ", bbsTitle=" + bbsTitle + ", bbsContent=" + bbsContent + ", bbsReadCount="
				+ bbsReadCount + ", bbsStoredFileName=" + bbsStoredFileName + ", bbsOrgFileName=" + bbsOrgFileName
				+ ", bbsStatus=" + bbsStatus + ", bbsWdate=" + bbsWdate + ", totalComment=" + totalComment
				+ ", userName=" + userName + ", startArticle=" + startArticle + ", endArticle=" + endArticle + "]";
	}
	

	
	
}
