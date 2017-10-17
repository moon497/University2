package kh.com.dao;

import java.util.List;

import kh.com.model.I_ProfEvaluationDTO;
import kh.com.model.I_StudentBasicInfoDTO;
import kh.com.model.I_StudentGradeDTO;
import kh.com.model.I_semesterGradeDTO;

public interface I_IntraDao {

	// 해당학생이 평가해야할 강의목록 불러오기
	public List<I_ProfEvaluationDTO> ProfEvaluation(I_ProfEvaluationDTO info) throws Exception;
	
	// 교수평가 점수넣기
	public boolean addProfessorGrade(I_ProfEvaluationDTO pdfo) throws Exception;
	
	// 성적확인
	public List<I_StudentGradeDTO> StudentGradeCheck(I_ProfEvaluationDTO Sgrade) throws Exception;
	
	// 내정보(학생) : 기본학생정보
	public I_StudentBasicInfoDTO studentBasicInfo(String id) throws Exception;
	
	// 내정보 수정(학생) : 기본학생정보
	public boolean updateStudentInfo(I_StudentBasicInfoDTO info) throws Exception;
	
	// 학생 총 수료학기 증가(다른의미로 학년으로 볼 수 있음)
	public boolean studentTotalsemester(String id) throws Exception;
	
	// 학년 / 학기별 성적 검색
	public List<I_semesterGradeDTO> semesterGrade (I_semesterGradeDTO grade);

	// 학년 / 학기별 성정검색
	public List<I_semesterGradeDTO> semesterGradechoice (I_semesterGradeDTO grade);
}
