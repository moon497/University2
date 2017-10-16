package kh.com.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.EnrolmentDao;
import kh.com.model.EnrollDto;
import kh.com.model.SubjectDto;
import kh.com.service.EnrolmentService;
@Service
public class EnrolmentServiceImpl implements EnrolmentService {
	private static final Logger logger = LoggerFactory.getLogger(EnrolmentServiceImpl.class);
	
	@Autowired
	EnrolmentDao enrolmentDao;

	@Override
	public boolean addSubject(SubjectDto sub) throws Exception {
		return enrolmentDao.addSubject(sub);
	}

	@Override
	public List<SubjectDto> getSublist(String id) throws Exception {
		return enrolmentDao.getSublist(id);
	}

	@Override
	public SubjectDto getReg(int seq) throws Exception {
		return enrolmentDao.getReg(seq);
	}

	@Override
	public boolean addClassTime(SubjectDto sub) throws Exception {
		return enrolmentDao.addClassTime(sub);
	}

	@Override
	public void deleteReg(int seq) throws Exception {
		enrolmentDao.deleteReg(seq);		
	}

	@Override
	public List<SubjectDto> getEnrollist(String major) throws Exception {
		return enrolmentDao.getEnrollist(major);
	}

	@Override
	public List<SubjectDto> getEnrollListFromUser(String user_id) {
		logger.info("진입");
		return enrolmentDao.getEnrollListFromUser(user_id);
	}

	@Override
	public boolean deleteEnroll(int sub_seq) {
		return enrolmentDao.deleteEnroll(sub_seq);
	}
	
	
	
}
