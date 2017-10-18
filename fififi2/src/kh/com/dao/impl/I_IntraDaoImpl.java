package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.I_IntraDao;
import kh.com.model.ProfEvaluationDTO;
import kh.com.model.I_StudentBasicInfoDTO;
import kh.com.model.I_StudentGradeDTO;
import kh.com.model.I_semesterGradeDTO;

@Repository
public class I_IntraDaoImpl implements I_IntraDao {
	private static final Logger logger = LoggerFactory.getLogger(I_IntraDaoImpl.class);
		
	@Autowired
	SqlSession sqlsession;
	
	// 강의평가
	private String intra = "Intranet.";
	
	// 성적확인
	private String studentGrade = "studentGrade.";
	
	/**
	 * 해당학생이 평가해야할 강의목록 불러오기
	 */
	@Override
	public List<ProfEvaluationDTO> ProfEvaluation(ProfEvaluationDTO info) throws Exception {
		List<ProfEvaluationDTO> list = sqlsession.selectList(intra + "SelectSubNames", info);
		return list;
	}
	
	/**
	 * 교수평가 점수넣기
	 */
	@Override
	public boolean addProfessorGrade(ProfEvaluationDTO pdfo) throws Exception {
		int i = 0;
		i = sqlsession.update(intra+"addAssessment", pdfo);
		return i!=0?true:false;
	}
	
	/**
	 * 성적확인
	 */
	@Override
	public List<I_StudentGradeDTO> StudentGradeCheck(ProfEvaluationDTO Sgrade) throws Exception {
		List<I_StudentGradeDTO> PSdto = sqlsession.selectList(studentGrade+"studentGrade", Sgrade);
		return PSdto;
	}
	
	/**
	 * 내정보(학생) : 기본학생정보
	 */
	@Override
	public I_StudentBasicInfoDTO studentBasicInfo(String id) throws Exception {
		I_StudentBasicInfoDTO basicInfo = sqlsession.selectOne(intra+"studentBasicInfo", id);
		return basicInfo;
	}

	/**
	 * 내정보 수정(학생) : 기본학생정보
	 */
	@Override
	public boolean updateStudentInfo(I_StudentBasicInfoDTO info) throws Exception {
		int i = 0;
		i = sqlsession.update(intra + "updateStudentInfo", info);
		return i!=0?true:false;
	}
	
	/**
	 * 학생 총 수료학기 증가(다른의미로 학년으로 볼 수 있음)
	 */
	@Override
	public boolean studentTotalsemester(String id) throws Exception {
		int totalsemester = sqlsession.update(intra+"updateTotalsemester", id);
		return totalsemester!=0?true:false;
	}
	
	/**
	 * 학년 / 학기별 성적 검색
	 */
	@Override
	public List<I_semesterGradeDTO> semesterGrade(I_semesterGradeDTO grade) {
		List<I_semesterGradeDTO> list = sqlsession.selectList(intra+"semesterGrade", grade);
		return list;
	}
	
	/**
	 * 학년 / 학기별 성정검색
	 */
	@Override
	public List<I_semesterGradeDTO> semesterGradechoice(I_semesterGradeDTO grade) {
		List<I_semesterGradeDTO> list = sqlsession.selectList(intra+"semesterGradechoice", grade);
		return list;
	}

}
