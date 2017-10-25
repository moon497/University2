package kh.com.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.model.E_QnaDto;
import kh.com.service.E_QnaService;

@Controller
public class E_QnaController {
	private static final Logger logger = LoggerFactory.getLogger(E_QnaController.class);

	@Autowired
	E_QnaService e_QnaService;
	
	@RequestMapping(value="E_Qnalist.do",method={RequestMethod.GET, RequestMethod.POST})
	public String E_Qnalist(int sub_seq,HttpServletRequest req,Model model, E_QnaDto qdto) {
	    logger.info("E_QnaController E_Qnalist");            

	    
	    
		return null;
	}
	
	
	

}
