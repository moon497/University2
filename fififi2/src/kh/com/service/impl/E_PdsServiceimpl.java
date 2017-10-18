package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.E_PdsDao;
import kh.com.model.E_PdsBean;
import kh.com.model.E_PdsDto;
import kh.com.service.E_PdsService;
import kh.com.util.Pagination;

@Service
public class E_PdsServiceimpl implements E_PdsService{

	@Autowired
	private E_PdsDao e_PdsDao;
	
	@Override
	public List<E_PdsDto> getEPdsList(Pagination pagination) throws Exception {
		return e_PdsDao.getEPdsList(pagination);
	}
	
	@Override
	public int getPdsCount(E_PdsDto epds) throws Exception {
		return e_PdsDao.getPdsCount(epds);
	}

	
	@Override
	public void uploadPds(E_PdsBean epdsb) throws Exception{
		E_PdsDto epds = new E_PdsDto(
				epdsb.getUser_id(),
				epdsb.getTitle(),
				epdsb.getContent(),
				epdsb.getFilename(),
				epdsb.getOrg_filename(),
				epdsb.getSdate(),
				epdsb.getEdate(),
				epdsb.getSub_seq()
				);
		e_PdsDao.uploadPds(epds);
	}

	@Override
	public boolean addPdsReadcount(int seq) throws Exception {
		return e_PdsDao.addPdsReadcount(seq);
	}

	@Override
	public E_PdsDto getPds(int seq) throws Exception {
		return e_PdsDao.getPds(seq);
	}

	@Override
	public void updateEPds(E_PdsBean epdsb) throws Exception {
		E_PdsDto epds = new E_PdsDto(
				epdsb.getEclass_pds_bbs_seq(),
				epdsb.getTitle(),
				epdsb.getContent(),
				epdsb.getFilename(),
				epdsb.getOrg_filename(),
				epdsb.getSdate(),
				epdsb.getEdate()
				);
		e_PdsDao.updateEPds(epds);
	}

	@Override
	public int deleteEPds(int seq) throws Exception {
		return e_PdsDao.deleteEPds(seq);
	}
		

	

	
}
