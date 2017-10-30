package kh.com.service;

import java.util.List;

import kh.com.model.E_QnaDto;
import kh.com.util.Pagination;

public interface E_QnaService {
	public List<E_QnaDto> getQnalist(Pagination pagination) throws Exception;
	public int getQnaCount(E_QnaDto eqna) throws Exception; 
	public E_QnaDto getQna(int seq) throws Exception;
	public void uploadQna(E_QnaDto eqna) throws Exception;
	public boolean QnaaddReadcount(int seq) throws Exception;
	public boolean updatQna(E_QnaDto eqna) throws Exception;
	public int deleteQna(int seq) throws Exception;

	
	
	public void reply(E_QnaDto eqna) throws Exception;
	public boolean answerBbs(E_QnaDto eqna) throws Exception;
}
