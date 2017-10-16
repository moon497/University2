package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.IntraDao;
import kh.com.model.ProfEvaluationDTO;
import kh.com.service.IntraService;

@Service
public class IntraServiceImpl implements IntraService {
	
	@Autowired
	IntraDao khIntraDao;
	
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

}
