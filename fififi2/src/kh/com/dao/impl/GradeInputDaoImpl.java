package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.GradeInputDao;
import kh.com.model.MemberDto;
import kh.com.model.SubjectDto;

@Repository
public class GradeInputDaoImpl implements GradeInputDao {

	@Autowired
	SqlSession sqlSession;
	private String ns = "GradeInput.";
	
	
	
	@Override
	public List<SubjectDto> gradeinputlist(MemberDto dto) {
		List<SubjectDto> list = sqlSession.selectList(ns + "gradeInput_List", dto);
		return list;
	}
	
	

}
  