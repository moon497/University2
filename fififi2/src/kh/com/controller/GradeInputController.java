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

import kh.com.model.AssessmentDto;
import kh.com.model.MemberDto;
import kh.com.model.SubjectDto;
import kh.com.service.AssessmentService;
import kh.com.service.GradeInputService;
import kh.com.service.SubjectService;

@Controller
public class GradeInputController {
	private static final Logger logger = LoggerFactory.getLogger(GradeInputController.class);
		
	@Autowired
	GradeInputService gradeinputService;	

	@Autowired
	AssessmentService assessmentService;
	
	@Autowired
	SubjectService subjectService;
	
	//성적등록화면
	@RequestMapping(value="gradeinput.do", method={RequestMethod.GET, RequestMethod.POST})
	public String classList(HttpServletRequest req, Model model) throws Exception{
		logger.info("진입");

		//init
		MemberDto login;
		List<AssessmentDto> list;
		List<SubjectDto> subList;
		AssessmentDto as = new AssessmentDto();
		int sub_seq_num;
		
		//변수받기
		login = ((MemberDto)req.getSession().getAttribute("login"));
		sub_seq_num = getSeq(req);
		
		//입력용 변수 준비
		as.setProfessor_id(login.getUser_id());
		as.setSub_seq_num(sub_seq_num);
		
		//데이터 받아오기
		subList = subjectService.getSubjectList(login.getUser_id());
		list = assessmentService.scoreList(as);
		
		model.addAttribute("list", list);
		model.addAttribute("subList", subList);
		
		logger.info("처리완료");
		
		return "gradeinputlist.tiles";
	}
	
	//성적등록처리
	@RequestMapping(value="scoreMassUpdate.do", method={RequestMethod.GET, RequestMethod.POST})
	public String test(HttpServletRequest req, Model model){
		logger.info("진입");
		
		//init
		int sub_seq_num;
		int value;
		AssessmentDto as;
		List<AssessmentDto> list = new ArrayList<>();
		
		Enumeration<String> names = req.getParameterNames();
		sub_seq_num = getSeq(req);
		
		//입력쿼리 세팅
		while (names.hasMoreElements()) {
			String key = (String) names.nextElement();		
			if (key.equals("seq")) {
				//seq는 통과
			} else {	
				as = new AssessmentDto();
				logger.info("key값: {}",key);
				value = getValue(req, key);
				
				as.setSub_seq_num(sub_seq_num);
				as.setStudent_id(key);
				as.setStudent_score(value);
				
				logger.info(as.toString());

				list.add(as);
			}
			
		}
		
		assessmentService.massUpdateScore(list);
		
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
