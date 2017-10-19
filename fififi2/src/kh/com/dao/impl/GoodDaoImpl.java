package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.GoodDao;
import kh.com.model.GoodDto;
import kh.com.model.MainBbs;
import kh.com.model.QueryBbs;

@Repository
public class GoodDaoImpl implements GoodDao {
	private static final Logger logger = LoggerFactory.getLogger(GoodDaoImpl.class);
	private final String ns = "Goods.";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public boolean insertGood(GoodDto good) {
		logger.info("진입");
		
		return sqlSession.insert(ns+"insertGood", good) > 0 ? true : false;
	}

	@Override
	public GoodDto getGood(int seq) {
		return sqlSession.selectOne(ns+"getGood", seq);
	}

	@Override
	public List<GoodDto> getGoodList(GoodDto good) {
		logger.info("진입");
		
		return sqlSession.selectList(ns+"getGoodList", good);
	}

	@Override
	public int getTotalBbs(String boardName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateBbs(MainBbs bbs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGood(int seq) {
		logger.info("진입");
		
		return sqlSession.update(ns+"deleteGood", seq) > 0 ? true : false;
	}

}