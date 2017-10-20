package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.AssessmentDao;
import kh.com.model.AssessmentDto;
import kh.com.model.MemberDto;
import kh.com.model.StudentDTO;
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
	public boolean deleteAs(AssessmentDto as) {
		int n = sqlSession.insert(ns + "deleteAs", as);
		return n>0?true:false;
	}

	@Override
	public boolean addnowStudent(int sub_seq) throws Exception {
		int n = sqlSession.update(ns+"addnowStudent", sub_seq);
		return n>0?true:false;
	}

	@Override
	public boolean minusNowStudent(int sub_seq) throws Exception {
		int n = sqlSession.update(ns+"minusNowStudent", sub_seq);
		return n>0?true:false;
	}

	@Override
	public List<AssessmentDto> sumPoint(String student_id) throws Exception {
		return sqlSession.selectList(ns+"sumPoint", student_id);
	}

	@Override
	public StudentDTO getStudent(String student_id) throws Exception {
		return sqlSession.selectOne(ns+"getStudent", student_id);
	}

	@Override
	public MemberDto getProf(String prof_id) throws Exception {		
		return sqlSession.selectOne(ns+"getProf", prof_id);
	}	
	
	@Override
	public MemberDto getUsers(String user_id) throws Exception {
		MemberDto dto;
		
		dto = sqlSession.selectOne(ns+"getUsers", user_id);
		
		System.out.println("dto: " + dto.toString());
		
		return dto;
	}

	@Override
	public boolean updateProInfo(MemberDto mem) throws Exception {
		System.out.println("updateProInfo daoimpl");
		System.out.println("prof 변경 : " + mem.toString());
		
		int n = sqlSession.update(ns+"updateProInfo", mem);
		return n>0?true:false;
	}

	@Override
	public boolean updateProInfo2(MemberDto mem) throws Exception {
		System.out.println("updateProInfo2 daoimpl");
		System.out.println("users 변경 : " + mem.toString());
		
		int n = sqlSession.update(ns+"updateProInfo2", mem);
		return n>0?true:false;
	}

	//정혜
	@Override
	public List<AssessmentDto> gradeList(AssessmentDto dto) {
		logger.info("진입");
		return sqlSession.selectList(ns+"gradeList", dto);
	}

	@Override
	public boolean gradeUpdate(AssessmentDto dto) {
		logger.info("진입");
		return sqlSession.update(ns+"gradeUpdate", dto) > 0 ? true:false;
	}

	
	
}
