package kh.com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.model.MemberDto;

@Controller
public class MarketController {
	private static final Logger logger = LoggerFactory.getLogger(MarketController.class);

	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value= "/market/write.do",method=RequestMethod.GET)
	public String write(HttpServletRequest req) {
		logger.info("진입");
		
		//init
		HttpSession session;
		MemberDto login;
		
		session = req.getSession();
		
		login = (MemberDto) session.getAttribute("login");
		
		if (login == null) {
			return "checkLogin.tiles";		
		} else {
			return "marketWrite.tiles";			
		}
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	
	/************************************************************
	 * 							Util Method 
	 * **********************************************************/
}
