package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kh.com.dao.BbsDao;
import kh.com.dao.CommentDao;
import kh.com.model.Post;
import kh.com.service.BbsService;

@Service
@Transactional
public class BbsServiceImpl implements BbsService {

	@Autowired
	BbsDao bbsDao;
	
	@Autowired
	CommentDao commentDao;
	
	@Override
	public boolean insertBbs(Post dto) {
		return bbsDao.insertBbs(dto);
	}

	@Override
	public Post getBbs(int seq) {
		return bbsDao.getBbs(seq);
	}

	@Override
	public List<Post> getBbsList(Post query) {
		List<Post> list;
		
		list = bbsDao.getBbsList(query);
		
		//댓글 갯수 가져오기
		for (Post mainBbs : list) {
			int totalComment = commentDao.getTotalComment(mainBbs.getBbsSeq());
			mainBbs.setTotalComment(totalComment);
		}
		
		return list;
	}

	@Override
	public int getTotalBbs(int boardSeq) {
		return bbsDao.getTotalBbs(boardSeq);
	}

	@Override
	public boolean updateBbs(Post bbs) {
		return bbsDao.updateBbs(bbs);
	}

	@Override
	public boolean deleteBbs(int seq) {
		return bbsDao.deleteBbs(seq);
	}

}
