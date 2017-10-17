package kh.com.dao;

import java.util.List;

import kh.com.model.AssessmentDto;
import kh.com.model.SubjectDto;

public interface AssessmentDao {
	
	public boolean addSub(AssessmentDto as) throws Exception;	
	public List<SubjectDto> getAsListFromUser(String user_id);			// 수강신청중인 리스트
	public boolean deleteAs(int sub_seq);

	
	//정혜
	public List<AssessmentDto> gradeList(AssessmentDto dto);			// 성적확인 리스트
	public boolean gradeUpdate(AssessmentDto dto);					// 성적 삽입

}
