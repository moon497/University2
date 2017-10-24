package kh.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import kh.com.model.MemberDto;
import kh.com.model.QuerySubjectDto;
import kh.com.model.StudentDTO;
import kh.com.model.SubjectDto;
import kh.com.service.AssessmentService;
import kh.com.service.EnrolmentService;
import kh.com.service.LoginService;

@Controller
public class EnrolmentController {
	
	@Autowired
	EnrolmentService enrolmentService;

	@Autowired
	AssessmentService assessmentService;
	
	private static final Logger logger 
	= LoggerFactory.getLogger(MemberController.class);
	
	// 수강신청 화면 
	@RequestMapping(value="enrolment.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String enrolment(HttpServletRequest req, Model model)throws Exception {
		logger.info("진입");
		
		MemberDto login = ((MemberDto)req.getSession().getAttribute("login"));
		StudentDTO student =  assessmentService.getStudent(login.getUser_id());
		
		if(login.getUser_auth().equals("200")){				
			return "redirect:/main.do";			
		}else if(login.getUser_auth().equals("300")){
			return "redirect:/main.do";			
		}else {			
			if(student.getStudent_term() % 2 == 1) {
				student.setStudent_term(1);
			}if(student.getStudent_term() % 2 == 0) {
				student.setStudent_term(2);
			}  
			
			model.addAttribute("student", student);
			
			if (login != null && login.getUser_auth().equals("100")) {
				return "enrolment.tiles";			
			} else {
				return "checkStudent.tiles";
			}
		}
	}
	
	// 교수 강의등록 
	@RequestMapping(value="registration.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String registration(HttpServletRequest req, Model model)throws Exception {		
		logger.info("EnrolmentController registration");
		MemberDto user = ((MemberDto)req.getSession().getAttribute("login"));	
		System.out.println("강의등록 전 : " + user.toString());						
		model.addAttribute("user", user);			
		return "registration.tiles";
		
	}
	
	// 교수 강의등록 
	@RequestMapping(value="registrationAf.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String registrationAf(HttpServletRequest req, SubjectDto sub, Model model)throws Exception {		
		logger.info("EnrolmentController registrationAf");
		
		MemberDto user = ((MemberDto)req.getSession().getAttribute("login"));
		System.out.println("강의등록 af : " + user.toString());			
		
		if (user.getUser_auth().equals("200") == false) {
			return "checkLogin.tiles";
		}
		MemberDto prof = assessmentService.getProf(user.getUser_id());		
	/*	
		prof.setUser_id(user.getUser_id());
		prof.setUser_name(user.getUser_name());
		prof.setUser_email(user.getUser_email());
		prof.setUser_phone(user.getUser_phone());
		prof.setUser_address(user.getUser_address());
		prof.setUser_birth(user.getUser_birth());
		prof.setUser_auth(user.getUser_auth());
		prof.setUser_status(user.getUser_status());
	*/
		System.out.println(prof.toString());
		
		sub.setMajor_number(prof.getProf_major());
		sub.setProfessor_id(user.getUser_id());
		sub.setProfessor_name(user.getUser_name());
		
		
		System.out.println("결과 prof : " + prof.toString());		
		System.out.println("결과: " + sub.toString());
		
		enrolmentService.addSubject(sub);		
		
		return "redirect:/registrationlist.do";
	}
	
	// 교수의 강의 목록
	@RequestMapping(value="registrationlist.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String registrationlist(HttpServletRequest req, Model model)throws Exception {
		logger.info("EnrolmentController registrationlist");
		
		String id = ((MemberDto)req.getSession().getAttribute("login")).getUser_id();		
		List<SubjectDto> reglist = enrolmentService.getSublist(id);				
		model.addAttribute("reglist", reglist);
		
		return "registrationlist.tiles";
	}
	
	// 교수 강의 추가 
	@RequestMapping(value="addReg.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String addreg(int seq, Model model)throws Exception {
		logger.info("EnrolmentController addReg");
		SubjectDto sub = enrolmentService.getReg(seq);
		model.addAttribute("sub", sub);
		
		return "addReg.tiles";
	}
		
	// 교수 강의 추가 
	@RequestMapping(value="addRegAf.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String addRegAf(SubjectDto sub, Model model)throws Exception {
		logger.info("EnrolmentController addRegAf");		
		System.out.println("결과: "+sub.toString());
		enrolmentService.addClassTime(sub);		
		
		return "redirect:/registrationlist.do";
	}
	
	// 교수 강의 삭제
	@RequestMapping(value="delReg.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public String delreg(int seq, Model model)throws Exception {
		logger.info("EnrolmentController delReg");
	//	System.out.println("seq" + seq);
		enrolmentService.deleteReg(seq);
		
		return "redirect:/registrationlist.do";
	}
	
	//강의 수정 페이지
	@RequestMapping(value="updateReg.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateReg(HttpServletRequest req, int seq, Model model) throws Exception {
		logger.info("EnrolmentController updateReg");
		MemberDto user = ((MemberDto)req.getSession().getAttribute("login"));	
		System.out.println("강의등록 전 : " + user.toString());						
				
		System.out.println("seq : " + seq);
		SubjectDto sub = enrolmentService.getReg(seq);
		System.out.println("sub : " + sub);
		
		model.addAttribute("sub", sub);
		model.addAttribute("user", user);	
		return "upReg.tiles";
	}
	
	//강의 수정 POST
	@RequestMapping(value="updateRegAf.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateRegAf(SubjectDto sub, Model model) throws Exception {
		logger.info("진입");
		
		//강의 수정
		enrolmentService.updateReg(sub);	
		
		//강의 목록 화면으로
		return "redirect:/registrationlist.do";
	}
	
	
	// 수강신청화면에서 강의목록 
	@RequestMapping(value="sublist.do", method= {RequestMethod.GET, RequestMethod.POST,})
	public @ResponseBody List<SubjectDto> sublist(HttpServletRequest req, String major, Model model)throws Exception {
				
		MemberDto mem = ((MemberDto)req.getSession().getAttribute("login"));
		
		QuerySubjectDto query = new QuerySubjectDto();
		
		query.setMajor(major);
		query.setUser_id(mem.getUser_id());
		
		List<SubjectDto> list = enrolmentService.getEnrollist(query);
		System.out.println(list.toString());		
			
		return list;
	}
	
	
}