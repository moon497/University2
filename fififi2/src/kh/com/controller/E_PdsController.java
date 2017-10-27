package kh.com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kh.com.model.E_BbsDto;
import kh.com.model.E_CommentDto;
import kh.com.model.E_PdsBean;
import kh.com.model.E_PdsDto;
import kh.com.model.MemberDto;
import kh.com.service.E_CommentService;
import kh.com.service.E_PdsService;
import kh.com.util.FUpUtil;
import kh.com.util.Pagination;

@Controller
public class E_PdsController {
   
   private static final Logger logger = LoggerFactory.getLogger(E_PdsController.class);
   
   @Autowired
   E_PdsService e_PdsService;
   @Autowired
   E_CommentService e_CommentService;

   @RequestMapping(value="E_Pdslist.do", method={RequestMethod.GET, RequestMethod.POST})
   public String getEPdsList(int sub_seq,HttpServletRequest req, E_PdsDto epds,Model model) throws Exception{
      logger.info("E_PdsController E_Pdslist");            
      
      int currPage = getCurrPage(req);
      int totalArticle = e_PdsService.getPdsCount(epds);
      
      Pagination pagination = new Pagination(totalArticle, currPage);
      sub_seq = epds.getSub_seq();
       pagination.setSub_seq(sub_seq);
      List<E_PdsDto> epdslist = e_PdsService.getEPdsList(pagination);
      
      for (int i = 0; i < epdslist.size(); i++) {
         System.out.println(epdslist.get(i).toString());
      }
      
      model.addAttribute("pagination",pagination);
      model.addAttribute("epdslist",epdslist);
      
      return "E_Pdslist.tiles";
   }
   
   @RequestMapping(value="E_Pdsdetail.do", method={RequestMethod.GET, RequestMethod.POST})
   public String E_Pdsdetail(int seq,Model model,HttpServletRequest req) throws Exception{
      logger.info("E_PdsController E_Pdsdetail");
      
      e_PdsService.addPdsReadcount(seq);
      E_PdsDto epds = e_PdsService.getPds(seq);
      model.addAttribute("epds",epds);
      System.out.println(epds.toString());
      
      List<E_CommentDto> clist = e_CommentService.getClist(seq);
      model.addAttribute("clist",clist);
      
      return "E_Pdsdetail.tiles";
   }
   
   @RequestMapping(value="E_Pdsdelete.do", method={RequestMethod.GET, RequestMethod.POST})
   public String E_Pdsdelete(E_PdsDto pdto,int seq,Model model,HttpServletRequest req) throws Exception{
      logger.info("E_PdsController E_Pdsdelete");
      e_PdsService.deleteEPds(seq);
      return "redirect:/E_Pdslist.do?sub_seq="+pdto.getSub_seq();
   }
   
   @RequestMapping(value="E_Pdswrite.do", method={RequestMethod.GET, RequestMethod.POST})
   public String E_Pdswrite(Model model,HttpServletRequest req) throws Exception{
      logger.info("E_PdsController E_Pdswrite");            
      MemberDto dto = (MemberDto) req.getSession().getAttribute("login");
      model.addAttribute("login",dto);      
      
      return "E_Pdswrite.tiles";
   }
   
   @RequestMapping(value="E_PdswriteAf.do", method={RequestMethod.GET, RequestMethod.POST})
   public String E_PdswriteAf(Model model, E_PdsDto pdsdto,E_PdsBean epdsb, HttpServletRequest req,
                          @RequestParam(value="fileload", required=false) MultipartFile fileload) throws Exception{
      logger.info("E_PdsController E_PdswriteAf");
      String newFile ="";
      
      pdsdto.setFilename(fileload.getOriginalFilename());
      
      String fupload = req.getServletContext().getRealPath("/upload");
      logger.info("파일 저장 경로:" + fupload);      
      
      String f = pdsdto.getFilename();
      logger.info("f:" + f);   
      
      if (f=="") {
         f="-1";
         epdsb.setOrg_filename(f);
         newFile = f;
         epdsb.setFilename(f);
      }else{
         epdsb.setOrg_filename(f);
         newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
         epdsb.setFilename(newFile);
      }
      
      File file = new File(fupload + "/" + newFile);
      logger.info("file:" + file);      
      try {
         FileUtils.writeByteArrayToFile(file, fileload.getBytes());
         //DB에 추가
         e_PdsService.uploadPds(epdsb);
         System.out.println("파일 업로드 성공");
      } catch (IOException e) {System.out.println("파일 업로드 실패" + epdsb.toString());}
      
      return "redirect:/E_Pdslist.do?sub_seq="+epdsb.getSub_seq();
   }

