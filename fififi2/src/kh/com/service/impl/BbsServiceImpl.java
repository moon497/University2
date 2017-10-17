package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.com.dao.BbsDao;
import kh.com.dao.CommentDao;
import kh.com.model.MainBbs;
import kh.com.model.QueryBbs;
import kh.com.service.BbsService;

@Service
@Transactional
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDao bbsDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Override
	public boolean insertBbs(MainBbs dto) {
		return bbsDao.insertBbs(dto);
	}

	@Override
	public MainBbs getBbs(int seq) {
		return bbsDao.getBbs(seq);
	}

	@Override
	public List<MainBbs> getBbsList(QueryBbs query) {
		List<MainBbs> list;
		
		list = bbsDao.getBbsList(query);
		
		//댓글 갯수 가져오기
		for (MainBbs mainBbs : list) {
			int totalComment = commentDao.getTotalComment(mainBbs.getBbsSeq());
			mainBbs.setTotalComment(totalComment);
		}
		
		return list;
	}

	@Override
	public int getTotalBbs(String boardName) {
		return bbsDao.getTotalBbs(boardName);
	}

	@Override
	public boolean updateBbs(MainBbs bbs) {
		return bbsDao.updateBbs(bbs);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return bbsDao.deleteBbs(seq);
	}

}
