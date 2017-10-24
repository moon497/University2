package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.BbsDao;
import kh.com.model.Post;

@Repository
public class BbsDaoImpl implements BbsDao {
	private static final Logger logger = LoggerFactory.getLogger(BbsDaoImpl.class);
	private final String ns = "Post.";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Post> getBbsList(Post query) {
		logger.info("getBbsList");
		
		return sqlSession.selectList(ns+"getBbsList",query);
	}

	@Override
	public boolean insertBbs(Post bbs) {
		
		return sqlSession.insert(ns + "insertBbs", bbs) > 0 ? true:false;
		
	}

	@Override
	public int getTotalBbs(int boardSeq) {
		return sqlSession.selectOne(ns+"getTotalBbs", boardSeq);
	}

	@Override
	public Post getBbs(int bbsSeq) {
		return sqlSession.selectOne(ns+"getBbs",bbsSeq);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return sqlSession.update(ns + "deleteBbs", seq) > 0 ? true:false;
	}

	@Override
	public boolean updateBbs(Post bbs) {
		logger.info("진입");
		
		return sqlSession.update(ns + "updateBbs", bbs) > 0 ? true:false;
	}
}