package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.EnrolmentDao;
import kh.com.model.EnrollDto;
import kh.com.model.SubjectDto;
import kh.com.service.impl.EnrolmentServiceImpl;

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
	public List<SubjectDto> getEnrollist(String major) throws Exception {		
		return sqlSession.selectList(ns+"getEnrollist", major);
	}

	@Override
	public List<SubjectDto> getEnrollListFromUser(String user_id) {
		logger.info("진입");
		return sqlSession.selectList(ns+"getEnrollListFromUser", user_id);
	}

	@Override
	public boolean deleteEnroll(int sub_seq) {
		int n = sqlSession.insert(ns + "deleteEnroll", sub_seq);
		return n>0?true:false;
	}
	
	
	
}
