package kh.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.model.CommentDto;
import kh.com.model.QueryComment;
import kh.com.service.CommentService;
import kh.com.util.Pagination;

@Controller
public class CommentController {
	private static final Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	CommentService serv;

	/*************************************************
	 * 					CREATE
	 * ***********************************************/	
	//댓글 기능
	@RequestMapping(value="/comment/writeAf.do",method=RequestMethod.POST)
	public String writeComment(RedirectAttributes redirectAttr, HttpServletRequest req, Model model) {
		logger.info("Post: /comment/writeAf.do");
		//init
		String boardUrl;
		int bbsSeq;
		int page;
        String userId;
        String commentContent;
        CommentDto comment;
        
        //init
        comment = new CommentDto();
        
        //listen
        boardUrl = req.getParameter("boardUrl");
        page = getParam(req,"page");
		bbsSeq = getBbsSeq(req);
		userId = req.getParameter("userId");
		commentContent = req.getParameter("commentContent");
		
		//setup
		comment.setBbsSeq(bbsSeq);
        comment.setUserId(userId);
        comment.setCommentContent(commentContent);
        
		serv.insertComment(comment);
		
		//redirect Setup
		redirectAttr.addAttribute("seq", bbsSeq);
		redirectAttr.addAttribute("page", page);
		
		return "redirect:/"+boardUrl+"/detail.do";
	}

	//대댓글 기능
	@RequestMapping(value="/comment/reply.do",method=RequestMethod.POST)
	public String writeReply(RedirectAttributes redirectAttr, HttpServletRequest req, CommentDto comment, Model model) {
		logger.info("진입");
		//init
		String boardUrl;
		int bbsSeq;
		int page;        
        
        //listen
        boardUrl = req.getParameter("boardUrl");
        page = Integer.parseInt(req.getParameter("page"));
		bbsSeq = getBbsSeq(req);
		
		//setup
		logger.info(comment.toString());		
		
		//do
		serv.insertReply(comment);
		
		//redirect Setup
		redirectAttr.addAttribute("seq", bbsSeq);
		redirectAttr.addAttribute("page", page);
//		
		return "redirect:/"+boardUrl+"/detail.do";
	}
	
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//[AJAX] 리스트 화면
	@RequestMapping(value="/comment/list.do",method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> list(HttpServletRequest req) {
		logger.info("/comment/list.do");
		
		//init
		Map<String,Object> map;
		List<CommentDto> commentList;
		QueryComment queryComment;
		Pagination pagination;
		int bbsSeq;
		int totalComment;
		
		//변수 세팅
		map = new HashMap<>();
		bbsSeq = getBbsSeq(req);
		totalComment = getTotalComment(bbsSeq);
		logger.info("bbsSeq: {}",bbsSeq);
		
		//페이징
		pagination = new Pagination(totalComment, getCurrPage(req));
			

		//질의 설정
		queryComment = new QueryComment();
		queryComment.setBbsSeq(bbsSeq);
		queryComment.setStartArticle(pagination.getStartArticle());
		queryComment.setEndArticle(pagination.getEndArticle());
		
		//받아오기
		commentList = serv.getCommentList(queryComment);
		
		//요소 추가
		map.put("commentList", commentList);
		map.put("pagination", pagination);
		map.put("queryComment", queryComment);
		
		return map;
	}
	
	/*************************************************
	 * 					UPDATE
	 * ***********************************************/	
	//글 수정하기
	@RequestMapping(value="/comment/updateAf.do",method=RequestMethod.POST)
	public String updateAfArticle(RedirectAttributes redirectAttr, HttpServletRequest req, CommentDto comment, Model model) {
		logger.info("comment/updateAf");
		
		//init
		String boardUrl;
		int bbsSeq;
		int page;
		
        //listen
        boardUrl = req.getParameter("boardUrl");
        page = Integer.parseInt(req.getParameter("page"));
		bbsSeq = getBbsSeq(req);
		
		//DB set	
		serv.updateComment(comment);
		

		//redirect Setup
		redirectAttr.addAttribute("seq", bbsSeq);
		redirectAttr.addAttribute("page", page);
		
		
		return  "redirect:/"+boardUrl+"/detail.do";
	}
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//글 삭제하기
	@RequestMapping(value="/comment/delete.do",method=RequestMethod.GET)
	public String deleteArticle(HttpServletRequest req, RedirectAttributes redirectAttributes) {
		logger.info("/comment/delete");
		
		//init
		String boardUrl;
		int bbsSeq;		
		
		//listen
		boardUrl = req.getParameter("boardUrl");
		bbsSeq = getBbsSeq(req);
		
		//삭제
		serv.deleteComment(getCommentSeq(req));
		
		//리다이렉트 전달값
		redirectAttributes.addAttribute("seq", bbsSeq);
		redirectAttributes.addAttribute("page", req.getParameter("page"));
		
		return "redirect:/"+boardUrl+"/detail.do";
		
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

	private int getTotalComment(int bbsSeq) {
		return serv.getTotalComment(bbsSeq);
	}
	
	private int getParam(HttpServletRequest req, String param) {
		int bbsSeq;
		
		if (req.getParameter(param) == null || req.getParameter(param).equals("")) {
			bbsSeq = 1;
		} else {
			bbsSeq = Integer.parseInt(req.getParameter(param));
		}
		return bbsSeq;
	}

	private int getBbsSeq(HttpServletRequest req) {
		int bbsSeq;
		
		if (req.getParameter("bbsSeq") == null) {
			bbsSeq = 0;
		} else {
			bbsSeq = Integer.parseInt(req.getParameter("bbsSeq"));
		}
		return bbsSeq;
	}
	
	private int getCommentSeq(HttpServletRequest req) {
		int seq;
		
		if (req.getParameter("seq") == null) {
			seq = 0;
		} else {
			seq = Integer.parseInt(req.getParameter("seq"));
		}
		
		return seq;
	}
}
