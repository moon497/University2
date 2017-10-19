package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.controller.MemberController;
import kh.com.dao.EnrolmentDao;
import kh.com.model.QuerySubjectDto;
import kh.com.model.SubjectDto;

@Repository
public class EnrolmentDaoImpl implements EnrolmentDao {
	private static final Logger logger = LoggerFactory.getLogger(EnrolmentDaoImpl.class);
	
	
	@Autowired
	SqlSession sqlSession;
	
	private String ns = "Enrolment.";

	@Override
	public boolean addSubject(SubjectDto sub) throws Exception {
		int n = sqlSession.insert(ns + "addSubject", sub);
		return n>0?true:false;
	}

	@Override
	public List<SubjectDto> getSublist(String id) throws Exception {		
		return sqlSession.selectList(ns + "getSublist", id);
	}

	@Override
	public SubjectDto getReg(int seq) throws Exception {
		return sqlSession.selectOne(ns + "getReg", seq);
	}

	@Override
	public boolean addClassTime(SubjectDto sub) throws Exception {
		int n = sqlSession.insert(ns + "addClassTime", sub);
		return n>0?true:false;
	}

	@Override
	public void deleteReg(int seq) throws Exception {
		sqlSession.delete(ns+"deleteReg", seq);		
	}

	@Override
	public List<SubjectDto> getEnrollist(QuerySubjectDto query) throws Exception {	
		logger.info("진입");
		
		logger.info("query: {}",query.toString());
		
		return sqlSession.selectList(ns+"getEnrollist", query);
	}

	@Override
	public boolean updateReg(SubjectDto sub) throws Exception {		
		int n = sqlSession.update(ns+"updateReg", sub);
		return n>0?true:false;
	}

	
	
	
}
