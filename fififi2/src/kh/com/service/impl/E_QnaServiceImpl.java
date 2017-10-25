package kh.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.com.dao.E_QnaDao;
import kh.com.service.E_QnaService;

@Service
public class E_QnaServiceImpl implements E_QnaService{

	@Autowired
	private E_QnaDao e_QnADao;
	
	
}
