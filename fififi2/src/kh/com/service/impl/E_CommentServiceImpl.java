package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.E_BbsDao;
import kh.com.dao.E_CommentDao;
import kh.com.model.E_CommentDto;
import kh.com.service.E_CommentService;

@Service
public class E_CommentServiceImpl implements E_CommentService{


	@Autowired
	private E_CommentDao e_CommentDao;
	
	@Override
	public List<E_CommentDto> getClist(int seq) throws Exception {
		return e_CommentDao.getClist(seq);
	}

	@Override
	public void uploadComment(E_CommentDto cdto) throws Exception {
		e_CommentDao.uploadComment(cdto);
	}

	@Override
	public int deleteComment(int seq) throws Exception {
		return e_CommentDao.deleteComment(seq);
	}
	
}
