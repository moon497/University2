package kh.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import kh.com.model.E_BbsDto;
import kh.com.service.E_BbsService;

public class DownloadView extends AbstractView{

	@Autowired E_BbsService e_bbsservice;
	public DownloadView() {
		System.out.println("DownloadView DownloadView()");
		setContentType("application/download; charset=utf-8");
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		File file = (File) model.get("downloadFile");
		File file2 = (File) model.get("downloadFile2");
		response.setContentType(getContentType());
		response.setContentLength((int)file.length());
		
		String userAgent = request.getHeader("User-Agent");
		
		boolean ie = userAgent.indexOf("MSIE") > -1;
		String fileName = null;
		if(ie) fileName = URLEncoder.encode(file2.getName(), "utf-8");
		else   fileName = new String(file2.getName().getBytes("utf-8"), "iso-8859-1");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setHeader("Content-Length", "" + file.length());
		response.setHeader("Pragma", "no-cache;"); 
		response.setHeader("Expires", "-1;");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fi = null;
		fi = new FileInputStream(file);
		FileCopyUtils.copy(fi, out);
		
		if(fi != null) fi.close();
		out.flush();
	}
	
}
