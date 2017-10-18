package kh.com.dao;

import java.util.List;

import kh.com.model.E_PdsDto;
import kh.com.util.Pagination;

public interface E_PdsDao {
	public List<E_PdsDto> getEPdsList(Pagination pagination) throws Exception;
	public void uploadPds(E_PdsDto epds) throws Exception;
	public int getPdsCount(E_PdsDto epds) throws Exception; 
	public boolean addPdsReadcount(int seq) throws Exception;
	public void updateEPds(E_PdsDto epds) throws Exception;
	public E_PdsDto getPds(int seq) throws Exception;
	public int deleteEPds(int seq) throws Exception;

}
