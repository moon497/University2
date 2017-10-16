package kh.com.dao;

import java.util.List;

import kh.com.model.EnrollDto;
import kh.com.model.SubjectDto;

public interface EnrolmentDao {

	public boolean addSubject(SubjectDto sub) throws Exception;		// 수업추가	
	public List<SubjectDto> getSublist(String id) throws Exception;	// 강의 리스트
	public SubjectDto getReg(int seq) throws Exception;				// 수업보기
	public boolean addClassTime(SubjectDto sub) throws Exception;	// 수업 시간 추가
	public void deleteReg(int seq) throws Exception;				// 수업 삭제
	public List<SubjectDto> getEnrollist(String major) throws Exception;	// 검색된 과 수업리스트
	public List<SubjectDto> getEnrollListFromUser(String user_id);			// 수강신청중인 리스트
	public boolean deleteEnroll(int sub_seq);								// 수강신청중인 데이터
}
