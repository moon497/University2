package kh.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.GoodDao;
import kh.com.model.GoodDto;
import kh.com.model.Post;
import kh.com.service.GoodService;

@Service
public class GoodServiceImpl implements GoodService {
	private static final Logger logger = LoggerFactory.getLogger(GoodServiceImpl.class);
	
	@Autowired
	GoodDao dao;

	@Override
	public boolean insertGood(GoodDto good) {
		logger.info("진입");
		
		return dao.insertGood(good);
	}

	@Override
	public GoodDto getGood(int seq) {
		return dao.getGood(seq);
	}
	
	@Override
	public List<GoodDto> getGoodList(GoodDto good) {
		logger.info("진입");
		
		return dao.getGoodList(good);
	}

	@Override
	public int getTotalBbs(String boardName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateBbs(Post bbs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGood(int seq) {
		return dao.deleteGood(seq);
	}

}