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

import kh.com.model.AssessmentDto;
import kh.com.model.MemberDto;
import kh.com.model.StudentDTO; 
import kh.com.model.SubjectDto;
import kh.com.service.AssessmentService;
import kh.com.service.EnrolmentService;

@Controller
public class AssessmentController {
	
	@Autowired
	AssessmentService assessmentService;
	
	@Autowired
	EnrolmentService enrolmentService;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 수강신청 
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
		assessmentService.addnowStudent(sub.getSub_seq());
						
		System.out.println("end mem : " + mem.toString());

				
		return "추가 성공";		
	}
	
	// 나의 수강 목록 보기
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
	
	// 수강 삭제
	@RequestMapping(value="asDelete.do", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody String enrollDelete(HttpServletRequest req, Model model) throws Exception {
		logger.info("진입");
		int sub_seq;
		
		sub_seq = Integer.parseInt(req.getParameter("sub_seq"));
		MemberDto mem = (MemberDto)req.getSession().getAttribute("login");
		
		AssessmentDto as = new AssessmentDto();
		as.setSub_seq_num(sub_seq);
		as.setStudent_id(mem.getUser_id());
		
		assessmentService.deleteAs(as);
		assessmentService.minusNowStudent(sub_seq);
		
		return "삭제 성공";
	}	
	
	
	// 학점 계산
	@RequestMapping(value="sumpoint.do", method= {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody StudentDTO sumpoint(HttpServletRequest req, Model model) throws Exception {
		
		String student_id = req.getParameter("student_id");
		System.out.println("student_id : " + student_id);
		
		StudentDTO student = assessmentService.getStudent(student_id);
		List<AssessmentDto>list = assessmentService.sumPoint(student_id);
		SubjectDto sub = new SubjectDto();
		
		int totalPoint = 0;
		int seq = 0;
		int point = 0;
		
		for (int i = 0; i < list.size(); i++) {
			seq = list.get(i).getSub_seq_num();
			sub = enrolmentService.getReg(seq);
			point = sub.getSub_point();
			totalPoint += point;
		}
		
		if(student.getStudent_term() % 2 == 1) {
			student.setStudent_term(1);
		}if(student.getStudent_term() % 2 == 0) {
			student.setStudent_term(2); 
		}   
		
		student.setTotalPoint(totalPoint);		// 이번학기 총 수강 학점
		
		System.out.println("student : " + student);
		
		return student;
	}
	
	
	@RequestMapping(value="schedule.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String schedule(HttpServletRequest req, Model model) throws Exception {
		
		MemberDto mem = (MemberDto)req.getSession().getAttribute("login");
		StudentDTO student = assessmentService.getStudent(mem.getUser_id());
		
		//학생이 듣는 과목 불러오기 
		List<AssessmentDto>list = assessmentService.sumPoint(student.getStudent_id());
		
		model.addAttribute("student", student);
		model.addAttribute("sublist", list);
		
		return "schedule.tiles";
	}
	
	
	@RequestMapping(value="ProInfo.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String ProInfo(HttpServletRequest req, Model model) throws Exception {
		logger.info("ProInfo");
				
		MemberDto login = (MemberDto)req.getSession().getAttribute("login");
		System.out.println("mem : " + login.toString());
		
		MemberDto user = assessmentService.getUsers(login.getUser_id());
		System.out.println("user : " + user.toString());
		
		MemberDto prof = assessmentService.getProf(login.getUser_id());
		prof.setUser_id(user.getUser_id());
		prof.setUser_name(user.getUser_name());
		prof.setUser_email(user.getUser_email());
		prof.setUser_phone(user.getUser_phone());
		prof.setUser_photo(user.getUser_photo());
		
		System.out.println(prof.toString());
		
		model.addAttribute("prof", prof);
		
		return "Pro.tiles";
	}
	
	// 교수 정보수정
	@RequestMapping(value="updateProInfo.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateProInfo(MemberDto mem, Model model) throws Exception {
		logger.info("updateProInfo");
		System.out.println("정보수정 : " + mem.toString());
		
		assessmentService.updateProInfo(mem);	// prof 테이블 수정
		assessmentService.updateProInfo2(mem);	// user 테이블 수정
		
		return "redirect:/ProInfo.do";
	}
	
}





