package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.SuggestDao;
import kh.com.model.SuggestDto;

@Repository
public class SuggestDoaImpl implements SuggestDao {

	@Autowired
	SqlSession sqlSession;
	
	String ns = "suggest.";
	
	@Override
	public int getCount() throws Exception {
		int n = sqlSession.selectOne(ns+"getCount");
		return n;
	}

	@Override
	public List<SuggestDto> getsuggestList(SuggestDto sug) throws Exception {		
		return sqlSession.selectList(ns+"getSuggestList", sug);
	}

	@Override
	public boolean suggestWrite(SuggestDto sug) throws Exception {
		int n = sqlSession.insert(ns+"suggestWrite", sug);
		return n>0?true:false;
	}

	@Override
	public SuggestDto getSuggest(int seq) throws Exception {		
		return sqlSession.selectOne(ns+"getSuggest", seq);
	}

	@Override
	public boolean suggestDelete(int seq) throws Exception {		
		int n = sqlSession.update(ns+"suggestDelete", seq);
		return n>0?true:false;
	}

	@Override
	public boolean suggestUpdate(SuggestDto sug) throws Exception {
		int n = sqlSession.update(ns+"suggestUpdate", sug);
		return n>0?true:false;
	}
	
	

	
}
