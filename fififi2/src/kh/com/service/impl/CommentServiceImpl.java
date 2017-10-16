package kh.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.com.controller.CommentController;
import kh.com.dao.CommentDao;
import kh.com.model.CommentDto;
import kh.com.model.QueryComment;
import kh.com.service.CommentService;
import kh.com.util.CommentReply;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	private static final Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);

	@Autowired
	CommentDao dao;

	@Override
	public boolean insertComment(CommentDto comment) {
		return dao.insertComment(comment);
	}

	@Override
	public boolean insertReply(CommentDto comment) {
		logger.info("진입");
		//init
        QueryComment query;
        //init
        query = new QueryComment();

		query.setCommentGroupNo(comment.getCommentGroupNo());
        
		List<CommentDto> list = dao.getCommentReplyList(query);

		CommentReply reply = new CommentReply(list, comment.getCommentShape());
		
		comment.setCommentShape(reply.getCommentShape());
		
		logger.info("comment: {}",comment.toString());
		
		return dao.insertReply(comment);
	}

	@Override
	public CommentDto getComment(int commentSeq) {
		return dao.getComment(commentSeq);
	}

	@Override
	public List<CommentDto> getCommentList(QueryComment query) {
		return dao.getCommentList(query);
	}
	@Override
	public List<CommentDto> getCommentReplyList(QueryComment query) {
		return dao.getCommentReplyList(query);
	}

	@Override
	public int getTotalComment(int bbsSeq) {
		return dao.getTotalComment(bbsSeq);
	}

	@Override
	public boolean updateComment(CommentDto comment) {
		return dao.updateComment(comment);
	}

	@Override
	public boolean deleteComment(int commentSeq) {
		return dao.deleteComment(commentSeq);
	}

}
