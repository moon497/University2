package kh.com.dao;

import java.util.List;

import kh.com.model.E_PdsBean;
import kh.com.model.E_PdsDto;
import kh.com.util.Pagination;

public interface E_PdsDao {
	public List<E_PdsDto> getEPdsList() throws Exception;
	public void uploadPds(E_PdsDto epds);

}
