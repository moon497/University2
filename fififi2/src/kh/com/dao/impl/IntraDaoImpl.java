package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.IntraDao;
import kh.com.model.ProfEvaluationDTO;

@Repository
public class IntraDaoImpl implements IntraDao {
	private static final Logger logger = LoggerFactory.getLogger(IntraDaoImpl.class);
		
	@Autowired
	SqlSession sqlsession;
	
	private String ns = "Intranet.";
	
	/**
	 * 해당학생이 평가해야할 강의목록 불러오기
	 */
	@Override
	public List<ProfEvaluationDTO> ProfEvaluation(ProfEvaluationDTO info) throws Exception {
		List<ProfEvaluationDTO> list = sqlsession.selectList(ns + "SelectSubNames", info);
		return list;
	}
	
	/**
	 * 교수평가 점수넣기
	 */
	@Override
	public boolean addProfessorGrade(ProfEvaluationDTO pdfo) throws Exception {
		int i = 0;
		i = sqlsession.update(ns+"addAssessment", pdfo);
		System.out.println("IntraDaoImpl : " + i);
		return i!=0?true:false;
	}

}
