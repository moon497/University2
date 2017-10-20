package kh.com.dao;

import java.util.List;

import kh.com.model.AssessmentDto;
import kh.com.model.MemberDto;
import kh.com.model.StudentDTO;
import kh.com.model.SubjectDto;

public interface AssessmentDao {
	
	//재현
	public boolean addSub(AssessmentDto as) throws Exception;			// 학생 -> 수강신청
	public List<SubjectDto> getAsListFromUser(String user_id);			// 수강신청중인 리스트
	public boolean deleteAs(AssessmentDto as);							// 학생 -> 수강중인 과목 삭제

	public boolean addnowStudent(int sub_seq) throws Exception;			// 학생 ++
	public boolean minusNowStudent(int sub_seq) throws Exception; 		// 학생 --
	
	public List<AssessmentDto> sumPoint(String student_id) throws Exception;	// 수강중인 과목들 리스트
	
	public StudentDTO getStudent(String student_id) throws Exception;	// 학생 DTO 
	public MemberDto getProf(String prof_id) throws Exception;			// 교수 DTO
	public MemberDto getUsers(String user_id) throws Exception;			// user DTO
	public boolean updateProInfo(MemberDto mem) throws Exception;		// prof 테이블 수정
	public boolean updateProInfo2(MemberDto mem) throws Exception;		// users 테이블 수정
	
	//정혜
	public List<AssessmentDto> gradeList(AssessmentDto dto);			// 성적확인 리스트
	public boolean gradeUpdate(AssessmentDto dto);					// 성적 삽입
	
	

}
