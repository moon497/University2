package kh.com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.com.model.Board;
import kh.com.model.Post;
import kh.com.model.MemberDto;
import kh.com.service.BbsService;
import kh.com.util.FileUpload;
import kh.com.util.Pagination;

@Controller
public class BbsController {
	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);
	//http://springboot.tistory.com/25 예외처리
	
	@Autowired
	BbsService servBbs;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/
	//글쓰기 화면
	@RequestMapping(value= "/{boardUrl}/write.do",method=RequestMethod.GET)
	public String write(@PathVariable String boardUrl, HttpServletRequest req) {
		logger.info("/{}/write.do",boardUrl);
		
		//boardUrl 체크
		if (checkBoardUrl(boardUrl) == false) {
			return "checkLogin.tiles";		//TODO 바꿀 것
		}
		
		//init
		HttpSession session;
		MemberDto mem;
		
		session = req.getSession();
		
		mem = (MemberDto) session.getAttribute("login");
		
		if (mem == null) {
			return "checkLogin.tiles";
		} else {
			return "bbsWrite.tiles";
		}
	}

	//글쓰기 기능
	@RequestMapping(value="/{boardUrl}/write.do",method=RequestMethod.POST)
	public String writePost(@PathVariable String boardUrl, MultipartHttpServletRequest req, MultipartFile uploadFile, Model model) throws IOException {
		logger.info("{} 진입",boardUrl);
		//init
		String path = "";
        String userId; 
        String bbsContent;
        String bbsStoredFileName;
        String bbsOrgFileName;
        String bbsTitle;
        
        //init
        path = req.getSession().getServletContext().getRealPath("/") + "upload/file/"; //파일 저장경로
        logger.info(path);
        FileUpload fileUpload = new FileUpload(uploadFile, path);
        Post bbs = new Post();
        
        //listen
		userId = req.getParameter("userId");
		bbsTitle = req.getParameter("bbsTitle");
		bbsContent = req.getParameter("bbsContent");		
		bbsStoredFileName = fileUpload.getStoredFileName();
		bbsOrgFileName = fileUpload.getOrgFileName();
		
		//setup
        bbs.setBoardSeq(getBoardSeq(boardUrl));
        bbs.setUserId(userId);
        bbs.setBbsTitle(bbsTitle);
        bbs.setBbsContent(bbsContent);
        bbs.setBbsStoredFileName(bbsStoredFileName);
        bbs.setBbsOrgFileName(bbsOrgFileName);
        
        logger.info("bbs: {}",bbs.toString());
        
		servBbs.insertBbs(bbs);		
		
		logger.info("insert Done");
		
		return "redirect:/"+boardUrl+"/list.do";
	}
	
	
	/*************************************************
	 * 					READ
	 * ***********************************************/
	//리스트 화면
	@RequestMapping(value="/{boardUrl}/list.do",method=RequestMethod.GET)
	public String list(@PathVariable String boardUrl, HttpServletRequest req, Model model) {
		logger.info("/bbs/list.do");
		
		//init
		List<Post> bbsList;
		Post query;
		Pagination pagination;
		
		//페이징
		pagination = new Pagination(getTotalBbs(getBoardSeq(boardUrl)), getCurrPage(req));

		//질의 설정
		query = new Post();
		query.setBoardSeq(getBoardSeq(boardUrl));
		query.setStartArticle(pagination.getStartArticle());
		query.setEndArticle(pagination.getEndArticle());
		
		//받아오기
		bbsList = servBbs.getBbsList(query);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardName", getBoardName(boardUrl));
		
		return "bbsList.tiles";
		
	}

	//디테일 화면
	@RequestMapping(value="/{boardUrl}/detail.do",method=RequestMethod.GET)
	public String detail(@PathVariable String boardUrl, HttpServletRequest req, Model model) {
		logger.info("/{}/detail.do", boardUrl);
		//init
		Pagination pagination;
		List<Post> bbsList;
		Post bbs;
		Post query;
		int seq;
		String ext;
		boolean isImg;

		//페이징
		pagination = new Pagination(getTotalBbs(getBoardSeq(boardUrl)), getCurrPage(req));
		
		//질의 설정
		seq = Integer.parseInt(req.getParameter("seq"));
		
		query = new Post();
		query.setBoardSeq(getBoardSeq(boardUrl));
		query.setStartArticle(pagination.getStartArticle());
		query.setEndArticle(pagination.getEndArticle());
		
		//DB 데이터
		bbs = servBbs.getBbs(seq);
		bbsList = servBbs.getBbsList(query);
		ext = getExt(bbs);
		logger.info("ext: {}",ext);
		isImg = isImg(ext);
		
		//요소 추가
		model.addAttribute("bbsList", bbsList);
		model.addAttribute("pagination", pagination);
		model.addAttribute("boardName", getBoardName(boardUrl));
		model.addAttribute("bbs", bbs);
		model.addAttribute("isImg", isImg);
		
		return "bbsDetail.tiles";
		
	}

	/*************************************************
	 * 					UPDATE
	 * ***********************************************/
	//글 수정하기
	@RequestMapping(value="/{boardUrl}/update.do",method=RequestMethod.GET)
	public String updatePost(@PathVariable String boardUrl, HttpServletRequest req, Model model) {
		logger.info("bbs/update");
		//init
		Post bbs;
		
		//DB get
		bbs = servBbs.getBbs(getSeq(req));
		
		//요소 추가
		model.addAttribute("bbs", bbs);
		
		return "bbsUpdate.tiles";
	}
	
	//글 수정하기
	@RequestMapping(value="/{boardUrl}/update.do",method=RequestMethod.POST)
	public String updateAf(@PathVariable String boardUrl, MultipartHttpServletRequest req, MultipartFile uploadFile, Post bbs, Model model) {
		logger.info("진입");
		//init
		String path = "";
        String bbsStoredFileName;
        String bbsOrgFileName;
        
        //init
        path = req.getSession().getServletContext().getRealPath("/") + "upload/file/"; //파일 저장경로
        logger.info(path);
        FileUpload fileUpload = new FileUpload(uploadFile, path);
        
        //listen	
		bbsStoredFileName = fileUpload.getStoredFileName();
		bbsOrgFileName = fileUpload.getOrgFileName();
		
		//setup
        bbs.setBoardSeq(getBoardSeq(boardUrl));
        
        if (bbsOrgFileName == null || bbsOrgFileName.equals("-1") ) {
            bbs.setBbsStoredFileName(req.getParameter("bbsStoredFileName"));
            bbs.setBbsOrgFileName(req.getParameter("bbsOrgFileName"));
         } else {
             bbs.setBbsStoredFileName(bbsStoredFileName);
             bbs.setBbsOrgFileName(bbsOrgFileName);	
         }
		
		//query Set
		bbs.setBoardSeq(getBoardSeq(boardUrl));
		
		logger.info(bbs.toString());
		
		//DB set
		try {
			servBbs.updateBbs(bbs);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return  "redirect:/"+boardUrl+"/list.do";
	}
	
	
	/*************************************************
	 * 					DELETE
	 * ***********************************************/
	//글 삭제하기
	@RequestMapping(value="/{boardUrl}/delete.do",method=RequestMethod.GET)
	public String deleteArticle(@PathVariable String boardUrl, HttpServletRequest req, RedirectAttributes redirectAttributes) {
		logger.info("/bbs/delete");
		
		//삭제
		servBbs.deleteBbs(getSeq(req));
		
		//리다이렉트 전달값
		redirectAttributes.addAttribute("page", req.getParameter("page"));
		
		return "redirect:/"+boardUrl+"/list.do";
		
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
	
	private int getSeq(HttpServletRequest req) {
		int seq;
		
		if (req.getParameter("seq") == null) {
			seq = 0;
		} else {
			seq = Integer.parseInt(req.getParameter("seq"));
		}
		
		return seq;
	}

	private int getTotalBbs(int boardSeq) {
		return servBbs.getTotalBbs(boardSeq);
	}
	
	private boolean isImg(String ext) {
		//init
		List<String> imgList;
		imgList = new ArrayList<>();
		
		//data
		imgList.add(".png");
		imgList.add(".jpg");
		imgList.add(".jpeg");
		imgList.add(".gif");
		
		if (imgList.contains(ext)) {
			return true;
		}
		
		return false;
	}

	private String getExt(Post bbs) {
		if (bbs.getBbsOrgFileName() == null || bbs.getBbsOrgFileName().equals("-1")) {
			return "-1";
		} else {
			
			return bbs.getBbsOrgFileName().substring(bbs.getBbsOrgFileName().lastIndexOf('.'));
			
		}
	}
	
	//게시판 이름 설정
	private String getBoardName(String boardUrl) {
		switch (boardUrl) {
		case "free":
			return "자유 게시판";
		case "today":
			return "오늘의 KH";
		case "notice":
			return "공지사항";

		default:
			break;
		}
		
		return null;
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