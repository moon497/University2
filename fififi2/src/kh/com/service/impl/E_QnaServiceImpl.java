package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.E_QnaDao;
import kh.com.model.E_QnaDto;
import kh.com.service.E_QnaService;
import kh.com.util.Pagination;

@Service
public class E_QnaServiceImpl implements E_QnaService{

	@Autowired
	private E_QnaDao e_QnaDao;

	@Override
	public List<E_QnaDto> getQnalist(Pagination pagination) throws Exception {
		return e_QnaDao.getQnalist(pagination);
	}

	@Override
	public int getQnaCount(E_QnaDto eqna) throws Exception {
		return e_QnaDao.getQnaCount(eqna);
	}

	@Override
	public E_QnaDto getQna(int seq) throws Exception {
		return e_QnaDao.getQna(seq);
	}

	@Override
	public void uploadQna(E_QnaDto eqna) throws Exception {
		e_QnaDao.uploadQna(eqna);
	}

	@Override
	public boolean QnaaddReadcount(int seq) throws Exception {
		return e_QnaDao.QnaaddReadcount(seq);
	}

	@Override
	public boolean updatQna(E_QnaDto eqna) throws Exception {
		return e_QnaDao.updatQna(eqna);
	}
	// 댓글 위로 추가
		@Override
	public void reply(E_QnaDto eqna) throws Exception {
			e_QnaDao.replyBbsUpdate(eqna);
			e_QnaDao.replyBbsInsert(eqna);
	}
		
	// 댓글 아래로 추가
	@Override
	public boolean answerBbs(E_QnaDto eqna) throws Exception {
		int step = e_QnaDao.answerGetStep(eqna.getEclass_qna_bbs_seq());
		if(step==0) step = e_QnaDao.answerGetMaxStep(eqna.getEclass_qna_bbs_seq());
		else e_QnaDao.answerUpdate(eqna.getEclass_qna_bbs_seq(), step);
		eqna.setStep(step);
		return e_QnaDao.answerInsert(eqna);
	}

	@Override
	public int deleteQna(int seq) throws Exception {
		return e_QnaDao.deleteQna(seq);
	}
}