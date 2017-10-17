package kh.com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.IntroDao;
import kh.com.model.IntroBbsDto;

@Repository
public class IntroDaoImpl implements IntroDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String ns = "Intro.";
	
	@Override
	public boolean IntroBbsWrite(IntroBbsDto dto) throws Exception{
		System.out.println("IntroBbsWrite 다오임플 :  " + dto.toString());
		int n = 0;
		n = sqlSession.insert(ns + "IntroBbsWrite", dto);
		System.out.println(n);
		return n>0?true:false;
	}

	@Override
	public List<IntroBbsDto> IntroBbsList() throws Exception{
		List<IntroBbsDto> list = new ArrayList<IntroBbsDto>();
		list = (List<IntroBbsDto>)(Object)sqlSession.selectList(ns + "IntroBbsList");
		return list;
	}

	@Override
	public IntroBbsDto introBbsDetail(int seq) throws Exception{
		IntroBbsDto dto =  sqlSession.selectOne(ns + "introBbsDetail", seq);
		return dto;
	}

	@Override
	public void introReadCount(int seq) throws Exception {
		sqlSession.update(ns+"introReadCount", seq);
	}

	@Override
	public boolean introBbsUpdate(IntroBbsDto dto) throws Exception {
		int n = sqlSession.update(ns+"introBbsUpdate", dto);
		return n>0?true:false;
	}

	@Override
	public boolean introBbsDelete(int seq) throws Exception {
		int n = sqlSession.delete(ns+"introBbsDelete", seq);
		return n>0?true:false;
	}
	
	
	
	
	
	
	
	
	

}
