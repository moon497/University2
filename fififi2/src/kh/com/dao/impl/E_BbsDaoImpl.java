package kh.com.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.E_BbsDao;
import kh.com.model.E_BbsDto;
import kh.com.model.ProfEvaluationDTO;
import kh.com.util.Pagination;

@Repository
public class E_BbsDaoImpl implements E_BbsDao{
	private static final Logger logger = LoggerFactory.getLogger(E_BbsDaoImpl.class);

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String ns = "Eclass.";
	
	@Override
	public List<E_BbsDto> getEBbsList(Pagination pagination) throws Exception {
		return sqlSession.selectList(ns+"getEBbsList",pagination);
	}


	@Override
	public E_BbsDto getBbs(int seq) throws Exception {
		return sqlSession.selectOne(ns+"getEbbs",seq);
	}


	@Override
	public boolean addReadcount(int seq) throws Exception {
		int n = sqlSession.update(ns+"addReadcount", seq);
		return n>0;
	}

	@Override
	public void uploadBbs(E_BbsDto edto) {
		sqlSession.insert(ns+"uploadBbs",edto);
	}


	@Override
	public int getBbsCount(E_BbsDto edto) throws Exception {
		return sqlSession.selectOne(ns+"getBbsCount",edto);
	}


	@Override
	public boolean updateEBbs(E_BbsDto edto) {
		int n = sqlSession.update(ns+"updateEBbs",edto);
		return n>0;
	}


	@Override
	public List<ProfEvaluationDTO> ProfEvaluation(ProfEvaluationDTO info) throws Exception {
		List<ProfEvaluationDTO> elist = sqlSession.selectList(ns + "SelectSubNames", info);
		return elist;
	}


	@Override
	public int deleteEBbs(int seq) {
		return sqlSession.delete(ns+"deleteEBbs",seq);
	}

	
	
}
