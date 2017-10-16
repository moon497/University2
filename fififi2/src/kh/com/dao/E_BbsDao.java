package kh.com.dao;

import java.util.List;

import kh.com.model.E_BbsDto;
import kh.com.util.Pagination;

public interface E_BbsDao {
	public List<E_BbsDto> getEBbsList(Pagination pagination) throws Exception;
	public E_BbsDto getBbs(int seq) throws Exception;
	public boolean addReadcount(int seq) throws Exception;
	public void uploadPds(E_BbsDto edto);
	public int getBbsCount(E_BbsDto edto) throws Exception;
	public boolean updateEBbs(E_BbsDto edto) throws Exception;


}
