package kh.com.service;

import java.util.List;

import kh.com.model.E_PdsBean;
import kh.com.model.E_PdsDto;

public interface E_PdsService {
	public List<E_PdsDto> getEPdsList() throws Exception;
	public void uploadPds(E_PdsBean epdsb);
}
