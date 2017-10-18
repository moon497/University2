package kh.com.service;

import java.util.List;

import kh.com.model.E_PdsBean;
import kh.com.model.E_PdsDto;
import kh.com.util.Pagination;

public interface E_PdsService {
	public List<E_PdsDto> getEPdsList(Pagination pagination) throws Exception;
	public void uploadPds(E_PdsBean epds) throws Exception;
	public int getPdsCount(E_PdsDto epds) throws Exception;
	public boolean addPdsReadcount(int seq) throws Exception;
	public E_PdsDto getPds(int seq) throws Exception;
	public void updateEPds(E_PdsBean epds) throws Exception;
	public int deleteEPds(int seq) throws Exception;


}
