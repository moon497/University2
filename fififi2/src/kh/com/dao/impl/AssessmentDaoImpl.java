package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.AssessmentDao;
import kh.com.model.AssessmentDto;
import kh.com.model.SubjectDto;

@Repository
public class AssessmentDaoImpl implements AssessmentDao {
	private static final Logger logger = LoggerFactory.getLogger(AssessmentDaoImpl.class);
	
	@Autowired
	SqlSession sqlSession;
	
	String ns = "Assessment.";
	
	@Override
	public boolean addSub(AssessmentDto as) throws Exception {
		int n = sqlSession.insert(ns + "addSub", as);
		return n>0?true:false;
	}

	@Override
	public List<SubjectDto> getAsListFromUser(String user_id) {
		logger.info("진입");
		return sqlSession.selectList(ns+"getAsListFromUser", user_id);
	}

	@Override
	public boolean deleteAs(int sub_seq) {
		int n = sqlSession.insert(ns + "deleteAs", sub_seq);
		return n>0?true:false;
	}

	@Override
	public List<AssessmentDto> scoreList(AssessmentDto dto) {
		logger.info("진입");
		return sqlSession.selectList(ns+"scoreList", dto);
	}

	@Override
	public boolean updateScore(AssessmentDto dto) {
		logger.info("진입");
		return sqlSession.update(ns+"updateScore", dto) > 0 ? true:false;
	}

	
	
}
