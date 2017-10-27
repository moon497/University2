package kh.com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.model.Board;
import kh.com.model.Post;
import kh.com.service.BbsService;
import kh.com.util.Pagination;

@Controller
public class MemberController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	BbsService servBbs;
	/**
	 * 메인페이지 
	 */
	@RequestMapping(value="main.do", method= {RequestMethod.GET,RequestMethod.POST})
	public String main(HttpServletRequest req, Model model) {
		logger.info("진입");
		
		//init
		List<Post> noticeList;
		List<Post> todayList;
		Post query;
		Pagination paginationNotice;
		Pagination paginationToday;
		
		//페이징
		paginationNotice = new Pagination(getTotalBbs(getBoardSeq("notice")), getCurrPage(req));
		paginationToday = new Pagination(getTotalBbs(getBoardSeq("today")), getCurrPage(req));

		//질의 설정
		query = new Post();
		query.setBoardSeq(getBoardSeq("notice"));
		query.setStartArticle(paginationNotice.getStartArticle());
		query.setEndArticle(paginationNotice.getEndArticle());
		
		//받아오기
		noticeList = servBbs.getBbsList(query);
				
		//받아오기
		query.setBoardSeq(getBoardSeq("today"));									//쿼리 수정
		query.setStartArticle(paginationToday.getStartArticle());
		query.setEndArticle(paginationToday.getEndArticle());
		
		todayList = servBbs.getBbsList(query);
		
		//엔터처리
		for (Post mainBbs : noticeList) {
			mainBbs.setBbsContent(mainBbs.getBbsContent().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
		}
		for (Post mainBbs : todayList) {
			mainBbs.setBbsContent(mainBbs.getBbsContent().replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""));
			logger.info(mainBbs.toString());
		}
		
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("todayList", todayList);
		
		return "index.tiles";
	}
	
	/**
	 * 서브페이지 (오른쪽 메뉴영역 다름) 
	 */
	@RequestMapping(value="sub_test.do", method=RequestMethod.GET)
	public String sub(Model model) {
		logger.info("KhMemberController login");				
		return "sub.tiles";
	}	

	/************************************************************
	 * 							Util Method 
	 * **********************************************************/
	private int getCurrPage(HttpServletRequest req) {
		int currPage;
		
		if (req.getParameter("page") == null) {
			currPage = 1;
		} else {
			currPage = Integer.parseInt(req.getParameter("page"));
		}
		
		return currPage;
	}
	
	private int getTotalBbs(int boardSeq) {
		return servBbs.getTotalBbs(boardSeq);
	}
	
	private boolean checkBoardUrl(String boardUrl) {
		Board boards = new Board();
		
		return boards.containsKey(boardUrl);
	}
	
	private Integer getBoardSeq(String boardUrl) {
		Board boards = new Board();
		
		return boards.getBoardSeq(boardUrl);
	}
}