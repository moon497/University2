package kh.com.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.E_PdsDao;
import kh.com.model.E_PdsBean;
import kh.com.model.E_PdsDto;

@Repository
public class E_PdsDaoImpl implements E_PdsDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String ns = "EPds.";
	
	@Override
	public List<E_PdsDto> getEPdsList() throws Exception {
		return sqlSession.selectList(ns+"getEPdsList");
	}

	@Override
	public void uploadPds(E_PdsDto epds) {
		sqlSession.insert(ns+"uploadPds",epds);
	}
	
}
