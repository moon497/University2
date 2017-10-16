package kh.com.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.model.MemberDto;
import kh.com.model.ProfEvaluationDTO;
import kh.com.service.IntraService;

@Controller
public class IntranetController {
	
	@Autowired
	IntraService khIntraService;
	
	private static final Logger logger 
	= LoggerFactory.getLogger(IntranetController.class);
	
	/**
	 * 메인페이지 
	 */
	@RequestMapping(value="intranet.do", method=RequestMethod.GET)
	public String intranet(Model model) {
		logger.info("KhIntranetController intranet");
		return "intranet.tiles";
	}
	
	/**
	 * 해당학생이 평가해야할 강의목록 불러오기
	 */
	@RequestMapping(value="assessment.do", method={RequestMethod.GET, RequestMethod.POST})
	public String assessment(Model model, HttpServletRequest req) throws Exception {
		logger.info("KhIntranetController assessment");
		//info.setStudent_id("jiyuns");
		
		ProfEvaluationDTO info = new ProfEvaluationDTO();
		String id = ((MemberDto)req.getSession().getAttribute("login")).getUser_id();
		info.setStudent_id(id);
		
		model.addAttribute("doc_title", "학사인트라넷");
		model.addAttribute("doc_title_sub", "교수평가 ");
		
		List<ProfEvaluationDTO> list =  khIntraService.ProfEvaluation(info);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		model.addAttribute("assessmentList", list);
		
		return "assessment.tiles";
	}
	
	/**
	 * 교수평가 제출
	 */
	@ResponseBody
	@RequestMapping(value="assessmentAf.do", produces="application/String; charset=utf-8", method={RequestMethod.GET, RequestMethod.POST})
	public String assessmentAf(ProfEvaluationDTO pdfo) throws Exception {
		logger.info("KhIntranetController assessmentAf");
		System.out.println("★ : " + pdfo.toString());
		
		boolean b = khIntraService.addProfessorGrade(pdfo);
		
		if(b == true) {
			return "평가를 성공적으로 하였습니다.";
		}else {
			return "평가를 실패하였습니다.";
		}		
	}

}