   @RequestMapping(value="E_Pdsupdate.do", method={RequestMethod.GET, RequestMethod.POST})
   public String E_Pdsupdate(int seq,int sub_seq,Model model) throws Exception{
      logger.info("E_PdsController E_Pdsupdate");
      
      E_PdsDto edto = e_PdsService.getPds(seq);
      System.out.println("seq : " + seq);
      System.out.println("sub_seq : " + sub_seq);
      
      model.addAttribute("edto",edto);
      
      return "E_Pdsupdate.tiles";
   }
      
   @RequestMapping(value="E_PdsupdateAf.do", method={RequestMethod.GET, RequestMethod.POST})
   public String E_PdsupdateAf(Model model, E_PdsDto pdsdto,E_PdsBean epdsb, HttpServletRequest req,
                          @RequestParam(value="fileload", required=false) MultipartFile fileload) throws Exception{
      
         logger.info("E_PdsController E_PdsupdateAf");
         String newFile ="";
         pdsdto.setFilename(fileload.getOriginalFilename());
         String fupload = req.getServletContext().getRealPath("/upload");
         logger.info("파일 저장 경로:" + fupload);      
         
         String f = pdsdto.getFilename();
         
         if (f=="") {
            f="-1";
            epdsb.setOrg_filename(f);
            newFile = f;
            epdsb.setFilename(f);
         }else{
            epdsb.setOrg_filename(f);
            newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
            epdsb.setFilename(newFile);
         }
         
         File file = new File(fupload + "/" + newFile);
         logger.info("file:" + file);      
         try {
            FileUtils.writeByteArrayToFile(file, fileload.getBytes());
            //DB에 추가
            e_PdsService.updateEPds(epdsb);
            System.out.println("파일 업로드 성공" + epdsb.toString());
         } catch (IOException e) {System.out.println("파일 업로드 실패" + e);}
         
         return "redirect:/E_Pdslist.do?sub_seq="+epdsb.getSub_seq();
      }
      

   
   
   
   /************************************************************
    *                      Comment
    * **********************************************************/
   
   @RequestMapping(value="E_comment_write.do", method={RequestMethod.GET, RequestMethod.POST})
   public String E_comment_write(Model model, E_CommentDto cdto, HttpServletRequest req,
                          @RequestParam(value="fileload", required=false) MultipartFile fileload) throws Exception {
      logger.info("E_PdsController E_comment_write");

      String newFile ="";
            
      cdto.setFilename(fileload.getOriginalFilename());
   
      String fupload = req.getSession().getServletContext().getRealPath("/upload");
      logger.info("파일 저장 경로:" + fupload);      
      
      String f = cdto.getFilename();
      logger.info("f:" + f);   
      if (f=="") {
         f="-1";
         cdto.setOrg_filename(f);
         newFile = f; // 파일명 변환작업
         cdto.setFilename(f);
      }else{
         cdto.setOrg_filename(f);
         newFile = FUpUtil.getNewFile(f); // 파일명 변환작업
         cdto.setFilename(newFile);
      }
      File file = new File(fupload + "/" + newFile);
      logger.info("file:" + file);      
      
      try {
         FileUtils.writeByteArrayToFile(file, fileload.getBytes());
         //DB에 추가
         e_CommentService.uploadComment(cdto);
         System.out.println("파일 업로드 성공");
         System.out.println("확인 : " + cdto.toString());
      } catch (Exception e) {
         System.out.println("파일 업로드 실패" + e);
         System.out.println("cdto : " + cdto.toString());}
            
      return "redirect:/E_Pdsdetail.do?seq="+cdto.getEclass_pds_bbs_seq()+"&sub_seq="+cdto.getSub_seq();
   }
   
   @RequestMapping(value="deleteComment.do", method={RequestMethod.GET, RequestMethod.POST})
   public String deleteComment(E_CommentDto cdto,int c_seq,int seq,Model model,HttpServletRequest req) throws Exception{
      logger.info("E_PdsController deleteComment");
      c_seq = cdto.getC_seq();
      e_CommentService.deleteComment(c_seq);
      return "redirect:/E_Pdsdetail.do?seq="+seq+"&sub_seq="+cdto.getSub_seq();
   }
   
   
   /************************************************************
    *                      Util Method 
    * **********************************************************/
   private int getCurrPage(HttpServletRequest req) {
      int currPage;
      
      if (req.getParameter("page") == null) {
         currPage = 1;
      } else {
         currPage = Integer.parseInt(req.getParameter("page"));
      }
      
      return currPage;
   }
   
   
   
   
   
}