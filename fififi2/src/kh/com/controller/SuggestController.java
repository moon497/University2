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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.model.MemberDto;
import kh.com.model.Post;
import kh.com.model.SuggestDto;
import kh.com.service.SuggestService;
import kh.com.util.FileUpload;
import kh.com.util.Pagination;

@Controller
public class SuggestController {
	
	@Autowired
	SuggestService suggestService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 건의사항 리스트  
	@RequestMapping(value="suggestlist.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String suggestlist(Model model, HttpServletRequest req)throws Exception {
		logger.info("suggestlist");
		SuggestDto suggest;
		Pagination pagination;
		
		MemberDto login = (MemberDto)req.getSession().getAttribute("login");
			
		// 총 게시물 수 
		int totalArticle = suggestService.getCount();
		System.out.println("totalarticle : " + totalArticle);

		// 페이징 (총 게시물, 현재페이지)
		pagination = new Pagination(totalArticle, getCurrPage(req)); 
		
		suggest = new SuggestDto();		
		suggest.setStart_post((pagination.getStartArticle()));
		suggest.setEnd_post((pagination.getEndArticle()));
		
		System.out.println("suggest : " + suggest.toString());
		
		List<SuggestDto> suggestlist = suggestService.getsuggestList(suggest);
		for (int i = 0; i < suggestlist.size(); i++) {			
			System.out.println("suggestlist(" + i + ") : " + suggestlist.get(i).toString());
		}
		
		model.addAttribute("login", login);		
		model.addAttribute("pagination" ,pagination);
		model.addAttribute("suggestlist", suggestlist);
		model.addAttribute("doc_title", "건의사항");
	    model.addAttribute("doc_title_sub", "게시판");   
		
		
		return "suggestlist.tiles";
	}
	
	// 건의사항 글쓰기 전
	@RequestMapping(value="suggestWrite.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String suggestWrite(Model model, HttpServletRequest req)throws Exception {
		logger.info("suggestWrite");
		MemberDto login = (MemberDto)req.getSession().getAttribute("login");
		System.out.println("login : " + login.toString());
		
		model.addAttribute("login", login);
		model.addAttribute("doc_title", "건의사항");
	    model.addAttribute("doc_title_sub", "글쓰기"); 
		
		return "suggestWrite.tiles";
	}
	
	// 건의사항 글쓰기 후 
	@RequestMapping(value="suggestwriteAf.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String suggestwriteAf(SuggestDto sug, Model model, MultipartHttpServletRequest req, MultipartFile file)throws Exception {
		logger.info("suggestWriteAf");
		
		
		
		String path = req.getSession().getServletContext().getRealPath("/") + "upload/file/"; //파일 저장경로
	    logger.info(path);
	    FileUpload fileUpload = new FileUpload(file, path);
	    
	    sug.setFilename(fileUpload.getStoredFileName());
	    sug.setOrg_filename(fileUpload.getOrgFileName());	   
	    System.out.println("sug : " + sug.toString());
		
		suggestService.suggestWrite(sug);
		
		return "redirect:/suggestlist.do";
	}
	
	// 글 클릭시 디테일 뷰 
	@RequestMapping(value="suggestdetail.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String suggestdetail(int seq, Model model, HttpServletRequest req)throws Exception {
		logger.info("suggestdetail");			
		
		SuggestDto sug = suggestService.getSuggest(seq);
		System.out.println("sug : " + sug.toString());
		
		model.addAttribute("sug", sug);
		model.addAttribute("doc_title", "건의사항");
	    model.addAttribute("doc_title_sub", "게시판"); 
			
		return "suggestDetail.tiles";
	}
	
	
	
	
	
	
	
	// 현재 페이지 구하기 
	private int getCurrPage(HttpServletRequest req) {
		int currPage;
		
		if (req.getParameter("page") == null) {
			currPage = 1;
		} else {
			currPage = Integer.parseInt(req.getParameter("page"));
		}
		
		return currPage;
	}
	
}




