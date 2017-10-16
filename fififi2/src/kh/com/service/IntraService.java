package kh.com.service;

import java.util.List;

import kh.com.model.ProfEvaluationDTO;

public interface IntraService {
	
	// 해당학생이 평가해야할 강의목록 불러오기
	public List<ProfEvaluationDTO> ProfEvaluation(ProfEvaluationDTO info) throws Exception;
	
	// 교수평가 점수넣기
	public boolean addProfessorGrade(ProfEvaluationDTO pdfo) throws Exception;
}
