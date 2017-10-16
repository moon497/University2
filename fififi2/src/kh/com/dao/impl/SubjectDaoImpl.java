package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.SubjectDao;
import kh.com.model.SubjectDto;

@Service
public class SubjectDaoImpl implements SubjectDao {
	private static final Logger logger = LoggerFactory.getLogger(SubjectDaoImpl.class);
	private static final String ns = "Subject.";
	
	@Autowired
	SqlSession session;

	@Override
	public List<SubjectDto> getSubjectList(String professorId) {
		logger.info("진입");
		return session.selectList(ns+"getSubjectList", professorId);
	}

}
