package kh.com.dao;

import kh.com.model.MemberDto;

public interface LoginDao {
	
	public MemberDto login(MemberDto dto) throws Exception; // 로그인
	public MemberDto studentLogin(MemberDto dto);
	public MemberDto professorLogin(MemberDto dto);
	public MemberDto adminLogin(MemberDto dto);
	
	public void addMember(MemberDto dto) throws Exception; // 회원가입
	public void addMember_student(MemberDto dto) throws Exception; // 회원가입 시 학생일 경우 학생 테이블 만들어 주기 
	public void addMember_prof(MemberDto dto) throws Exception;
	public void addMember_admin(MemberDto dto) throws Exception;
	public String findid(MemberDto dto) throws Exception; // 아이디찾기
	public MemberDto findpw(MemberDto dto) throws Exception; // 비밀번호 찾기
	

}
