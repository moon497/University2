package kh.com.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.E_QnaDao;

@Repository
public class E_QnaDaoImpl implements E_QnaDao{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private String ns = "Eclass.";
	

}
