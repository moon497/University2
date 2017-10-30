package kh.com.dao;

import java.util.List;

import kh.com.model.E_QnaDto;
import kh.com.util.Pagination;

public interface E_QnaDao {
	public List<E_QnaDto> getQnalist(Pagination pagination) throws Exception;
	public int getQnaCount(E_QnaDto eqna) throws Exception; 
	public E_QnaDto getQna(int seq) throws Exception;
	public void uploadQna(E_QnaDto eqna) throws Exception;
	public boolean QnaaddReadcount(int seq) throws Exception;
	public boolean updatQna(E_QnaDto eqna) throws Exception;
	public int deleteQna(int seq) throws Exception;

	
	
	public boolean replyBbsUpdate(E_QnaDto eqna) throws Exception;	
	public boolean replyBbsInsert(E_QnaDto eqna) throws Exception;	
	public boolean answerInsert(E_QnaDto eqna) throws Exception;
	public boolean answerUpdate(int seq, int step) throws Exception;
	public int answerGetMaxStep(int seq) throws Exception;
	public int answerGetStep(int seq) throws Exception;
}
