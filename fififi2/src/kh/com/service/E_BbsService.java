package kh.com.service;

import java.util.List;

import kh.com.model.E_BbsDto;
import kh.com.model.ProfEvaluationDTO;
import kh.com.util.Pagination;

public interface E_BbsService {
	public List<E_BbsDto> getEBbsList(Pagination pagination) throws Exception;
	public E_BbsDto getBbs(int seq) throws Exception;
	public boolean addReadcount(int seq) throws Exception;
	public void uploadBbs(E_BbsDto edto);
	public int getBbsCount(E_BbsDto edto) throws Exception;
	public boolean updateEBbs(E_BbsDto edto) throws Exception;	
	public int deleteEBbs(int seq) throws Exception;


	public List<ProfEvaluationDTO> ProfEvaluation(ProfEvaluationDTO info) throws Exception;

	
}
