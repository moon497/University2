package kh.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.AssessmentDao;
import kh.com.model.AssessmentDto;
import kh.com.model.MemberDto;
import kh.com.model.StudentDTO;
import kh.com.model.SubjectDto;
import kh.com.service.AssessmentService;

@Service
public class AssessmentServiceImpl implements AssessmentService {
	private static final Logger logger = LoggerFactory.getLogger(AssessmentServiceImpl.class);
	
	@Autowired
	AssessmentDao assessmentDao;
	
	@Override
	public boolean addSub(AssessmentDto as) throws Exception {
		System.out.println("serviceimpl addsub : " + as.toString());
		return assessmentDao.addSub(as);
	}

	@Override
	public List<SubjectDto> getAsListFromUser(String user_id) {
		logger.info("진입");
		return assessmentDao.getAsListFromUser(user_id);
	}

	
	@Override
	public boolean deleteAs(AssessmentDto as) {
		return assessmentDao.deleteAs(as);
	}

	@Override
	public boolean addnowStudent(int sub_seq) throws Exception {
		return assessmentDao.addnowStudent(sub_seq);
	}

	@Override
	public boolean minusNowStudent(int sub_seq) throws Exception {
		return assessmentDao.minusNowStudent(sub_seq);
	}

	@Override
	public List<AssessmentDto> sumPoint(String student_id) throws Exception {
		return assessmentDao.sumPoint(student_id);
	}

	@Override
	public StudentDTO getStudent(String student_id) throws Exception {
		return assessmentDao.getStudent(student_id);
	}

	@Override
	public MemberDto getProf(String prof_id) throws Exception {
		return assessmentDao.getProf(prof_id);
	}

	
	
	//정혜
	@Override
	public List<AssessmentDto> gradeList(AssessmentDto dto) {
		return assessmentDao.gradeList(dto);
	}

	@Override
	public boolean gradeUpdate(List<AssessmentDto> list) {
		logger.info("진입");
		boolean b = false;
		
		for (AssessmentDto assessmentDto : list) {
			logger.info(assessmentDto.toString());
			
			b = assessmentDao.gradeUpdate(assessmentDto);
		}
		
		return b;
	}


	
	
}
