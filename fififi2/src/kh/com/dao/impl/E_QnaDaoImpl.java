package kh.com.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.E_QnaDao;
import kh.com.model.E_QnaDto;
import kh.com.util.Pagination;

@Repository
public class E_QnaDaoImpl implements E_QnaDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String ns = "Eclass.";
	@Override
	public List<E_QnaDto> getQnalist(Pagination pagination) throws Exception {
		return sqlSession.selectList(ns+"getQnalist", pagination);
	}
	@Override
	public int getQnaCount(E_QnaDto eqna) throws Exception {
		return sqlSession.selectOne(ns+"getQnaCount",eqna);
	}
	@Override
	public E_QnaDto getQna(int seq) throws Exception {
		return sqlSession.selectOne(ns+"getQna",seq);
	}
	@Override
	public void uploadQna(E_QnaDto eqna) throws Exception {
		sqlSession.update(ns+"uploadQna",eqna);
	}
	@Override
	public boolean QnaaddReadcount(int seq) throws Exception {
		int n = sqlSession.update(ns+"QnaaddReadcount",seq);
		return n>0;
	}
	@Override
	public boolean updatQna(E_QnaDto eqna) throws Exception {
		int n = sqlSession.update(ns+"updatQna", eqna);
		return n>0;
	}
	/*댓글 위로 추가*/
	@Override
	public boolean replyBbsUpdate(E_QnaDto eqna) throws Exception {
		int n = sqlSession.update(ns+"replyBbsUpdate", eqna);
		return n>0;
	}

	@Override
	public boolean replyBbsInsert(E_QnaDto eqna) throws Exception {
		int n = sqlSession.update(ns+"replyBbsInsert", eqna);
		return n>0;
	}
	/*댓글 아래로 추가*/
	@Override
	public int answerGetStep(int seq) throws Exception {
		return sqlSession.selectOne(ns+"answer_getstep", seq);
	}
	@Override
	public int answerGetMaxStep(int seq) throws Exception {
		return sqlSession.selectOne(ns+"answer_getmaxstep", seq);
	}
	
	@Override
	public boolean answerUpdate(int seq, int step) throws Exception {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("seq", seq);
		map.put("step", step );
		int n = sqlSession.update(ns+"answer_update", map);
		return n>0;
	}
	
	@Override
	public boolean answerInsert(E_QnaDto eqna) throws Exception {
		int n = sqlSession.insert(ns+"answer_insert", eqna);
		return n>0?true:false;
	}
	@Override
	public int deleteQna(int seq) throws Exception {
		return sqlSession.update(ns+"deleteQna",seq);
	}

}