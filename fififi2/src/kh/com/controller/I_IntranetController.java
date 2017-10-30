package kh.com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.map.HashedMap;
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
import kh.com.model.StudentDTO;
import kh.com.model.I_StudentBasicInfoDTO;
import kh.com.model.I_StudentGradeDTO;
import kh.com.model.I_semesterGradeDTO;
import kh.com.service.I_IntraService;

@Controller
public class I_IntranetController {
	
	@Autowired
	I_IntraService khIntraService;
	
	private static final Logger logger 
				= LoggerFactory.getLogger(I_IntranetController.class);
	
	/**
	 * 강의평가 : 해당학생이 평가해야할 강의목록 불러오기
	 */
	@RequestMapping(value="assessment.do", 
					method={RequestMethod.GET, RequestMethod.POST})
	public String assessment(Model model, HttpServletRequest req) 
													throws Exception {
		logger.info("KhIntranetController assessment");
		
		//init
		MemberDto login;
		ProfEvaluationDTO info = new ProfEvaluationDTO();
		String id = "";
		
		// 로그아웃
		if (((MemberDto)req.getSession().getAttribute("login")) == null) {
			login = new MemberDto();
			login.setUser_id("");
		} else {
		// 로그인
			login = ((MemberDto)req.getSession().getAttribute("login"));
			id = login.getUser_id();
			
			// 학생정보를 가져오는 메소드
			StudentDTO studentInformation 
						= khIntraService.StudentInformation(id);
			
			// 받아온 학생정보를 통해서 평가 강의목록 가져오기위해  해당 dto에 필요한 값 저장
			info.setStudent_id(studentInformation.getStudent_id());
			info.setSub_semester(studentInformation.getStudent_term());
			info.setStudent_year(studentInformation.getStudent_year());
			
			// 평가해야할 강의목록 리스트 가져오기
			List<ProfEvaluationDTO> list 
						= khIntraService.ProfEvaluation(info);
			model.addAttribute("assessmentList", list);
		}
		model.addAttribute("current", "current");
		model.addAttribute("selector", "assessment");
		model.addAttribute("doc_title", "학사인트라넷");
		model.addAttribute("doc_title_sub", "교수평가 ");
		
		return "assessment.tiles";
	}
	
	/**
	 * 강의평가 : 평가제출
	 */
	@ResponseBody
	@RequestMapping(value="assessmentAf.do", 
					produces="application/String; charset=utf-8", 
					method={RequestMethod.GET, RequestMethod.POST})
	public String assessmentAf(ProfEvaluationDTO pdfo) throws Exception {
		logger.info("KhIntranetController assessmentAf");
		boolean b = khIntraService.addProfessorGrade(pdfo);
		if(b == true) {
			return "평가를 성공적으로 하였습니다.";
		}else {
			return "평가를 실패하였습니다.";
		}		
	}
	
	/**
	 * 성적확인
	 */
	@RequestMapping(value="student_grade.do", 
					method={RequestMethod.GET, RequestMethod.POST})
	public String studentGrade(Model model, HttpServletRequest req) 
													throws Exception {
		logger.info("KhIntranetController studentGrade");
		model.addAttribute("doc_title", "성적확인");
		model.addAttribute("selector", "studentGrade");
		model.addAttribute("current", "current");
		
		//init
		MemberDto login;
		ProfEvaluationDTO info = new ProfEvaluationDTO();
		String id = "";
		
		// 로그아웃
		if (((MemberDto)req.getSession().getAttribute("login")) == null) {
			login = new MemberDto();
			login.setUser_id("");
		} else {
			login = ((MemberDto)req.getSession().getAttribute("login"));
			id = login.getUser_id();
			info.setStudent_id(id);
			
			// 성적 리스트 보여주기
			List<I_StudentGradeDTO> sdto 
					= khIntraService.StudentGradeCheck(info);
			// 합이 0이 아닐 경우 jsp로 값 안보내줌
			for (int i = 0; i < sdto.size(); i++) {
				if(sdto.get(i).getProfessor_grade() == 0) {
					System.out.println("아직 등록되지 않은 평가과목이 존재한다.");
					model.addAttribute("confirm","existNullgrade");
				}else {
					model.addAttribute("confirm","notexistNullgrade");
					model.addAttribute("StudentGrade", sdto);
				}
			}
			
			if(sdto.size() == 0) {
				model.addAttribute("confirm", "notseason");
			}
		}
		return "studentGrade.tiles";
	}
	
