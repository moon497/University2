package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.SuggestDao;
import kh.com.model.SuggestDto;
import kh.com.service.SuggestService;

@Service
public class SuggestServiceImpl implements SuggestService {
	
	@Autowired
	SuggestDao suggestDao;

	@Override
	public int getCount() throws Exception {		
		return suggestDao.getCount();
	}

	@Override
	public List<SuggestDto> getsuggestList(SuggestDto sug) throws Exception {		
		return suggestDao.getsuggestList(sug);
	}

	@Override
	public boolean suggestWrite(SuggestDto sug) throws Exception {		
		return suggestDao.suggestWrite(sug);
	}

	@Override
	public SuggestDto getSuggest(int seq) throws Exception {
		return suggestDao.getSuggest(seq);
	}
	
	
}
