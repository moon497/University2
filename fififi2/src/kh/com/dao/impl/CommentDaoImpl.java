package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.CommentDao;
import kh.com.model.CommentDto;
import kh.com.model.QueryComment;

@Repository
public class CommentDaoImpl implements CommentDao {
	private static final Logger logger = LoggerFactory.getLogger(CommentDaoImpl.class);
	private final String ns = "Comments.";
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public boolean insertComment(CommentDto comment) {		
		return sqlSession.insert(ns + "insertComment", comment) > 0 ? true:false;
	}

	@Override
	public boolean insertReply(CommentDto comment) {
		return sqlSession.insert(ns + "insertReply", comment) > 0 ? true:false;
	}

	@Override
	public CommentDto getComment(int commentSeq) {
		return sqlSession.selectOne(ns+"getComment",commentSeq);
	}

	@Override
	public List<CommentDto> getCommentList(QueryComment query) {
		logger.info("getCommentList");
		
		return sqlSession.selectList(ns+"getCommentList",query);
	}
	@Override
	public List<CommentDto> getCommentReplyList(QueryComment query) {
		logger.info("진입");
		
		return sqlSession.selectList(ns+"getCommentReplyList",query);
	}

	@Override
	public int getTotalComment(int bbsSeq) {
		return sqlSession.selectOne(ns+"getTotalComment", bbsSeq);
	}

	@Override
	public boolean updateComment(CommentDto comment) {
		return sqlSession.update(ns + "updateComment", comment) > 0 ? true:false;
	}

	@Override
	public boolean deleteComment(int commentSeq) {
		return sqlSession.update(ns + "deleteComment", commentSeq) > 0 ? true:false;
	}
}