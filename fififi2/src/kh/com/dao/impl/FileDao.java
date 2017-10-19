package kh.com.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.model.File;

@Repository
public class FileDao {
	private static final Logger logger = LoggerFactory.getLogger(FileDao.class);
	private static final String ns = "Files.";
	
	@Autowired
	SqlSession session;	
	

	/*******************************************
	 * 					CREATE					
	 * *****************************************/
	public boolean insertFile(File file) {
		logger.info("진입");
		
		return session.insert(ns+"insertFile", file) > 0 ? true:false;
		
	}
	
	/*******************************************
	 * 					READ					
	 * *****************************************/
	public List<File> getFileList(int postSeq) {
		logger.info("진입");
		
		return session.selectList(ns+"getFileList", postSeq);
		
	}
	
	
	/*******************************************
	 * 					UPDATE					
	 * *****************************************/
	

	/*******************************************
	 * 					DELETE					
	 * *****************************************/
	
}