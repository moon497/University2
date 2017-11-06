package kh.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.service.impl.FileService;
import kh.com.model.File;
import kh.com.util.FileUpload;

@Controller
public class FileController {
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	FileService serv;
	
	/*************************************************
	 * 					CREATE
	 * ***********************************************/	
	//이미지 업로드 기능
	@RequestMapping(value="/file/image/upload.do",method=RequestMethod.POST)
	public @ResponseBody String insertImage(MultipartHttpServletRequest req, MultipartFile file) {
		logger.info("진입");
		//init
		FileUpload fileUpload;
		String path;
		String url;
		File fileDto = new File();
		
		//init
		path = req.getSession().getServletContext().getRealPath("/") + "upload/image/"; //파일 저장경로
		fileUpload = new FileUpload(file, path);

		//file
		fileDto.setFileSize(file.getSize());
		fileDto.setContentType(file.getContentType());
		fileDto.setOriginalFileName(fileUpload.getOrgFileName());
		fileDto.setStoredFileName(fileUpload.getStoredFileName());
				
        //action
		serv.insertFile(fileDto);
		
		//return
		url = req.getContextPath() + "/upload/image/" + fileUpload.getStoredFileName();
		
		return url;
	}
}
