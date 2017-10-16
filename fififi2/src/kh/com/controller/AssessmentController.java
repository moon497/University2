package kh.com.controller;

import java.util.ArrayList;
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

import kh.com.model.SubjectDto;
import kh.com.service.AssessmentService;

@Controller
public class AssessmentController {
	
	@Autowired
	AssessmentService assessmentService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="", method= {RequestMethod.GET, RequestMethod.POST,})
	public String ee(HttpServletRequest req, Model model)throws Exception {
		
				
		return "ee";
	}
	
	@RequestMapping(value="asList.do", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody List<SubjectDto> enrolmentList(HttpServletRequest req, Model model)throws Exception {
		List<SubjectDto> list = new ArrayList<>();
		logger.info("진입");
		String id;
		
		id = req.getParameter("user_id");
		
		list = assessmentService.getAsListFromUser(id);
		
		logger.info("size: {}",list.size());
		
		for (SubjectDto subjectDto : list) {
			logger.info(subjectDto.toString());
		}
		
		return list;
	}
	
	@RequestMapping(value="asDelete.do", method= {RequestMethod.GET})
	public String enrollDelete(HttpServletRequest req, Model model) throws Exception {
		logger.info("진입");
		int sub_seq;
		
		sub_seq = Integer.parseInt(req.getParameter("seq"));
		
		assessmentService.deleteAs(sub_seq);
		
		return "enrolment.tiles";
	}
	
	
}