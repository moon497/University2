package kh.com.service;

import java.util.List;

import kh.com.model.IntroBbsDto;

public interface IntroService {
	
	public boolean IntroBbsWrite(IntroBbsDto dto) throws Exception;
	
	int getIntroCount(IntroBbsDto dto) throws Exception;
	
	public List<IntroBbsDto> IntroBbsList(IntroBbsDto dto) throws Exception;
	public IntroBbsDto introBbsDetail(int seq) throws Exception;
	public void introReadCount(int seq) throws Exception;
	public boolean introBbsUpdate(IntroBbsDto dto) throws Exception;
	public boolean introBbsDelete(int seq) throws Exception ;
	
	
	
}
