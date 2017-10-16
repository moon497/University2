package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.SubjectDao;
import kh.com.model.SubjectDto;
import kh.com.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectDao dao;

	@Override
	public List<SubjectDto> getSubjectList(String professorId) {
		return dao.getSubjectList(professorId);
	}

}
