package kh.com.dao;

import java.util.List;

import kh.com.model.SuggestDto;

public interface SuggestDao {
	
	public int getCount()throws Exception;											// 총 게시글 수 
	public List<SuggestDto> getsuggestList(SuggestDto sug) throws Exception; 		// 리스트 불러오기 

	public boolean suggestWrite(SuggestDto sug) throws Exception;					// 글 쓰기 
	public SuggestDto getSuggest(int seq)throws Exception;							// 글 정보 가져오기
	
}
