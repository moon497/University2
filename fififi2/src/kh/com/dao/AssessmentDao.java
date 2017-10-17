package kh.com.dao;

import java.util.List;

import kh.com.model.AssessmentDto;
import kh.com.model.MemberDto;
import kh.com.model.StudentGradeDTO;
import kh.com.model.SubjectDto;

public interface AssessmentDao {
	
	//재현
	public boolean addSub(AssessmentDto as) throws Exception;	
	public List<SubjectDto> getAsListFromUser(String user_id);			// 수강신청중인 리스트
	public boolean deleteAs(int sub_seq);

	public boolean addnowStudent(int sub_seq) throws Exception;
	public boolean minusNowStudent(int sub_seq) throws Exception;
	
	public List<AssessmentDto> sumPoint(String student_id) throws Exception;
	
	public StudentGradeDTO getStudent(String student_id) throws Exception;
	public MemberDto getProf(String prof_id) throws Exception;
	
	//정혜
	public List<AssessmentDto> gradeList(AssessmentDto dto);			// 성적확인 리스트
	public boolean gradeUpdate(AssessmentDto dto);					// 성적 삽입

}
