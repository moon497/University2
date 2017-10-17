package kh.com.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.LoginDao;
import kh.com.model.MemberDto;

@Repository
public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	SqlSession sqlsession;
	private String ns = "Login.";
	
	
	@Override
	public MemberDto login(MemberDto dto) throws Exception {
		System.out.println(" login 다오임플 1/1" + dto.toString());
		return sqlsession.selectOne(ns+"login", dto);
	}


	@Override
	public void addMember(MemberDto dto) throws Exception {
		System.out.println("addMember 다오임플 실행 1/2 " + dto.toString());
		sqlsession.insert(ns + "addmember", dto);
		System.out.println("addMember 다오임플 2/2");
	}


	@Override
	public void addMember_student(MemberDto dto) throws Exception {
		System.out.println("addMember_student 다오 임플 1/2" + dto.toString());
		sqlsession.insert(ns+"addMember_student", dto);
		System.out.println("addMember_student 다오임플 2/2");
	}


	@Override
	public void addMember_prof(MemberDto dto) throws Exception {
		System.out.println("addMember_prof 다오 임플 1/2" + dto.toString());
		sqlsession.insert(ns+"addMember_prof", dto);
		System.out.println("addMember_prof 다오임플 2/2");
		
	}
	

	@Override
	public void addMember_admin(MemberDto dto) throws Exception {
		System.out.println("addMember_admin 다오 임플 1/2" + dto.toString());
		sqlsession.insert(ns+"addMember_admin", dto);
		System.out.println("addMember_admin 다오임플 2/2");
	}


	@Override
	public String findid(MemberDto dto) throws Exception {
		System.out.println("findid 다오임플 1/1" + dto.toString()) ;
		return sqlsession.selectOne(ns+"findid", dto);
	}


	@Override
	public MemberDto findpw(MemberDto dto) throws Exception {
		System.out.println("findpw 다오임플 1/1" +  dto.toString());
		return sqlsession.selectOne(ns+"findpw", dto);
	}
	


	@Override
	public MemberDto studentLogin(MemberDto dto) {
		return sqlsession.selectOne(ns+"studentLogin", dto);
	}


	@Override
	public MemberDto professorLogin(MemberDto dto) {
		return sqlsession.selectOne(ns+"professorLogin", dto);
	}


	@Override
	public MemberDto adminLogin(MemberDto dto) {
		return sqlsession.selectOne(ns+"adminLogin", dto);
	}


	@Override
	public void updatePhoto_student(MemberDto dto) throws Exception {
		System.out.println("updatePhoto_student 다오임플 1");
		sqlsession.update(ns+"updatePhoto_student", dto);
		System.out.println("updatePhoto_student 다오임플 1");
	}
	
	
	
	
	
	
	

}
