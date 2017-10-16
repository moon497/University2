package kh.com.dao;

import java.util.List;

import kh.com.model.SubjectDto;

public interface SubjectDao {
	
	public List<SubjectDto> getSubjectList(String professorId);

}
