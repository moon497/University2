package kh.com.controller;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.model.MemberDto;
import kh.com.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginservice;
	
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger 
	= LoggerFactory.getLogger(LoginController.class);
	
	
	//2->02
	public static String two(String tt){
		String ss="";
		return (tt+"").length()>1?(tt+""):"0"+tt;
	}
	
	@RequestMapping(value="login.do", method={RequestMethod.GET, RequestMethod.POST})
	public String login(Model model) throws Exception{
		logger.info("login.do");
		model.addAttribute("doc_title", "기타");
		model.addAttribute("doc_title_sub", "로그인");
		return "login.tiles";
	}

	@RequestMapping(value="loginAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String loginAf(Model model, MemberDto dto, HttpServletRequest req) throws Exception{
		logger.info("loginAf.do");
		MemberDto login = null;
		login = loginservice.login(dto);
		logger.info("유저: {}",login.toString());
	
		if(login != null && !login.getUser_id().equals("")) {
			req.getSession().setAttribute("login", login);			
			System.out.println("loginAf.do의 로그인 된 id : " +login.getUser_id());
			return "redirect:/main.do";
		}else {
			System.out.println("여기");
			return "redirect:/login.do";
		}	
	}
	
	@RequestMapping(value="logout.do", method={RequestMethod.GET, RequestMethod.POST})
	public String logout(Model model, HttpServletRequest req) throws Exception{
		logger.info("logout.do " + new Date());		
		req.getSession().invalidate();			
		return "redirect:/main.do";	
	}
	
	//아이디찾기
	@RequestMapping(value="findId.do" , method={RequestMethod.GET, RequestMethod.POST})
	public String findId(Model model) throws Exception{
		logger.info("LoginController findId");
		model.addAttribute("doc_title", "기타");	
		model.addAttribute("doc_title_sub", "아이디찾기");
		
		return "findId.tiles";
	}
	
	@RequestMapping(value="findIdAf.do" , method={RequestMethod.GET, RequestMethod.POST})
	public String findIdAf(Model model, MemberDto dto) throws Exception{
		logger.info("LoginController findIdAf");
		model.addAttribute("doc_title", "기타");
		model.addAttribute("doc_title_sub", "아이디찾기");
		
		String findid = loginservice.findid(dto);
		if(findid != null && !findid.equals("")) {
			model.addAttribute("findid", findid);
			return "findIdPwAf.tiles";  
		}else {
			return "findIdPwAf.tiles";
		}
	}
	
	//비밀번호찾기
	@RequestMapping(value="findPw.do" , method={RequestMethod.GET, RequestMethod.POST})
	public String findPw(Model model) throws Exception{
		logger.info("LoginController findPw");
		model.addAttribute("doc_title", "기타");
		model.addAttribute("doc_title_sub", "비밀번호찾기");
		
		return "findPw.tiles";
	}

	@RequestMapping(value="findPwAf.do" , method={RequestMethod.GET, RequestMethod.POST})
	public String findPwAf (Model model, MemberDto dto) throws Exception{
			logger.info("LoginController findPw");
			model.addAttribute("doc_title", "기타");
			model.addAttribute("doc_title_sub", "비밀번호찾기");
		
			MemberDto findpw = loginservice.findpw(dto);
			if(findpw == null || findpw.getUser_pw().equals("") ) {
				return "findIdPwAf.tiles";
			
			}else {

			System.out.println(findpw.getUser_email()  +  " : email");
		   
			String setfrom = "junghyejunghye@gmail.com";         
		    String tomail  = findpw.getUser_email();     // 받는 사람 이메일
		    String title   = "KH대학교 비밀번호 입니다";      // 제목
		    String content = "KH대학교 찾으시는 해당 비밀번호는 : " + findpw.getUser_pw() + " 입니다";    // 내용
		    
		    System.out.println(setfrom);
		    System.out.println(tomail);
		    System.out.println(title);
		    System.out.println(content);
		    SimpleMailMessage message = new SimpleMailMessage();
		    System.out.println("1/1/1");
		    
		    message.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
		    message.setTo(tomail);     // 받는사람 이메일
		    message.setSubject(title); // 메일제목은 생략이 가능하다
		    message.setText(content);  // 메일 내용
		    System.out.println("1/2");
		    
		    
		    mailSender.send(message);
		    System.out.println("1/3");
		    model.addAttribute("findpw", findpw.getUser_email());
		    System.out.println("1/4");
		        
		   return "findIdPwAf.tiles";
	
		}
	}
	
	//회원가입
	@RequestMapping(value="regi.do", method={RequestMethod.GET, RequestMethod.POST})
	public String regi(Model model) throws Exception{
		logger.info("LoginController regi");
		model.addAttribute("doc_title", "교직원");
		model.addAttribute("doc_title_sub", "회원가입");
		return "regiview.tiles";
	}
	
	@RequestMapping(value="regiview.do", method={RequestMethod.GET, RequestMethod.POST})
	public String regi(Model model, int t) throws Exception{
		logger.info("LoginController regi");
		model.addAttribute("doc_title", "교직원");
		model.addAttribute("doc_title_sub", "회원가입");
		
		if(t==1) {
		return "regi_s.tiles";
		}
		else if(t==2){
		return "regi_p.tiles";
		}
		else if(t==3){
		return "regi_a.tiles";
		}
		return "regiview_tiles";
	}
	
	@RequestMapping(value="regiAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String regiAf(Model model, MemberDto dto, 
						String user_birth1, String user_birth2, String user_birth3,
						String user_phone1, String user_phone2, String user_phone3,   	
						String postcode, String roadAddress, String detailAddress) throws Exception {
		
		dto.setUser_birth(user_birth1 + two(user_birth2) +  two(user_birth3)); //년도,월,일 합쳐서 넣기
		dto.setUser_phone(user_phone1+user_phone2+user_phone3); //핸드폰 번호 3자리 합쳐서 넣기 
		dto.setUser_address(roadAddress+detailAddress); // 주소 합쳐 넣기 
		
	    logger.info(dto.toString());
		loginservice.addMember(dto);
		logger.info("regiAf 2/2");
		
		return "regiAf.tiles";
	}
	
