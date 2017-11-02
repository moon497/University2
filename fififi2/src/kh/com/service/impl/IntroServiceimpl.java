package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.impl.IntroDaoImpl;
import kh.com.model.IntroBbsDto;
import kh.com.service.IntroService;


@Service
public class IntroServiceimpl implements IntroService {

	@Autowired
	IntroDaoImpl introDao;

	@Override
	public boolean IntroBbsWrite(IntroBbsDto dto) throws Exception {
		System.out.println("IntroBbsWrite 서비스임플" +dto.toString());
		return introDao.IntroBbsWrite(dto);
	}
	
	
	@Override
	public int getIntroCount(IntroBbsDto dto) throws Exception {
		return introDao.getIntroCount(dto);
	}


	@Override
	public List<IntroBbsDto> IntroBbsList(IntroBbsDto dto) throws Exception{
		return introDao.IntroBbsList(dto);
	}

	@Override
	public IntroBbsDto introBbsDetail(int seq) throws Exception {
		return introDao.introBbsDetail(seq);
	}

	@Override
	public void introReadCount(int seq) throws Exception {
		introDao.introReadCount(seq);
	}

	@Override
	public boolean introBbsUpdate(IntroBbsDto dto) throws Exception {
		return introDao.introBbsUpdate(dto);
	}

	@Override
	public boolean introBbsDelete(int seq) throws Exception {
	    return introDao.introBbsDelete(seq);
	}
	
}
	
	
	
	
	
	
	
	


