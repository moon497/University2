package kh.com.service;

import java.util.List;

import kh.com.model.SuggestDto;

public interface SuggestService {

	public int getCount()throws Exception;
	public List<SuggestDto> getsuggestList(SuggestDto sug) throws Exception;
	
	public boolean suggestWrite(SuggestDto sug) throws Exception;
	public SuggestDto getSuggest(int seq) throws Exception;	
}
