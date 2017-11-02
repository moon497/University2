package kh.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.util.SystemOutLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.model.IntroBbsDto;
import kh.com.model.MemberDto;
import kh.com.service.IntroService;
import kh.com.util.FileUpload;

@Controller
public class IntroController implements Serializable {
	
	@Autowired
	IntroService introService;
	
	private static final Logger logger 
	= LoggerFactory.getLogger(IntroController.class);
	
	
	@RequestMapping(value="introBbs.do", method=RequestMethod.GET)
	public String introBbs(Model model, HttpServletRequest req, IntroBbsDto dto) throws Exception {
		model.addAttribute("doc_title", "소개");
		model.addAttribute("doc_title_sub", "학교소개");	
	
		
		int sn = dto.getPageNumber();
		int start = (sn) * dto.getRecordCountPerPage() + 1;
		int end = (sn + 1) * dto.getRecordCountPerPage();
		
		dto.setStart(start);
		dto.setEnd(end);
		
		int totalRecordCount = introService.getIntroCount(dto);
		List<IntroBbsDto> list = introService.IntroBbsList(dto);
		model.addAttribute("list", list);
		
		MemberDto login = ((MemberDto)req.getSession().getAttribute("login"));
		
		model.addAttribute("login", login);
		model.addAttribute("pageNumber", sn);
		model.addAttribute("pageCountPerScreen", 3);
		model.addAttribute("recordCountPerPage", dto.getRecordCountPerPage());
		model.addAttribute("totalRecordCount", totalRecordCount);
		
		return "introBbs.tiles";
	}	

	@RequestMapping(value="introBbswrite.do", method={RequestMethod.GET, RequestMethod.POST})
	public String introBbswrite(Model model) throws Exception{
		logger.info("introBbswrite.do");
		model.addAttribute("doc_title", "소개");
		model.addAttribute("doc_title_sub", "학교소개");	
		return "introBbswrite.tiles";
	}
	
	@RequestMapping(value="introBbswriteAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String introBbswriteAf(Model model, IntroBbsDto dto, MultipartHttpServletRequest req, MultipartFile file) throws Exception {
			logger.info("introBbswriteAf.do");
			
			String path = "";
	        String storedFileName; //dto 저장 파일 
	        String orgFileName;

	        path = req.getSession().getServletContext().getRealPath("/") + "upload/intro/"; //파일 저장경로
	        FileUpload fileUpload = new FileUpload(file, path);
			storedFileName = fileUpload.getStoredFileName();
			orgFileName = fileUpload.getOrgFileName();
			System.out.println("파일경로 : ---  : " + path );
			
			dto.setFilename(storedFileName);
			dto.setOrg_filename(orgFileName);
			
			introService.IntroBbsWrite(dto);
			
			return "redirect:/introBbs.do";
	}
	
	@RequestMapping(value="introBbsDetail.do", method={RequestMethod.GET, RequestMethod.POST})
	public String introBbsDetail(Model model, int seq) throws Exception {
		logger.info("introBbsDetail.do :" + seq);
		model.addAttribute("doc_title", "소개");
		model.addAttribute("doc_title_sub", "학교소개");	
		
		introService.introReadCount(seq);
		IntroBbsDto dto = introService.introBbsDetail(seq);
		model.addAttribute("dto", dto);
		
		return "introBbsDetail.tiles";
	}
	
	@RequestMapping(value="introBbsUpdate.do", method={RequestMethod.GET, RequestMethod.POST})
	public String introBbsUpdate(Model model, int seq) throws Exception {
		logger.info("introBbsUpdate.do" + seq);
		model.addAttribute("doc_title", "소개");
		model.addAttribute("doc_title_sub", "학교소개");	
		
		IntroBbsDto dto = introService.introBbsDetail(seq);
		model.addAttribute("dto", dto);
		
		return "introBbsUpdate.tiles";
	}
	
	@RequestMapping(value="introBbsUpdateAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String introBbsUpdateAf(Model model, IntroBbsDto dto, MultipartFile file, MultipartHttpServletRequest req ) throws Exception {
		logger.info("introBbsUpdateAf");
		
		String path = "";
        String storedFileName; //dto 저장 파일 
        String orgFileName;

        path = req.getSession().getServletContext().getRealPath("/") + "upload/intro/"; //파일 저장경로
        FileUpload fileUpload = new FileUpload(file, path);
		storedFileName = fileUpload.getStoredFileName();
		orgFileName = fileUpload.getOrgFileName();

		if (orgFileName == null || orgFileName.equals("-1") ) {
			dto.setFilename(req.getParameter("filename"));
			dto.setOrg_filename(req.getParameter("org_filename"));	
		} else {
			dto.setFilename(storedFileName);
			dto.setOrg_filename(orgFileName);	
		}
		
		
		System.out.println(dto.toString());
	    introService.introBbsUpdate(dto);
		
		return "redirect:/introBbs.do";
	}
	
	@RequestMapping(value="introBbsDelete.do" , method={RequestMethod.GET, RequestMethod.POST})
	public String introBbsDelete(Model model, int seq ) throws Exception {
		logger.info("introBbsDelete : " + seq);
		introService.introBbsDelete(seq);
		
		return "redirect:/introBbs.do";
	}
	
	
	@RequestMapping(value="introLocation.do" , method={RequestMethod.GET, RequestMethod.POST})
	public String introLocation(Model model) throws Exception {
		logger.info("introLocation");
		model.addAttribute("doc_title", "소개");
		model.addAttribute("doc_title_sub", "오시는길");
		return "introLocation.tiles";
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

}
