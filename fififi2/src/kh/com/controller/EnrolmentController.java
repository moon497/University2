package kh.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.com.model.AssessmentDto;
import kh.com.model.EnrollDto;
import kh.com.model.MemberDto;
import kh.com.model.SubjectDto;
import kh.com.service.AssessmentService;
import kh.com.service.EnrolmentService;
import kh.com.service.LoginService;

@Controller
public class EnrolmentController {
	private static final Logger logger = LoggerFactory.getLogger(EnrolmentController.class);
	
	@Autowired
	EnrolmentService enrolmentService;

	@Autowired
	AssessmentService assessmentService;
	
	@RequestMapping(value="enrolment.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String enrolment(HttpServletRequest req, Model model)throws Exception {
		logger.info("진입");
		
		MemberDto login = ((MemberDto)req.getSession().getAttribute("login"));		
		model.addAttribute("user", login);
		
		if (login != null && login.getUser_auth().equals("100")) {
			return "enrolment.tiles";			
		} else {
			return "checkStudent.tiles";
		}
		
				
	}
	
	@RequestMapping(value="registration.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String registration(HttpServletRequest req, Model model)throws Exception {		
		logger.info("EnrolmentController registration");
		
		MemberDto user = ((MemberDto)req.getSession().getAttribute("login"));		
		model.addAttribute("user", user);		
		return "registration.tiles";
	}
	
	@RequestMapping(value="registrationAf.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String registrationAf(HttpServletRequest req, SubjectDto sub, Model model)throws Exception {		
		logger.info("EnrolmentController registrationAf");
		
		MemberDto user = ((MemberDto)req.getSession().getAttribute("login"));
		
		sub.setMajor_number(user.getProf_major());
		sub.setProfessor_name(user.getUser_name());	
		
		System.out.println("결과: "+sub.toString());
		enrolmentService.addSubject(sub);		
		
		return "redirect:/main.do";
	}
	
	
	@RequestMapping(value="registrationlist.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String registrationlist(HttpServletRequest req, Model model)throws Exception {
		logger.info("EnrolmentController registrationlist");
		
		String id = ((MemberDto)req.getSession().getAttribute("login")).getUser_id();		
		List<SubjectDto> reglist = enrolmentService.getSublist(id);				
		model.addAttribute("reglist", reglist);
		
		return "registrationlist.tiles";
	}
	
	
	@RequestMapping(value="addReg.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String addreg(int seq, Model model)throws Exception {
		logger.info("EnrolmentController addReg");
		SubjectDto sub = enrolmentService.getReg(seq);
		model.addAttribute("sub", sub);
		
		return "addReg.tiles";
	}
		
	@RequestMapping(value="addRegAf.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String addRegAf(SubjectDto sub, Model model)throws Exception {
		logger.info("EnrolmentController addRegAf");		
		System.out.println("결과: "+sub.toString());
		enrolmentService.addClassTime(sub);		
		
		return "redirect:/main.do";
	}
	
	
	@RequestMapping(value="delReg.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String delreg(int seq, Model model)throws Exception {
		logger.info("EnrolmentController delReg");
	//	System.out.println("seq" + seq);
		enrolmentService.deleteReg(seq);
		
		return "redirect:/registrationlist.do";
	}
	
	@RequestMapping(value="subsearch.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String subsearch(HttpServletRequest req, String major, Model model)throws Exception {
		logger.info("EnrolmentController subsearch");
//		System.out.println("major : " + major);
		
		MemberDto mem = ((MemberDto)req.getSession().getAttribute("login"));	
		
		List<SubjectDto> list = enrolmentService.getEnrollist(major);
		System.out.println(list.toString());
		
		model.addAttribute("user", mem);				
		model.addAttribute("major", major);
		model.addAttribute("sublist", list);
		
		return "enrolment.tiles";
	}
	
	
	@RequestMapping(value="addSub.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public @ResponseBody String addSub(HttpServletRequest req)throws Exception {
		
		int seq = Integer.parseInt(req.getParameter("sub_seq"));		
		System.out.println("sub_seq : " + req.getParameter("sub_seq"));
		
		MemberDto mem = ((MemberDto)req.getSession().getAttribute("login"));
		System.out.println("mem : " + mem.toString());

		SubjectDto sub = enrolmentService.getReg(seq);

		System.out.println("sub : " + sub.toString());

		AssessmentDto as = new AssessmentDto();
		as.setSub_seq_num(sub.getSub_seq());
		as.setStudent_id(mem.getUser_id());
		as.setStudent_name(mem.getUser_name());
		as.setProfessor_id(sub.getProfessor_id());
		as.setProfessor_name(sub.getProfessor_name());

		System.out.println(as.toString());
				
		assessmentService.addSub(as);
		
		System.out.println("end mem : " + mem.toString());

				
		return "redirect:/main.do";		
	}
	
}