package kh.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.AssessmentDao;
import kh.com.model.AssessmentDto;
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
	public boolean deleteAs(int sub_seq) {
		return assessmentDao.deleteAs(sub_seq);
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
