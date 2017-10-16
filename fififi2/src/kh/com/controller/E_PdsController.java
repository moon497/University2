package kh.com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.reflection.SystemMetaObject;
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
import kh.com.model.E_PdsBean;
import kh.com.model.E_PdsDto;
import kh.com.service.E_PdsService;
import kh.com.util.FUpUtil;

@Controller
public class E_PdsController {
	
	private static final Logger logger = LoggerFactory.getLogger(E_PdsController.class);
	
	@Autowired
	E_PdsService e_PdsService;

	@RequestMapping(value="E_Pdslist.do", method={RequestMethod.GET, RequestMethod.POST})
	public String getEPdsList(Model model) throws Exception{
		logger.info("E_PdsController E_Pdslist");				
		
		List<E_PdsDto> epdslist = e_PdsService.getEPdsList();
		model.addAttribute("epdslist",epdslist);
		System.out.println("epdslist : " + epdslist.toString());
		
		return "E_Pdslist.tiles";
	}
	
	@RequestMapping(value="E_Pdswrite.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Pdswrite(Model model) throws Exception{
		logger.info("E_PdsController E_Pdswrite");				

		return "E_Pdswrite.tiles";
	}
	@RequestMapping(value="E_PdswriteAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_PdswriteAf(Model model, E_PdsDto pdsdto,E_PdsBean epdsb, HttpServletRequest req,
		                    @RequestParam(value="fileload", required=false) MultipartFile fileload) {
		logger.info("E_PdsController E_PdswriteAf");
		pdsdto.setFilename(fileload.getOriginalFilename());
		logger.info("fileload:" + fileload);		
		// tomcat // 폴더 // String fupload = "f:\\upload"; 
		String fupload = req.getServletContext().getRealPath("/upload");
		logger.info("파일 저장 경로:" + fupload);		
		
		String f = pdsdto.getFilename();
		logger.info("f:" + f);		
		// 날짜/시간 번호, 시퀀스
		pdsdto.setOrg_filename(f);
		epdsb.setOrg_filename(f);
		
		String newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
		pdsdto.setFilename(newFile);
		epdsb.setFilename(newFile);
		
		logger.info("newFile:" + newFile);		
		System.out.println(pdsdto.toString());
		File file = new File(fupload + "/" + newFile);
		logger.info("file:" + file);		
		try {
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			//DB에 추가
			e_PdsService.uploadPds(epdsb);
			System.out.println("파일 업로드 성공");
		} catch (IOException e) {System.out.println("파일 업로드 실패" + e);}
		
		return "redirect:/E_Pdslist.do";
	}
	
	
}
