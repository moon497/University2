package kh.com.service;

import kh.com.model.MemberDto;

public interface LoginService {
	
	public MemberDto login(MemberDto dto) throws Exception;	
	public void addMember(MemberDto dto) throws Exception ;
	public String findid(MemberDto dto) throws Exception;
	public MemberDto findpw(MemberDto dto) throws Exception;

}
