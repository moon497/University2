package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.I_IntraDao;
import kh.com.model.ProfEvaluationDTO;
import kh.com.model.StudentDTO;
import kh.com.model.I_StudentBasicInfoDTO;
import kh.com.model.I_StudentGradeDTO;
import kh.com.model.I_semesterGradeDTO;
import kh.com.service.I_IntraService;

@Service
public class I_IntraServiceImpl implements I_IntraService {
	
	@Autowired
	I_IntraDao khIntraDao;

	/**
	 * 학생정보 받아오기
	 */
	@Override
	public StudentDTO StudentInformation(String id) throws Exception {
		StudentDTO studentinformation = khIntraDao.StudentInformation(id);
		return studentinformation;
	}
	
	/**
	 * 해당학생이 평가해야할 강의목록 불러오기
	 */
	@Override
	public List<ProfEvaluationDTO> ProfEvaluation(ProfEvaluationDTO info) throws Exception {
		List<ProfEvaluationDTO> list = khIntraDao.ProfEvaluation(info);
		return list;
	}
	
	/**
	 * 교수평가 점수넣기
	 */
	@Override
	public boolean addProfessorGrade(ProfEvaluationDTO pdfo) throws Exception {
		return khIntraDao.addProfessorGrade(pdfo);
	}
	
	/**
	 * 성적확인
	 */
	@Override
	public List<I_StudentGradeDTO> StudentGradeCheck(ProfEvaluationDTO Sgrade) throws Exception {
		List<I_StudentGradeDTO> list = khIntraDao.StudentGradeCheck(Sgrade); 
		return list;
	}

	/**
	 * 학생이 성적확인 완료 클릭
	 */
	@Override
	public boolean updateGradeConfirm(StudentDTO id) throws Exception {
		return khIntraDao.updateGradeConfirm(id);
	}
	
	/**
	 * 내정보(학생) : 기본학생정보
	 */
	@Override
	public I_StudentBasicInfoDTO studentBasicInfo(String id) throws Exception {
		I_StudentBasicInfoDTO basicInfo = khIntraDao.studentBasicInfo(id);
		return basicInfo;
	}

	/**
	 * 내정보 수정(학생) : 기본학생정보
	 */
	@Override
	public boolean updateStudentInfo(I_StudentBasicInfoDTO info) throws Exception {
		return khIntraDao.updateStudentInfo(info);
	}
	
	/**
	 * 학생 총 수료학기 증가(다른의미로 학년으로 볼 수 있음)
	 */
	@Override
	public boolean studentTotalsemester(StudentDTO id) throws Exception {
		return khIntraDao.studentTotalsemester(id);
	}
	
	/**
	 * 학년 / 학기별 성적 검색
	 */
	@Override
	public List<I_semesterGradeDTO> semesterGrade(I_semesterGradeDTO grade) {
		List<I_semesterGradeDTO> list = khIntraDao.semesterGrade(grade);
		return list;
	}
	
	/**
	 * 학년 / 학기별 성정검색
	 */
	@Override
	public List<I_semesterGradeDTO> semesterGradechoice(I_semesterGradeDTO grade) {
		List<I_semesterGradeDTO> list = khIntraDao.semesterGradechoice(grade);
		return list;
	}

}