	/**
	 * 내정보
	 */
	@RequestMapping(value="updateInfo.do", 
					method={RequestMethod.GET, RequestMethod.POST})
	public String updateInfo(Model model, HttpServletRequest req) 
													throws Exception {
		logger.info("KhIntranetController updateInfo");
		model.addAttribute("doc_title", "내정보(학생)");
		model.addAttribute("current", "current");
		
		//init
		MemberDto login;
		String id = "";
		
		// 로그아웃
		if (((MemberDto)req.getSession().getAttribute("login")) == null) {
			login = new MemberDto();
			login.setUser_id("");
			
		} else {// 로그인
			login = ((MemberDto)req.getSession().getAttribute("login"));
			id = login.getUser_id();
			
			// 내정보 DTO에 담기
			I_StudentBasicInfoDTO basicInfo = khIntraService.studentBasicInfo(id);
			model.addAttribute("basicinfo", basicInfo);
		}
		return "updateInfo.tiles";
	}
	
	/**
	 * 학생 모든 성적확인
	 */
	@RequestMapping(value="semesterGrade.do", 
					method={RequestMethod.GET, RequestMethod.POST})
	public String semesterGrade(Model model, HttpServletRequest req) 
													throws Exception {
		logger.info("KhIntranetController semesterGrade");
		model.addAttribute("doc_title", "학기별 성적");
		
		//init
		MemberDto login;
		String id = "";
		int maxYear = 0; // 학년
		
		I_semesterGradeDTO grade = new I_semesterGradeDTO();
		
		// 로그아웃
		if (((MemberDto)req.getSession().getAttribute("login")) == null) {
			login = new MemberDto();
			login.setUser_id("");
		} else {
		// 로그인
			login = ((MemberDto)req.getSession().getAttribute("login"));
			id = login.getUser_id();
			
			StudentDTO studentInformation 
						= khIntraService.StudentInformation(id);
			grade.setStudent_id(studentInformation.getStudent_id());
			grade.setStudent_term(studentInformation.getStudent_term());
			
			//DB 받음
			List<I_semesterGradeDTO> gradeList 
							= khIntraService.semesterGrade(grade);
			
			for(int i=0; i < gradeList.size(); i++) {
				maxYear 
					= getMax(gradeList.get(i).getStudent_term(),maxYear);
			}
			if(gradeList.size() == 0) {
				System.out.println("등록된 성적 없음.");
			}else {
				maxYear = maxYear/2;
				model.addAttribute("Allgradelist", gradeList);
				model.addAttribute("gradelist", gradeList);
				model.addAttribute("maxYear",maxYear);
			}
		}
		return "semesterGrade.tiles";
	}
	// 학생 모든 성적확인 > 성적확인시 보여주는 부분
	private int getMax(int a, int b) {
		if (a >= b) {
			return a;
		} else {
			return b;
		}
	}
	
	/**
	 * 학생의 학기별 성적확인 
	 */
	@ResponseBody
	@RequestMapping(value="semesterGradechoice.do", 
					method={RequestMethod.GET, RequestMethod.POST})
	public List<I_semesterGradeDTO> semesterGradechoice(I_semesterGradeDTO grade) 
																throws Exception {
		logger.info("KhIntranetController semesterGradechoice");
		int grades = grade.getStudent_term();
		List<I_semesterGradeDTO> semelist 
					= khIntraService.semesterGradechoice(grade);
		
		return semelist;
	}
	
	/**
	 * 학생 내정보 변경
	 */
	@ResponseBody
	@RequestMapping(value="updateStudentInfo.do", 
					produces="application/String; charset=utf-8",
					method={RequestMethod.GET, RequestMethod.POST})
	public String updateStudentInfo(I_StudentBasicInfoDTO info) 
													throws Exception {
		logger.info("KhIntranetController updateStudentInfo");
		boolean b = khIntraService.updateStudentInfo(info);
		if(b == true) {
			return "수정이 완료되었습니다.";
		}else {
			return "수정이 실패되었습니다.";
		}	
	}
	
	/**
	 * 성적확인 후 성적확인 완료 버튼 클릭시 gradeConfirm.do
	 */
	@ResponseBody
	@RequestMapping(value="gradeConfirm.do", 
					produces="application/String; charset=utf-8",
					method={RequestMethod.GET, RequestMethod.POST})
	public String gradeConfirm(StudentDTO id) throws Exception {
		logger.info("KhIntranetController gradeConfirm");
		System.out.println("id : " + id);
		boolean confirm = khIntraService.studentTotalsemester(id);
		khIntraService.updateGradeConfirm(id);
		if(confirm == true) {
			return "성적확인을 완료하셨습니다.";
		}else {
			return "재시도해주세요";
		}
		
	}
}
