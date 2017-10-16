package kh.com.service;

import java.util.List;

import kh.com.model.SubjectDto;

public interface SubjectService {
	
	public List<SubjectDto> getSubjectList(String professorId);

}