//    @RequestMapping(value="excelread.do",method={RequestMethod.GET, RequestMethod.POST})
//	public String excelread(Model model, String fileread) throws Exception {
//    	logger.info("excelread");
//
//		MemberDto dto = new MemberDto();
//		
//		FileInputStream fis = new FileInputStream("F:\\"+fileread);
//		logger.info("fileread: " + fileread);
//	
//		int rowindex=0;
//		int columnindex=0;
//		
//		if(fileread.toUpperCase().endsWith(".XLS")) {
//			logger.info("--------------");
//			HSSFWorkbook workbook = new HSSFWorkbook(fis);
//			HSSFSheet sheet = workbook.getSheetAt(0);
//			//시트 수 (첫번째에만 존재하므로 0을 준다)
//			//만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
//		
//			
//			//행의 수
//			int rows=sheet.getPhysicalNumberOfRows();
//			for(rowindex=1;rowindex<rows;rowindex++){
//			    
//				//행을읽는다
//			    HSSFRow row=sheet.getRow(rowindex);
//			    if(row !=null){
//			        
//			    	//셀의 수
//			        int cells=row.getPhysicalNumberOfCells();
//			        for(columnindex=0;columnindex<=cells;columnindex++){
//			            //셀값을 읽는다
//			            HSSFCell cell=row.getCell(columnindex);
//			            
//			            String value="";
//			            //셀이 빈값일경우를 위한 널체크
//			            if(cell==null){
//			                continue;
//			            }else{
//			                //타입별로 내용 읽기
//			                switch (cell.getCellType()){
//			                case HSSFCell.CELL_TYPE_FORMULA:
//			                    value=cell.getCellFormula();
//			                    break;
//			                case HSSFCell.CELL_TYPE_NUMERIC:
//			                    value=cell.getNumericCellValue()+"";
//			                    break;
//			                case HSSFCell.CELL_TYPE_STRING:
//			                    value=cell.getStringCellValue()+"";
//			                    break;
//			                case HSSFCell.CELL_TYPE_BLANK:
//			                    value=cell.getBooleanCellValue()+"";
//			                    break;
//			                case HSSFCell.CELL_TYPE_ERROR:
//			                    value=cell.getErrorCellValue()+"";
//			                    break;
//			                }
//			            }
//			           
//			            switch (columnindex) {
//						case 0: 
//							dto.setUser_id(value);
//							break;
//						case 1: 
//							dto.setUser_pw(value);;
//							break;
//						case 2: 
//							dto.setUser_name(value);
//							break;
//						case 3: 
//							dto.setUser_email(value);
//							break;
//						case 4: 
//							dto.setUser_phone(value);
//							break;
//						case 5: 
//							dto.setUser_address(value);
//							break;
//						case 6: 
//							dto.setUser_birth(value);
//							break;
//						case 7: 
//							dto.setUser_auth(value);
//							break;
//						case 8: 
//							dto.setMajor_number(value);
//							break;	
//						case 9: 
//							dto.setUser_status(value);
//							break;	
//						case 10: 
//							dto.setStudent_regidate(value);
//							break;
//						case 11: 
//							int n = Integer.parseInt(value);
//							dto.setStudent_year(n);
//							break;
//						default:
//							break;
//						}
//			           System.out.println("내용"+value);
//			           System.out.println(dto.toString());
//			        }
//			        System.out.println("최종 dto : " +dto.toString());
//			        loginservice.addMember(dto);
//			        System.out.println();
//			    }
//			}
//		}else if(fileread.toUpperCase().endsWith(".XLSX")) {
//			
//			XSSFWorkbook workbook=new XSSFWorkbook(fis);
//	 		XSSFSheet sheet=workbook.getSheetAt(0);
//	 		int rows=sheet.getPhysicalNumberOfRows();
//			for(rowindex=1;rowindex<rows;rowindex++){
//			    
//				//행을읽는다
//			    XSSFRow row=sheet.getRow(rowindex);
//			    if(row !=null){
//			        
//			    	//셀의 수
//			        int cells=row.getPhysicalNumberOfCells();
//			        for(columnindex=0;columnindex<=cells;columnindex++){
//			            //셀값을 읽는다
//			            XSSFCell cell=row.getCell(columnindex);
//			            
//			            String value="";
//			            //셀이 빈값일경우를 위한 널체크
//			            if(cell==null){
//			                continue;
//			            }else{
//			                //타입별로 내용 읽기
//			                switch (cell.getCellType()){
//			                case XSSFCell.CELL_TYPE_FORMULA:
//			                    value=cell.getCellFormula();
//			                    break;
//			                case XSSFCell.CELL_TYPE_NUMERIC:
//			                    value=cell.getNumericCellValue()+"";
//			                    break;
//			                case XSSFCell.CELL_TYPE_STRING:
//			                    value=cell.getStringCellValue()+"";
//			                    break;
//			                case XSSFCell.CELL_TYPE_BLANK:
//			                    value=cell.getBooleanCellValue()+"";
//			                    break;
//			                case XSSFCell.CELL_TYPE_ERROR:
//			                    value=cell.getErrorCellValue()+"";
//			                    break;
//			                }
//			            }
//			           
//			            switch (columnindex) {
//						case 0: 
//							dto.setUser_id(value);
//							break;
//						case 1: 
//							dto.setUser_pw(value);;
//							break;
//						case 2: 
//							dto.setUser_name(value);
//							break;
//						case 3: 
//							dto.setUser_email(value);
//							break;
//						case 4: 
//							dto.setUser_phone(value);
//							break;
//						case 5: 
//							dto.setUser_address(value);
//							break;
//						case 6: 
//							dto.setUser_auth(value);
//							break;
//						case 7: 
//							dto.setMajor_number(value);
//							break;	
//						case 8: 
//							dto.setUser_status(value);
//							break;	
//						default:
//							break;
//						}
//			           System.out.println("내용"+value);
//			           System.out.println(dto.toString());
//			        }
//			        System.out.println("한개 밖 dto" +dto.toString());
//			        loginservice.addMember(dto);
//			        System.out.println();
//			    }
//			}
//		}
//		return "regiAf.tiles";
//	}	
	
	
	
	
}
