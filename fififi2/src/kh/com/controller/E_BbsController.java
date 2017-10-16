package kh.com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.model.E_BbsDto;
import kh.com.model.MemberDto;
import kh.com.service.E_BbsService;
import kh.com.util.FUpUtil;
import kh.com.util.FileUpload;
import kh.com.util.Pagination;

@Controller
public class E_BbsController {

	private static final Logger logger = LoggerFactory.getLogger(E_BbsController.class);

	@Autowired // DI/IoC
	E_BbsService e_BbsService;
	
	@RequestMapping(value="E_Bbslist.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Bbslist(HttpServletRequest req, E_BbsDto edto, Model model) throws Exception{
		logger.info("E_BbsController E_Bbslist");		
		
		int currPage = getCurrPage(req);
		int totalArticle = e_BbsService.getBbsCount(edto);
		Pagination pagination = new Pagination(totalArticle, currPage);
		
		List<E_BbsDto> ebbslist = e_BbsService.getEBbsList(pagination);
		System.out.println(ebbslist.toString());

		model.addAttribute("pagination", pagination);
		model.addAttribute("ebbslist",ebbslist);
		
		return "E_main.tiles";
	}
	
	@RequestMapping(value="E_Bbswrite.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Bbswrite(Model model,HttpServletRequest req) throws Exception{
		logger.info("E_BbsController E_Bbswrite");						
		MemberDto dto = (MemberDto) req.getSession().getAttribute("login");
		model.addAttribute("login",dto);
		System.out.println(dto.toString());
		return "E_Bbswrite.tiles";
	}
	
	@RequestMapping(value="E_BbswriteAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_BbswriteAf(Model model, E_BbsDto pdsdto, HttpServletRequest req,
		                    @RequestParam(value="fileload", required=false) MultipartFile fileload) {
		logger.info("E_BbsController E_BbswriteAf");
		
		String newFile ="";
		
		pdsdto.setFilename(fileload.getOriginalFilename());
	
		String fupload = req.getSession().getServletContext().getRealPath("/upload");
		logger.info("파일 저장 경로:" + fupload);		
		
		String f = pdsdto.getFilename();
		logger.info("f:" + f);	
		
		if (f=="") {
			f="-1";
			pdsdto.setOrg_filename(f);
			//pdsdto.setUser_id("june");	
			newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
			pdsdto.setFilename(f);
		}else{
			pdsdto.setOrg_filename(f);
			//pdsdto.setUser_id("june");
			newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
			pdsdto.setFilename(newFile);
		}
		File file = new File(fupload + "/" + newFile);
		logger.info("file:" + file);		
		
		try {
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			//DB에 추가
			e_BbsService.uploadPds(pdsdto);
			System.out.println("파일 업로드 성공");
		} catch (Exception e) {System.out.println("파일 업로드 실패" + e);}

		return "redirect:/E_Bbslist.do";
	}
	
	@RequestMapping(value="E_Bbsupdate.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Bbsupdate(int seq,Model model) throws Exception{
		logger.info("E_BbsController E_Bbsupdate");
		
		E_BbsDto edto = e_BbsService.getBbs(seq);
		System.out.println("seq : " + seq);
		model.addAttribute("edto",edto);
		return "E_Bbsupdate.tiles";
	}
	
	@RequestMapping(value="E_BbsupdateAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_BbsupdateAf(E_BbsDto edto, Model model,HttpServletRequest req,
						@RequestParam(value="fileload", required=false) MultipartFile fileload) throws Exception{
		logger.info("E_BbsController E_BbsupdateAf");
		String newFile ="";
		edto.setFilename(fileload.getOriginalFilename());
		System.out.println("seqqq" + edto.getEclass_notice_bbs_seq());
		String fupload = req.getSession().getServletContext().getRealPath("/upload");
		logger.info("파일 저장 경로:" + fupload);		
		
		String f = edto.getFilename();
		logger.info("f:" + f);	
		
		if (f=="") {
			f="-1";
			edto.setOrg_filename(f);
			newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
			edto.setFilename(f);
			//edto.setUser_id(user_id);
			
		}else{
			edto.setOrg_filename(f);
			newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
			edto.setFilename(newFile);
		}
		File file = new File(fupload + "/" + newFile)	;
		logger.info("file:" + file);		
		
		try {
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			//DB에 추가
			System.out.println("edtos : " + edto.toString());
			e_BbsService.updateEBbs(edto);
			System.out.println("파일 업로드 성공");
			System.out.println("edtos : " + edto.toString());
		} catch (Exception e) {System.out.println("파일 업로드 실패" + e);}


		return "redirect:/E_Bbslist.do";
	}
	
	@RequestMapping(value="E_Bbsdetail.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Bbsdetail(int seq,Model model) throws Exception{
		logger.info("E_BbsController E_Bbsdetail");
		e_BbsService.addReadcount(seq);
		E_BbsDto edto = e_BbsService.getBbs(seq);
		model.addAttribute("edto",edto);
		System.out.println(edto.toString());
		return "E_Bbsdetail.tiles";
	}
	
	@RequestMapping(value="fileDownload.do", method={RequestMethod.GET, RequestMethod.POST})
	public String fileDownload(E_BbsDto ebbs, HttpServletRequest request,String org_filename, String filename, Model model) throws Exception {
		logger.info("E_BbsController fileDownload : " + new Date());
		String fupload = request.getServletContext().getRealPath("/upload");
		// 로컬: String fupload = "f:\\upload"; 
		System.out.println(org_filename);
		File downloadFile2 = new File(fupload + "/" + org_filename);
		File downloadFile = new File(fupload + "/" + filename);
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("downloadFile2", downloadFile2);
		//filename = ebbs.getOrg_filename();
		return "downloadView";
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
