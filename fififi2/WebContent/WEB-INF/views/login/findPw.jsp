<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery/jquery-1.11.1.min.js"></script>
<style type="text/css">
.inputtextcss{
    width: 200px;
    height: 25px;
    padding: 5px;
    border: 1px solid #e2e2e2; 
}
.buttoncss{
    border: #337ab7 solid 1px;
    color: white;
    padding: 0px;
	width: 100px;
    border-bottom-width: 1px;
    background-color: 337ab7;
}
.tablecss tr{
	height:5px;
}
.tablecss td{
	padding: 5px; 
	padding-right: 50px;
} 
</style>
</head>
<body>

<section class="category-content col-sm-9">
    <h2 class="category-title">비밀번호 검색</h2> 
  <button type="button" id="find_id" class="buttoncss">아이디찾기</button>
  <button type="button" id="find_pw" class="buttoncss">비밀번호찾기</button>
  <br><br>

<form action="findPwAf.do" id="findPw" method="post"> 
    <table class="tablecss">
    <tr>
    	<td>아이디(학번)</td>
    	<td><input type="text" name="user_id" id="user_id" data-msg="아이디" class="inputtextcss"></td>
    </tr>
    <tr>
    	<td>성명</td>
    	<td><input type="text" name="user_name" id="user_name" data-msg="이름" class="inputtextcss"></td>
    </tr>
	<tr>
    	<td>이메일</td>
    	<td><input type="text" name="user_email" id="user_email" data-msg="이메일" class="inputtextcss"></td>
    </tr>
    </table>
 
    <button id="find" >조회</button>
</form>
     
</section>   
<script type="text/javascript">
 $("#find_pw").click(function() {
	location.href="findPw.do";
 });   
 $("#find_id").click(function() {
	location.href="findId.do";
});    
 
 
 $("#find").click(function() {
		if($("#user_name").val() == ""){
			alert($("#user_name").attr("data-msg") + " 입력해 주십시오" );
			$("#user_name").focus();
		} else if($("#major_number").val() == ""){
			alert($("#major_number").attr("data-msg") + " 입력해 주십시오" );
			$("#user_pw").focus();
		} else if($("#user_email").val() == ""){
			alert($("#user_email").attr("data-msg") + " 입력해 주십시오" );
			$("#user_email").focus();
		} else if($("#user_id").val() == ""){
			alert($("#user_id").attr("data-msg") + " 입력해 주십시오" );
			$("#user_id").focus();
		}  
		else{
			$("#findPw").attr("target", "_self").submit();
		}	
});
 
$(function() {
	    $("input").focus(function () {
	        $(this).css("border", "2px solid #337ab7");
	    });
	    $("input").blur(function () { //포커스를 잃었을때
	        $(this).css("border", "1px solid #e2e2e2");
	    });
});

function categoryChange(e) {
	  var student_major_a = ["국어국문학과", "유아교육학과", "영어영문학과", "중문학과", "사학과"];
	  var student_major_b = ["정치외교학과","언론정보학과","경제학과","소비자학과","사회복지학과"];
	  var student_major_c = ["수학과","통계학과","물리학과","화학과","생명과학과","해양과학과","식품영양학과"];
	  var student_major_d = ["컴퓨터공학과","정보통신공학과","전자공학과","전기공학과","전자정보공학과"];
	  var student_major_e = ["보건행정경영학과","의료생명공학과","의료IT공학과","의예과","간호학과"];
	  

	  var target = document.getElementById("student_major");
	 
	  if(e.value == "인문과학대학") var d = student_major_a;
	  else if(e.value == "사회과학대학") var d = student_major_b;
	  else if(e.value == "자연과학대학") var d = student_major_c;
	  else if(e.value == "공과대학") var d = student_major_d;
	  else if(e.value == "의료과학대학") var d = student_major_e;
	 
	  target.options.length = 0;
	 
	  for (x in d) {
	    var opt = document.createElement("option");
	    opt.value = d[x];
	    opt.innerHTML = d[x];
	    target.appendChild(opt);
	  } 
	}

</script>

</script>


</body>
</html>