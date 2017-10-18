package kh.com.service;

import java.util.List;

import kh.com.model.E_CommentDto;

public interface E_CommentService {
	public List<E_CommentDto> getClist(int seq) throws Exception;
	public void uploadComment(E_CommentDto cdto) throws Exception;
	public int deleteComment(int seq) throws Exception;

}
