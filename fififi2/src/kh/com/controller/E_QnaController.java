package kh.com.controller;

import java.util.List;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kh.com.model.E_QnaDto;
import kh.com.model.MemberDto;
import kh.com.service.E_QnaService;
import kh.com.util.Pagination;

@Controller
public class E_QnaController {
	private static final Logger logger = LoggerFactory.getLogger(E_QnaController.class);

	@Autowired
	E_QnaService e_QnaService;
	
	@RequestMapping(value="E_Qnalist.do",method={RequestMethod.GET, RequestMethod.POST})
	public String E_Qnalist(int sub_seq,HttpServletRequest req,Model model, E_QnaDto eqna) throws Exception{
	    logger.info("E_QnaController E_Qnalist");            

	    int currPage = getCurrPage(req);
	    int totalArticle = e_QnaService.getQnaCount(eqna);
	      
	    Pagination pagination = new Pagination(totalArticle, currPage);
	    sub_seq = eqna.getSub_seq();
	    pagination.setSub_seq(sub_seq);
	    List<E_QnaDto> qnalist = e_QnaService.getQnalist(pagination);
	      
	    for (int i = 0; i < qnalist.size(); i++) {
	       System.out.println(qnalist.get(i).toString());
	    }
	      
	    model.addAttribute("pagination",pagination);
	    model.addAttribute("qnalist",qnalist);
	    
		return "E_Qnalist.tiles";
	}
	
	@RequestMapping(value="E_Qnadetail.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String E_Qnadetail(int seq,HttpServletRequest req, Model model) throws Exception{
		logger.info("E_QnaController E_Qnadetail");
		
		e_QnaService.QnaaddReadcount(seq);
		E_QnaDto eqna = e_QnaService.getQna(seq);
		model.addAttribute("eqna",eqna);
		System.out.println(eqna.toString());
		
		return "E_Qnadetail.tiles";
	}
	
	@RequestMapping(value="E_Qnadelete.do", method={RequestMethod.GET, RequestMethod.POST})
	   public String E_Qnadelete(E_QnaDto eqna,int seq,Model model,HttpServletRequest req) throws Exception{
	      logger.info("E_PdsController E_Qnadelete");
	      e_QnaService.deleteQna(seq);
	      return "redirect:/E_Qnalist.do?sub_seq="+eqna.getSub_seq();
	   }	

	
	@RequestMapping(value="E_Qnawrite.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String E_Qnawrite(HttpServletRequest req, Model model) throws Exception{
		logger.info("E_QnaController E_Qnawrite");
		MemberDto dto = (MemberDto) req.getSession().getAttribute("login");
	    model.addAttribute("login",dto);      
	    
		return "E_Qnawrite.tiles";

	}
	
	@RequestMapping(value="E_QnawriteAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_QnawriteAf(Model model, E_QnaDto eqna,HttpServletRequest req) throws Exception{
		logger.info("E_QnaController E_QnawriteAf");
		
		e_QnaService.uploadQna(eqna);
		
	    return "redirect:/E_Qnalist.do?sub_seq="+eqna.getSub_seq();

	}
	
	@RequestMapping(value="E_Qnaupdate.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Qnaupdate(int seq,Model model) throws Exception{
		logger.info("E_QnaController E_Qnaupdate");

		E_QnaDto eqna = e_QnaService.getQna(seq);
		model.addAttribute("eqna", eqna);
		
		return "E_Qnaupdate.tiles";
	}
	
	@RequestMapping(value="E_QnaupdateAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_QnaupdateAf(E_QnaDto eqna, Model model,HttpServletRequest req) throws Exception{
		logger.info("E_QnaController E_QnaupdateAf");
		
		e_QnaService.updatQna(eqna);
		System.out.println(eqna.toString());
		
		return "redirect:/E_Qnalist.do?sub_seq="+eqna.getSub_seq();
	}
	
	@RequestMapping(value="E_Qnareply.do", method={RequestMethod.GET, RequestMethod.POST})
	public String E_Qnareply(int seq, Model model) throws Exception {
		logger.info("E_QnaController E_Qnareply");
		E_QnaDto eqna = e_QnaService.getQna(seq);
		model.addAttribute("eqna", eqna);
		System.out.println(eqna.toString());
		return "E_Qnareply.tiles";
	}
	
	/*@RequestMapping(value="E_QnareplyAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String bbsreplyAf(E_QnaDto eqna, Model model) throws Exception {
		logger.info("E_QnaController E_QnareplyAf");
		System.out.println(eqna.toString());
		e_QnaService.reply(eqna);
		System.out.println(eqna.toString());
		return "redirect:/E_Qnalist.do?sub_seq="+eqna.getSub_seq();
	}
	
	@RequestMapping(value="bbsanswer.do", method={RequestMethod.GET, RequestMethod.POST})
	public String bbsanswer(int seq, Model model) throws Exception {
		logger.info("E_QnaController bbsanswer");
		E_QnaDto eqna = e_QnaService.getQna(seq);
		model.addAttribute("eqna", eqna);
		return "bbsanswer.tiles";
	}*/
	
	@RequestMapping(value="E_QnaanswerAf.do", method={RequestMethod.GET, RequestMethod.POST})
	public String bbsanswerAf(E_QnaDto eqna, Model model) throws Exception {
		logger.info("E_QnaController E_QnaanswerAf");
		System.out.println(eqna.toString());
		e_QnaService.answerBbs(eqna);
		System.out.println(eqna.toString());
		return "redirect:/E_Qnalist.do?sub_seq="+eqna.getSub_seq();
	}
	
	
	  /*************************************************************
	   *                         Util Method 					   *
	   *************************************************************/
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