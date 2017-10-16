package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.BbsDao;
import kh.com.model.MainBbs;
import kh.com.model.QueryBbs;

@Repository
public class BbsDaoImpl implements BbsDao {
	private static final Logger logger = LoggerFactory.getLogger(BbsDaoImpl.class);
	private final String ns = "MainBbs.";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<MainBbs> getBbsList(QueryBbs query) {
		logger.info("getBbsList");
		
		return sqlSession.selectList(ns+"getBbsList",query);
	}

	@Override
	public boolean insertBbs(MainBbs bbs) {
		
		return sqlSession.insert(ns + "insertBbs", bbs) > 0 ? true:false;
		
	}

	@Override
	public int getTotalBbs(String boardName) {
		return sqlSession.selectOne(ns+"getTotalBbs", boardName);
	}

	@Override
	public MainBbs getBbs(int bbsSeq) {
		return sqlSession.selectOne(ns+"getBbs",bbsSeq);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return sqlSession.update(ns + "deleteBbs", seq) > 0 ? true:false;
	}

	@Override
	public boolean updateBbs(MainBbs bbs) {
		logger.info("진입");
		
		return sqlSession.update(ns + "updateBbs", bbs) > 0 ? true:false;
	}
}