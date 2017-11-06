package kh.com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.IntroDao;
import kh.com.model.IntroBbsDto;
import kh.com.model.IntroCalendarDto;

@Repository
public class IntroDaoImpl implements IntroDao {

	private static final Logger logger = LoggerFactory.getLogger(IntroDaoImpl.class);
	
	@Autowired
	SqlSession sqlSession;
	
	String ns = "Intro.";
	
	@Override
	public boolean IntroBbsWrite(IntroBbsDto dto) throws Exception{
		logger.info("진입");
		logger.info("dto: {}",dto.toString());
		
		return sqlSession.insert(ns + "IntroBbsWrite", dto) > 0 ? true : false;
	}

	
	@Override
	public int getIntroCount(IntroBbsDto dto) throws Exception {
		return sqlSession.selectOne(ns+"getIntroCount", dto);
	}

	
	
	@Override
	public List<IntroBbsDto> IntroBbsList(IntroBbsDto dto) throws Exception{
		List<IntroBbsDto> list = new ArrayList<IntroBbsDto>();
		list = (List<IntroBbsDto>)(Object)sqlSession.selectList(ns + "IntroBbsList", dto);
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


	@Override
	public List<IntroCalendarDto> getCalendarList(IntroCalendarDto fcal) throws Exception {
		List<IntroCalendarDto> list = new ArrayList<IntroCalendarDto>();
		list = sqlSession.selectList(ns + "getCalendarList", fcal);		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	

}
