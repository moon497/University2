package kh.com.service;

import java.util.List;

import kh.com.model.EnrollDto;
import kh.com.model.SubjectDto;

public interface EnrolmentService {
	
	public boolean addSubject(SubjectDto sub) throws Exception;
	public List<SubjectDto> getSublist(String id) throws Exception;
	public SubjectDto getReg(int seq) throws Exception;
	public boolean addClassTime(SubjectDto sub) throws Exception;
	public void deleteReg(int seq) throws Exception;	
	public List<SubjectDto> getEnrollist(String major) throws Exception;
	public List<SubjectDto> getEnrollListFromUser(String user_id);
	public boolean deleteEnroll(int sub_seq);
}
