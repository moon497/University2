package kh.com.dao;

import java.util.List;

import kh.com.model.IntroBbsDto;

public interface IntroDao {
	
	public boolean IntroBbsWrite(IntroBbsDto dto) throws Exception; 
	public List<IntroBbsDto> IntroBbsList() throws Exception;
	public IntroBbsDto introBbsDetail(int seq) throws Exception;
	public void introReadCount(int seq) throws Exception;
	public boolean introBbsUpdate(IntroBbsDto dto) throws Exception;
	public boolean introBbsDelete(int seq) throws Exception;
}
