package kh.com.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.File;
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
import org.apache.poi.util.SystemOutLogger;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.com.model.MemberDto;
import kh.com.service.LoginService;
import kh.com.util.FileUpload;

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
	  System.out.println("재현이가 수정한 소스코드");
	  System.out.println("재현이가 수정한 소스코드2");
	   
      logger.info("login.do");
      model.addAttribute("doc_title", "기타");
      model.addAttribute("doc_title_sub", "로그인");
      return "login.tiles";
   }

   @ResponseBody
   @RequestMapping(value="loginAf.do", 
               produces="application/String; charset=utf-8",
               method={RequestMethod.GET, RequestMethod.POST})
   public String loginAf(MemberDto dto, HttpServletRequest req) throws Exception{
      logger.info("loginAf.do");
      MemberDto login = new MemberDto();
      login = loginservice.login(dto);
      
      if (login != null && !login.getUser_id().equals("")) {
         req.getSession().setAttribute("login", login);
         return "로그인 성공";
      }else {
         return "로그인실패!!";
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
         
         String setfrom = "junghyejunghye@gmail.com";  // 보내는사람       
          String tomail  = findpw.getUser_email();     // 받는 사람 이메일
          String title   = "KH대학교 비밀번호 입니다";      // 제목
          String content = "KH대학교 찾으시는 해당 비밀번호는 : " + findpw.getUser_pw() + " 입니다";    // 내용
          
          System.out.println(setfrom);
          System.out.println(tomail);
          System.out.println(title);
          System.out.println(content);
          SimpleMailMessage message = new SimpleMailMessage();
          System.out.println("1/1/1");
          
          message.setFrom(setfrom);  
          message.setTo(tomail);    
          message.setSubject(title);
          message.setText(content); 
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
   public String regiview(Model model, String t) throws Exception{
      logger.info("LoginController regiview");
      model.addAttribute("doc_title", "교직원");
      model.addAttribute("doc_title_sub", "회원가입");
      System.out.println(t);
      model.addAttribute("t", t);
      return "regiview.tiles";
   }
   
   @RequestMapping(value="regiAf.do", method={RequestMethod.GET, RequestMethod.POST})
   public String regiAf(Model model, MemberDto dto, MultipartHttpServletRequest req, MultipartFile file, 
         String user_birth1, String user_birth2, String user_birth3) throws Exception {

       //init
      String path = "";
      String storedFileName; //dto 저장 파일 
      String orgFileName;

        //init
      path = req.getSession().getServletContext().getRealPath("/") + "upload/reg/"; //파일 저장경로
      FileUpload fileUpload = new FileUpload(file, path);
      storedFileName = fileUpload.getStoredFileName();
      orgFileName = fileUpload.getOrgFileName();

      dto.setUser_photo(storedFileName);
      dto.setUser_birth(user_birth1 + two(user_birth2) +  two(user_birth3)); 
      
      loginservice.addMember(dto);
      
      logger.info("regiAf 2/2");
      
      return "regiAf.tiles";
   }
   
   
   // 사진 대량 등록 
   @RequestMapping(value="photoUpdate.do",method={RequestMethod.GET, RequestMethod.POST})
   public String excelread_photo(Model model,  MultipartHttpServletRequest req, List<MultipartFile> file) throws Exception {
    
    	logger.info("photoUpdate.do");
        String path = "";
        String storedFileName; //dto 저장 파일 
        String orgFileName;
        
        path = req.getSession().getServletContext().getRealPath("/") + "upload/reg/"; //파일 저장경로
        logger.info("경로 : " + path);
        
        for(int i = 0; i<file.size(); i++) { 
          FileUpload fileUpload = new FileUpload(file.get(i), path);
	      storedFileName = fileUpload.getStoredFileName();
	      orgFileName = fileUpload.getOrgFileName();
	      
	      int idx = orgFileName.lastIndexOf(".");
	      String fileName = orgFileName.substring(0,idx);
	      System.out.println(fileName);
	      
	      MemberDto dto = new MemberDto();
	      dto.setUser_id(fileName);
	      dto.setUser_photo(storedFileName);
	      loginservice.updatePhoto_student(dto);
      }
        
       return "regiAf.tiles";
    }
   
   @RequestMapping(value="excelread.do",method={RequestMethod.GET, RequestMethod.POST})
   public String excelread(Model model, MultipartFile file, MultipartHttpServletRequest req) throws Exception {
       System.out.println("filename : " + file.getName());
       
       MemberDto dto = new MemberDto();
       String path = "";
       String orgFileName;
       
       path = req.getSession().getServletContext().getRealPath("/") + "upload/reg/"; //파일 저장경로

       FileUpload fileUpload = new FileUpload(file, path);
	   orgFileName = fileUpload.getOrgFileName();
	   
	   int rowindex=0;
	   int columnindex=0;
	   
      if(orgFileName.toUpperCase().endsWith(".XLS")) {
         HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
         HSSFSheet sheet = workbook.getSheetAt(0);
         //시트 수 (첫번째에만 존재하므로 0을 준다)
         //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
         
         //행의 수
         int rows=sheet.getPhysicalNumberOfRows();
         for(rowindex=1;rowindex<rows;rowindex++){
             
            //행을읽는다
             HSSFRow row=sheet.getRow(rowindex);
             if(row !=null){
                 
                //셀의 수
                 int cells=row.getPhysicalNumberOfCells();
                 for(columnindex=0;columnindex<=cells;columnindex++){
                     //셀값을 읽는다
                     HSSFCell cell=row.getCell(columnindex);
                     
                     String value="";
                     //셀이 빈값일경우를 위한 널체크
                     if(cell==null){
                         continue;
                     }else{
                         //타입별로 내용 읽기
                         switch (cell.getCellType()){
                         case HSSFCell.CELL_TYPE_FORMULA:
                             value=cell.getCellFormula();
                             break;
                         case HSSFCell.CELL_TYPE_NUMERIC:
                             value=cell.getNumericCellValue()+"";
                             break;
                         case HSSFCell.CELL_TYPE_STRING:
                             value=cell.getStringCellValue()+"";
                             break;
                         case HSSFCell.CELL_TYPE_BLANK:
                             value=cell.getBooleanCellValue()+"";
                             break;
                         case HSSFCell.CELL_TYPE_ERROR:
                             value=cell.getErrorCellValue()+"";
                             break;
                         }
                     }
                    
                     switch (columnindex) {
                  case 0: 
                     dto.setUser_id(value);
                     break;
                  case 1: 
                     dto.setUser_pw(value);;
                     break;
                  case 2: 
                     dto.setUser_name(value);
                     break;
                  case 3: 
                     dto.setUser_email(value);
                     break;
                  case 4: 
                     dto.setUser_phone(value);
                     break;
                  case 5: 
                     dto.setUser_address(value);
                     break;
                  case 6: 
                     dto.setUser_birth(value);
                     break;
                  case 7: 
                     dto.setUser_auth(value);
                     break;
                  case 8: 
                     dto.setStudent_first_major(value);
                     break;      
                  case 9: 
                     dto.setStudent_major(value);
                     break;   
                  case 10: 
                     dto.setUser_status(value);
                     break;   
                  case 11: 
                     dto.setStudent_regidate(value);
                     break;
                  case 12: 
                     String v = value;
                     int n = Integer.parseInt(v);
                     dto.setStudent_year(n);
                     break;
                  default:
                     break;
                  }
                    System.out.println("내용 :"+value);
                 }
                 System.out.println("loginController 최종 dto :" +dto.toString());
                 dto.setUser_photo("사진없음");
                 loginservice.addMember(dto);
                 System.out.println();
             }
         }
      }else if(orgFileName.toUpperCase().endsWith(".XLSX")) {
         
         XSSFWorkbook workbook=new XSSFWorkbook(file.getInputStream());
          XSSFSheet sheet=workbook.getSheetAt(0);
          int rows=sheet.getPhysicalNumberOfRows();
         for(rowindex=1;rowindex<rows;rowindex++){
             
            //행을읽는다
             XSSFRow row=sheet.getRow(rowindex);
             if(row !=null){
                 
                //셀의 수
                 int cells=row.getPhysicalNumberOfCells();
                 for(columnindex=0;columnindex<=cells;columnindex++){
                     //셀값을 읽는다
                     XSSFCell cell=row.getCell(columnindex);
                     
                     String value="";
                     //셀이 빈값일경우를 위한 널체크
                     if(cell==null){
                         continue;
                     }else{
                         //타입별로 내용 읽기
                         switch (cell.getCellType()){
                         case XSSFCell.CELL_TYPE_FORMULA:
                             value=cell.getCellFormula();
                             break;
                         case XSSFCell.CELL_TYPE_NUMERIC:
                             value=cell.getNumericCellValue()+"";
                             break;
                         case XSSFCell.CELL_TYPE_STRING:
                             value=cell.getStringCellValue()+"";
                             break;
                         case XSSFCell.CELL_TYPE_BLANK:
                             value=cell.getBooleanCellValue()+"";
                             break;
                         case XSSFCell.CELL_TYPE_ERROR:
                             value=cell.getErrorCellValue()+"";
                             break;
                         }
                     }
                     switch (columnindex) {
                    case 0: 
                     dto.setUser_id(value);
                     break;
                  case 1: 
                     dto.setUser_pw(value);;
                     break;
                  case 2: 
                     dto.setUser_name(value);
                     break;
                  case 3: 
                     dto.setUser_email(value);
                     break;
                  case 4: 
                     dto.setUser_phone(value);
                     break;
                  case 5: 
                     dto.setUser_address(value);
                     break;
                  case 6: 
                     dto.setUser_birth(value);
                     break;
                  case 7: 
                     dto.setUser_auth(value);
                     break;
                  case 8: 
                     dto.setStudent_first_major(value);
                     break;      
                  case 9: 
                     dto.setStudent_major(value);
                     break;   
                  case 10: 
                     dto.setUser_status(value);
                     break;   
                  case 11: 
                     dto.setStudent_regidate(value);
                     break;
                  case 12: 
                     int n = Integer.parseInt(value);
                     dto.setStudent_year(n);
                     break;
                  default:
                     break;
                  }
                    System.out.println("내용"+value);
                 }
                 System.out.println("loginController 최종 dto" +dto.toString());
                 dto.setUser_photo("사진없음");
                 loginservice.addMember(dto);
                 System.out.println();
             }
         }
      }

      return "regiAf.tiles";
   }   

}