package kh.com.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kh.com.model.E_BbsDto;
import kh.com.model.MemberDto;
import kh.com.model.ProfEvaluationDTO;
import kh.com.service.E_BbsService;
import kh.com.util.FUpUtil;
import kh.com.util.Pagination;

@Controller
public class E_BbsController {

	private static final Logger logger = LoggerFactory.getLogger(E_BbsController.class);

	@Autowired // DI/IoC
	E_BbsService e_BbsService;
	
	@RequestMapping(value="E_Classlist.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Classlist(Model model, HttpServletRequest req) throws Exception {
		logger.info("E_BbsController E_Classlist");
		
		ProfEvaluationDTO info = new ProfEvaluationDTO();
		String id = ((MemberDto)req.getSession().getAttribute("login")).getUser_id();
		info.setStudent_id(id);
		
		List<ProfEvaluationDTO> eclist =  e_BbsService.ProfEvaluation(info);
		System.out.println(info.toString());
		for (int i = 0; i < eclist.size(); i++) {
			System.out.println(eclist.get(i).toString());
		}
		model.addAttribute("eclist", eclist);
		
		return "E_Classlist.tiles";
	}
	
	@RequestMapping(value="E_Bbslist.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Bbslist(int sub_seq,HttpServletRequest req, E_BbsDto edto, Model model) throws Exception{
		logger.info("E_BbsController E_Bbslist");		
		
		int currPage = getCurrPage(req); 
		int totalArticle = e_BbsService.getBbsCount(edto);
		
		Pagination pagination = new Pagination(totalArticle, currPage);
		sub_seq = edto.getSub_seq();
	    pagination.setSub_seq(sub_seq);

		List<E_BbsDto> ebbslist = e_BbsService.getEBbsList(pagination);
		
		for (int i = 0; i < ebbslist.size(); i++) {
			System.out.println(ebbslist.get(i).toString());
		}
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("ebbslist",ebbslist);

		return "E_Bbslist.tiles";
	}
	
	@RequestMapping(value="E_Bbsdetail.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Bbsdetail(int seq,Model model,HttpServletRequest req,int sub_seq, E_BbsDto edto) throws Exception{
		logger.info("E_BbsController E_Bbsdetail");
		
		e_BbsService.addReadcount(seq);
		edto = e_BbsService.getBbs(seq);
		model.addAttribute("edto",edto);
		
		return "E_Bbsdetail.tiles";
	}	
	
	@RequestMapping(value="E_Bbsdelete.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Bbsdelete(E_BbsDto edto,int seq,Model model,HttpServletRequest req) throws Exception{
		logger.info("E_BbsController E_Bbsdelete");
		e_BbsService.deleteEBbs(seq);
		return "redirect:/E_Bbslist.do?sub_seq="+edto.getSub_seq();
	}
		
	@RequestMapping(value="E_Bbswrite.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Bbswrite(Model model,HttpServletRequest req,int sub_seq) throws Exception{
		logger.info("E_BbsController E_Bbswrite");						
		MemberDto dto = (MemberDto) req.getSession().getAttribute("login");
		model.addAttribute("login",dto);		

		return "E_Bbswrite.tiles";
	}
	
	@RequestMapping(value="E_BbswriteAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_BbswriteAf(Model model, E_BbsDto bbsdto, HttpServletRequest req,
		                    @RequestParam(value="fileload", required=false) MultipartFile fileload) {
		logger.info("E_BbsController E_BbswriteAf");
		
		String newFile ="";
		
		bbsdto.setFilename(fileload.getOriginalFilename());
	
		String fupload = req.getSession().getServletContext().getRealPath("/upload");
		logger.info("파일 저장 경로:" + fupload);		
		
		String f = bbsdto.getFilename();
		logger.info("f:" + f);	
		if (f=="") {
			f="-1";
			bbsdto.setOrg_filename(f);
			newFile = f;
			bbsdto.setFilename(f);
		}else{
			bbsdto.setOrg_filename(f);
			newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
			bbsdto.setFilename(newFile);
		}
		File file = new File(fupload + "/" + newFile);
		logger.info("file:" + file);		
		
		try {
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			//DB에 추가
			e_BbsService.uploadBbs(bbsdto);
			System.out.println("파일 업로드 성공");
			System.out.println("확인 : " + bbsdto.toString());
		} catch (Exception e) {System.out.println("파일 업로드 실패" + e);}
				
		return "redirect:/E_Bbslist.do?sub_seq="+bbsdto.getSub_seq();
	}
	
	@RequestMapping(value="E_Bbsupdate.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Bbsupdate(int seq,Model model) throws Exception{
		logger.info("E_BbsController E_Bbsupdate");
		E_BbsDto edto = e_BbsService.getBbs(seq);
		model.addAttribute("edto",edto);
		return "E_Bbsupdate.tiles";
	}
	
	@RequestMapping(value="E_BbsupdateAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_BbsupdateAf(E_BbsDto edto, Model model,HttpServletRequest req,
						@RequestParam(value="fileload", required=false) MultipartFile fileload) throws Exception{
		logger.info("E_BbsController E_BbsupdateAf");
		String newFile ="";
		edto.setFilename(fileload.getOriginalFilename());
		
		String fupload = req.getSession().getServletContext().getRealPath("/upload");
		logger.info("파일 저장 경로:" + fupload);		
		
		String f = edto.getFilename();
		logger.info("f:" + f);	
		
		if (f=="") {
			f="-1";
			edto.setOrg_filename(f);
			newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
			edto.setFilename(f);			
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
			e_BbsService.updateEBbs(edto);
			System.out.println("파일 업로드 성공");
			System.out.println("edtos : " + edto.toString());
		} catch (Exception e) {System.out.println("파일 업로드 실패" + e);}

		return "redirect:/E_Bbslist.do?sub_seq="+edto.getSub_seq();
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
