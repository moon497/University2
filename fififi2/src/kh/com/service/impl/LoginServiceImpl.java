package kh.com.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.LoginDao;
import kh.com.model.MemberDto;
import kh.com.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private LoginDao logindao;

	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		MemberDto login = logindao.login(dto);
		String auth = login.getUser_auth();
		
		logger.info(auth);
		
		if (auth.equals("100")) {
			return logindao.studentLogin(dto);
		} else if (auth.equals("200")) {
			return logindao.professorLogin(dto);
		} else if (auth.equals("300")) {
			return logindao.adminLogin(dto);			
		} else {
			
			return login;
			
		}
		
	}

	@Override
	public void addMember(MemberDto dto) throws Exception {
		 if(dto.getUser_auth().equals("100")) {
			 logindao.addMember(dto);
			 logindao.addMember_student(dto);
		 }else if(dto.getUser_auth().equals("200")){
			 logindao.addMember(dto);
			 logindao.addMember_prof(dto);
		 }else if(dto.getUser_auth().equals("300")){
			 logindao.addMember(dto);
			 logindao.addMember_admin(dto);;
		 }
		 else {
			 logindao.addMember(dto);
		 }
	}

	@Override
	public String findid(MemberDto dto) throws Exception {
		return logindao.findid(dto);
	}

	@Override
	public MemberDto findpw(MemberDto dto) throws Exception {
		return logindao.findpw(dto);
	}

	@Override
	public void updatePhoto_student(MemberDto dto) throws Exception {
		logindao.updatePhoto_student(dto);
	}
	
	
	
	
	
	
	
	

}
