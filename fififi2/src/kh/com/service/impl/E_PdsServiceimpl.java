package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.E_PdsDao;
import kh.com.model.E_PdsBean;
import kh.com.model.E_PdsDto;
import kh.com.service.E_PdsService;

@Service
public class E_PdsServiceimpl implements E_PdsService{

	@Autowired
	private E_PdsDao e_PdsDao;
	
	@Override
	public List<E_PdsDto> getEPdsList() throws Exception {
		return e_PdsDao.getEPdsList();
	}
	
	@Override
	public void uploadPds(E_PdsBean epdsb) {
		E_PdsDto epds = new E_PdsDto(
				epdsb.getUser_id(),
				epdsb.getTitle(),
				epdsb.getContent(),
				epdsb.getFilename(),
				epdsb.getOrg_filename(),
				epdsb.getSdate(),
				epdsb.getEdate()
				);

		System.out.println(" 서비스   : " + epds.toString());
		e_PdsDao.uploadPds(epds);

	}

}
