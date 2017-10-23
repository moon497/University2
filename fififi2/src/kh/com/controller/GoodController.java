package kh.com.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.model.GoodDto;
import kh.com.model.MemberDto;
import kh.com.service.GoodService;
import kh.com.util.Pagination;

@Controller
public class GoodController {
	private static final Logger logger = LoggerFactory.getLogger(GoodController.class);
	
	@Autowired
	GoodService serv;

	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value= "/good/write.do",method=RequestMethod.GET)
	public String writeGet(HttpServletRequest req) {
		logger.info("진입");
		System.out.println("종희가 수정한 소스코드");
		
		//init
		HttpSession session;
		MemberDto login;
		
		session = req.getSession();
		
		login = (MemberDto) session.getAttribute("login");
		
		if (login == null) {
			return "checkLogin.tiles";		
		} else {
			return "goodWrite.tiles";			
		}
	}
	
	//글쓰기 기능
	@RequestMapping(value= "/good/write.do",method=RequestMethod.POST)
	public String writePost(GoodDto good, HttpServletRequest req) {
		logger.info("진입");
		
		logger.info(good.toString());
		
		serv.insertGood(good);
		
		
		return "redirect:/good/list.do";
		
		
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//리스트 기능
	@RequestMapping(value= "/good/list.do",method=RequestMethod.GET)
	public String listGet(HttpServletRequest req, Model model) {
		logger.info("진입");
		
		//init
		List<GoodDto> list;
		Pagination pagination = new Pagination(10, 1);		//FIXME
		GoodDto query = new GoodDto();
		
		
		//query Set
		query.setStartArticle(1);
		query.setEndArticle(10);
		
		list = serv.getGoodList(query);
		
		//대표이미지 설정
		for (GoodDto goodDto : list) {			
		    String re1=".*?";	// Non-greedy match on filler
		    String re2="((?:\\/[\\w\\.\\-]+)+)";	// Unix Path 1

		    Pattern p = Pattern.compile(re1+re2,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		    
		    Matcher m = p.matcher(goodDto.getContent());
		    if (m.find())
		    {
		        goodDto.setImgUrl(m.group(1));
		    }
			
			logger.info("list: {}",goodDto.toString());
		}
		
		//set
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		
		return "goodList.tiles";
		
	}
	
	//단일뷰 기능
	@RequestMapping(value= "/good/detail.do",method=RequestMethod.GET)
	public String detailGet(int seq, HttpServletRequest req, Model model) {
		logger.info("진입");
		
		//init
		GoodDto good = new GoodDto();
		
		
		
		good = serv.getGood(seq);
		
		//set
		model.addAttribute("good", good);
		
		return "goodDetail.tiles";
		
	}
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/

	//단일뷰 기능
	@RequestMapping(value= "/good/delete.do",method=RequestMethod.GET)
	public String deleteGet(int seq, HttpServletRequest req, Model model) {
		logger.info("진입");
		
		//init
		
		
		//run
		serv.deleteGood(seq);
		
		//set

		return "redirect:/good/list.do";
		
	}
	
	/************************************************************
	 * 							Util Method 
	 * **********************************************************/
}
