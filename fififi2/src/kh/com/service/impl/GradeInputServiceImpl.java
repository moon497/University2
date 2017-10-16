package kh.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.GradeInputDao;
import kh.com.model.MemberDto;
import kh.com.model.SubjectDto;
import kh.com.service.GradeInputService;

@Service
public class GradeInputServiceImpl implements GradeInputService {
	
	@Autowired
	GradeInputDao gradeinputDao;

	@Override
	public List<SubjectDto> gradeinputlist(MemberDto dto) {
		return gradeinputDao.gradeinputlist(dto);
	}
	
	

}
