package kh.com.dao;

import java.util.List;

import kh.com.model.QuerySubjectDto;
import kh.com.model.SubjectDto;

public interface EnrolmentDao {

	public boolean addSubject(SubjectDto sub) throws Exception;		// 수업추가	
	public List<SubjectDto> getSublist(String id) throws Exception;	// 강의 리스트
	public SubjectDto getReg(int seq) throws Exception;				// 수업보기
	public boolean addClassTime(SubjectDto sub) throws Exception;	// 수업 시간 추가
	public void deleteReg(int seq) throws Exception;				// 수업 삭제
	public List<SubjectDto> getEnrollist(QuerySubjectDto query) throws Exception;	// 검색된 과 수업리스트
	public boolean updateReg(SubjectDto sub) throws Exception;		// 강의 수정 
}
