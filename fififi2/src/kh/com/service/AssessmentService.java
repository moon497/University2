package kh.com.service;

import java.util.List;

import kh.com.model.AssessmentDto;
import kh.com.model.MemberDto;
import kh.com.model.StudentDTO;
import kh.com.model.SubjectDto;

public interface AssessmentService {
	
	public boolean addSub(AssessmentDto as) throws Exception;
	public List<SubjectDto> getAsListFromUser(String user_id);			// 수강신청중인 리스트
	public boolean deleteAs(AssessmentDto as);	
	
	public boolean addnowStudent(int sub_seq) throws Exception;
	public boolean minusNowStudent(int sub_seq) throws Exception;
	
	public List<AssessmentDto> sumPoint(String student_id) throws Exception;
	
	public StudentDTO getStudent(String student_id) throws Exception;
	public MemberDto getProf(String prof_id) throws Exception;
	public MemberDto getUsers(String user_id) throws Exception;	
	public boolean updateProInfo(MemberDto mem) throws Exception;
	public boolean updateProInfo2(MemberDto mem) throws Exception;
	
	//정혜
	public List<AssessmentDto> gradeList(AssessmentDto dto);			// 성적확인 리스트	
	public boolean gradeUpdate(List<AssessmentDto> list);			// 성적 대량 삽입
	
}
