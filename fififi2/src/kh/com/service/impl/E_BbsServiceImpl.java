package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.E_BbsDao;
import kh.com.model.E_BbsDto;
import kh.com.model.ProfEvaluationDTO;
import kh.com.service.E_BbsService;
import kh.com.util.Pagination;

@Service
public class E_BbsServiceImpl implements E_BbsService{

	@Autowired
	private E_BbsDao e_BbsDao;
	
	@Override
	public List<E_BbsDto> getEBbsList(Pagination pagination) throws Exception {
		return e_BbsDao.getEBbsList(pagination);
	}

	@Override
	public E_BbsDto getBbs(int seq) throws Exception {
		return e_BbsDao.getBbs(seq);
	}

	@Override
	public boolean addReadcount(int seq) throws Exception {
		return e_BbsDao.addReadcount(seq);
	}

	@Override
	public void uploadBbs(E_BbsDto edto) {
		e_BbsDao.uploadBbs(edto);
	}

	@Override
	public int getBbsCount(E_BbsDto edto) throws Exception {
		return e_BbsDao.getBbsCount(edto);
	}

	@Override
	public boolean updateEBbs(E_BbsDto edto) throws Exception{
		return e_BbsDao.updateEBbs(edto);
	}

	@Override
	public List<ProfEvaluationDTO> ProfEvaluation(ProfEvaluationDTO info) throws Exception {
		List<ProfEvaluationDTO> eclist = e_BbsDao.ProfEvaluation(info);
		return eclist;
	}

	@Override
	public int deleteEBbs(int seq) throws Exception{
		return e_BbsDao.deleteEBbs(seq);
	}

}
