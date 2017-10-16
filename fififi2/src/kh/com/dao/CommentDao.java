package kh.com.dao;

import java.util.List;

import kh.com.model.CommentDto;
import kh.com.model.QueryComment;

public interface CommentDao {
	
	/*					CREATE					*/
	boolean insertComment(CommentDto comment);
	boolean insertReply(CommentDto comment);
	
	/*					READ					*/
	CommentDto getComment(int commentSeq);
	List<CommentDto> getCommentList(QueryComment query);
	List<CommentDto> getCommentReplyList(QueryComment query);
	int getTotalComment(int bbsSeq);
	
	/*					UPDATE					*/
	boolean updateComment(CommentDto comment);

	/*					DELETE					*/
	boolean deleteComment(int commentSeq);

}
