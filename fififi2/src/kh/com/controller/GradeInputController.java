package kh.com.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import kh.com.model.AssessmentDto;
import kh.com.model.MemberDto;
import kh.com.model.SubjectDto;
import kh.com.service.AssessmentService;
import kh.com.service.SubjectService;

@Controller
public class GradeInputController {
	private static final Logger logger = LoggerFactory.getLogger(GradeInputController.class);
		
		 
	@Autowired
	AssessmentService assessmentService;
	
	@Autowired
	SubjectService subjectService;

	
	//성적등록화면
	@RequestMapping(value="gradeinput.do", method={RequestMethod.GET, RequestMethod.POST})
	public String classList(HttpServletRequest req, Model model) throws Exception{
		model.addAttribute("doc_title", "교직원");	
		model.addAttribute("doc_title_sub", "성적입력");

		
		MemberDto login = ((MemberDto)req.getSession().getAttribute("login"));
		
		List<SubjectDto> subList = subjectService.getSubjectList(login.getUser_id());
	
		AssessmentDto dto = new AssessmentDto();
		dto.setProfessor_id(login.getUser_id());
		dto.setSub_seq_num(getSeq(req));
		List<AssessmentDto> list = assessmentService.gradeList(dto);
		
		model.addAttribute("list", list);
		model.addAttribute("subList", subList);

		logger.info("처리완료");
		
		return "gradeinputlist.tiles";
	}
	

	@RequestMapping(value="gradeUpdate.do", method={RequestMethod.GET, RequestMethod.POST})
	public String gradeUpdate(HttpServletRequest req, Model model){
		logger.info("진입");
		
		//init
		int value;
		AssessmentDto dto;
		List<AssessmentDto> list = new ArrayList<>();
		
		Enumeration<String> names = req.getParameterNames();
		
		//입력쿼리 세팅
		while (names.hasMoreElements()) {
			String key = (String) names.nextElement();		
			if (key.equals("seq")) {
				//seq는 통과
			} else {	
				dto = new AssessmentDto();
				logger.info("key값: {}",key);
				value = getValue(req, key);
				
				dto.setSub_seq_num(getSeq(req));
				dto.setStudent_id(key);
				dto.setStudent_score(value);
				
				logger.info(dto.toString());

				list.add(dto);
			}
		}
		
		assessmentService.gradeUpdate(list);
		
		return "main.tiles";
	}

	/************************************************************
	 * 							Util Method 
	 * **********************************************************/
	
	private int getSeq(HttpServletRequest req) {
		int seq;
		
		if (req.getParameter("seq") == null) {
			seq = 0;
		} else {
			seq = Integer.parseInt(req.getParameter("seq"));
		}
		return seq;
	}
	
	private int getValue(HttpServletRequest req, String key) {
		int value;
		
		if (req.getParameter(key) == null) {
			value = 0;
		} else {
			value = Integer.parseInt(req.getParameter(key));
		}
		return value;
	}
	
	
	
	
}
