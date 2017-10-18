package kh.com.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.E_PdsDao;
import kh.com.model.E_PdsDto;
import kh.com.util.Pagination;

@Repository
public class E_PdsDaoImpl implements E_PdsDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String ns = "Eclass.";
	
	@Override
	public List<E_PdsDto> getEPdsList(Pagination pagination) throws Exception {
		return sqlSession.selectList(ns+"getEPdsList",pagination);
	}

	@Override
	public void uploadPds(E_PdsDto epds) throws Exception{
		System.out.println("dao :" + epds.toString());
		sqlSession.insert(ns+"uploadPds",epds);
	}
	
	@Override
	public void updateEPds(E_PdsDto epds) throws Exception {
		System.out.println("다오 : " + epds.toString());
		sqlSession.update(ns+"updateEPds",epds);
	}
	
	@Override
	public int getPdsCount(E_PdsDto epds) throws Exception {
		return sqlSession.selectOne(ns+"getPdsCount",epds);
	}

	@Override
	public boolean addPdsReadcount(int seq) throws Exception {
		int n = sqlSession.update(ns+"addPdsReadcount",seq);
		return n>0;
	}

	@Override
	public E_PdsDto getPds(int seq) throws Exception {
		return sqlSession.selectOne(ns+"getPds",seq);
	}

	@Override
	public int deleteEPds(int seq) throws Exception {
		return sqlSession.delete(ns+"deleteEPds",seq);
	}

	
	
}
