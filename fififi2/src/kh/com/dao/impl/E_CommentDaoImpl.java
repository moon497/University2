package kh.com.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.com.dao.E_CommentDao;
import kh.com.model.E_CommentDto;

@Repository
public class E_CommentDaoImpl implements E_CommentDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String ns = "Eclass.";
	
	
	@Override
	public List<E_CommentDto> getClist(int seq) throws Exception {
		return sqlSession.selectList(ns+"getClist",seq);
	}


	@Override
	public void uploadComment(E_CommentDto cdto) throws Exception {
		System.out.println("cdto :" + cdto.toString());
		sqlSession.insert(ns+"uploadComment", cdto);
	}


	@Override
	public int deleteComment(int seq) throws Exception {
		return sqlSession.delete(ns+"deleteComment",seq);
	}

}
